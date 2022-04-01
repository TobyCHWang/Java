package utilities;

import exception.EmptyQueueException;

public class MyQueue<E> implements QueueADT<E> {
	
	private MyDLL<E> list;
	
	public MyQueue() {
		list = new MyDLL();
	}

	@Override
	public void enqueue(E toAdd) throws NullPointerException {
		if (toAdd == null) {
			throw new NullPointerException();
		}
		list.add(toAdd);
	}

	@Override
	public E dequeue() throws EmptyQueueException {
		if (list.size() == 0) {
			throw new EmptyQueueException();
		}
		return (E) list.remove(0);
	}

	@Override
	public E peek() throws EmptyQueueException {
		if (list.size() == 0) {
			throw new EmptyQueueException();
		}
		return (E) list.get(0);
	}

	@Override
	public boolean equals(QueueADT<E> that) throws NullPointerException {
		if (this == that) {
			return true;
		}
		if (list.size() != that.size()) {
			return false;
		}
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
		return list.iterator();
	}

	@Override
	public Object[] toArray() {
		return list.toArray();
	}

	@Override
	public E[] toArray(E[] copy) throws NullPointerException {
		return list.toArray(copy);
	}

	@Override
	public boolean isFull() {
		return false;
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
	public void dequeueAll(){
		list.clear();
	}

}
