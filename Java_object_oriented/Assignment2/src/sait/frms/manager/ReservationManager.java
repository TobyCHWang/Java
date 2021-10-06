package sait.frms.manager;
/**
 * This Manager class is for Reservation method 
 * 1.	makeReservation
 * 2.	findReservations
 * 3.	findReservationByCode
 * 4.	generateReservationCode
 * 5.   getAvailableSeats
 * 6.   populateFromBinary from res/reservations.bin
 * 7.   persist data to res/reservations.bin
 * @author Chih-hung Wang, Nicolas Rojas, Tama Parsons, Michael Sajna
 * @version July 11,2021
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.naming.InvalidNameException;

import sait.frms.exception.InvalidCitizenshipException;
import sait.frms.exception.NoSeatsException;
import sait.frms.exception.NullFlightException;
import sait.frms.problemdomain.Flight;
import sait.frms.problemdomain.Reservation;

public class ReservationManager {
	private ArrayList<Reservation> reservations;
	private String codeString;
	private String flightcodeString;
	private String airlinString;
	private String reservernameString;
	private String citizenshipsString;
	private String airlineString;
	private double cost;
	private boolean active=true;
	private static final String BINARY_FILE = "res/reservations.bin";
	private static final int RESERVERATION_SIZE=133;
	
	
	/**
	 * @throws FileNotFoundException 
	 * 
	 */
	public ReservationManager() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
		reservations=new ArrayList<Reservation>();
		//this.raf = new RandomAccessFile(BINARY_FILE, MODE);
	}

	/*public ArrayList<Reservation> getAll() throws IOException{
		ArrayList<Reservation> aReservations=new ArrayList<>();
		for (long position = 0; position < this.raf.length(); position += RESERVERATION_SIZE) {
			Reservation reservation=this.populateFromBinary();
			aReservations.add(reservation);
		}
		return aReservations;
	}*/
	public Reservation makeReservation(Flight flight, String name, String citizenship) throws IOException {
		try {
			int seat=getAvailableSeats(flight);
			seat--;
			if(flight==null) {
				throw new NullFlightException();
			}
			if(name==null||name.isEmpty()) {
				throw new InvalidNameException();
			}
			if(citizenship == null || citizenship.isEmpty()) {
				throw new InvalidCitizenshipException();
			}
			
		}catch (NoSeatsException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (NullFlightException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}catch (InvalidNameException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}catch(InvalidCitizenshipException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		codeString=generateReservationCode(flight);
		flightcodeString=flight.getCode();
		String airliString = flight.getAirlineName();
		if(airliString.equals("OA")){
			airliString="Otto Airlines";
		}
		if(airliString.equals("CA")){
			airliString="Conned Air";
		}
		if(airliString.equals("TB")){
			airliString="Try a Bus Airways";
		}
		if(airliString.equals("VA")){
			airliString="Vertical Airways";
		}
		reservernameString=name;
		citizenshipsString=citizenship;
		cost=flight.getCostPerSeat();
		Reservation aReservation=new Reservation();
		aReservation.setActive(true);
		aReservation=new Reservation(codeString,flightcodeString,airliString,name,citizenship,cost,active);
		reservations.add(aReservation);
		persist();
		return aReservation;
		
	}
	
	public ArrayList<Reservation> findReservations(String reservationCode,String airline,String name) throws IOException{
		populateFromBinary();
		ArrayList<Reservation> searchReservationByCodeAirlineName=new ArrayList<Reservation>();
		
		for(int i=0;i<reservations.size();i++) {
			airlineString=reservations.get(i).getFlightcode();
			String twoCharacterString=airlineString.substring(0, 2);
			if(twoCharacterString.equals("OA")){
				airlineString="Otto Airlines";
			}
			if(twoCharacterString.equals("CA")){
				airlineString="Conned Air";
			}
			if(twoCharacterString.equals("TB")){
				airlineString="Try a Bus Airways";
			}
			if(twoCharacterString.equals("VA")){
				airlineString="Vertical Airways";
			}
		}
		for(int i=0;i<reservations.size();i++) {
			if (reservations.get(i).getCode().equalsIgnoreCase(reservationCode)||airlineString.equalsIgnoreCase(airline)||reservations.get(i).getName().equalsIgnoreCase(name)) {
				searchReservationByCodeAirlineName.add(reservations.get(i));
			}
		}
		return searchReservationByCodeAirlineName;
		
	}
	
	public Reservation findReservationByCode(String reservationCode) {
		Reservation searchReservation=new Reservation();
		for(int i=0;i<reservations.size();i++) {
			if (reservations.get(i).getCode().equalsIgnoreCase(reservationCode)) {
				searchReservation=reservations.get(i);
			}
		}
		return	searchReservation;
		
	}
	
	private int getAvailableSeats(Flight flight) throws NoSeatsException {
		int seats=flight.getSeats();
		if(seats<=0) {
			throw new NoSeatsException();
		}else {
			return seats;
		}
			
	}

	private String generateReservationCode(Flight flight){
		String firstletterString;
		String secondString;
		String finalString;
		String firstletterStringFrom=flight.getFrom();
		String firstletterStringTo=flight.getTo();
		if(firstletterStringFrom.charAt(0)=='Y' && firstletterStringTo.charAt(0)=='Y') {
			firstletterString="D";
		}else {
			firstletterString="I";
		}
		Random r = new Random();
		int low = 1000;
		int high = 9999;
		int result = r.nextInt(high-low) + low;
		secondString=String.valueOf(result);
		finalString=firstletterString+secondString;
		return finalString;
		
	}
	
	private void populateFromBinary() throws IOException {
		//problem: airline issue=null active=false
		FileInputStream fstream = new FileInputStream(BINARY_FILE);
		DataInputStream inputStream = new DataInputStream(fstream);
		boolean endOfFile = false;
		while(!endOfFile) {
			try {
				String reservationCode=inputStream.readUTF().trim();
				String flightCode=inputStream.readUTF().trim();
				String reserveAirline=inputStream.readUTF().trim();
				String reserveName=inputStream.readUTF().trim();
				String reserveCitizenship=inputStream.readUTF().trim();
			
				double cost=inputStream.readDouble();
				boolean active=inputStream.readBoolean();
				Reservation aReservation=new Reservation(reservationCode,flightCode,reserveAirline,reserveName,reserveCitizenship,cost,active);
				reservations.add(aReservation);
			} catch (Exception e) {
				// TODO: handle exception
				endOfFile = true;
			}
		}

		
	}
	
	public void persist() throws IOException {
		try {
			FileOutputStream test = new FileOutputStream(BINARY_FILE,true);
			DataOutputStream outputStream = new DataOutputStream(test);
			// 5bytes + 2bytes = 7bytes
			String reservationCode = String.format("%-7s", codeString);
			outputStream.writeUTF(reservationCode);
			// 7bytes + 2bytes = 9bytes
			String flightCode = String.format("%-7s", flightcodeString);
			outputStream.writeUTF(flightCode);
			// 2bytes + 2bytes = 4bytes
			String reserveAirline = String.format("%-2s",airlinString);
			outputStream.writeUTF(reserveAirline);
			// 50bytes + 2bytes = 52bytes name
			String reserveName = String.format("%-50s", reservernameString);
			outputStream.writeUTF(reserveName);
			// 50bytes + 2bytes = 52bytes
			String reserveCitizenship = String.format("%-50s", citizenshipsString);
			outputStream.writeUTF(reserveCitizenship);
			// 8 bytes
			outputStream.writeDouble(cost);
			// 1 byte
			outputStream.writeBoolean(active);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}
}
