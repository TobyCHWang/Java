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
		return size;
	}

	@Override
	public void clear() {
		size = 0;
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		if (toAdd == null) {
			throw new NullPointerException();
		}
		if (size == array.length) {
			Object[] temp = (E[]) new Object[(array.length * 2)];
			for (int i = 0; i < array.length; i++) {
				temp[i] = array[i];
			}
			array = (E[]) temp;
		}
		array[index] = toAdd;
		size++;
		return true;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if (toAdd == null) {
			throw new NullPointerException();
		}
		if (size == array.length) {
			Object[] temp = (E[]) new Object[(array.length * 2)];
			for (int i = 0; i < array.length; i++) {
				temp[i] = array[i];
			}
			array = (E[]) temp;
		}
		array[size] = toAdd;
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
		return array[index];
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		E toReturn = null;
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		Object[] temp = (E[]) new Object[array.length - 1];
		for (int i = 0, k = 0; i < array.length; i++) {
			if (i == index) {
				toReturn = (E) array[i];
				continue;
			}
			temp[k++] = array[i];
		}
		array = (E[]) temp;
		size--;
		return toReturn;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		E toReturn = null;
		if (toRemove == null) {
			throw new NullPointerException();
		}
		Object[] temp = (E[]) new Object[array.length - 1];
		for (int i = 0, k = 0; i < array.length; i++) {
			if (toRemove == array[i]) {
				toReturn = (E) array[i];
				continue;
			}
			temp[k++] = array[i];
		}
		array = (E[]) temp;
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
		E toReturn = array[index];
		array[index] = toChange;
		return toReturn;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) {
			throw new NullPointerException();
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i] == toFind) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if (toHold == null) {
			throw new NullPointerException();
		}
		if (toHold.length < this.size) {
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
