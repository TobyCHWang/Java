package utilities;

import java.util.EmptyStackException;

public class MyStack<E> implements StackADT<E> {
	private MyArrayList<E> list;
	
	public MyStack() {
		list=new MyArrayList<>();
	}
	
	@Override
	public boolean push(E toPush) throws NullPointerException {
		return list.add(toPush);
	}
	

	@Override
	public E pop() throws EmptyStackException {
		return list.remove(list.size()-1);
	}

	@Override
	public E peek() throws EmptyStackException {
		return list.get(list.size()-1);
	}

	@Override
	public boolean equals(StackADT<E> that) throws NullPointerException {
		boolean condition=false;
		
		for(int i=list.size()-1;i>=0;i--) {
			if(list.get(i).equals(that.peek())) {
				condition=true;
				that.pop();
			}else {
				condition=false;
			}
		}
		
		
		return condition;
	}

	@Override
	public Iterator<E> iterator() {
		return list.iterator();
	}

	@Override
	public E[] toArray(E[] copy) throws NullPointerException {
		for(int i=0;i<list.size()/2;i++) {
			E temp=list.get(i);
			list.set(i, list.get(list.size()-i-1));
			list.set(list.size()-i-1, temp);
		}
		System.arraycopy(list, 0, copy, 0, list.size());
		return copy;
	}

	@Override
	public Object[] toArray() {
		for(int i=0;i<list.size()/2;i++) {
			E temp=list.get(i);
			list.set(i, list.get(list.size()-i-1));
			list.set(list.size()-i-1, temp);
		}
		
		
		return list.toArray();
	}

	@Override
	public int search(E obj) throws NullPointerException {
		for(int i=0;i<list.size();i++) {
			if(list.get(i)==obj) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean contains(E obj) throws NullPointerException {
		return list.contains(obj);
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
	   list.clear();
			
	}



	



	
	
	
}
