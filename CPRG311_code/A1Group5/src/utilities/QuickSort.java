package utilities;

import java.util.Comparator;

public class QuickSort {
	// This method is used to swap the values between the two given index
    private static void swap(Object []a, int left,int right){
        Object temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }
	
    
    
    
    
    
    
    //Quick sort https://www.cs.mcgill.ca/~dprecup/courses/IntroCS/Assignments/QuickSort.java
    
  //comparable descend
    public static<T extends Comparable<? super T>> void quickSort(T []arr){
    	quickSortWithSpecific(arr, 0, arr.length-1);
    }
    
    //Comparator descend
    public static<T> void quickSort(T []arr,Comparator<? super T>comparator){
    	quickSortWithSpecific(arr, 0, arr.length-1,comparator);
    	
    }
    
	private static <T extends Comparable<? super T>> void quickSortWithSpecific(T[] a, int i, int j) {
		if (i < j) {
			int l = partition(a, i, j);
			quickSortWithSpecific(a, i, l);
			quickSortWithSpecific(a, l + 1, j);
		}
	}
	


	private static <T extends Comparable<? super T>> int partition(T[] a, int p, int q) {
		T x = a[p];
		int m = (p + q) / 2;
		if ((a[p].compareTo(a[m]) >= 0 && a[m].compareTo(a[q]) >= 0)
				|| (a[q].compareTo(a[m]) >= 0 && a[m].compareTo(a[p]) >= 0))
			x = a[m];
		if ((a[p].compareTo(a[q]) <= 0 && a[q].compareTo(a[m]) >= 0)
				|| (a[m].compareTo(a[q]) <= 0 && a[q].compareTo(a[p]) >= 0))
			x = a[q];
		int i = p - 1;
		int j = q + 1;
		while (true) {
			do
				i++;
			while (!(i > q || a[i].compareTo(x) <= 0));
			do
				j--;
			while (!(j < p || a[j].compareTo(x) >= 0));
			if (i < j)
				swap(a, i, j);
			else
				return j;
		}
	}

    //COMPA
	private static<T> void quickSortWithSpecific(T []arr,int i, int j,Comparator<? super T>comparator){
		if (i < j) {
			int l = partition(arr, i, j,comparator);
			quickSortWithSpecific(arr, i, l,comparator);
			quickSortWithSpecific(arr, l + 1, j,comparator);
		}
    	
    }
	
	private static <T> int partition(T[] a, int p, int q,Comparator<? super T>comparator) {
		T x = a[p];
		int m = (p + q) / 2;
		if ((comparator.compare(a[p], a[m]) >= 0 && comparator.compare(a[m], a[q]) >= 0)
				|| (comparator.compare(a[q], a[m]) >= 0 && comparator.compare(a[m], a[p]) >= 0))
			x = a[m];
		if ((comparator.compare(a[p], a[q]) <= 0 && comparator.compare(a[q], a[m]) >= 0)
				|| (comparator.compare(a[m], a[q]) <= 0 && comparator.compare(a[q], a[p])  >= 0))
			x = a[q];
		int i = p - 1;
		int j = q + 1;
		while (true) {
			do
				i++;
			while (!(i > q || comparator.compare(a[i], x)  <= 0));
			do
				j--;
			while (!(j < p || comparator.compare(a[j], x) >= 0));
			if (i < j)
				swap(a, i, j);
			else
				return j;
		}
	}

}
