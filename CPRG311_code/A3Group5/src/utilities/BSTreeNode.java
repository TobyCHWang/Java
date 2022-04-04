package utilities;

public class BSTreeNode<E> {
	private E element;	
	private BSTreeNode<E> left, right;
	
	
	
	/**
	 * @param element
	 * @param left
	 * @param right
	 */
	public BSTreeNode(E element, BSTreeNode<E> left, BSTreeNode<E> right) {
		super();
		this.element = element;
		this.left = left;
		this.right = right;
	}
	
	public BSTreeNode(E element) {
		super();
		this.element = element;
	}

	/**
	 * @return the element
	 */
	public E getElement() {
		return element;
	}

	/**
	 * @param element the element to set
	 */
	public void setElement(E element) {
		this.element = element;
	}

	/**
	 * @return the left
	 */
	public BSTreeNode<E> getLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(BSTreeNode<E> left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public BSTreeNode<E> getRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(BSTreeNode<E> right) {
		this.right = right;
	}
	
	public boolean hasLeftChild() {
		return left!=null;
	}
	
	
     public boolean hasRightChild() {
    	 return right!=null;
	}
     
     public boolean isLeaf() {
    	 return (left == null && right == null);
	}
     
     public int getNumberNodes() {
    	int leftSize=0;
    	int rightSize=0;
    	
    	if(this.left!=null) {
    		leftSize=this.left.getNumberNodes();
    	}
    	
    	if(this.right!=null) {
    		rightSize=this.right.getNumberNodes();
    	}
    	
    	return 1+leftSize+rightSize;
     }
	
     
     public int getHeight() {
    	 int leftHeight=0;
    	 int rightHeight=0;
    	 if(this.left!=null) {
    		 leftHeight=this.left.getHeight();
    	 }
    	 if(this.right!=null) {
    		 rightHeight=this.right.getHeight();
    	 }
    	 
    	 return 1+Math.max(leftHeight, rightHeight);
     }
     
     public int getHeight(BSTreeNode<E> node) {
    	 if (node == null) {
    		 return -1;
    	 }

    	 return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
     }
     
    
    
	
	


}
