package utilities;

import exception.EmptyQueueException;

public class MyQueue<E> implements QueueADT<E> {
	
	private MyDLL<E> list;
	
	public MyQueue() {
		list=new MyDLL<>();
	}
	
	
	@Override
	public boolean enqueue(E toPush) {
		return list.add(toPush);
		
	}

	@Override
	public E dequeue() throws EmptyQueueException {
		return list.remove(0);
	}

	@Override
	public E peek() throws EmptyQueueException{
		return list.get(0);
	}

	@Override
	public boolean equals(QueueADT<E> that) throws NullPointerException {
		boolean condition=false;
		
		for(int i=list.size()-1;i>=0;i--) {
			try {
				if(list.get(i).equals(that.peek())) {
					condition=true;
					that.dequeue();
				}else {
					condition=false;
				}
			} catch (IndexOutOfBoundsException e) {
				
				e.printStackTrace();
			} catch (EmptyQueueException e) {
				
				e.printStackTrace();
			}
		}
		
		
		return condition;
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
	public E[] toArray(E[] copy) {
		return list.toArray(copy);
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public void dequeueAll() {
		list.clear();
		
	}

	@Override
	public boolean isEmpty() {
		return (list.size()==0);
	}

	@Override
	public int size() {
		return list.size();
	}

}
