/**
 * 
 */
package utilities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author water
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
		list=new MyStack<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		list=null;
	}


	/**
	 * Test method for {@link utilities.MyStack#push(java.lang.Object)}.
	 */
	@Test
	void testPush() {
		list.push("A");
		list.push("B");
		list.push("C");
		assertEquals(3, list.size());
		assertEquals("C", list.peek());
	}

	/**
	 * Test method for {@link utilities.MyStack#pop()}.
	 */
	@Test
	void testPop() {
		list.push("A");
		list.push("B");
		list.push("C");
		
		list.pop();
		assertEquals(2, list.size());
		assertEquals("B", list.peek());
	}

	/**
	 * Test method for {@link utilities.MyStack#peek()}.
	 */
	@Test
	void testPeek() {
		list.push("A");
		list.push("B");
		list.push("C");
		assertEquals("C", list.peek());
	}

	/**
	 * Test method for {@link utilities.MyStack#equals(utilities.StackADT)}.
	 */
	@Test
	void testEqualsStackADTOfE() {
		MyStack<String> additonMyStack=new MyStack<>();
		MyStack<String> additonMyStackNot=new MyStack<>();
		list.push("A");
		list.push("B");
		list.push("C");
		list.push("C");
		
		additonMyStack.push("A");
		additonMyStack.push("B");
		additonMyStack.push("C");
		additonMyStack.push("C");
		
		
		additonMyStackNot.push("A");
		additonMyStackNot.push("B");
		additonMyStackNot.push("V");
		
		
		assertTrue(list.equals(additonMyStack));
		assertFalse(list.equals(additonMyStackNot));
		
		
	}

	/**
	 * Test method for {@link utilities.MyStack#iterator()}.
	 */
	@Test
	void testIterator() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyStack#toArray(E[])}.
	 */
	@Test
	void testToArrayEArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyStack#toArray()}.
	 */
	@Test
	void testToArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyStack#search(java.lang.Object)}.
	 */
	@Test
	void testSearch() {
		list.push("A");
		list.push("B");
		list.push("C");
		assertEquals(0, list.search("A"));
		assertEquals(1, list.search("B"));
		assertEquals(2, list.search("C"));
	}

	/**
	 * Test method for {@link utilities.MyStack#contains(java.lang.Object)}.
	 */
	@Test
	void testContains() {
		list.push("A");
		list.push("B");
		list.push("C");
		assertTrue(list.contains("A"));
		assertFalse(list.contains("v"));
		
	}

	/**
	 * Test method for {@link utilities.MyStack#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		list.push("A");
		list.push("B");
		list.push("C");
		assertFalse(list.isEmpty());
		list.clear();
		assertTrue(list.isEmpty());
	}

	/**
	 * Test method for {@link utilities.MyStack#size()}.
	 */
	@Test
	void testSize() {
		list.push("A");
		list.push("B");
		list.push("C");
		
		assertEquals(3, list.size());
	}

	/**
	 * Test method for {@link utilities.MyStack#clear()}.
	 */
	@Test
	void testClear() {
		list.push("A");
		list.push("B");
		list.push("C");
		
		list.clear();
		assertEquals(0, list.size());
	}

}
