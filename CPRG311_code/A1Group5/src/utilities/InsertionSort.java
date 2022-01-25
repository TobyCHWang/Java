package utilities;

import java.util.Comparator;

public class InsertionSort {
	//Insertion sort https://www.programiz.com/dsa/insertion-sort
    
	  //comparable descend
	     public static<T extends Comparable<? super T>> void insertionSort(T []arr){
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
	    public static<T> void insertionSort(T []arr,Comparator<? super T>comparator){
	    	
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

}
