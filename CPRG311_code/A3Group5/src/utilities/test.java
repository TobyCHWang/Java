package utilities;

import exceptions.TreeException;

public class test {
public static void main(String[] args) throws TreeException {
	BSTree<String> tree=new BSTree<>();
	tree.add("c");
	tree.add("b");
	tree.add("a");
	
	
	System.out.println(tree.search("c").getElement());
}
}
