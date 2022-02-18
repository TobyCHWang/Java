package exception;

public class EmptyQueueException extends Exception {
	
	public EmptyQueueException() {
		super("Error: Empty Queue");
	}

}
