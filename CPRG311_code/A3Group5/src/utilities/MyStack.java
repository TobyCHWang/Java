package utilities;

import java.lang.reflect.Array;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class MyStack<E> implements StackADT<E> {

	private MyArrayList<E> list;

	public MyStack() {
		list = new MyArrayList<>();
	}

	@Override
	public void push(E toPush) throws NullPointerException {
		list.add(toPush);
	}

	@Override
	public E pop() throws EmptyStackException {
		if (list.size() == 0) {
			throw new EmptyStackException();
		}
		return list.remove(list.size() - 1);
	}

	@Override
	public E peek() throws EmptyStackException {
		if (list.size() == 0) {
			throw new EmptyStackException();
		}
		return list.get(list.size() - 1);
	}

	@Override
	public boolean equals(StackADT<E> that) throws NullPointerException {
		if (this == that) {
			return true;
		}
		if (list.size() != that.size()) {
			return false;
		}
		E temp = null;
		Iterator list_it = list.iterator();
		Iterator that_it = that.iterator();
		while (list_it.hasNext()) {
			if (!list_it.next().equals(that_it.next())) {
				return false;
			}
		}
		return true;
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
			copy = (E[]) new Object[size()];
			for (int i = 0; i < size(); i++) {
				copy[i] = list.get(size() - 1 - i);
			}
		}

		@Override
		public boolean hasNext() {
			return pos < size();
		}

		@Override
		public E next() throws NoSuchElementException {
			if (pos >= size()) {
				throw new NoSuchElementException();
			}
			
			E toReturn = list.get(size() -1- pos);
			return toReturn;
		}
	}

	@Override
	public Object[] toArray() {
//		return list.toArray();
		Object[] toHold = (E[]) new Object[this.size()];
		for (int i = 0; i < toHold.length; i++) {
			toHold[i] = list.get(size() - 1 - i);
		}
		return toHold;
	}

	@Override
	public E[] toArray(E[] copy) throws NullPointerException {
//		return list.toArray(copy);
		if (copy == null) {
			throw new NullPointerException();
		}
		if (copy.length < this.size()) {
			copy = (E[]) Array.newInstance(list.get(0).getClass(), this.size());
		}
		if (!list.isEmpty()) {
			for (int i = 0; i < copy.length; i++) {
				copy[i] = list.get(size() - 1 - i);
			}
		}
		return copy;
	}

	@Override
	public int search(E toSearch) throws NullPointerException {
		if (toSearch == null) {
			throw new NullPointerException();
		}
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == toSearch) {
				return size() - i;
			}
		}
		return -1;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		return list.contains(toFind);
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void clear() {
		list.clear();
	}

}
