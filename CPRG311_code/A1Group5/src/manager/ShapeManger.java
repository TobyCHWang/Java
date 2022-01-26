package manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import problemdomain.AreaCompare;
import problemdomain.Shape;
import problemdomain.VolumeCompare;
import utilities.BubbleSort;
import utilities.HeapSort;
import utilities.InsertionSort;
import utilities.MergeSort;
import utilities.QuickSort;
import utilities.SelectionSort;

public class ShapeManger {
	
	private ArrayList<Shape> shapeList;
	private Object[] objArray;
	private Shape[] shapeArray;
	private int sortIndex;
	private long startTime;
	private long endTime;
	private long elapsedTime;
	private boolean condition=true;
	
//	only test need modify
	public ShapeManger(ArrayList<String> arrayList) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		shapeList=new ArrayList<Shape>();
		executeCommand(arrayList);
		
		
	}
	
//	command
	private void executeCommand(ArrayList<String> arrayList) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		int fileIndex = 0;
		int typeIndex=0;
		sortIndex=0;
		String filePath;
			for (int i = 0; i < arrayList.size(); i++) {
				char aChart = arrayList.get(i).charAt(1);
				char lowerChart = Character.toLowerCase(aChart);
				if (Character.compare(lowerChart, 'f') == 0) {
					fileIndex = i;
				}else if(Character.compare(lowerChart, 't') == 0){
					typeIndex=i;
				}else if(Character.compare(lowerChart, 's') == 0) {
					sortIndex=i;
				}
			}
			
			
			
			filePath=arrayList.get(fileIndex).substring(2,arrayList.get(fileIndex).length());
			loadFile(filePath);
			
//			h a condition, sort condition
			String compareType=arrayList.get(typeIndex).substring(2,arrayList.get(typeIndex).length()).toLowerCase().replace("\"", "").trim();
		
			
				switch (compareType) {
				case "a":
					System.out.println("Type: Area");
					condition=switchSortByArea(arrayList);
					if(condition) {
						printArrayByArea(shapeArray);
					}else {
						System.out.println("Wrong sort argument");
					}
					
					
					break;
				case "h":
					System.out.println("Type: Height");
					condition=switchSortByHeight(arrayList);
					if(condition) {
						printArrayByHeight(shapeArray);
					}else {
						System.out.println("Wrong sort argument");
					}
					
					
					break;
				case "v":
					System.out.println("Type: Volume");
					condition=switchSortByVolume(arrayList);
					if(condition) {
						printArrayByVolume(shapeArray);
					}else {
						System.out.println("Wrong sort argument");
					}
					
					
					break;

				default:
					System.out.println("Type Argument is wrong, Try Again");
					break;
				}
			
		}
		
			

	
	//sort switch methodByheight
	
	private boolean switchSortByHeight(ArrayList<String> arrayList) {
		String compareSort=arrayList.get(sortIndex).substring(2,arrayList.get(sortIndex).length()).toLowerCase();
		
		
		switch (compareSort) {
		case "b":
			startTime=System.currentTimeMillis();
			BubbleSort.bubbleSort(shapeArray);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println("Sort:Bubble sort and ElapseTime:"+elapsedTime);
			condition=true;
			break;
		case "s":
			startTime=System.currentTimeMillis();
			SelectionSort.selectionSort(shapeArray);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println("Sort:Selection sort and ElapseTime:"+elapsedTime);
			condition=true;
			break;
		case "i":
			startTime=System.currentTimeMillis();
			InsertionSort.insertionSort(shapeArray);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println("Sort:Insertion sort and ElapseTime:"+elapsedTime);

			break;
		case "m":
			startTime=System.currentTimeMillis();
			MergeSort.mergeSort(shapeArray);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println("Sort:Merge sort and ElapseTime:"+elapsedTime);
			condition=true;
			break;
		case "q":
			startTime=System.currentTimeMillis();
			QuickSort.quickSort(shapeArray);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println("Sort:Quick sort and ElapseTime:"+elapsedTime);
			condition=true;
			break;
			
		case "z":
			startTime=System.currentTimeMillis();
			HeapSort.heapSort(shapeArray);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println("Sort:Heap sort and ElapseTime:"+elapsedTime);
			condition=true;
			break;

		default:
			condition=false;
			break;
		}
		return condition;
	}
	
	//sort switch methodByArea
	private boolean switchSortByArea(ArrayList<String> arrayList) {
		String compareSort=arrayList.get(sortIndex).substring(2,arrayList.get(sortIndex).length()).toLowerCase();
		AreaCompare ac=new AreaCompare();
		
		switch (compareSort) {
		case "b":
			startTime=System.currentTimeMillis();
			BubbleSort.bubbleSort(shapeArray, ac);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println("Sort:Bubble sort and ElapseTime:"+elapsedTime);
			condition=true;
			break;
		case "s":
			startTime=System.currentTimeMillis();
			SelectionSort.selectionSort(shapeArray, ac);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println("Sort:Selection sort and ElapseTime:"+elapsedTime);
			condition=true;
			break;
		case "i":
			startTime=System.currentTimeMillis();
			InsertionSort.insertionSort(shapeArray, ac);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println("Sort:Insertion sort and ElapseTime:"+elapsedTime);

			break;
		case "m":
			startTime=System.currentTimeMillis();
			MergeSort.mergeSort(shapeArray, ac);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println("Sort:Merge sort and ElapseTime:"+elapsedTime);
			condition=true;
			break;
		case "q":
			startTime=System.currentTimeMillis();
			QuickSort.quickSort(shapeArray, ac);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println("Sort:Quick sort and ElapsedTime:"+elapsedTime);
			
			break;
			
		case "z":
			startTime=System.currentTimeMillis();
			HeapSort.heapSort(shapeArray,ac);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println("Sort:Heap sort and ElapseTime:"+elapsedTime);
			condition=true;
			break;

		default:
			condition=false;
			break;
		}
		return condition;
	}
	
	//sort switch methodByVolume
	
	private boolean switchSortByVolume(ArrayList<String> arrayList) {
		String compareSort=arrayList.get(sortIndex).substring(2,arrayList.get(sortIndex).length()).toLowerCase();
		VolumeCompare vc=new VolumeCompare();
		switch (compareSort) {
		case "b":
			startTime=System.currentTimeMillis();
			BubbleSort.bubbleSort(shapeArray, vc);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println("Sort:Bubble sort and ElapseTime:"+elapsedTime);
			condition=true;
			break;
		case "s":
			startTime=System.currentTimeMillis();
			SelectionSort.selectionSort(shapeArray, vc);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println("Sort:Selection sort and ElapseTime:"+elapsedTime);
			condition=true;
			break;
		case "i":
			startTime=System.currentTimeMillis();
			InsertionSort.insertionSort(shapeArray, vc);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println("Sort:Insertion sort and ElapseTime:"+elapsedTime);

			break;
		case "m":
			startTime=System.currentTimeMillis();
			MergeSort.mergeSort(shapeArray, vc);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println("Sort:Merge sort and ElapseTime:"+elapsedTime);
			condition=true;
			break;
		case "q":
			startTime=System.currentTimeMillis();
			QuickSort.quickSort(shapeArray, vc);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println("Sort:Quick sort and ElapseTime:"+elapsedTime);

			break;
			
		case "z":
			startTime=System.currentTimeMillis();
			HeapSort.heapSort(shapeArray,vc);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println("Sort:Heap sort and ElapseTime:"+elapsedTime);
			condition=true;
			break;

		default:
			condition=false;
			break;
		}
		return condition;
	}
	
	
//	By height
	
	private void printArrayByHeight(Shape[] arr) {
		System.out.println("The first element is "+arr[0].getHeight());
		for(int i=1000;i<arr.length;i+=1000) {
			System.out.println(i+" value: "+arr[i].getHeight());
		}
		System.out.println("The last element is "+arr[arr.length-1].getHeight());
	}

	//By area
	private void printArrayByArea(Shape[] arr) {
		System.out.println("The first element is "+arr[0].calcBaseArea());
		for(int i=1000;i<arr.length;i+=1000) {
			System.out.println(i+" value: "+arr[i].calcBaseArea());
		}
		System.out.println("The last element is "+arr[arr.length-1].calcBaseArea());
	}
	
	//By volume
	private void printArrayByVolume(Shape[] arr) {
		System.out.println("The first element is "+arr[0].calcVolume());
		for(int i=1000;i<arr.length;i+=1000) {
			System.out.println(i+" value: "+arr[i].calcVolume());
		}
		System.out.println("The last element is "+arr[arr.length-1].calcVolume());
	}
	
	
//	loadMethod arrayList put arg into arraylist s t f 

//	loadFile method 
	private void loadFile(String filepath) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
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
	
	
	
	
	
	

	
	
    
    
    
    
    

    
    
    
    //student’s choice of sorting algorithm
    
    
//	for my test
	public double Test() {
		return shapeArray[0].calcBaseArea();
	}
	

}
