package utilities;

import java.lang.reflect.Array;
import java.util.Arrays;
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

	// size is zero
	@Override
	public void clear() {
		size=0;

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
			E[] largeArray=Arrays.copyOf(array, array.length*2);
			array=largeArray;
				
		}
		E preValue=toAdd;
		// TODO insert toAdd into index position (requires a loop)
		for(int i=index;i<array.length;i++) {
			E temp=preValue;
			preValue=array[i];
			array[i]=temp;
		}
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
			E[] largeArray=Arrays.copyOf(array, array.length*2);
			array=largeArray;
		}
		array[size] = toAdd;
		size++;
		return true;
	}

	@Override
	//not sure
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		if (toAdd == null) {
			throw new NullPointerException();
		}
		
		if (size == array.length) {
			E[] largeArray=Arrays.copyOf(array, array.length*2);
			array=largeArray;
		}
		Object[] aObjects=toAdd.toArray();
		int numNew=aObjects.length;
		System.arraycopy(aObjects, 0, array, size, numNew);
		size+=numNew;
		return true;
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
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}else {
			for(int i = index; i < size; i++){
				array[i]=array[i+1];
			}
		}
		return (E) array;
	}

	// decrement size
	@Override
	public E remove(E toRemove) throws NullPointerException {
		if (toRemove == null) {
			throw new NullPointerException();
		}else {
			 for(int i = 0; i < array.length; i++){
			      if(array[i] == toRemove){
			        // shifting elements
			        for(int j = i; j < array.length - 1; j++){
			        	array[j] = array[j+1];
			        }
			       
			      }
			    }
		}
		return (E) array;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		if (toChange == null) {
			throw new NullPointerException();
		}
		array[index]=toChange;
		return (E) array;
	}

	@Override
	public boolean isEmpty() {
		return (size==0);
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) {
			throw new NullPointerException();
		}
		
		for(int i=0;i<array.length-1;i++) {
			if(array[i]==(toFind)) {
				return true;
			}
		}
		
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
