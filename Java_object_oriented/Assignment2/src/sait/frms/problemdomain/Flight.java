package sait.frms.problemdomain;
/**
 * This class is for Flight class 
 * @author Chih-hung Wang, Nicolas Rojas, Tama Parsons, Michael Sajna
 * @version July 11,2021
 */

public class Flight {
	private String code;
	private String from;
	private String to;
	private String weekday;
	private String time;
	private String airlineName;
	private int seats;
	private double costPerSeat;
	
	
	
	
	/**
	 * default constructor 
	 */
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param code
	 * @param airlineName
	 * @param from
	 * @param to
	 * @param weekday
	 * @param time
	 * @param seats
	 * @param costPerSeat
	 */
	public Flight(String code, String airlineName, String from, String to, String weekday, String time, int seats,
			double costPerSeat) {
		super();
		this.code = code;
		this.airlineName = airlineName;
		this.from = from;
		this.to = to;
		this.weekday = weekday;
		this.time = time;
		this.seats = seats;
		this.costPerSeat = costPerSeat;
	}
	public Flight(String code, String from, String to, String weekday, String time,
			int seats, double costPerSeat) {
		// TODO Auto-generated constructor stub
		this.code = code;
		this.from = from;
		this.to = to;
		this.weekday = weekday;
		this.time = time;
		this.seats = seats;
		this.costPerSeat = costPerSeat;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * @return the airlineName
	 */
	public String getAirlineName() {
		return airlineName;
	}
	/**
	 * @param airlineName the airlineName to set
	 */
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}
	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}
	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}
	/**
	 * @return the weekday
	 */
	public String getWeekday() {
		return weekday;
	}
	/**
	 * @param weekday the weekday to set
	 */
	public void setWeekday(String weekday) {
		this.weekday = weekday;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the seats
	 */
	public int getSeats() {
		return seats;
	}
	/**
	 * @param seats the seats to set
	 */
	public void setSeats(int seats) {
		this.seats = seats;
	}
	/**
	 * @return the costPerSeat
	 */
	public double getCostPerSeat() {
		return costPerSeat;
	}
	/**
	 * @param costPerSeat the costPerSeat to set
	 */
	public void setCostPerSeat(double costPerSeat) {
		this.costPerSeat = costPerSeat;
	}
	@Override
	public String toString() {
		return   code + ", From:" + from + ", To:" + to + ", day:" + weekday + " , Cost:" + costPerSeat;
	}
	

}
