package sait.frms.exception;
/**
 * This class is for InvalidReserveNameException class 
 * @author Chih-hung Wang, Nicolas Rojas, Tama Parsons, Michael Sajna
 * @version July 11,2021
 */
public class InvalidReserveNameException extends Exception {

	public InvalidReserveNameException(){
		super("Error: Invalid Reserve name");
	}
	public InvalidReserveNameException(String input) {
		super("Error: Invalid Reserve name"+input);
	}
}
