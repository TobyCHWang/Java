package utilities;

import java.util.Comparator;

public class MergeSort {
	//Merge sort
    
	  //comparable descend
	  public static<T extends Comparable<? super T>> void mergeSort(T []arr){
	    	mergeSortWithSpecific(arr, 0, arr.length-1);
	    }
	    
	    //Comparator descend
	   public static<T> void mergeSort(T []arr,Comparator<? super T>comparator){
	    	mergeSortWithSpecific(arr, 0, arr.length-1,comparator);
	    }
	    
//	    get temp 
	    public static<T extends Comparable<? super T>> void mergeSortWithSpecific(T[] a,int lowerIndex,int upperIndex){
	        if(lowerIndex == upperIndex){
	            return;
	        }else{
	            int mid = (lowerIndex+upperIndex)/2;
	            mergeSortWithSpecific(a,lowerIndex,mid);
	            mergeSortWithSpecific(a,mid+1,upperIndex);
	            mergeDesc(a,lowerIndex,mid+1,upperIndex);
	           
	        }
	    }
	    
	    
	    public static<T> void mergeSortWithSpecific(T []a,int lowerIndex,int upperIndex, Comparator<? super T>comparator){
	        if(lowerIndex == upperIndex){
	            return;
	        }else{
	            int mid = (lowerIndex+upperIndex)/2;
	            mergeSortWithSpecific(a,lowerIndex,mid,comparator);
	            mergeSortWithSpecific(a,mid+1, upperIndex,comparator);
	            mergeDesc(a,lowerIndex,mid+1,upperIndex,comparator);
	            
	        }
	    }
	    
	    
	    public static<T extends Comparable<? super T>> void mergeDesc(T[] arr,int lowerIndexCursor,int higerIndex,int upperIndex){
	        Object []tempArray = getTempArray(arr.length);
	        int tempIndex=0;
	        int lowerIndex = lowerIndexCursor;
	        int midIndex = higerIndex-1;
	        int totalItems = upperIndex-lowerIndex+1;
	        while(lowerIndex <= midIndex && higerIndex <= upperIndex){
	            if(((Comparable<? super T>)arr[lowerIndex]).compareTo(arr[higerIndex]) > 0){
	                tempArray[tempIndex++] = arr[lowerIndex++];
	            }else{
	                tempArray[tempIndex++] = arr[higerIndex++];
	            }
	        }
	 
	        while(lowerIndex <= midIndex){
	            tempArray[tempIndex++] = arr[lowerIndex++];
	        }
	 
	        while(higerIndex <= upperIndex){
	            tempArray[tempIndex++] = arr[higerIndex++];
	        }
	 
	        for(int i=0;i<totalItems;i++){
	            arr[lowerIndexCursor+i] = (T) tempArray[i];
	        }
	    }
	    
	    
	    
	    private static Object[] getTempArray(int length){
	        Object []tempArray = new Object[length];
	        return tempArray;
	    }
	    
	    
	    public static<T> void mergeDesc(T []a,int lowerIndexCursor,int higerIndex,int upperIndex,Comparator<? super T>comparator){
	        Object []tempArray = getTempArray(a.length);
	        int tempIndex=0;
	        int lowerIndex = lowerIndexCursor;
	        int midIndex = higerIndex-1;
	        int totalItems = upperIndex-lowerIndex+1;
	        while(lowerIndex <= midIndex && higerIndex <= upperIndex){
	            if(comparator.compare(a[lowerIndex],a[higerIndex]) > 0){
	                tempArray[tempIndex++] = a[lowerIndex++];
	            }else{
	                tempArray[tempIndex++] = a[higerIndex++];
	            }
	        }
	 
	        while(lowerIndex <= midIndex){
	            tempArray[tempIndex++] = a[lowerIndex++];
	        }
	 
	        while(higerIndex <= upperIndex){
	            tempArray[tempIndex++] = a[higerIndex++];
	        }
	 
	        for(int i=0;i<totalItems;i++){
	            a[lowerIndexCursor+i] = (T) tempArray[i];
	        }
	    }
	    

}
