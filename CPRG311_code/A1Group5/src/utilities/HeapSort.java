package utilities;

import java.util.Comparator;

public class HeapSort {
	
	//comparable descend
	  public static<T extends Comparable<? super T>> void heapSort(T []arr){
		  heapSortWithSpecific(arr,arr.length);
	    }
	    
	    //Comparator descend
	   public static<T> void heapSort(T []arr,Comparator<? super T>comparator){
		   heapSortWithSpecific(arr,arr.length,comparator);
	    }
	   
	   
	   public static<T extends Comparable<? super T>> void heapify(T []arr,int n, int i) {
		   int smallest = i; // Initialize smalles as root
	        int l = 2 * i + 1; // left = 2*i + 1
	        int r = 2 * i + 2; // right = 2*i + 2
	 
	        // If left child is smaller than root
	        if (l < n && arr[l].compareTo(arr[smallest])<0 )
	            smallest = l;
	 
	        // If right child is smaller than smallest so far
	        if (r < n && arr[r].compareTo(arr[smallest])<0 )
	            smallest = r;
	 
	        // If smallest is not root
	        if (smallest != i) {
	            T temp = arr[i];
	            arr[i] = arr[smallest];
	            arr[smallest] = temp;
	 
	            // Recursively heapify the affected sub-tree
	            heapify(arr, n, smallest);
	        }
	   }
	   
	   public static<T extends Comparable<? super T>> void heapSortWithSpecific(T []arr,int n) {
		// Build heap (rearrange array)
	        for (int i = n / 2 - 1; i >= 0; i--)
	            heapify(arr, n, i);
	 
	        // One by one extract an element from heap
	        for (int i = n - 1; i >= 0; i--) {
	             
	            // Move current root to end
	            T temp = arr[0];
	            arr[0] = arr[i];
	            arr[i] = temp;
	 
	            // call max heapify on the reduced heap
	            heapify(arr, i, 0);
	        }
	   }
	   
	   public static<T> void heapify(T []arr,int n, int i,Comparator<? super T>comparator) {
		   int smallest = i; // Initialize smalles as root
	        int l = 2 * i + 1; // left = 2*i + 1
	        int r = 2 * i + 2; // right = 2*i + 2
	 
	        // If left child is smaller than root
	        if (l < n && comparator.compare(arr[l], arr[smallest])<0 )
	            smallest = l;
	 
	        // If right child is smaller than smallest so far
	        if (r < n && comparator.compare(arr[r], arr[smallest])<0 )
	            smallest = r;
	 
	        // If smallest is not root
	        if (smallest != i) {
	            T temp = arr[i];
	            arr[i] = arr[smallest];
	            arr[smallest] = temp;
	 
	            // Recursively heapify the affected sub-tree
	            heapify(arr, n, smallest,comparator);
	        }
		   
	   }
	   
	   public static<T> void heapSortWithSpecific(T []arr,int n,Comparator<? super T>comparator) {
		// Build heap (rearrange array)
	        for (int i = n / 2 - 1; i >= 0; i--)
	            heapify(arr, n, i,comparator);
	 
	        // One by one extract an element from heap
	        for (int i = n - 1; i >= 0; i--) {
	             
	            // Move current root to end
	            T temp = arr[0];
	            arr[0] = arr[i];
	            arr[i] = temp;
	 
	            // call max heapify on the reduced heap
	            heapify(arr, i, 0,comparator);
	        }
		   
	   }

}
