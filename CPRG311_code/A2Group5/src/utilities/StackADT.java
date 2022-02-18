package utilities;

import java.util.EmptyStackException;

public interface StackADT<E> {
	
	 /**  
     * Adds the specified element to the top of this stack. 
     * @param element element to be pushed onto the stack
     * @return true if element is pushed successfully. 
     */
    public boolean push(E element);
    
    /**  
     * Removes and returns the top element from this stack. 
     * @return the element removed from the stack
     */
    public E pop() throws EmptyStackException;

    /**  
     * Returns without removing the top element of this stack. 
     * @return the element on top of the stack
     */
    public E peek() throws EmptyStackException;
    
    /**  
     * Two stacks must contain equal items appearing in the same order. 
     * @return true if two stacks contain equal items
     */
    
    public boolean equals( StackADT<E> that);
    
    /**
	 * Returns an iterator over the elements in this list, in proper sequence.
	 * 
	 * @return An iterator over the elements in this list, in proper sequence.
	 * 			NB: The return is of type 
	 * 			<code>linearUtilities.Iterator<E></code>,
	 * 			not <code>java.util.Iterator</code>.
	 */
	public Iterator<E> iterator();
    
	
	/**
	 * Returns an array containing all of the items in this stack
	 * Obeys the general contract of the
	 * <code>java.util.Collection.toArray(Object [])</code> method.
	 * 
	 * @param copy
	 *			The array into which the elements of this list are to be
	 * 			stored, if it is big enough; otherwise, a new array of the
	 * 			same runtime type is allocated for this purpose.
	 * @return An array containing the elements of this list.
	 * @throws NullPointerException
	 * 			If the specified array is <code>null</code>.
	 */
	public E[] toArray( E[] copy) throws EmptyStackException;
	
	
	/**
	 * Returns an array containing all of the items in this stack
	 * sequence. Obeys the general contract of the 
	 * <code>java.util.Collection.toArray()</code> method.
	 * 
	 * @return An array containing all of the elements in this list in proper
	 * 			sequence.
	 */
	public Object[] toArray();
	
	
	/**
	 * 
	 */
	
	public int search(E obj) throws EmptyStackException;
	
	
	/**
	 * Returns true if this list contains the specified element. More formally,
	 * returns true if and only if this list contains at least one 
	 * element <code>e</code> such that <code>toFind.equals(e)</code>.
	 * 
	 * @param toFind
	 * 			The element whose presence in this list is to be tested.
	 * @return <code>true</code> if this list contains the specified element.
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code> and the
	 * 			list implementation does not support having 
	 * 			<code>null</code> elements.
	 */
	public boolean contains( E obj ) throws EmptyStackException;
    
    
    /**  
     * Returns true if this stack contains no elements. 
     * @return true if the stack is empty
     */
    public boolean isEmpty();
    
    /** 
     * Returns the number of elements in this stack. 
     * @return the number of elements in the stack
     */
    public int size();
    
    /**
	 * Removes all of the elements from this list. This list will be empty after
	 * this call returns.
	 */
	public void clear();
    

}
