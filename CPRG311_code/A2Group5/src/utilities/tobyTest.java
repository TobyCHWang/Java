package utilities;

import java.util.ArrayList;
import java.util.Iterator;

public class tobyTest {
public static void main(String[] args) {
//	MyArrayList<String> arrayList=new MyArrayList<>();
//	MyArrayList<String> arrayList2=new MyArrayList<>();
//	arrayList2.add("fff");
//	arrayList2.add("sdfsdf");
//
//	arrayList.add("a");
//	arrayList.add("b");
//	arrayList.add("d");
//	
//	arrayList.addAll(arrayList2);
//	for(int i=0;i<arrayList.size();i++) {
//		System.out.println(arrayList.get(i));
//	}
//	
//	
//	System.out.println(arrayList.contains("k"));
	
	MyDLL<String> aDll=new MyDLL<>();
	MyDLL<String> bDll=new MyDLL<>();
	aDll.add("a");
	aDll.add("b");
	aDll.add("v");
	bDll.add("k");
	bDll.add("g");
	bDll.add("jj");

	aDll.addAll(bDll);
	
	aDll.toArray();
	
	for(int i=0;i<aDll.size();i++) {
		System.out.println(aDll.get(i));
	}
	
//	System.out.println(aDll.contains("a"));
//	System.out.println(aDll.get(1));
//	System.out.println(aDll.size());
//	aDll.remove("b");
//	System.out.println(aDll.get(1));
//	System.out.println(aDll.size());
//	System.out.println(aDll.contains("a"));
//	aDll.set(0, "k");
//	System.out.println(aDll.get(0));
}
}
