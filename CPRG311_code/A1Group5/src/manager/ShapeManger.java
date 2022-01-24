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

public class ShapeManger {
	
	private ArrayList<Shape> shapeList;
	private Object[] objArray;
	private Shape[] shapeArray;
	private int sortIndex;
	private long startTime;
	private long endTime;
	private long elapsedTime;
	
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
		
//		h a condition, sort condition
		String compareType=arrayList.get(typeIndex).substring(2,arrayList.get(typeIndex).length()).toLowerCase();
	
		
		switch (compareType) {
		case "a":
			
			switchSortByArea(arrayList);
			printArrayByArea(shapeArray);
			
			break;
		case "h":
			switchSortByHeight(arrayList);
			printArrayByHeight(shapeArray);
			
			break;
		case "v":
			switchSortByVolume(arrayList);
			printArrayByVolume(shapeArray);
			
			break;

		default:
			System.out.println("error");
			break;
		}
		

	}
	
	//sort switch methodByheight
	
	private void switchSortByHeight(ArrayList<String> arrayList) {
		String compareSort=arrayList.get(sortIndex).substring(2,arrayList.get(sortIndex).length()).toLowerCase();
		
		switch (compareSort) {
		case "b":
			startTime=System.currentTimeMillis();
			bubbleSort(shapeArray);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println(elapsedTime);

			break;
		case "s":
			startTime=System.currentTimeMillis();
			selectionSort(shapeArray);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println(elapsedTime);

			break;
		case "i":
			startTime=System.currentTimeMillis();
			insertionSort(shapeArray);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println(elapsedTime);

			break;
		case "m":
			startTime=System.currentTimeMillis();
			mergeSort(shapeArray);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println(elapsedTime);

			break;
		case "q":
			startTime=System.currentTimeMillis();
			quickSort(shapeArray);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println(elapsedTime);

			break;

		default:
			System.out.println("error");
			break;
		}
	}
	
	//sort switch methodByArea
	private void switchSortByArea(ArrayList<String> arrayList) {
		String compareSort=arrayList.get(sortIndex).substring(2,arrayList.get(sortIndex).length()).toLowerCase();
		AreaCompare ac=new AreaCompare();
		
		switch (compareSort) {
		case "b":
			startTime=System.currentTimeMillis();
			bubbleSort(shapeArray, ac);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println(elapsedTime);

			break;
		case "s":
			startTime=System.currentTimeMillis();
			selectionSort(shapeArray, ac);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println(elapsedTime);

			break;
		case "i":
			startTime=System.currentTimeMillis();
			insertionSort(shapeArray, ac);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println(elapsedTime);

			break;
		case "m":
			startTime=System.currentTimeMillis();
			mergeSort(shapeArray, ac);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println(elapsedTime);

			break;
		case "q":
			startTime=System.currentTimeMillis();
			quickSort(shapeArray, ac);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println(elapsedTime);

			break;

		default:
			System.out.println("error");
			break;
		}
	}
	
	//sort switch methodByVolume
	
	private void switchSortByVolume(ArrayList<String> arrayList) {
		String compareSort=arrayList.get(sortIndex).substring(2,arrayList.get(sortIndex).length()).toLowerCase();
		VolumeCompare vc=new VolumeCompare();
		switch (compareSort) {
		case "b":
			startTime=System.currentTimeMillis();
			bubbleSort(shapeArray, vc);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println(elapsedTime);

			break;
		case "s":
			startTime=System.currentTimeMillis();
			selectionSort(shapeArray, vc);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println(elapsedTime);

			break;
		case "i":
			startTime=System.currentTimeMillis();
			insertionSort(shapeArray, vc);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println(elapsedTime);

			break;
		case "m":
			startTime=System.currentTimeMillis();
			mergeSort(shapeArray, vc);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println(elapsedTime);

			break;
		case "q":
			startTime=System.currentTimeMillis();
			quickSort(shapeArray, vc);
			endTime=System.currentTimeMillis();
			elapsedTime=endTime-startTime;
			System.out.println(elapsedTime);

			break;

		default:
			System.out.println("error");
			break;
		}
	}
	
	
//	By height
	
	private void printArrayByHeight(Shape[] arr) {
		for(int i=0;i<arr.length;i+=1000) {
			System.out.println(arr[i].getHeight());
		}
		System.out.println(arr[arr.length-1].getHeight());
	}

	//By area
	private void printArrayByArea(Shape[] arr) {
		for(int i=0;i<arr.length;i+=1000) {
			System.out.println(arr[i].calcBaseArea());
		}
		System.out.println(arr[arr.length-1].calcBaseArea());
	}
	
	//By volume
	private void printArrayByVolume(Shape[] arr) {
		for(int i=0;i<arr.length;i+=1000) {
			System.out.println(arr[i].calcVolume());
		}
		System.out.println(arr[arr.length-1].calcVolume());
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
	
	//bubble sort ref:https://examples.javacodegeeks.com/bubble-sort-java-algorithm-code-example/
	//comparable descend
	 private static<T extends Comparable<? super T>> void bubbleSort(T []arr){
	        int left = 0;
	        int right = arr.length-1;
	        // the outer loop, runs from right to left
	        for(int i=right;i>1;i--){
	            // the inner loops, runs from left to the right, limited by the outer loop
	            for(int j=left;j<i;j++){
	                // if the left item is smaller than the right one, swaps
	                if(((Comparable<? super T>)arr[j]).compareTo(arr[j+1]) < 0){
	                    swap(arr,j, j+1);
	                }
	            }
	        }
	    }
	 
	 //Comparator descend
	 
	 private static<T> void bubbleSort(T []arr,Comparator<? super T>comparator){
	        int left = 0;
	        int right = arr.length-1;
	        // the outer loop, runs from right to left
	        for(int i=right;i>1;i--){
	            // the inner loops, runs from left to the right, limited by the outer loop
	            for(int j=left;j<i;j++){
	                // if the left item is smaller than the right one, swaps
	                if(comparator.compare(arr[j], arr[j+1]) < 0){
	                    swap(arr,j, j+1);
	                }
	            }
	        }
	    }
	
	
	// This method is used to swap the values between the two given index
    private static void swap(Object []a, int left,int right){
        Object temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }
	
    //Selection sort https://www.geeksforgeeks.org/selection-sort/
    
    //comparable descend
    private static<T extends Comparable<? super T>> void selectionSort(T []arr){
    	
    	int size = arr.length;
		for (int i = 0; i < size - 1; i++) {
			int min = i;
			for (int j = i + 1; j < size; j++) {
				if (((Comparable<? super T>)arr[j]).compareTo(arr[min]) < 0) {
					swap(arr, j, min);
				}
			}
			
		}
    		
    }
    
    //Comparator descend
    private static<T> void selectionSort(T []arr,Comparator<? super T>comparator){
    	

    	int size = arr.length;
		for (int i = 0; i < size - 1; i++) {
			int min = i;
			for (int j = i + 1; j < size; j++) {
				if (comparator.compare(arr[j], arr[min]) < 0) {
					swap(arr, j, min);
				}
			}
			
		}
    	
    }
    
    //Insertion sort https://www.programiz.com/dsa/insertion-sort
    
  //comparable descend
    private static<T extends Comparable<? super T>> void insertionSort(T []arr){
    	int size = arr.length;
		for (int step = 1; step < size; step++) {
			T key = (T) arr[step];
			int j = step - 1;
			while (j >= 0 && ((Comparable<? super T>)arr[j]).compareTo(key) < 0) {
				// For ascending order, change key> arr[j] to key< arr[j].
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
    	
    }
    
    //Comparator descend
    private static<T> void insertionSort(T []arr,Comparator<? super T>comparator){
    	
    	int size = arr.length;
		for (int step = 1; step < size; step++) {
			T key = (T) arr[step];
			int j = step - 1;
			while (j >= 0 && (comparator.compare(arr[j], key) < 0)) {
				// For ascending order, change key> arr[j] to key< arr[j].
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
    	
    }
    
    //Merge sort
    
  //comparable descend
    private static<T extends Comparable<? super T>> void mergeSort(T []arr){
    	
    }
    
    //Comparator descend
    private static<T> void mergeSort(T []arr,Comparator<? super T>comparator){
    	
    }
    
    //Quick sort
    
  //comparable descend
    private static<T extends Comparable<? super T>> void quickSort(T []arr){
    	
    }
    
    //Comparator descend
    private static<T> void quickSort(T []arr,Comparator<? super T>comparator){
    	
    }
    
    
    //student’s choice of sorting algorithm
    
    
//	for my test
	public double Test() {
		return shapeArray[0].calcBaseArea();
	}
	

}
