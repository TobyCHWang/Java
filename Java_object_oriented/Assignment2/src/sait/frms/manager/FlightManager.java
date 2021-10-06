package sait.frms.manager;
/**
 * This Manager class is for Flight method 
 * 1.	getAirports
 * 2.	getFlights
 * 3.	findAirportByCode
 * 4.	findFlightByCode
 * 5.   findFlights
 * 6.   populateFlights from flight.csv
 * 7.   populateAirports from airport.csv
 * @author Chih-hung Wang, Nicolas Rojas, Tama Parsons, Michael Sajna
 * @version July 11,2021
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import sait.frms.problemdomain.Flight;

public class FlightManager {
	public static final String WEEKDAY_ANY="Any";
	public static final String WEEKDAY_SUNDAY="Sunday";
	public static final String WEEKDAY_MONDAY="Monday";
	public static final String WEEKDAY_TUESDAY="Tuesday";
	public static final String WEEKDAY_WEDNESDAY="Wednesday";
	public static final String WEEKDAY_THURSDAY="Thursday";
	public static final String WEEKDAY_FRIDAY="Friday";
	public static final String WEEKDAY_SATURDAY="Saturday";
	private final String AIRPORT_FILE_PATH="res/airports.csv";
	private final String FLIGHT_FILE_PATH="res/flights.csv";
	private ArrayList<Flight> flights;
	private ArrayList<String> airports;
	private String airportString;
	private String airportCodeString;
	private String airportNameString;
	
	
	/**
	 * @throws FileNotFoundException 
	 * 
	 */
	public FlightManager() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
		flights = new ArrayList<Flight>();
		airports=new ArrayList<String>();
	}
	
	public ArrayList<String> getAirports() throws FileNotFoundException{
		populateAirports();	
		return airports;
	}
	
	public ArrayList<Flight> getFlights() throws FileNotFoundException{
		populateFlights();
		return flights;
		
	}
	
	public String findAirportByCode(String code){
		for(int i=0;i<airports.size();i++) {
			if (airports.get(i).equalsIgnoreCase(code)) {
				airportString=airports.get(i)+","+airports.get(i+1);
			}
		}
		return airportString;
		
	}
	
	public Flight findFlightByCode(String code) throws FileNotFoundException {
		populateFlights();
		Flight searchFlight=new Flight();
		for(int i=0;i<flights.size();i++) {
			if (flights.get(i).getCode().equalsIgnoreCase(code)) {
				searchFlight=flights.get(i);
			}
		}
		return	searchFlight;
	}
	
	public ArrayList<Flight> findFlights(String from,String to,String weekday) throws FileNotFoundException{
		ArrayList<Flight> searchFlightByFromToWeekday=new ArrayList<Flight>();
		getFlights();
		if (weekday.equalsIgnoreCase("ANY")) {
			for (int i = 0; i < flights.size(); i++) {
				if (flights.get(i).getFrom().equalsIgnoreCase(from) && flights.get(i).getTo().equalsIgnoreCase(to)) {
					searchFlightByFromToWeekday.add(flights.get(i));
				}
			}
		} else {
			for (int i = 0; i < flights.size(); i++) {
				if (flights.get(i).getFrom().equalsIgnoreCase(from) && flights.get(i).getTo().equalsIgnoreCase(to)
						&& flights.get(i).getWeekday().equalsIgnoreCase(weekday)) {
					searchFlightByFromToWeekday.add(flights.get(i));
				}
			}
		}
		return searchFlightByFromToWeekday;
	}
		
		/*for(int i=0;i<flights.size();i++) {
		
			if (flights.get(i).getFrom().equalsIgnoreCase(from)&&flights.get(i).getTo().equalsIgnoreCase(to)&&flights.get(i).getWeekday().equalsIgnoreCase(weekday)) {
				searchFlightByFromToWeekday.add(flights.get(i));
			}
		}
		return searchFlightByFromToWeekday;
	}*/
	
	
	private void populateFlights() throws FileNotFoundException {
		Scanner in = new Scanner(new File(FLIGHT_FILE_PATH));
		
		while(in.hasNext()) {
			String eachline = in.nextLine();
			String []fields = eachline.split(",");
			String codeString=fields[0];
			String fromString=fields[1];
			String tosString=fields[2];
			String weekString=fields[3];
			String timeString=fields[4];
			String seatString=fields[5];
			int seat=Integer.parseInt(seatString);
			String coString=fields[6];
			double cost=Double.parseDouble(coString);
			String airlineCode = codeString.substring(0, 2);
			String airlineName = "";

			switch (airlineCode) {
			case "OA":
				airlineName = "Otto Airlines";
			case "CA":
				airlineName = "Conned Air";
			case "TB":
				airlineName = "Try a Bus Airways";
			case "VA":
				airlineName = "Vertical Airways";
			}
			Flight flight=new Flight(codeString,airlineCode,fromString,tosString,weekString,timeString,seat,cost);
			flights.add(flight);
		}
		in.close();
		
	}
		
	private void populateAirports() throws FileNotFoundException {
		Scanner in = new Scanner(new File(AIRPORT_FILE_PATH));
		
		while(in.hasNext()) {
			String eachline = in.nextLine();
			String []fields = eachline.split(",");
			airportCodeString=fields[0];
			airportNameString=fields[1];
			airports.add(airportCodeString);
			airports.add(airportNameString);
		}
		in.close();
		
	}
}

