package utilities;

public class MyStack<E> implements StackADT<E> {
	private MyArrayList<E> list;
	
	public MyStack() {
		list=new MyArrayList<>();
	}
	
	@Override
	public boolean push(E toPush) {
		return list.add(toPush);
	}
	

	@Override
	public E pop() {
		return list.remove(list.size()-1);
	}

	@Override
	public E peek() {
		return list.get(list.size()-1);
	}

	@Override
	public boolean equals(StackADT<E> that) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E[] toArray(E[] copy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int search(E obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(E obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		return (list.size()==0);
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}



	



	
	
	
}
