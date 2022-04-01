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
 * @author krist
 *
 */
class MyDLLTests {
	
	// attributes
	ListADT<String> dll;
		
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		dll = new MyDLL<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		dll = null;
	}

	/**
	 * Test method for {@link utilities.MyDLL#size()}.
	 */
	@Test
	void testSizeEmpty() {
		assertEquals(0, dll.size());
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#size()}.
	 */
	@Test
	void testSizeNotEmpty() {
		dll.add("A");
		dll.add("B");
		dll.add("C");
		assertEquals(3, dll.size());
	}

	/**
	 * Test method for {@link utilities.MyDLL#clear()}.
	 */
	@Test
	void testClearEmpty() {
		dll.clear();
		assertEquals(0, dll.size());
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#clear()}.
	 */
	@Test
	void testClearNotEmpty() {
		dll.add("A");
		dll.add("B");
		dll.add("C");
		dll.clear();
		assertEquals(0, dll.size());
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEEmpty() {
		boolean added = dll.add(0, "A");
		assertTrue(added);
		assertEquals(1, dll.size());
		assertEquals("A", dll.get(0));
		assertEquals("A", dll.get(dll.size() - 1));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEAppend() {
		dll.add("A");
		dll.add("B");
		dll.add("C");
		boolean added = dll.add(0, "D");
		assertTrue(added);
		assertEquals(4, dll.size());
		assertEquals("D", dll.get(0));
		assertEquals("C", dll.get(dll.size() - 1));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEPrepend() {
		dll.add("A");
		dll.add("B");
		dll.add("C");
		boolean added = dll.add(3, "D");
		assertTrue(added);
		assertEquals(4, dll.size());
		assertEquals("A", dll.get(0));
		assertEquals("D", dll.get(dll.size() - 1));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEOtherPos() {
		dll.add("A");
		dll.add("C");
		dll.add("D");
		boolean added = dll.add(1, "B");
		assertTrue(added);
		assertEquals(4, dll.size());
		assertEquals("A", dll.get(0));
		assertEquals("B", dll.get(1));
		assertEquals("D", dll.get(dll.size() - 1));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntENullPointerException() {
		try {
			dll.add(0, null);
			fail("NullPointerException wasn't thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntELowerIndexOutOfBounds() {
		try {
			dll.add(-1, "A");
			fail("IndexOutOfBoundsException wasn't thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEHigherIndexOutOfBounds() {
		try {
			dll.add(1, "A");
			fail("IndexOutOfBoundsException wasn't thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyDLL#add(java.lang.Object)}.
	 */
	@Test
	void testAddEEmpty() {
		boolean added = dll.add("A");
		assertTrue(added);
		assertEquals(1, dll.size());
		assertEquals("A", dll.get(0));
		assertEquals("A", dll.get(dll.size() - 1));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(java.lang.Object)}.
	 */
	@Test
	void testAddENotEmpty() {
		dll.add("A");
		dll.add("B");
		dll.add("C");
		boolean added = dll.add("D");
		assertTrue(added);
		assertEquals(4, dll.size());
		assertEquals("A", dll.get(0));
		assertEquals("D", dll.get(dll.size() - 1));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(java.lang.Object)}.
	 */
	@Test
	void testAddENullPointerException() {
		try {
			dll.add(null);
			fail("NullPointerException wasn't thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyDLL#addAll(utilities.ListADT)}.
	 */
	@Test
	void testAddAllEmpty() {
		ListADT<String> newDll = new MyDLL<>();
		newDll.add("A");
		newDll.add("B");
		newDll.add("C");
		boolean added = dll.addAll(newDll);
		assertTrue(added);
		assertEquals(3, dll.size());
		Iterator<String> it = dll.iterator();
		int i = 0;
		while (it.hasNext()) {
			assertEquals(newDll.get(i++), it.next());
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#addAll(utilities.ListADT)}.
	 */
	@Test
	void testAddAllNotEmpty() {
		dll.add("A");
		dll.add("B");
		ListADT<String> newDll = new MyArrayList<>();
		newDll.add("C");
		newDll.add("D");
		boolean added = dll.addAll(newDll);
		assertTrue(added);
		assertEquals(4, dll.size());
		assertEquals("A", dll.get(0));
		assertEquals("B", dll.get(1));
		assertEquals("C", dll.get(2));
		assertEquals("D", dll.get(3));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#addAll(utilities.ListADT)}.
	 */
	@Test
	void testAddAllNullPointerException() {
		try {
			dll.addAll(null);
			fail("NullPointerException wasn't thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyDLL#get(int)}.
	 */
	@Test
	void testGet() {
		dll.add("A");
		dll.add("B");
		dll.add("C");
		assertEquals(3, dll.size());
		assertEquals("A", dll.get(0));
		assertEquals("B", dll.get(1));
		assertEquals("C", dll.get(dll.size() - 1));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#get(int)}.
	 */
	@Test
	void testGetIndexOutOfBounds() {
		try {
			dll.get(0);
			fail("IndexOutOfBoundsException wasn't thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyDLL#remove(int)}.
	 */
	@Test
	void testRemoveIntBeg() {
		dll.add("A");
		dll.add("B");
		dll.add("C");
		assertEquals("A", dll.remove(0));
		assertEquals(2, dll.size());
		assertEquals("B", dll.get(0));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(int)}.
	 */
	@Test
	void testRemoveIntMid() {
		dll.add("A");
		dll.add("B");
		dll.add("C");
		assertEquals("B", dll.remove(1));
		assertEquals(2, dll.size());
		assertEquals("C", dll.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(int)}.
	 */
	@Test
	void testRemoveIntEnd() {
		dll.add("A");
		dll.add("B");
		dll.add("C");
		assertEquals("C", dll.remove(2));
		assertEquals(2, dll.size());
		assertEquals("B", dll.get(dll.size() - 1));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(int)}.
	 */
	@Test
	void testRemoveIntIndexOutOfBounds() {
		try {
			dll.remove(0);
			fail("IndexOutOfBoundsException wasn't thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyDLL#remove(java.lang.Object)}.
	 */
	@Test
	void testRemoveEBeg() {
		dll.add("A");
		dll.add("B");
		dll.add("C");
		assertEquals("A", dll.remove("A"));
		assertEquals(2, dll.size());
		assertEquals("B", dll.get(0));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(java.lang.Object)}.
	 */
	@Test
	void testRemoveEMid() {
		dll.add("A");
		dll.add("B");
		dll.add("C");
		assertEquals("B", dll.remove("B"));
		assertEquals(2, dll.size());
		assertEquals("C", dll.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(java.lang.Object)}.
	 */
	@Test
	void testRemoveEEnd() {
		dll.add("A");
		dll.add("B");
		dll.add("C");
		assertEquals("C", dll.remove("C"));
		assertEquals(2, dll.size());
		assertEquals("B", dll.get(dll.size() - 1));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(java.lang.Object)}.
	 */
	@Test
	void testRemoveENullPointerException() {
		try {
			dll.remove(null);
			fail("NullPointerException wasn't thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyDLL#set(int, java.lang.Object)}.
	 */
	@Test
	void testSetNotEmpty() {
		dll.add("A");
		dll.add("D");
		dll.add("C");
		assertEquals("D", dll.set(1, "B"));
		assertEquals(3, dll.size());
		assertEquals("B", dll.get(1));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#set(int, java.lang.Object)}.
	 */
	@Test
	void testSetNullPointerException() {
		try {
			dll.add("A");
			dll.set(0, null);
			fail("NullPointerException wasn't thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#set(int, java.lang.Object)}.
	 */
	@Test
	void testSetIndexOutOfBoundsException() {
		try {
			dll.set(0, "A");
			fail("IndexOutOfBoundsException wasn't thrown!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyDLL#isEmpty()}.
	 */
	@Test
	void testIsEmptyEmpty() {
		boolean empty = dll.isEmpty();
		assertTrue(empty);
		assertEquals(0, dll.size());
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#isEmpty()}.
	 */
	@Test
	void testIsEmptyNotEmpty() {
		dll.add("A");
		dll.add("B");
		dll.add("C");
		boolean empty = dll.isEmpty();
		assertFalse(empty);
		assertEquals(3, dll.size());
	}

	/**
	 * Test method for {@link utilities.MyDLL#contains(java.lang.Object)}.
	 */
	@Test
	void testContainsEmpty() {
		boolean contains = dll.contains("A");
		assertFalse(contains);
		assertEquals(0, dll.size());
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#contains(java.lang.Object)}.
	 */
	@Test
	void testContainsNotEmpty() {
		dll.add("A");
		dll.add("B");
		dll.add("C");
		boolean contains = dll.contains("B");
		assertTrue(contains);
		assertEquals(3, dll.size());
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#contains(java.lang.Object)}.
	 */
	@Test
	void testContainsNullPointerException() {
		try {
			dll.contains(null);
			fail("NullPointerException wasn't thrown!");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link utilities.MyDLL#toArray(E[])}.
	 */
	@Test
	void testToArrayEArrayEmpty() {
		String[] arr = new String[3];
		arr = dll.toArray(arr);
		assertEquals(3, arr.length);
		for(int i = 0; i < arr.length; i++) {
			assertNull(arr[i]);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#toArray(E[])}.
	 */
	@Test
	void testToArrayEArrayNotEmptySufficient() {
		dll.add("A");
		dll.add("B");
		dll.add("C");
		String[] arr = new String[3];
		arr = dll.toArray(arr);
		assertEquals(3, arr.length);
		for(int i = 0; i < arr.length; i++) {
			assertEquals(dll.get(i), arr[i]);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#toArray(E[])}.
	 */
	@Test
	void testToArrayEArrayNotEmptyInsufficient() {
		dll.add("A");
		dll.add("B");
		dll.add("C");
		String[] arr = new String[1];
		arr = dll.toArray(arr);
		assertEquals(3, arr.length);
		for(int i = 0; i < arr.length; i++) {
			assertEquals(dll.get(i), arr[i]);
		}
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#toArray(E[])}.
	 */
	@Test
	void testToArrayEArrayNullPointerException() {
		assertThrows(NullPointerException.class, () -> {
			dll.toArray(null);
		});
	}

	/**
	 * Test method for {@link utilities.MyDLL#toArray()}.
	 */
	@Test
	void testToArrayEmpty() {
		Object[] arr = dll.toArray();
		assertEquals(0, arr.length);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#toArray()}.
	 */
	@Test
	void testToArrayNotEmpty() {
		dll.add("A");
		dll.add("B");
		dll.add("C");
		Object[] arr = dll.toArray();
		assertEquals(3, arr.length);
		for(int i = 0; i < arr.length; i++) {
			assertEquals(dll.get(i), arr[i]);
		}	
	}

	/**
	 * Test method for {@link utilities.MyDLL#iterator()}.
	 */
	@Test
	void testIteratorEmpty() {
		Iterator<String> it = dll.iterator();
		assertFalse(it.hasNext());
		assertThrows(NoSuchElementException.class, () -> {
			it.next();
		});
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#iterator()}.
	 */
	@Test
	void testIteratorNotEmpty() {
		dll.add("A");
		dll.add("B");
		dll.add("C");
		Iterator<String> it = dll.iterator();
		assertTrue(it.hasNext());
		int i = 0;
		while (it.hasNext()) {
			assertEquals(dll.get(i++), it.next());
		}
		assertFalse(it.hasNext());
		assertThrows(NoSuchElementException.class, () -> {
			it.next();
		});
	}

}
