package utilities;

import java.util.Comparator;

public class SelectionSort {
//Selection sort https://www.geeksforgeeks.org/selection-sort/
    
    //comparable descend
    public static<T extends Comparable<? super T>> void selectionSort(T []arr){
    	
    	int size = arr.length;
		for (int i = 0; i < size - 1; i++) {
			int min = i;
			for (int j = i + 1; j < size; j++) {
				if (((Comparable<? super T>)arr[j]).compareTo(arr[min]) > 0) {
					swap(arr, j, min);
				}
			}
			
		}
    		
    }
    
    //Comparator descend
    public static<T> void selectionSort(T []arr,Comparator<? super T>comparator){
    	

    	int size = arr.length;
		for (int i = 0; i < size - 1; i++) {
			int min = i;
			for (int j = i + 1; j < size; j++) {
				if (comparator.compare(arr[j], arr[min]) > 0) {
					swap(arr, j, min);
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
