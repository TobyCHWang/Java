package utilities;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements ListADT<E> {

	private static final long serialVersionUID = 1L;

	// Attributes
	private E[] array;
	private int size;

	// Constructor
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		array = (E[]) new Object[10];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	// size is zero
	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	// increase size
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		if (toAdd == null) {
			throw new NullPointerException();
		}
		// check for capacity
		if (size == array.length) {
			// TODO create a new array (bigger than the original) x2
			// use a loop to copy everything from the original array into the new array
			// get array to reference to the new array
		}
		// TODO insert toAdd into index position (requires a loop)
		return true;
	}

	// increase size
	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if (toAdd == null) {
			throw new NullPointerException();
		}
		// check for capacity
		if (size == array.length) {
			// TODO create a new array (bigger than the original) x2
			// use a loop to copy everything from the original array into the new array
			// get array to reference to the new array
		}
		array[size] = toAdd;
		size++;
		return true;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		return array[index];
	}

	// decrement size
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	// decrement size
	@Override
	public E remove(E toRemove) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if(toHold.length < this.size) {
			toHold = (E[]) Array.newInstance(array[0].getClass(), this.size);
		}
		System.arraycopy(array, 0, toHold, 0, size);
		return toHold;
	}

	@Override
	public Object[] toArray() {
		// Object[] toHold = (E[]) Array.newInstance(array[0].getClass(), this.size);
		Object[] toHold = (E[]) new Object[this.size];
		System.arraycopy(array, 0, toHold, 0, size);
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

		public ArrayBasedIterator() {
			copy = (E[]) new Object[size];
			System.arraycopy(array, 0, copy, 0, size);
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
			E toReturn = array[pos];
			pos++;
			return toReturn;
		}

	}

}
