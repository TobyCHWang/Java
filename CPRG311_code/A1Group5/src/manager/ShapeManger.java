package manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;

import problemdomain.Shape;

public class ShapeManger {
	
	private ArrayList<Shape> shapeList;
	private Object[] objArray;
	private Shape[] shapeArray;
	
	public ShapeManger(String filepath) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		shapeList=new ArrayList<Shape>();
		loadFile(filepath);
		System.out.println(Test());
		
	}
	

//	loadFile method 
	public void loadFile(String filepath) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//open the file
	    FileReader file = new FileReader(filepath);
	    BufferedReader buffer = new BufferedReader(file);
	    String line = buffer.readLine();
	    //display the 1st line
	    String []fields = line.split(" ");
	    int numberOfData=Integer.parseInt(fields[0]);
	    for(int i=1;i<numberOfData*3;i+=3) {
	    	
	    	
	    	Object o = null;
	    	
	    	
	    	String className = "problemdomain."+fields[i];
	    	Class cls=Class.forName(className);
	    	Class paramTypes[] = new Class[2];
	    	
	    	paramTypes[0]=Double.TYPE;
	    	paramTypes[1]=Double.TYPE;
	    	
	    	Constructor ct=cls.getConstructor(paramTypes);
	    	
	    	Object argList[] = new Object[2];
	    	
	    	argList[0]=Double.parseDouble(fields[i+1]);
	    	argList[1]=Double.parseDouble(fields[i+2]);
	    	
	    	o=ct.newInstance(argList);
	    	
	    	shapeList.add((Shape)o);
	    		
	    }
	    
//	    covert ArrayList to Array
	    objArray=shapeList.toArray();
	    shapeArray=Arrays.copyOf(objArray, objArray.length, Shape[].class);
	    
	    buffer.close();
		
	}
	
	
//	for my test
	public double Test() {
		return shapeArray[0].getHeight();
	}
	

}
