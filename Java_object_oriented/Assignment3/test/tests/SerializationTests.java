package tests;

import static org.junit.jupiter.api.Assertions.*;

import sait.sll.problemdomain.*;
import sait.sll.utility.*;

import java.io.*;
import org.junit.jupiter.api.*;


/**
 * Test Serialization
 * @author Chih-hung Wang, Nicolas Rojas, Tama Parsons, Michael Sajna
 * @version July 26, 2021
 *
 */
class SerializationTests  {
	private ByteArrayOutputStream baos;
	private ObjectOutputStream oos;
	private LinkedListADT users;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		this.baos = new ByteArrayOutputStream();
		this.oos = new ObjectOutputStream(this.baos);
		
		// Create your implemented linked list here and assign to the linkedList attribute.
		this.users = new SLL(); 
		this.users.append(new User(1, "Joe Blow", "jblow@gmail.com", "password"));
		this.users.append(new User(2, "Joe Schmoe", "joe.schmoe@outlook.com", "abcdef"));
		this.users.append(new User(3, "Colonel Sanders", "chickenlover1890@gmail.com", "kfc5555"));
		this.users.append(new User(4, "Ronald McDonald", "burgers4life63@outlook.com", "mcdonalds999"));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		this.baos.close();
		this.oos.close();
		
		this.users.clear();
	}

	/**
	 * Tests the object was serialized.
	 * @throws IOException
	 */
	@Test
	void testSerialize() throws IOException {
		this.oos.writeObject(this.users);
		
		assertTrue(this.baos.size() > 0);
	}

	/**
	 * Tests the object was deserialized.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@Test
	void testDeserialize() throws ClassNotFoundException, IOException {
		this.oos.writeObject(this.users);
		
		this.oos.close();
		
		ByteArrayInputStream bais = new ByteArrayInputStream(this.baos.toByteArray());
		ObjectInputStream ios = new ObjectInputStream(bais);
		
		LinkedListADT users = (LinkedListADT) ios.readObject();
		
		assertFalse(users.isEmpty());
		
		User expectedUser1 = new User(1, "Joe Blow", "jblow@gmail.com", null);
		User actualUser1 = (User) users.retrieve(0);
		
		assertEquals(expectedUser1, actualUser1);
		assertTrue(actualUser1.isCorrectPassword(null));
		
		User expectedUser2 = new User(2, "Joe Schmoe", "joe.schmoe@outlook.com", null);
		User actualUser2 = (User) users.retrieve(1);
		
		assertEquals(expectedUser2, actualUser2);
		assertTrue(actualUser2.isCorrectPassword(null));
		
		User expectedUser3 = new User(3, "Colonel Sanders", "chickenlover1890@gmail.com", null);
		User actualUser3 = (User) users.retrieve(2);
		
		assertEquals(expectedUser3, actualUser3);
		assertTrue(actualUser3.isCorrectPassword(null));
		
		User expectedUser4 = new User(4, "Ronald McDonald", "burgers4life63@outlook.com", null);
		User actualUser4 = (User) users.retrieve(3);
		
		assertEquals(expectedUser4, actualUser4);
		assertTrue(actualUser4.isCorrectPassword(null));
		
		ios.close();
		bais.close();
		
	}
}
