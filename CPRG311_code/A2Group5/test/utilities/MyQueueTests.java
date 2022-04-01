/**
 * 
 */
package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exception.EmptyQueueException;

/**
 * @author krist
 *
 */
class MyQueueTests {

	// attributes
	QueueADT<String> list;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		list = new MyQueue<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		list = null;
	}

	/**
	 * Test method for {@link utilities.MyQueue#enqueue(java.lang.Object)}.
	 */
	@Test
	void testEnqueueEmpty() {
		list.enqueue("A");
		assertEquals(1, list.size());
		
	}

	/**
	 * Test method for {@link utilities.MyQueue#enqueue(java.lang.Object)}.
	 */
	@Test
	void testEnqueueNotEmpty() {
		list.enqueue("A");
		list.enqueue("B");
		list.enqueue("C");
		assertEquals(3, list.size());
		
	}

	/**
	 * Test method for {@link utilities.MyQueue#enqueue(java.lang.Object)}.
	 */
	@Test
	void testEnqueueNullPointerException() {
		try {
			list.enqueue(null);
			fail("NullPointerException wasn't thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyQueue#dequeue()}.
	 * 
	 * @throws EmptyQueueException
	 */
	@Test
	void testDequeueNotEmpty() throws EmptyQueueException {
		list.enqueue("A");
		list.enqueue("B");
		list.enqueue("C");
		assertEquals("A", list.dequeue());
		assertEquals("B", list.peek());
	}

	/**
	 * Test method for {@link utilities.MyQueue#dequeue()}.
	 */
	@Test
	void testDequeueEmptyQueueException() {
		try {
			list.dequeue();
			fail("EmptyQueueException wasn't thrown!");
		} catch (EmptyQueueException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyQueue#peek()}.
	 * 
	 * @throws EmptyQueueException
	 */
	@Test
	void testPeekEmpty() throws EmptyQueueException {
		list.enqueue("A");
		list.enqueue("B");
		list.enqueue("C");
		assertEquals("A", list.peek());
		assertEquals(3, list.size());
	}

	/**
	 * Test method for {@link utilities.MyQueue#peek()}.
	 */
	@Test
	void testPeekNotEmptyQueueException() {
		try {
			list.peek();
			fail("EmptyQueueException wasn't thrown!");
		} catch (EmptyQueueException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyQueue#equals(utilities.QueueADT)}.
	 */
	@Test
	void testEqualsQueueADTOfEEmpty() {
		QueueADT<String> newList = new MyQueue<>();
		boolean equals = list.equals(newList);
		assertTrue(equals);
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#equals(utilities.QueueADT)}.
	 */
	@Test
	void testEqualsQueueADTOfENotEmptySameClassEquals() {
		list.enqueue("A");
		list.enqueue("B");
		QueueADT<String> newList = new MyQueue<>();
		newList.enqueue("A");
		newList.enqueue("B");
		boolean equals = list.equals(newList);
		assertTrue(equals);
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#equals(utilities.QueueADT)}.
	 */
	@Test
	void testEqualsQueueADTOfENotEmptySameClassNotEquals() {
		list.enqueue("B");
		list.enqueue("A");
		QueueADT<String> newList = new MyQueue<>();
		newList.enqueue("A");
		newList.enqueue("B");
		boolean equals = list.equals(newList);
		assertFalse(equals);
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#equals(utilities.QueueADT)}.
	 */
	@Test
	void testEqualsQueueADTOfENotEmptyDifferentClass() {
		list.enqueue("A");
		QueueADT<Integer> newList = new MyQueue<>();
		newList.enqueue(1);
		boolean equals = list.equals(newList);
		assertFalse(equals);
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#equals(utilities.QueueADT)}.
	 */
	@Test
	void testEqualsQueueADTOfENullPointerException() {
		try {
			list.equals(null);
			fail("NullPointerException wasn't thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyQueue#iterator()}.
	 */
	@Test
	void testIteratorEmpty() {
		Iterator<String> it = list.iterator();
		assertFalse(it.hasNext());
		assertThrows(NoSuchElementException.class, () -> {
			it.next();
		});
	}

	/**
	 * Test method for {@link utilities.MyQueue#iterator()}.
	 * 
	 * @throws EmptyQueueException
	 * @throws NoSuchElementException
	 */
	@Test
	void testIteratorNotEmpty() throws NoSuchElementException, EmptyQueueException {
		list.enqueue("A");
		list.enqueue("B");
		list.enqueue("C");
		Iterator<String> it = list.iterator();
		assertTrue(it.hasNext());
		while (it.hasNext()) {
			assertEquals(list.peek(), it.next());
			list.dequeue();
		}
		assertFalse(it.hasNext());
		assertThrows(NoSuchElementException.class, () -> {
			it.next();
		});
	}

	/**
	 * Test method for {@link utilities.MyQueue#toArray()}.
	 */
	@Test
	void testToArrayEmpty() {
		Object[] arr = list.toArray();
		assertEquals(0, arr.length);
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#toArray()}.
	 * @throws EmptyQueueException 
	 */
	@Test
	void testToArrayNotEmpty() throws EmptyQueueException {
		list.enqueue("A");
		list.enqueue("B");
		list.enqueue("C");
		Object[] arr = list.toArray();
		assertEquals(3, arr.length);
		for (int i = 0; i < arr.length; i++) {
			assertEquals(list.peek(), arr[i]);
			list.dequeue();
		}
	}

	/**
	 * Test method for {@link utilities.MyQueue#toArray(E[])}.
	 */
	@Test
	void testToArrayEArrayEmpty() {
		String[] arr = new String[3];
		arr = list.toArray(arr);
		assertEquals(3, arr.length);
		for (int i = 0; i < arr.length; i++) {
			assertNull(arr[i]);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#toArray(E[])}.
	 * @throws EmptyQueueException 
	 */
	@Test
	void testToArrayEArrayNotEmptySufficient() throws EmptyQueueException {
		list.enqueue("A");
		list.enqueue("B");
		list.enqueue("C");
		String[] arr = new String[3];
		arr = list.toArray(arr);
		assertEquals(3, arr.length);
		for (int i = 0; i < arr.length; i++) {
			assertEquals(list.dequeue(), arr[i]);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#toArray(E[])}.
	 * @throws EmptyQueueException 
	 */
	@Test
	void testToArrayEArrayNotEmptyInsufficient() throws EmptyQueueException {
		list.enqueue("A");
		list.enqueue("B");
		list.enqueue("C");
		String[] arr = new String[1];
		arr = list.toArray(arr);
		assertEquals(3, arr.length);
		for (int i = 0; i < arr.length; i++) {
			assertEquals(list.dequeue(), arr[i]);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#toArray(E[])}.
	 */
	@Test
	void testToArrayEArrayNullPointerException() {
		try {
			list.toArray(null);
			fail("NullPointerException wasn't thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyQueue#isFull()}.
	 */
	@Test
	void testIsFullEmpty() {
		boolean full = list.isFull();
		assertFalse(full);
	}

	/**
	 * Test method for {@link utilities.MyQueue#isFull()}.
	 */
	@Test
	void testIsFullNotEmpty() {
		list.enqueue("A");
		list.enqueue("B");
		list.enqueue("C");
		boolean full = list.isFull();
		assertFalse(full);
	}

	/**
	 * Test method for {@link utilities.MyQueue#size()}.
	 */
	@Test
	void testSizeEmpty() {
		assertEquals(0, list.size());
	}

	/**
	 * Test method for {@link utilities.MyQueue#size()}.
	 */
	@Test
	void testSizeNotEmpty() {
		list.enqueue("A");
		list.enqueue("B");
		list.enqueue("C");
		assertEquals(3, list.size());
	}

	/**
	 * Test method for {@link utilities.MyQueue#isEmpty()}.
	 */
	@Test
	void testIsEmptyEmpty() {
		boolean empty = list.isEmpty();
		assertTrue(empty);
	}

	/**
	 * Test method for {@link utilities.MyQueue#isEmpty()}.
	 */
	@Test
	void testIsEmptyNotEmpty() {
		list.enqueue("A");
		list.enqueue("B");
		list.enqueue("C");
		boolean empty = list.isEmpty();
		assertFalse(empty);
	}

	/**
	 * Test method for {@link utilities.MyQueue#dequeueAll()}.
	 */
	@Test
	void testDequeueAllEmpty() {
		boolean empty = list.isEmpty();
		assertTrue(empty);
		assertEquals(0, list.size());
	}

	/**
	 * Test method for {@link utilities.MyQueue#dequeueAll()}.
	 */
	@Test
	void testDequeueAllNotEmpty() {
		list.enqueue("A");
		list.enqueue("B");
		list.enqueue("C");
		boolean empty = list.isEmpty();
		assertFalse(empty);
		assertEquals(3, list.size());
	}
}
