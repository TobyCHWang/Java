package utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import exceptions.TreeException;

public class test {
public static void main(String[] args) throws TreeException {
	BSTree<String> tree=new BSTree<>();
	tree.add("b");
	tree.add("a");
	tree.add("c");
	
	
	System.out.println(tree.getHeight());
	Iterator<String> it = tree.postorderIterator();
	assertTrue(it.hasNext());
	while (it.hasNext()) {
		System.out.println(it.next());
		
  }
	System.out.println("============");
	Iterator<String> it2 = tree.preorderIterator();
	assertTrue(it2.hasNext());
	while (it2.hasNext()) {
		System.out.println(it2.next());
		
  }
	System.out.println("============");
	Iterator<String> it3 = tree.inorderIterator();
	assertTrue(it3.hasNext());
	while (it3.hasNext()) {
		System.out.println(it3.next());
  }
	
	System.out.println(tree.contains("a"));
	
	
}
}
