package sait.frms.exception;
/**
 * This class is for NullFlightException class 
 * @author Chih-hung Wang, Nicolas Rojas, Tama Parsons, Michael Sajna
 * @version July 11,2021
 */
public class NullFlightException extends Exception{
	public NullFlightException() {
		super("Error: Flight cannot be empty or null");
	}

	public NullFlightException(String input) {
		super("Error: Flight cannot be empty or null"+input);
	}
}
