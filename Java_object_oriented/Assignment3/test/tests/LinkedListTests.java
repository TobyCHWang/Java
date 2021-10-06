package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.Serializable;

import org.junit.jupiter.api.*;

import sait.sll.utility.*;


/**
 * Test linked list class
 * @author Chih-hung Wang, Nicolas Rojas, Tama Parsons, Michael Sajna
 * @version July 26, 2021
 *
 */
class LinkedListTests {
	/**
	 * Contains the linked list that is manipulated in each test.
	 */
	private LinkedListADT linkedList;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		// Create your concrete linked list class and assign to to linkedList.
		this.linkedList = new SLL();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		this.linkedList.clear();
	}

	/**
	 * Test the linked list is empty.
	 */
	@Test
	void testIsEmpty() {
		assertTrue(this.linkedList.isEmpty());
		assertEquals(0, this.linkedList.size());
	}
	
	/**
	 * Tests appending elements to the linked list.
	 */
	@Test
	void testAppendNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> c -> d
		 */
		
		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());
		
		// Test the size is 4
		assertEquals(4, this.linkedList.size());

		// Test the first node value is a
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));
		
		// Test the third node value is c
		assertEquals("c", this.linkedList.retrieve(2));
		
		// Test the fourth node value is d
		assertEquals("d", this.linkedList.retrieve(3));
	}

	/**
	 * Tests prepending nodes to linked list.
	 */
	@Test
	void testPrependNodes() {
		this.linkedList.prepend("a");
		this.linkedList.prepend("b");
		this.linkedList.prepend("c");
		this.linkedList.prepend("d");
		
		/**
		 * Linked list should now be:
		 * 
		 * d -> c -> b -> a
		 */
		
		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());
		
		// Test the size is 4
		assertEquals(4, this.linkedList.size());

		// Test the first node value is a
		assertEquals("d", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("c", this.linkedList.retrieve(1));
		
		// Test the third node value is c
		assertEquals("b", this.linkedList.retrieve(2));
		
		// Test the fourth node value is d
		assertEquals("a", this.linkedList.retrieve(3));
	}
	
	/**
	 * Tests inserting node at valid index.
	 */
	@Test
	void testInsertNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		this.linkedList.insert("e", 2);
		
		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> e -> c -> d
		 */
		
		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());
		
		// Test the size is 5
		assertEquals(5, this.linkedList.size());

		// Test the first node value is a
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));
		
		// Test the third node value is e
		assertEquals("e", this.linkedList.retrieve(2));
		
		// Test the third node value is c
		assertEquals("c", this.linkedList.retrieve(3));
		
		// Test the fourth node value is d
		assertEquals("d", this.linkedList.retrieve(4));
	}
	
	/**
	 * Tests replacing existing nodes data.
	 */
	@Test
	void testReplaceNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		this.linkedList.replace("e", 2);
		
		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> e -> d
		 */
		
		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());
		
		// Test the size is 4
		assertEquals(4, this.linkedList.size());

		// Test the first node value is a
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));
		
		// Test the third node value is e
		assertEquals("e", this.linkedList.retrieve(2));
		
		// Test the fourth node value is d
		assertEquals("d", this.linkedList.retrieve(3));
	}
	
	/**
	 * Tests deleting node from linked list.
	 */
	@Test
	void testDeleteNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		this.linkedList.delete(2);
		
		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> d
		 */
		
		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());
		
		// Test the size is 4
		assertEquals(3, this.linkedList.size());

		// Test the first node value is a
		assertEquals("a", this.linkedList.retrieve(0));

		// Test the second node value is b
		assertEquals("b", this.linkedList.retrieve(1));
		
		// Test the fourth node value is d
		assertEquals("d", this.linkedList.retrieve(2));
	}
	
	/**
	 * Tests finding and retrieving node in linked list.
	 */
	@Test
	void testFindNode() {
		this.linkedList.append("a");
		this.linkedList.append("b");
		this.linkedList.append("c");
		this.linkedList.append("d");
		
		/**
		 * Linked list should now be:
		 * 
		 * a -> b -> c -> d
		 */
		
		boolean contains = this.linkedList.contains("b");
		assertTrue(contains);
		
		int index = this.linkedList.indexOf("b");
		assertEquals(1, index);
		
		String value = (String) this.linkedList.retrieve(1);
		assertEquals("b", value);
	}
	@Test
	void testReplaceNodeName() {
		this.linkedList.append("Toby");
		this.linkedList.append("Nick");
		this.linkedList.append("Tama");
		this.linkedList.append("Michael");
		
		this.linkedList.replace("Kate", 3);
		
		
		
		/**
		 * Linked list should now be:
		 * 
		 * Toby -> Nick -> Tama -> Kate 
		 */
		
		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());
		
		// Test the size is 4
		assertEquals(4, this.linkedList.size());

		// Test the first node value is Toby
		assertEquals("Toby", this.linkedList.retrieve(0));

		// Test the second node value is Nick
		assertEquals("Nick", this.linkedList.retrieve(1));
		
		// Test the third node value is Tama
		assertEquals("Tama", this.linkedList.retrieve(2));
		
		// Test the fourth node value is Kate
		assertEquals("Kate", this.linkedList.retrieve(3));
	}
	
	@Test
	void testFindNodeInsertName() {
		this.linkedList.append("Toby");
		this.linkedList.append("Nick");
		this.linkedList.append("Tama");
		this.linkedList.append("Michael");
		
		this.linkedList.insert("Kate", 3);
		
		/**
		 * Linked list should now be:
		 * 
		 * Toby -> Nick -> Tama -> Kate ->Michael
		 */
		
		boolean contains = this.linkedList.contains("Michael");
		assertTrue(contains);
		
		int index = this.linkedList.indexOf("Michael");
		assertEquals(4, index);
		
		String value = (String) this.linkedList.retrieve(1);
		assertEquals("Nick", value);
	}
	
	@Test
	void testFindNodeDeleteAndInsertName() {
		this.linkedList.append("Toby");
		this.linkedList.append("Nick");
		this.linkedList.append("Tama");
		this.linkedList.append("Michael");
		
		this.linkedList.insert("Kate", 3);
		
		this.linkedList.delete(0);
		
		/**
		 * Linked list should now be:
		 * 
		 * Nick -> Tama -> Kate ->Michael
		 */
		
		boolean contains = this.linkedList.contains("Michael");
		assertTrue(contains);
		
		int index = this.linkedList.indexOf("Michael");
		assertEquals(3, index);
		
		String value = (String) this.linkedList.retrieve(1);
		assertEquals("Tama", value);
	}
	
	@Test
	void testPrependNodesName() {
		this.linkedList.prepend("Toby");
		this.linkedList.prepend("Nick");
		this.linkedList.prepend("Tama");
		this.linkedList.prepend("Michael");
		
		this.linkedList.insert("Kate", 3);
		
		/**
		 * Linked list should now be:
		 * 
		 * Michael -> Tama -> Nick -> Kate-> Toby ->
		 */
		
		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());
		
		// Test the size is 5
		assertEquals(5, this.linkedList.size());

		// Test the first node value is Michael
		assertEquals("Michael", this.linkedList.retrieve(0));

		// Test the second node value is Tama
		assertEquals("Tama", this.linkedList.retrieve(1));
		
		// Test the third node value is Nick
		assertEquals("Nick", this.linkedList.retrieve(2));
		
		// Test the fourth node value is Kate
		assertEquals("Kate", this.linkedList.retrieve(3));
		
		// Test the fifth node value is Toby
		assertEquals("Toby", this.linkedList.retrieve(4));
	}
	
	@Test
	void testAllName() {
		this.linkedList.append("Toby");
		this.linkedList.append("Nick");
		this.linkedList.append("Tama");
		this.linkedList.prepend("John");
		this.linkedList.append("Michael");
		
		this.linkedList.insert("Kate", 3);
		
		this.linkedList.delete(0);
		this.linkedList.replace("Annie", 0);
		
		/**
		 * Linked list should now be:
		 * 
		 * Annie-> Nick->Kate -> Tama ->Michael
		 */
		
		// Test the linked list is not empty.
		assertFalse(this.linkedList.isEmpty());
				
		// Test the size is 5
		assertEquals(5, this.linkedList.size());

		// Test the first node value is Annie
		assertEquals("Annie", this.linkedList.retrieve(0));

		// Test the second node value is Nick
		assertEquals("Nick", this.linkedList.retrieve(1));
				
		// Test the third node value is Kate
		assertEquals("Kate", this.linkedList.retrieve(2));
				
		// Test the fourth node value is Tama
		assertEquals("Tama", this.linkedList.retrieve(3));
				
		// Test the fifth node value is Michael
		assertEquals("Michael", this.linkedList.retrieve(4));
	  }
	}
	
