/**
 * 
 */
package utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exception.EmptyQueueException;

/**
 * @author water
 *
 */

class MyQueueTests {

	/**
	 * @throws java.lang.Exception
	 */
	// attributes
	QueueADT<String> list;
	
	@BeforeEach
	void setUp() throws Exception {
		list= new MyQueue<>(); 
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		list=null;
	}

	

	/**
	 * Test method for {@link utilities.MyQueue#enqueue(java.lang.Object)}.
	 * @throws EmptyQueueException 
	 */
	@Test
	void testEnqueue() {
		list.enqueue("A");
		list.enqueue("B");
		list.enqueue("C");
		assertEquals(3, list.size());
		try {
			assertEquals("A", list.peek());
		} catch (EmptyQueueException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link utilities.MyQueue#dequeue()}.
	 */
	@Test
	void testDequeue() {
		list.enqueue("A");
		list.enqueue("B");
		list.enqueue("C");
		
		try {
			list.dequeue();
		} catch (EmptyQueueException e) {
			e.printStackTrace();
		}
		
		try {
			assertEquals("B", list.peek());
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link utilities.MyQueue#peek()}.
	 */
	@Test
	void testPeek() {
		list.enqueue("A");
		list.enqueue("B");
		list.enqueue("C");
		
		try {
			assertEquals("A", list.peek());
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link utilities.MyQueue#equals(utilities.QueueADT)}.
	 */
	@Test
	void testEqualsQueueADTOfE() {
		MyQueue<String> additionalMyQueue=new MyQueue<>();
		MyQueue<String> additionalMyQueueNot=new MyQueue<>();
		list.enqueue("A");
		list.enqueue("B");
		list.enqueue("C");
		list.enqueue("C");
		
		additionalMyQueue.enqueue("A");
		additionalMyQueue.enqueue("B");
		additionalMyQueue.enqueue("C");
		additionalMyQueue.enqueue("C");
		
		additionalMyQueueNot.enqueue("A");
		additionalMyQueueNot.enqueue("B");
		additionalMyQueueNot.enqueue("V");
		
		assertTrue(list.equals(additionalMyQueue));
		assertFalse(list.equals(additionalMyQueueNot));
	}

	/**
	 * Test method for {@link utilities.MyQueue#iterator()}.
	 */
	@Test
	void testIterator() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyQueue#toArray()}.
	 */
	@Test
	void testToArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyQueue#toArray(E[])}.
	 */
	@Test
	void testToArrayEArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyQueue#isFull()}.
	 */
	@Test
	void testIsFull() {
		list.enqueue("A");
		list.enqueue("B");
		list.enqueue("C");
		
		assertFalse(list.isFull());
	}

	/**
	 * Test method for {@link utilities.MyQueue#dequeueAll()}.
	 */
	@Test
	void testDequeueAll() {
		list.enqueue("A");
		list.enqueue("B");
		list.enqueue("C");
		
		assertEquals(3, list.size());
		
		try {
			list.dequeueAll();
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(0, list.size());
	}

	/**
	 * Test method for {@link utilities.MyQueue#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		list.enqueue("A");
		list.enqueue("B");
		list.enqueue("C");
		
		assertFalse(list.isEmpty());
		
		try {
			list.dequeueAll();
		} catch (EmptyQueueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(list.isEmpty());
	}

	/**
	 * Test method for {@link utilities.MyQueue#size()}.
	 */
	@Test
	void testSize() {
		list.enqueue("A");
		list.enqueue("B");
		list.enqueue("C");
		
		assertEquals(3, list.size());
	}

}
