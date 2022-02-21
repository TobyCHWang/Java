package utilities;

import java.util.NoSuchElementException;

public class MyDLL<E> implements ListADT<E> {
	
//	DLL NODE
	private MyDLLNode<E> head,tail;
    private int size;
    
    public MyDLL(){
       this.head =  this.tail = null;
    }
    
    
	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		size=0;
		head=null;
		tail=null;
		
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		
		if (toAdd == null) {
			throw new NullPointerException();
		}
		
		MyDLLNode<E> newNode=new MyDLLNode<E>(toAdd);
		
		if (head == null) {		// list is empty, index must be 0
			head = newNode;
			tail = newNode;
		}
		else if (index == 0) {			// insert before head
			newNode.setNext(head); 
			head.setPrev(newNode); 
			head = newNode;
		}
		else if (index == size) { 	// insert after tail
			newNode.setPrev(tail);
			tail.setNext(newNode);
			tail = newNode;
		}
		else {					// general case
			MyDLLNode<E> currentNode = head;
			for (int i = 1; i < index; i++) 
				currentNode = currentNode.getNext();
			// nodeRef now points to the node before the insert point
			// see course notes for pictures!
			newNode.setNext(currentNode.getNext()); 
			currentNode.setNext(newNode); 
			newNode.setPrev(currentNode); 
			newNode.getNext().setPrev(newNode); 
		}
		size++;
	
		return true;
		
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if (toAdd == null) {
			throw new NullPointerException();
		}
		
		MyDLLNode<E> newNode=new MyDLLNode<E>(toAdd,null,null);
		
		if(tail==null) {
			head=newNode;
			tail=head;
		}else {
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail=newNode;
		}
		size++;
		return true;
		
		
		
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		if (toAdd == null) {
			throw new NullPointerException();
		}
		if(toAdd==this) {
			ListADT<E> temp=new MyDLL<E>();
			Iterator<E> iterator=(Iterator<E>) toAdd.iterator();
			while(iterator.hasNext()) {
				temp.add(iterator.next());
			}
			iterator=temp.iterator();
			while(iterator.hasNext()) {
				this.add(iterator.next());
			}
		}else {
			Iterator<E> iterator=(Iterator<E>) toAdd.iterator();
			while(iterator.hasNext()) {
				this.add(iterator.next());
			}
		}
		return true;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		MyDLLNode<E> currentNode = head;
		
		for (int i = 0; i < index; i++) {
            currentNode=currentNode.getNext();
        }
		
		return (E) currentNode.getInformation();
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		  MyDLLNode<E> currentNode = head;
	        if (index == 0) {
	            head = head.getNext();
	            currentNode.setNext(null); 
	            
	        } else {
	        	MyDLLNode currentNodeBefore = null;
	            for (int i = 0; i < index; i++) {
	                currentNodeBefore = currentNode;
	                currentNode = currentNode.getNext();  
	            }
	            
	            if (index == size - 1) {
	                tail = currentNodeBefore;  
	                tail.setNext(null); 
	            } else {
	                currentNodeBefore.setNext(currentNode.getNext()); 
	                currentNode.getNext().setPrev(currentNodeBefore); 
	            }
	            currentNode.setPrev(null); 
	            currentNode.setNext(null); 
	        }
	        size--;
	        return (E) currentNode;
		
		
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		if (toRemove == null) {
			throw new NullPointerException();
		}
		
		
		boolean dataFound=false;
		MyDLLNode<E> currentNode=this.head;
		while(!dataFound) {
			if(currentNode.getInformation().equals(toRemove)) {
				MyDLLNode<E> previousNode=currentNode.getPrev();
				MyDLLNode<E> nextNode=currentNode.getNext();
				if(previousNode !=null) {
					previousNode.setNext(nextNode);
				}
				else {
					head=nextNode;
				}
				if(nextNode !=null) {
					nextNode.setPrev(previousNode);
				}
				dataFound=true;
			}
			else {
				currentNode=currentNode.getNext();
			}
		}
		size--;
		return (E) currentNode;
	}
	


	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		if (toChange == null) {
			throw new NullPointerException();
		}
		
		MyDLLNode<E> currentNode = head;
		
		for (int i = 0; i < index; i++) {
            currentNode=currentNode.getNext();
        }
		currentNode.setInformation(toChange);
		return (E) currentNode;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) {
			throw new NullPointerException();
		}
		
		MyDLLNode<E> currentNode=head;
		do {
			if(currentNode.getInformation().equals(toFind)) {
				return true;
			}else {
				currentNode=currentNode.getNext();
			}
		}while(currentNode!=null);
		
		return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if(toHold.length>=size) {
			int pos=0;
			Iterator<E> iterator=this.iterator();
			while(iterator.hasNext()) {
				toHold[pos]=iterator.next();
				pos++;
			}
			return toHold;
		}else {
				Object[] elementObject=(E[])new Object[size];
				int pos=0;
				Iterator<E> iterator=this.iterator();
				while(iterator.hasNext()) {
					elementObject[pos]=iterator.next();
					pos++;
				}
				return (E[]) elementObject;	
		}
		
	}

	@Override
	public Object[] toArray() {
		Object[] objects=new Object[size];
		int pos=0;
		Iterator<E> iterator=this.iterator();
		while(iterator.hasNext()) {
			objects[pos]=iterator.next();
			pos++;
		}
		return objects;
	}

	@Override
	public Iterator<E> iterator() {
		DoubleLinkedListIterator doubleLinkedListIterator=new DoubleLinkedListIterator(this, head);

		return doubleLinkedListIterator;
	}
	
	/******inner class*************/
	
	private class DoubleLinkedListIterator implements Iterator<E>{
//attributes		
		private MyDLL<E> dll;
		private MyDLLNode<E> node;
		private int pos;
		private boolean begin;
		
		//constructor
		public DoubleLinkedListIterator(MyDLL<E> dll,MyDLLNode<E> node) {
			this.dll=dll;
			this.node=node;
			this.begin=false;
		}
		

		@Override
		public boolean hasNext() {
			if(this.begin==false) {
				if(node!=null) {
					return true;
				}else {
					return false;
				}
			}
			MyDLLNode<E> temp=node.getNext();
			if(temp!=null) {
				return true;
			}else {
				return false;
			}	
				
		}

		@Override
		public E next() throws NoSuchElementException {
			if (pos >= size || this.node==null) {
				throw new NoSuchElementException();
			}
			
			if(this.begin==false) {
				this.begin=true;
				if(node!=null) {
					return node.getInformation();
				}else {
					return null;
				}
			}else {
				node=node.getNext();
				if(node==null){
					throw new NoSuchElementException();	
				}
				return node.getInformation();
			}
			
		}
		
	}
	

}
