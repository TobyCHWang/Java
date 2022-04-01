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

/**
 * @author krist
 *
 */
class MyStackTests {

	// attributes
	StackADT<String> list;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		list = new MyStack<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		list = null;
	}

	/**
	 * Test method for {@link utilities.MyStack#push(java.lang.Object)}.
	 */
	@Test
	void testPushEmpty() {
		list.push("A");
		assertEquals(1, list.size());
		assertEquals("A", list.peek());
		
	}

	/**
	 * Test method for {@link utilities.MyStack#push(java.lang.Object)}.
	 */
	@Test
	void testPushNotEmpty() {
		list.push("A");
		list.push("B");
		list.push("C");
		assertEquals(3, list.size());
		assertEquals("C", list.peek());
		
	}

	/**
	 * Test method for {@link utilities.MyStack#push(java.lang.Object)}.
	 */
	@Test
	void testPushNullPointerException() {
		try {
			list.push(null);
			fail("NullPointerException wasn't thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyStack#pop()}.
	 */
	@Test
	void testPopEmptyStackException() {
		try {
			list.pop();
			fail("EmptyStackException wasn't thrown!");
		} catch (EmptyStackException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyStack#pop()}.
	 */
	@Test
	void testPopNotEmpty() {
		list.push("A");
		list.push("B");
		list.push("C");
		assertEquals("C", list.pop());
		assertEquals(2, list.size());
		assertEquals("B", list.peek());
	}

	/**
	 * Test method for {@link utilities.MyStack#peek()}.
	 */
	@Test
	void testPeekEmptyStackException() {
		try {
			list.peek();
			fail("EmptyStackException wasn't thrown!");
		} catch (EmptyStackException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyStack#peek()}.
	 */
	@Test
	void testPeekNotEmpty() {
		list.push("A");
		list.push("B");
		list.push("C");
		assertEquals(3, list.size());
		assertEquals("C", list.peek());
	}

	/**
	 * Test method for {@link utilities.MyStack#equals(utilities.StackADT)}.
	 */
	@Test
	void testEqualsStackADTOfEEmpty() {
		StackADT<String> newList = new MyStack<>();
		boolean equals = list.equals(newList);
		assertTrue(equals);
	}
	
	// TODO confirm
	/**
	 * Test method for {@link utilities.MyStack#equals(utilities.StackADT)}.
	 */
	@Test
	void testEqualsStackADTOfENotEmptySameClassEquals() {
		list.push("A");
		list.push("B");
		StackADT<String> newList = new MyStack<>();
		newList.push("A");
		newList.push("B");
		boolean equals = list.equals(newList);
		assertFalse(equals);
	}

	/**
	 * Test method for {@link utilities.MyStack#equals(utilities.StackADT)}.
	 */
	@Test
	void testEqualsStackADTOfENotEmptySameClassNotEquals() {
		list.push("A");
		StackADT<String> newList = new MyStack<>();
		newList.push("B");
		boolean equals = list.equals(newList);
		assertFalse(equals);
	}

	/**
	 * Test method for {@link utilities.MyStack#equals(utilities.StackADT)}.
	 */
	@Test
	void testEqualsStackADTOfENotEmptyDiffClass() {
		list.push("A");
		StackADT<Integer> newList = new MyStack<>();
		newList.push(1);
		boolean equals = list.equals(newList);
		assertFalse(equals);
	}

	/**
	 * Test method for {@link utilities.MyStack#equals(utilities.StackADT)}.
	 */
	@Test
	void testEqualsStackADTOfENullPointerException() {
		try {
			list.equals(null);
			fail("NullPointerException wasn't thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyStack#iterator()}.
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
	 * Test method for {@link utilities.MyStack#iterator()}.
	 */
	@Test
	void testIteratorNotEmpty() {
		list.push("A");
		list.push("B");
		list.push("C");
		Iterator<String> it = list.iterator();
		assertTrue(it.hasNext());
		while (it.hasNext()) {
			assertEquals(list.peek(), it.next());
			list.pop();
		}
		assertFalse(it.hasNext());
		assertThrows(NoSuchElementException.class, () -> {
			it.next();
		});
	}

	/**
	 * Test method for {@link utilities.MyStack#toArray()}.
	 */
	@Test
	void testToArrayEmpty() {
		Object[] arr = list.toArray();
		assertEquals(0, arr.length);
	}

	/**
	 * Test method for {@link utilities.MyStack#toArray()}.
	 */
	@Test
	void testToArrayNotEmpty() {
		list.push("A");
		list.push("B");
		list.push("C");
		Object[] arr = list.toArray();
		assertEquals(3, arr.length);
		assertEquals("C", arr[0]);
		assertEquals("B", arr[1]);
		assertEquals("A", arr[2]);
		for (int i = 0; i < arr.length; i++) {
			assertEquals(list.pop(), arr[i]);
		}
	}

	/**
	 * Test method for {@link utilities.MyStack#toArray(E[])}.
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
	 * Test method for {@link utilities.MyStack#toArray(E[])}.
	 */
	@Test
	void testToArrayEArrayNotEmptySufficient() {
		list.push("A");
		list.push("B");
		list.push("C");
		String[] arr = new String[3];
		arr = list.toArray(arr);
		assertEquals(3, arr.length);
		assertEquals("C", arr[0]);
		assertEquals("B", arr[1]);
		assertEquals("A", arr[2]);
		for (int i = 0; i < arr.length; i++) {
			assertEquals(list.pop(), arr[i]);
		}
		
	}

	/**
	 * Test method for {@link utilities.MyStack#toArray(E[])}.
	 */
	@Test
	void testToArrayEArrayNotEmptyInsufficient() {
		list.push("A");
		list.push("B");
		list.push("C");
		String[] arr = new String[1];
		arr = list.toArray(arr);
		assertEquals(3, arr.length);
		assertEquals("C", arr[0]);
		assertEquals("B", arr[1]);
		assertEquals("A", arr[2]);
		for (int i = 0; i < arr.length; i++) {
			assertEquals(list.pop(), arr[i]);
		}
	}

	/**
	 * Test method for {@link utilities.MyStack#toArray(E[])}.
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
	 * Test method for {@link utilities.MyStack#search(java.lang.Object)}.
	 */
	@Test
	void testSearchEmpty() {
		assertEquals(-1, list.search("A"));
	}

	/**
	 * Test method for {@link utilities.MyStack#search(java.lang.Object)}.
	 */
	@Test
	void testSearchNotEmptyFound() {
		list.push("A");
		list.push("B");
		list.push("C");
		assertEquals(3, list.size());
		assertEquals("C", list.peek());
		assertEquals(3, list.search("A"));
		assertEquals(2, list.search("B"));
		assertEquals(1, list.search("C"));
	}

	/**
	 * Test method for {@link utilities.MyStack#search(java.lang.Object)}.
	 */
	@Test
	void testSearchNotEmptyNotFound() {
		list.push("A");
		list.push("B");
		list.push("C");
		assertEquals(3, list.size());
		assertEquals("C", list.peek());
		assertEquals(-1, list.search("D"));
	}

	/**
	 * Test method for {@link utilities.MyStack#search(java.lang.Object)}.
	 */
	@Test
	void testSearchNullPointerException() {
		try {
			list.search(null);
			fail("NullPointerException wasn't thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyStack#contains(java.lang.Object)}.
	 */
	@Test
	void testContainsEmpty() {
		boolean contains = list.contains("A");
		assertFalse(contains);
	}

	/**
	 * Test method for {@link utilities.MyStack#contains(java.lang.Object)}.
	 */
	@Test
	void testContainsNotEmpty() {
		list.push("A");
		list.push("B");
		list.push("C");
		boolean contains = list.contains("B");
		assertEquals(3, list.size());
		assertEquals("C", list.peek());
		assertTrue(contains);
	}

	/**
	 * Test method for {@link utilities.MyStack#contains(java.lang.Object)}.
	 */
	@Test
	void testContainsNullPointerException() {
		try {
			list.contains(null);
			fail("NullPointerException wasn't thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyStack#size()}.
	 */
	@Test
	void testSizeEmpty() {
		assertEquals(0, list.size());
	}

	/**
	 * Test method for {@link utilities.MyStack#size()}.
	 */
	@Test
	void testSizeNotEmpty() {
		list.push("A");
		list.push("B");
		list.push("C");
		assertEquals(3, list.size());
		assertEquals("C", list.peek());
	}

	/**
	 * Test method for {@link utilities.MyStack#isEmpty()}.
	 */
	@Test
	void testIsEmptyEmpty() {
		boolean empty = list.isEmpty();
		assertTrue(empty);
	}

	/**
	 * Test method for {@link utilities.MyStack#isEmpty()}.
	 */
	@Test
	void testIsEmptyNotEmpty() {
		list.push("A");
		list.push("B");
		list.push("C");
		boolean empty = list.isEmpty();
		assertEquals(3, list.size());
		assertEquals("C", list.peek());
		assertFalse(empty);
	}

	/**
	 * Test method for {@link utilities.MyStack#clear()}.
	 */
	@Test
	void testClearEmpty() {
		list.clear();
		assertEquals(0, list.size());
	}

	/**
	 * Test method for {@link utilities.MyStack#clear()}.
	 */
	@Test
	void testClearNotEmpty() {
		list.push("A");
		list.push("B");
		list.push("C");
		list.clear();
		assertEquals(0, list.size());
	}

}
