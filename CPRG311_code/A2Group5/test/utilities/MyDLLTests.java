/**
 * 
 */
package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author water
 *
 */
class MyDLLTests {
	// attributes
		ListADT<String> list;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		list = new MyDLL<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		list=null;
	}

	/**
	 * Test method for {@link utilities.MyDLL#size()}.
	 */
	@Test
	void testSizeEmpty() {
		assertEquals(0, list.size());;
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#size()}.
	 */
	@Test
	void testSizeNotEmpty() {
		list.add("A");
		list.add("B");
		list.add("C");
		assertEquals(3, list.size());
	}

	/**
	 * Test method for {@link utilities.MyDLL#clear()}.
	 */
	@Test
	void testClear() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.clear();
		assertEquals(0, list.size());
	}

	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEEmpty() {
		boolean added = list.add(0, "A");
		assertEquals(1, list.size());
		assertEquals("A", list.get(0));
		assertTrue(added);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntENotEmptyAppend() {
		list.add("A");
		boolean added = list.add(1, "B");
		assertTrue(added);
		assertEquals(2, list.size());
		assertEquals("B", list.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	
	@Test
	void testAddIntENotEmptyPrepend() {
		list.add("B");
		boolean added = list.add(0, "A");
		assertTrue(added);
		assertEquals(2, list.size());
		assertEquals("A", list.get(0));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	
	@Test
	void testAddIntENotEmptyInsert() {
		list.add("A");
		list.add("C");
		boolean added = list.add(1, "B");
		assertTrue(added);
		assertEquals(3, list.size());
		assertEquals("B", list.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntENullPointerException() {
		try {
			list.add(0, null);
			fail("NullPointerException wasn't thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	
	@Test
	void testAddIntELowestIndexOutOfBoundsException() {
		try {
			list.add(-1, "A");
			fail("IndexOutOfBoundsException wasn't thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	
	@Test
	void testAddIntEHighestIndexOutOfBoundsException() {
		try {
			list.add(1, "A");
			fail("IndexOutOfBoundsException wasn't thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	

	/**
	 * Test method for {@link utilities.MyDLL#add(java.lang.Object)}.
	 */
	@Test
	void testAddE() {
		// TODO 3 methods
				list.add("A");
				list.add("B");
				list.add("C");
				assertEquals(3, list.size());
				assertEquals("A", list.get(0));
				assertEquals("B", list.get(1));
				assertEquals("C", list.get(2));
	}

	/**
	 * Test method for {@link utilities.MyDLL#addAll(utilities.ListADT)}.
	 */
	@Test
	void testAddAll() {
		MyDLL<String> additonalDllList=new MyDLL<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		additonalDllList.add("E");
		additonalDllList.add("F");
		additonalDllList.add("G");
		additonalDllList.add("H");
		list.addAll(additonalDllList);
		assertEquals(8, list.size());
		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));
		assertEquals("D", list.get(3));
		assertEquals("E", list.get(4));
		assertEquals("F", list.get(5));
		assertEquals("G", list.get(6));
		assertEquals("H", list.get(7));
	}

	/**
	 * Test method for {@link utilities.MyDLL#get(int)}.
	 */
	@Test
	void testGet() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		assertEquals(4, list.size());
		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));
		assertEquals("D", list.get(3));
	}

	/**
	 * Test method for {@link utilities.MyDLL#remove(int)}.
	 */
	@Test
	void testRemoveIntInHead() {
		list.add("A");
		list.add("C");
		list.add("R");
		list.add("G");
		list.remove(0);
		assertEquals(3, list.size());
		assertEquals("C", list.get(0));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(int)}.
	 */
	@Test
	void testRemoveIntInTail() {
		list.add("A");
		list.add("C");
		list.add("R");
		list.add("G");
		list.remove(3);
		assertEquals(3, list.size());
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(int)}.
	 */
	@Test
	void testRemoveIntInMiddle() {
		list.add("A");
		list.add("C");
		list.add("R");
		list.add("G");
		list.remove(2);
		assertEquals(3, list.size());
		assertEquals("G", list.get(2));
	}

	/**
	 * Test method for {@link utilities.MyDLL#remove(java.lang.Object)}.
	 */
	@Test
	void testRemoveE() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		assertEquals(4, list.size());
		list.remove("B");
		assertEquals(3, list.size());
		assertEquals("C", list.get(1));
	}

	/**
	 * Test method for {@link utilities.MyDLL#set(int, java.lang.Object)}.
	 */
	@Test
	void testSetInHead() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.set(0, "k");
		assertEquals(4, list.size());
		assertEquals("k", list.get(0));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#set(int, java.lang.Object)}.
	 */
	@Test
	void testSetInTail() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.set(2, "r");
		assertEquals(4, list.size());
		assertEquals("r", list.get(2));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#set(int, java.lang.Object)}.
	 */
	@Test
	void testSetInMiddle() {
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.set(3, "v");
		assertEquals(4, list.size());
		assertEquals("v", list.get(3));
	}

	/**
	 * Test method for {@link utilities.MyDLL#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		list.add("A");
		list.add("B");
		list.add("C");
		assertFalse(list.isEmpty());
		list.clear();
		assertTrue(list.isEmpty());
	}

	/**
	 * Test method for {@link utilities.MyDLL#contains(java.lang.Object)}.
	 */
	@Test
	void testContains() {
		list.add("A");
		list.add("C");
		list.add("D");
		list.add("B");
		assertTrue(list.contains("A"));
		assertFalse(list.contains("v"));
	}

	/**
	 * Test method for {@link utilities.MyDLL#toArray(E[])}.
	 */
	@Test
	void testToArrayEArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyDLL#toArray()}.
	 */
	@Test
	void testToArray() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.MyDLL#iterator()}.
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
	 * Test method for {@link utilities.MyDLL#iterator()}.
	 */
	@Test
	void testIteratorNonEmpty() {
		list.add("A");
		list.add("B");
		list.add("C");
		Iterator<String> it = list.iterator();
		assertTrue(it.hasNext());
		int i = 0;
		while (it.hasNext()) {
			assertEquals(list.get(i++), it.next());
		}
		assertFalse(it.hasNext());
		assertThrows(NoSuchElementException.class, () -> {
			it.next();
		});
	}

}
