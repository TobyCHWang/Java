/**
 * 
 */
package utilities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.TreeException;

/**
 * @author water
 *
 */
class BSTreeTest {
	BSTreeADT<String> tree;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		tree=new BSTree<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		tree=null;
	}

	/**
	 * Test method for {@link utilities.BSTree#getRoot()}.
	 * @throws TreeException 
	 */
	@Test
	void testGetRoot(){
		tree.add("A");
		tree.add("B");
		tree.add("C");
		try {
			assertEquals("A", tree.getRoot().getElement());
		} catch (TreeException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link utilities.BSTree#getHeight()}.
	 */
	@Test
	void testGetHeightRight() {
		tree.add("A");
		tree.add("B");
		tree.add("C");
		assertEquals(3, tree.getHeight());
	}
	
	/**
	 * Test method for {@link utilities.BSTree#getHeight()}.
	 */
	@Test
	void testGetHeightLeft() {
		tree.add("C");
		tree.add("B");
		tree.add("A");
		assertEquals(3, tree.getHeight());
	}
	
	/**
	 * Test method for {@link utilities.BSTree#getHeight()}.
	 */
	@Test
	void testGetHeightLeftAndRight() {
		tree.add("B");
		tree.add("A");
		tree.add("C");
		assertEquals(2, tree.getHeight());
	}

	/**
	 * Test method for {@link utilities.BSTree#size()}.
	 */
	@Test
	void testSizeRight() {
		tree.add("A");
		tree.add("B");
		tree.add("C");
		assertEquals(3, tree.size());
	}
	
	/**
	 * Test method for {@link utilities.BSTree#size()}.
	 */
	@Test
	void testSizeLeft() {
		tree.add("C");
		tree.add("B");
		tree.add("A");
		assertEquals(3, tree.size());
	}
	
	/**
	 * Test method for {@link utilities.BSTree#size()}.
	 */
	@Test
	void testSizeLeftAndRight() {
		tree.add("B");
		tree.add("A");
		tree.add("C");
		assertEquals(3, tree.size());
	}

	/**
	 * Test method for {@link utilities.BSTree#isEmpty()}.
	 */
	@Test
	void testIsEmpty() {
		assertEquals(0, tree.size());
	}

	/**
	 * Test method for {@link utilities.BSTree#clear()}.
	 */
	@Test
	void testClear() {
		tree.add("B");
		tree.add("A");
		tree.add("C");
		tree.clear();
		assertEquals(0, tree.size());
	}

	/**
	 * Test method for {@link utilities.BSTree#contains(java.lang.Comparable)}.
	 */
	@Test
	void testContains() {
		tree.add("B");
		tree.add("A");
		tree.add("C");
		try {
			assertTrue(tree.contains("A"));
		} catch (TreeException e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link utilities.BSTree#search(java.lang.Comparable)}.
	 */
	@Test
	void testSearch() {
		tree.add("B");
		tree.add("A");
		tree.add("C");
		try {
			assertEquals("B", tree.search("B").getElement());
		} catch (TreeException e) {
			
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link utilities.BSTree#add(java.lang.Comparable)}.
	 */
	@Test
	void testAdd() {
		tree.add("B");
		tree.add("A");
		tree.add("C");
		assertEquals(3, tree.size());
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#iterator()}.
	 */
	@Test
	void testInorderIteratorEmpty() {
		Iterator<String> it = tree.inorderIterator();
		assertFalse(it.hasNext());
		assertThrows(NoSuchElementException.class, () -> {
			it.next();
		});
	}

	/**
	 * Test method for {@link utilities.BSTree#inorderIterator()}.
	 */
	@Test
	void testInorderIterator() {
		ArrayList<String> arrayList=new ArrayList<>();
		tree.add("B");
		tree.add("A");
		tree.add("C");
		Iterator<String> it = tree.inorderIterator();
		while (it.hasNext()) {
			arrayList.add(it.next());
		}
		assertEquals("A", arrayList.get(0));
		assertEquals("B", arrayList.get(1));
		assertEquals("C", arrayList.get(2));
	}

	/**
	 * Test method for {@link utilities.BSTree#preorderIterator()}.
	 */
	@Test
	void testPreorderIterator() {
		ArrayList<String> arrayList=new ArrayList<>();
		tree.add("B");
		tree.add("A");
		tree.add("C");
		Iterator<String> it = tree.preorderIterator();
		while (it.hasNext()) {
			arrayList.add(it.next());
		}
		assertEquals("B", arrayList.get(0));
		assertEquals("A", arrayList.get(1));
		assertEquals("C", arrayList.get(2));
	}

	/**
	 * Test method for {@link utilities.BSTree#postorderIterator()}.
	 */
	@Test
	void testPostorderIterator() {
		ArrayList<String> arrayList=new ArrayList<>();
		tree.add("B");
		tree.add("A");
		tree.add("C");
		Iterator<String> it = tree.postorderIterator();
		while (it.hasNext()) {
			arrayList.add(it.next());
		}
		assertEquals("A", arrayList.get(0));
		assertEquals("C", arrayList.get(1));
		assertEquals("B", arrayList.get(2));
	}

}
