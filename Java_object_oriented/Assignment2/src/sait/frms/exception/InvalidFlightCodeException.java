package sait.frms.exception;
/**
 * This class is for InvalidFlightCodeException class 
 * @author Chih-hung Wang, Nicolas Rojas, Tama Parsons, Michael Sajna
 * @version July 11,2021
 */
public class InvalidFlightCodeException extends Exception {
	public InvalidFlightCodeException() {
		super("Error: Invalid flight code");
	}
	public InvalidFlightCodeException(String input) {
		super("Error: Invalid flight code"+input);
	}
}
