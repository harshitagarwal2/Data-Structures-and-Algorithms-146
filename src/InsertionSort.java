
/**
 * @author Harshit
 * All the index referencing according to the book were from 1 and in the program it is 0.
 */
public class InsertionSort {
	public void sort(int[] A) {
		for(int j=1; j < A.length; j++ ) {
			int key = A[j];
			int i = j-1;
			while(i >= 0 && A[i]> key) {
				A[i+1] = A[i];
				i = i-1;
			}
			A[i+1] = key;
		}
	}
	
	  static void printArray(int arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i] + " "); 
	        System.out.println(); 
	    } 
	  
	    // Driver method 
	    public static void main(String args[]) 
	    { 
	        int arr[] = {12, 11, 13, 5, 6, 7}; 
	  
	        System.out.println("Given Array"); 
	        printArray(arr); 
	  
	        InsertionSort ob = new InsertionSort(); 
	        ob.sort(arr); 
	  
	        System.out.println("\nSorted array"); 
	        printArray(arr); 
	    } 
}
