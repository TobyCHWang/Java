package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.*;

/**
 * @author krist
 *
 */
class MyArrayListTest {
	// attributes
	ListADT<String> list;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		list = new MyArrayList<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		list = null;
	}

	/**
	 * Test method for {@link utilities.MyArrayList#size()}.
	 */
	@Test
	void testSizeEmpty() {
		assertEquals(0, list.size());
	}

	/**
	 * Test method for {@link utilities.MyArrayList#size()}.
	 */
	@Test
	void testSizeNotEmpty() {
		list.add("A");
		list.add("B");
		list.add("C");
		assertEquals(3, list.size());
	}

	/**
	 * Test method for {@link utilities.MyArrayList#clear()}.
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
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	void testAddIntEEmpty() {
		boolean added = list.add(0, "A");
		assertEquals(1, list.size());
		assertEquals("A", list.get(0));
		assertTrue(added);
	}

	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
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
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
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
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
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
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
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
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
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
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
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
	 * Test method for {@link utilities.MyArrayList#add(java.lang.Object)}.
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
	 * Test method for {@link utilities.MyArrayList#addAll(utilities.ListADT)}.
	 */
	@Test
	void testAddAll() {
		MyArrayList<String> additonalArrayList=new MyArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		additonalArrayList.add("E");
		additonalArrayList.add("F");
		additonalArrayList.add("G");
		additonalArrayList.add("H");
		list.addAll(additonalArrayList);
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
	 * Test method for {@link utilities.MyArrayList#get(int)}.
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
	 * Test method for {@link utilities.MyArrayList#remove(int)}.
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
	 * Test method for {@link utilities.MyArrayList#remove(int)}.
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
	 * Test method for {@link utilities.MyArrayList#remove(int)}.
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
	 * Test method for {@link utilities.MyArrayList#remove(java.lang.Object)}.
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
	 * Test method for {@link utilities.MyArrayList#set(int, java.lang.Object)}.
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
	 * Test method for {@link utilities.MyArrayList#set(int, java.lang.Object)}.
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
	 * Test method for {@link utilities.MyArrayList#set(int, java.lang.Object)}.
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
	 * Test method for {@link utilities.MyArrayList#isEmpty()}.
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
	 * Test method for {@link utilities.MyArrayList#contains(java.lang.Object)}.
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
	 * Test method for {@link utilities.MyArrayList#toArray(E[])}.
	 */
	@Test
	void testToArrayEArrayEmpty() {
		String[] arr = new String[3];
		arr = list.toArray(arr);
		assertEquals(3, arr.length);
		for(int i = 0; i < arr.length; i++) {
			assertNull(arr[i]);
		}
	}

	/**
	 * Test method for {@link utilities.MyArrayList#toArray(E[])}.
	 */
	@Test
	void testToArrayEArrayNonEmptySufficient() {
		list.add("A");
		list.add("B");
		list.add("C");
		String[] arr = new String[3];
		arr = list.toArray(arr);
		assertEquals(3, arr.length);
		for(int i = 0; i < arr.length; i++) {
			assertEquals(list.get(i), arr[i]);
		}
	}

	/**
	 * Test method for {@link utilities.MyArrayList#toArray(E[])}.
	 */
	@Test
	void testToArrayEArrayNonEmptyInsufficient() {
		list.add("A");
		list.add("B");
		list.add("C");
		String[] arr = new String[1];
		arr = list.toArray(arr);
		assertEquals(3, arr.length);
		for(int i = 0; i < arr.length; i++) {
			assertEquals(list.get(i), arr[i]);
		}
	}

	/**
	 * Test method for {@link utilities.MyArrayList#toArray(E[])}.
	 */
	@Test
	void testToArrayEArrayNullPointerException() {
		assertThrows(NullPointerException.class, () -> {
			list.toArray(null);
		});
	}

	/**
	 * Test method for {@link utilities.MyArrayList#toArray()}.
	 */
	@Test
	void testToArrayEmpty() {
		Object[] arr = list.toArray();
		assertEquals(0, arr.length);
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#toArray()}.
	 */
	@Test
	void testToArrayNonEmpty() {
		list.add("A");
		list.add("B");
		list.add("C");
		Object[] arr = list.toArray();
		assertEquals(3, arr.length);
		for(int i = 0; i < arr.length; i++) {
			assertEquals(list.get(i), arr[i]);
		}	
	}

	/**
	 * Test method for {@link utilities.MyArrayList#iterator()}.
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
	 * Test method for {@link utilities.MyArrayList#iterator()}.
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
