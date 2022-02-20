package utilities;

import exception.EmptyQueueException;

public interface QueueADT<E> {
	
	 /**  
     * Adds one element to the rear of this queue. 
     * @param element  the element to be added to the rear of the queue 
     * @return true if element is added successfully. 
     * @exception if element is null 
     */
    public boolean enqueue(E element) throws NullPointerException;
    
    /**  
     * Removes and returns the element at the front of this queue.
     * @return the element at the front of the queue
     * @exception EmptyQueueException if queue is empty 
     */
    public E dequeue() throws EmptyQueueException;
    
    /**  
     * Returns without removing the element at the front of this queue.
     * @return the first element in the queue
     */
    public E peek() throws EmptyQueueException;
    
    /**
     * Two queues must contain equal items appearing in the same order
     * @param that, the queue need to be compared 
     * @return <code>true</code> if Two queues must contain equal items appearing in the same order.
     */
    
    public boolean equals( QueueADT<E> that) throws NullPointerException;
    
    /**
     * optional
     */
    public Iterator<E> iterator();
    
    /**
     * 
     */
    
    public Object[] toArray();
    
    /**
     * 
     */
    public E[] toArray(E[] copy) throws NullPointerException;
    
    /**
     * 
     */
    public boolean isFull();
    
    /**
     * 
     */
    public void dequeueAll() throws EmptyQueueException;
    
    /**  
     * Returns true if this queue contains no elements.
     * @return true if this queue is empty
     */
    public boolean isEmpty();
    
    /**  
     * Returns the number of elements in this queue. 
     * @return the integer representation of the size of the queue
     */
    public int size();

}
