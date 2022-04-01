package utilities;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class MyDLL<E> implements ListADT<E> {

	private MyDLLNode<E> head, tail;
	private int size;

	public MyDLL() {
		this.head = this.tail = null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		size = 0;
		this.head = this.tail = null;
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (toAdd == null) {
			throw new NullPointerException();
		}
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else if (index == 0) {
			newNode.setNext(head);
			head.setPrev(newNode);
			head = newNode;
		} else if (index == size) {
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
		} else {
			MyDLLNode<E> curr = head;
			for (int i = 0; i < index; i++) {
				curr = curr.getNext();
			}
			curr.getPrev().setNext(newNode);
			newNode.setPrev(curr.getPrev());
			curr.setPrev(newNode);
			newNode.setNext(curr);
		}
		size++;
		return true;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if (toAdd == null) {
			throw new NullPointerException();
		}
		MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
		}
		size++;
		return true;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		if (toAdd == null) {
			throw new NullPointerException();
		}
		for (Iterator<? extends E> iterator = toAdd.iterator(); iterator.hasNext();) {
			E elem = iterator.next();
			add(elem);
		}
		return true;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		MyDLLNode<E> curr = head;
		for (int i = 0; i < index; i++) {
			curr = curr.getNext();
		}
		return curr.getElement();
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		E toReturn;
		if (size() == 1) {
			toReturn = head.getElement();
			head = null;
			tail = null;
		} else if (index == 0) {
			toReturn = head.getElement();
			head.getNext().setPrev(null);
			head = head.getNext();
		} else if (index == size - 1) {
			toReturn = tail.getElement();
			tail.getPrev().setNext(null);
			tail = tail.getPrev();
		} else {
			MyDLLNode<E> curr = head;
			for (int i = 0; i < index; i++) {
				curr = curr.getNext();
			}
			toReturn = curr.getElement();
			curr.getPrev().setNext(curr.getNext());
			curr.getNext().setPrev(curr.getPrev());
		}
		size--;
		return toReturn;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		if (head == null || toRemove == null) {
			throw new NullPointerException();
		}
		E toReturn = null;
		MyDLLNode<E> curr = head;
		for (int i = 0; i < size; i++) {
			if (!curr.getElement().equals(toRemove)) {
				curr = curr.getNext();
			}
		}
		toReturn = curr.getElement();
		if (curr.getPrev() != null) {
			curr.getPrev().setNext(curr.getNext());
		} else {
			head = curr.getNext();
		}
		if (curr.getNext() != null) {
			curr.getNext().setPrev(curr.getPrev());
		}
		size--;
		return toReturn;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if (toChange == null) {
			throw new NullPointerException();
		}
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		MyDLLNode<E> curr = head;
		for (int i = 0; i < index; i++) {
			curr = curr.getNext();
		}
		E toReturn = curr.getElement();
		curr.setElement(toChange);
		return toReturn;
	}

	@Override
	public boolean isEmpty() {
		return head == null && tail == null;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) {
			throw new NullPointerException();
		}
		MyDLLNode<E> curr = head;
		for (int i = 0; i < size; i++) {
			if (curr.getElement() == toFind) {
				return true;
			}
			curr = curr.getNext();
		}
		return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if (toHold == null) {
			throw new NullPointerException();
		}
		MyDLLNode<E> curr = head;
		if (toHold.length < size) {
			toHold = (E[]) Array.newInstance(curr.getElement().getClass(), size);
		}
		if (head != null) {
			for (int i = 0; i < toHold.length; i++) {
				toHold[i] = curr.getElement();
				curr = curr.getNext();
			}
		}
		return toHold;
	}

	@Override
	public Object[] toArray() {
		Object[] toHold = (E[]) new Object[size];
		MyDLLNode<E> curr = head;
		for (int i = 0; i < toHold.length; i++) {
			toHold[i] = curr.getElement();
			curr = curr.getNext();
		}
		return toHold;
	}

	@Override
	public Iterator<E> iterator() {
		return new ArrayBasedIterator();
	}

	/**************************************************
	 * INNER CLASS
	 **************************************************/

	private class ArrayBasedIterator implements Iterator<E> {
		private int pos;
		private E[] copy;
		MyDLLNode<E> curr = head;

		public ArrayBasedIterator() {
			MyDLLNode<E> curr = head;
			copy = (E[]) new Object[size];
			for (int i = 0; i < size; i++) {
				copy[i] = curr.getElement();
				curr = curr.getNext();
			}
		}

		@Override
		public boolean hasNext() {
			return pos < size;
		}

		@Override
		public E next() throws NoSuchElementException {
			if (pos >= size) {
				throw new NoSuchElementException();
			}
			E toReturn = curr.getElement();
			curr = curr.getNext();
			pos++;
			return toReturn;
		}
	}

}
