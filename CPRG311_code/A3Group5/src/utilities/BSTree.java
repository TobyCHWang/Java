package utilities;

import java.util.NoSuchElementException;
import java.util.Stack;

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
				current=current.getLeft();
			}else if(entry.compareTo(current.getElement())>0) {
				current=current.getRight();
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
				current=current.getLeft();
			}else if(entry.compareTo(current.getElement())>0) {
				current=current.getRight();
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
				else {
					return false;
				}
					
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
		return new InorderIterator();
	}

	@Override
	public Iterator<E> preorderIterator() {
		return new PreorderIterator();
	}

	@Override
	public Iterator<E> postorderIterator() {
		return new PostorderIterator();
	}
	
	/**************************************************
	 * INNER CLASS InorderIterator
	 **************************************************/
       private class InorderIterator implements Iterator<E>{
		
		private Stack<BSTreeNode<E>> nodeStack;
		private BSTreeNode<E> currentNode;
		
		public InorderIterator(){
            nodeStack = new Stack<>();
            currentNode = root;
        }
		
		
		@Override
		public boolean hasNext() {
			return !nodeStack.isEmpty() || (currentNode != null);
		}
		@Override
		public E next() throws NoSuchElementException {
			BSTreeNode<E> nextNode = null;

            // Find leftmost node with no left child
            while (currentNode != null)
            {
                nodeStack.push(currentNode);
                currentNode = currentNode.getLeft();
            }

            // Get leftmost node, then move to its right subtree
            if (!nodeStack.isEmpty())
            {
                nextNode = nodeStack.pop();
                assert nextNode != null; // Since nodeStack was not empty
                                         // before the pop
                currentNode = nextNode.getRight();
            }
            else
                throw new NoSuchElementException();

            return nextNode.getElement(); 
		}
   }
	
	/**************************************************
	 * INNER CLASS PreorderIterator
	 **************************************************/
	private class PreorderIterator implements Iterator<E>{
		
		private Stack<BSTreeNode<E>> nodeStack;
		private BSTreeNode<E> currentNode;
		
		public PreorderIterator(){
            nodeStack = new Stack<>();
            if (root != null)
                nodeStack.push(root);
        }
		
		@Override
		public boolean hasNext() {
			return !nodeStack.isEmpty();
		}
		@Override
		public E next() throws NoSuchElementException {
			BSTreeNode<E> nextNode;
            
            if (hasNext())
            {
                nextNode = nodeStack.pop();
                BSTreeNode<E> leftChild = nextNode.getLeft();
                BSTreeNode<E> rightChild = nextNode.getRight();
                
                // Push into stack in reverse order of recursive calls
                if (rightChild != null)
                    nodeStack.push(rightChild);
                    
                if (leftChild != null)
                    nodeStack.push(leftChild);
            }
            else
            {
                throw new NoSuchElementException();
            }
        
            return nextNode.getElement();
		}
	}
	
	/**************************************************
	 * INNER CLASS PostorderIterator
	 **************************************************/
	
	private class PostorderIterator implements Iterator<E>{
		
		private Stack<BSTreeNode<E>> nodeStack;
		private BSTreeNode<E> currentNode;
		
		 public PostorderIterator(){
	            nodeStack = new Stack<>();
	            currentNode = root;
	        }
		
		
		@Override
		public boolean hasNext() {
			return !nodeStack.isEmpty() || (currentNode != null);
		}

		@Override
		public E next() throws NoSuchElementException {
			boolean foundNext = false;
           BSTreeNode<E> leftChild, rightChild, nextNode = null;
         
            // Find leftmost leaf
            while (currentNode != null)
            {
                nodeStack.push(currentNode);
                leftChild = currentNode.getLeft();
                if (leftChild == null)
                   currentNode = currentNode.getRight();
                else
                   currentNode = leftChild;
            }
         
            // Stack is not empty either because we just pushed a node, or
            // it wasn't empty to begin with since hasNext() is true.
            // But Iterator specifies an exception for next() in case
            // hasNext() is false.
         
            if (!nodeStack.isEmpty())
            {
                nextNode = nodeStack.pop();
                // nextNode != null since stack was not empty before pop
                
                BSTreeNode<E> parent = null;
                if (!nodeStack.isEmpty())
                {
                   parent = nodeStack.peek();
                   if (nextNode == parent.getLeft())
                      currentNode = parent.getRight();
                   else
                      currentNode = null;
                }
                else
                   currentNode = null;
            }
            else
            {
                throw new NoSuchElementException();
            }
         
            return nextNode.getElement();
		}
		
	}
		

}
