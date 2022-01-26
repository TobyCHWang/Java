package application;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import manager.ShapeManger;

public class AppDriver {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		ArrayList<String> commandArrayList=new ArrayList<String>();
//		ArrayList<String> test=new ArrayList<String>();
//		test.add("-fpolyfor1.txt");
//		test.add("-th");
//		test.add("-dz");
		
		
//		
//		System.out.println(test);
		
		for(int i=0;i<3;i++) {
			commandArrayList.add(args[i]);
		}
//		
//		
//		
		ShapeManger aManger=new ShapeManger(commandArrayList);
		
//		ShapeManger aManger=new ShapeManger(test);

	}

}
