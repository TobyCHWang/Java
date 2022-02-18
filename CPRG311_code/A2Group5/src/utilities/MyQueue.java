package utilities;

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
	public E dequeue() {
		return list.remove(0);
	}

	@Override
	public E peek() {
		return list.get(0);
	}

	@Override
	public boolean equals(QueueADT<E> that) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E[] toArray(E[] copy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public void dequeueAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return list.size();
	}

}
