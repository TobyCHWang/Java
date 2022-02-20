package utilities;

import java.util.ArrayList;
import java.util.Iterator;

public class tobyTest {
public static void main(String[] args) {
	MyArrayList<String> arrayList=new MyArrayList<>();
//	MyArrayList<String> arrayList2=new MyArrayList<>();
//	arrayList2.add("fff");
//	arrayList2.add("sdfsdf");
//
	arrayList.add("a");
	arrayList.add("b");
	arrayList.add("a");
	
	System.out.println(arrayList.contains("a"));
	
	arrayList.remove("a");
//	
//	arrayList.addAll(arrayList2);
//	for(int i=0;i<arrayList.size();i++) {
//		System.out.println(arrayList.get(i));
//	}
//	
//	
//	System.out.println(arrayList.contains("k"));
	
//	MyDLL<String> aDll=new MyDLL<>();
////	MyDLL<String> bDll=new MyDLL<>();
//	aDll.add("a");
//	aDll.add("b");
//	
//	for(int i=aDll.size()-1;i>=0;i--) {
//		System.out.println(aDll.get(i));
//	}
//	aDll.add("v");
//	System.out.println(aDll.size());
//	aDll.clear();
//	System.out.println(aDll.size());
//	bDll.add("k");
//	bDll.add("g");
//	bDll.add("jj");
//
//	aDll.addAll(bDll);
//	
//	aDll.toArray();
//	
//	for(int i=0;i<aDll.size();i++) {
//		System.out.println(aDll.get(i));
//	}
	
//	System.out.println(aDll.contains("a"));
//	System.out.println(aDll.get(1));
//	System.out.println(aDll.size());
//	aDll.remove("b");
//	System.out.println(aDll.get(0));
//	System.out.println(aDll.size());
//	System.out.println(aDll.contains("a"));
//	aDll.set(0, "k");
//	System.out.println(aDll.get(0));
	
	
	
	
//	MyStack<String> stack=new MyStack<>();
//	stack.push("a");
//	stack.push("b");
//	stack.push("c");
//	stack.push("d");
//	
//	
//	
//	
//	System.out.println(stack.toArray());
//	
//	
//	
//	MyStack<String> stack2=new MyStack<>();
//	stack2.push("a");
//	stack2.push("d");
//	stack2.push("c");
//	System.out.println(stack.equals(stack2));
	
	MyQueue<String> aMyQueue=new MyQueue<>();
	MyQueue<String> aMyQueue2=new MyQueue<>();
	aMyQueue.enqueue("aa");
	aMyQueue.enqueue("bb");
	
	aMyQueue2.enqueue("aa");
	aMyQueue2.enqueue("bb");
	System.out.println(aMyQueue.equals(aMyQueue2));
	
	
//	System.out.println(stack.search("b"));
//	System.out.println(stack.peek());
//	stack.clear();
//	System.out.println(stack.contains("b"));
//	System.out.println(stack.size());
	
//	MyArrayList<String> arrayList=new MyArrayList<>();
//	arrayList.add("aa");
//	arrayList.add("bb");
//	System.out.println(arrayList.size());
//	arrayList.remove(0);
//	System.out.println(arrayList.size());
	
//	System.out.println(stack.size()); 
	
}
}
