package utilities;

import exceptions.TreeException;
import utilities.BSTreeNode;

public class BSTree<E extends Comparable<? super E>> implements BSTreeADT<E> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BSTreeNode<E> root;
	private int size;
	
	
	
	@Override
	public BSTreeNode<E> getRoot() throws TreeException {
		
		if(isEmpty()) {
			throw new TreeException();
		}else {
			return root;
		}
		
	}

	@Override
	public int getHeight() {
		if(root!=null) {
			return root.getHeight();
		}else {
			return 0;
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public void clear() {
		root=null;
		size=0;
		
	}

	@Override
	public boolean contains(E entry) throws TreeException {
		BSTreeNode<E> current=root;
		
		while(current !=null) {
			if(entry.compareTo(current.getElement())<0) {
				current.setLeft(current);
			}else if(entry.compareTo(current.getElement())>0) {
				current.setRight(current);
			}else {
				return true;
			}
			
		}
		
		return false;
	}

	@Override
	public BSTreeNode<E> search(E entry) throws TreeException {
		BSTreeNode<E> current=root;
		
		while(current !=null) {
			if(entry.compareTo(current.getElement())<0) {
				current.setLeft(current);
			}else if(entry.compareTo(current.getElement())>0) {
				current.setRight(current);
			}else {
				return current;
			}
			
		}
		
		return null;
	}

	@Override
	public boolean add(E newEntry) throws NullPointerException {
		if (root == null)
			root = new BSTreeNode<>(newEntry); // Create a new root
		else {
			// Locate the parent node
			BSTreeNode<E> parent = null;
			BSTreeNode<E> current = root;
			while (current != null) {
				if (newEntry.compareTo(current.getElement()) < 0) {
					parent = current;
					current=current.getLeft(); 
				}
				else if (newEntry.compareTo(current.getElement()) > 0) {
					parent = current;
					current=current.getRight();
				}
				else
					return false; // Duplicate node not inserted
			}
			// Create the new node and attach it to the parent
			if (newEntry.compareTo(parent.getElement()) < 0)
				parent.setLeft(new BSTreeNode<>(newEntry)); 
			else
				parent.setRight(new BSTreeNode<>(newEntry)); 
		}

		size++;
		return true; // Element inserted successfully
	}



	@Override
	public Iterator<E> inorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> preorderIterator() {
		

		return null;
	}

	@Override
	public Iterator<E> postorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}
		

}
