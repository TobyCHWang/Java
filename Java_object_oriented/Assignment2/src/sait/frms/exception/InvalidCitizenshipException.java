package sait.frms.exception;
/**
 * This class is for InvalidCitizenshipException class 
 * @author Chih-hung Wang, Nicolas Rojas, Tama Parsons, Michael Sajna
 * @version July 11,2021
 */

public class InvalidCitizenshipException extends Exception {
	public InvalidCitizenshipException() {
		super("Error: Invalid citizenship");
	}
	public InvalidCitizenshipException(String input) {
		super("Error: Invalid citizenship"+input);
	}
}
