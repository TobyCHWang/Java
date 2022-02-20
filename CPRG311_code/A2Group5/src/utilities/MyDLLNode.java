package utilities;

public class MyDLLNode<E> {
	private E information;
	private MyDLLNode<E> prev;
	private MyDLLNode<E> next;
	
	
	//constructor 
	public MyDLLNode(E information) {
		this.information=information;
	}
	
	



	/**
	 * @param information
	 * @param prev
	 * @param next
	 */
	public MyDLLNode(E information, MyDLLNode<E> prev, MyDLLNode<E> next) {
		super();
		this.information = information;
		this.prev = prev;
		this.next = next;
	}



	/**
	 * @return the prev
	 */
	public MyDLLNode<E> getPrev() {
		return prev;
	}

	/**
	 * @param prev the prev to set
	 */
	public void setPrev(MyDLLNode<E> prev) {
		this.prev = prev;
	}

	/**
	 * @return the next
	 */
	public MyDLLNode<E> getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(MyDLLNode<E> next) {
		this.next = next;
	}

	/**
	 * @return the information
	 */
	public E getInformation() {
		return information;
	}

	/**
	 * @param information the information to set
	 */
	public void setInformation(E information) {
		this.information = information;
	}
	
	
	

}
