/**
 * 
 */
package utilities;

import static org.junit.jupiter.api.Assertions.*;

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
	 * Test method for {@link utilities.BSTree#inorderIterator()}.
	 */
	@Test
	void testInorderIterator() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.BSTree#preorderIterator()}.
	 */
	@Test
	void testPreorderIterator() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link utilities.BSTree#postorderIterator()}.
	 */
	@Test
	void testPostorderIterator() {
		fail("Not yet implemented");
	}

}
