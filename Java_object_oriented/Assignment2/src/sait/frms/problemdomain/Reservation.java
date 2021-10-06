package sait.frms.problemdomain;
/**
 * This class is for Reservation class 
 * @author Chih-hung Wang, Nicolas Rojas, Tama Parsons, Michael Sajna
 * @version July 11,2021
 */

public class Reservation {
  private String code;
  private String flightcode;
  private String airline;
  private String name;
  private String citizenship;
  private double cost;
  private boolean active;
  
  
/**
 * default constructor 
 */
public Reservation() {
	super();
	// TODO Auto-generated constructor stub
}
/**
 * @param code
 * @param flightcode
 * @param airline
 * @param name
 * @param citizenship
 * @param cost
 * @param active
 */
public Reservation(String code, String flightcode, String airline, String name, String citizenship, double cost,
		boolean active) {
	super();
	this.code = code;
	this.flightcode = flightcode;
	this.airline = airline;
	this.name = name;
	this.citizenship = citizenship;
	this.cost = cost;
	this.active = active;
}
public Reservation(String code, Flight flight, String name, String citizenship) {
	this.code=code;
	//flight
	this.name=name;
	this.citizenship=citizenship;
}
/**
 * @return the code
 *
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
 * @return the flightcode
 */
public String getFlightcode() {
	return flightcode;
}
/**
 * @param flightcode the flightcode to set
 */
public void setFlightcode(String flightcode) {
	this.flightcode = flightcode;
}
/**
 * @return the airline
 */
public String getAirline() {
	return airline;
}
/**
 * @param airline the airline to set
 */
public void setAirline(String airline) {
	this.airline = airline;
}
/**
 * @return the name
 */
public String getName() {
	return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
/**
 * @return the citizenship
 */
public String getCitizenship() {
	return citizenship;
}
/**
 * @param citizenship the citizenship to set
 */
public void setCitizenship(String citizenship) {
	this.citizenship = citizenship;
}
/**
 * @return the cost
 */
public double getCost() {
	return cost;
}
/**
 * @param cost the cost to set
 */
public void setCost(double cost) {
	this.cost = cost;
}
/**
 * @return the active
 */
public boolean isActive() {
	return active;
}
/**
 * @param active the active to set
 */
public void setActive(boolean active) {
	this.active = active;
}
@Override
public String toString() {
	return code;
}

  
}
