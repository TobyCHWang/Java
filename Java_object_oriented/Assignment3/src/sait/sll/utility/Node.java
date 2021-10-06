package sait.sll.utility;

import java.io.Serializable;
/**
 * This class is for Node class 
 * @author Chih-hung Wang, Nicolas Rojas, Tama Parsons, Michael Sajna
 * @version July 26, 2021
 */

public class Node implements Serializable {
	private Object element;
	private Node successor;
	
	/**
	 * @param element  Instance of Node
	 * @param successor Instance of Node
	 */
	public Node(Object element, Node successor) {
		super();
		this.element = element;
		this.successor = successor;
	}
	/**
	 * @param element  Instance of Object
	 */
	
	public Node(Object element) {
		super();
		this.element = element;
		this.successor = null;
	}
	/**
	 * @return the element
	 */

	public Object getElement() {
		return element;
	}
	
	/**
	 * @param element  Instance of Object
	 */
	public void setElement(Object element) {
		this.element = element;
	}
	/**
	 * @return the successor
	 */

	public Node getNext() {
		return successor;
	}
	/**
	 * @param successor Instance of Node
	 */

	public void setNext(Node successor) {
		this.successor = successor;
	}
}
