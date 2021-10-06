package sait.sll.utility;

import java.io.IOException;
import java.io.Serializable;

/**
 * This class is for SLL class 
 * @author Chih-hung Wang, Nicolas Rojas, Tama Parsons, Michael Sajna
 * @version July 26, 2021
 */

public class SLL implements LinkedListADT, Serializable{
	private Node head;
	private Node tail;
	private int sllSize; 
	
	/**
	 * 
	 */
	public SLL() {
		this.head=null;
		this.tail=null;
		this.sllSize=0;
	}

	/**
	 * @return the head
	 */
	public Node getHead() {
		return head;
	}

	/**
	 * @param head the head to set
	 */
	public void setHead(Node head) {
		this.head = head;
	}

	/**
	 * @return the tail
	 */
	public Node getTail() {
		return tail;
	}

	/**
	 * @param tail the tail to set
	 */
	public void setTail(Node tail) {
		this.tail = tail;
	}

	/**
	 * @return the sllSize
	 */
	public int getSllSize() {
		return sllSize;
	}

	/**
	 * @param sllSize the sllSize to set
	 */
	public void setSllSize(int sllSize) {
		this.sllSize = sllSize;
	}

	@Override
	/**
	 * this method check SLL isempty
	 */
	public boolean isEmpty() {
		return (head==null);
	}

	@Override
	/**
	 * this method clear SLL
	 */
	public void clear() {
		sllSize=0;
		head=null;
		tail=null;
	}

	@Override
	/**
	 * this append data
	 */
	public void append(Object data) {
		// TODO Auto-generated method stub
		Node newNode=new Node(data);
		if (!isEmpty()) {
			tail.setNext(newNode);
			tail=newNode;
		}else {
			head=newNode;
			tail=newNode;
		}
		sllSize++;
		
	}

	@Override
	/**
	 * this method prepend data
	 */
	public void prepend(Object data) {
		// TODO Auto-generated method stub
		Node newNode = new Node(data);
		newNode.setNext(head);
		head = newNode;
		sllSize++;
		if (tail == null) {
			tail = head;
		}
	}

	@Override
	/**
	 * this method insert data in specific index
	 */
	public void insert(Object data, int index) throws IndexOutOfBoundsException {
		if(index<0||index>sllSize) {
			throw new IndexOutOfBoundsException();
		}else {
			Node nowNode=head;
			Node tempNode=new Node(data);
			for(int i=1;i<index;i++) {
				nowNode=nowNode.getNext();
			}
			tempNode.setNext(nowNode.getNext());
			nowNode.setNext(tempNode);
			
			sllSize++;
		}
		
		
	}

	@Override
	/**
	 * this method replace data in specific index
	 */
	public void replace(Object data, int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if(index<0 || index>=sllSize) {
			throw new IndexOutOfBoundsException();
		}else {
			Node intiNode=head;
			for(int i=0;i<index;i++) {
				intiNode=intiNode.getNext();
			}
			intiNode.setElement(data);
		}
		
	}

	@Override
	/**
	 * this method return SLL length
	 */
	public int size() {
		// TODO Auto-generated method stub
		return getSllSize();
	}

	@Override
	/**
	 * this method delete data in specific index
	 */
	public void delete(int index) throws IndexOutOfBoundsException {
		if(index<0||index>=sllSize) {
			throw new IndexOutOfBoundsException();
		}else {
			Node nowNode=head;
			for(int i=1;i<index;i++) {
				nowNode=nowNode.getNext();
			}
			nowNode.setNext(nowNode.getNext().getNext());
			sllSize--;
		}
		
	}

	@Override
	/**
	 * this method retrieve data in specific index
	 */
	public Object retrieve(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		if(index<0 || index>=sllSize) {
			throw new IndexOutOfBoundsException();
		}else {
			Node intiNode=head;
			for(int i=0;i<index;i++) {
				intiNode=intiNode.getNext();
			}
			return intiNode.getElement();
		}
	}

	@Override
	/**
	 * this method find data in specific index
	 */
	public int indexOf(Object data) {
		int index=0;
		Node curretNode=head;
		while (curretNode!=null){
			if(curretNode.getElement()==data) {
				return index;
			}
			curretNode=curretNode.getNext();
			index++;
		}
		return 0;
	}
	
	/**
	 * this method check data in SLL
	 */

	@Override
	public boolean contains(Object data) {
		Node curretNode=head;
		while (curretNode!=null){
			if(curretNode.getElement()==data) {
				return true;
			}
			curretNode=curretNode.getNext();
		}
		return false;
	}

}
