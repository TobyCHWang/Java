package sait.frms.exception;
/**
 * This class is for NoSeatsException class 
 * @author Chih-hung Wang, Nicolas Rojas, Tama Parsons, Michael Sajna
 * @version July 11,2021
 */
public class NoSeatsException extends Exception {

	public NoSeatsException() {
		super("Error: No seats available");
	}
	public NoSeatsException(String input) {
		super("Error: seats available"+input);
	}
}
