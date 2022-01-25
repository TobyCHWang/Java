package utilities;

import java.util.Comparator;

public class BubbleSort {
	//bubble sort ref:https://examples.javacodegeeks.com/bubble-sort-java-algorithm-code-example/
		//comparable descend
	    public static<T extends Comparable<? super T>> void bubbleSort(T []arr){
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
		 
		 public static<T> void bubbleSort(T []arr,Comparator<? super T>comparator){
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

}
