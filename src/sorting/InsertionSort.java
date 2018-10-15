package sorting;

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
	        int arr[] = {20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1}; 
	        int arr2[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
	        int arr3[] = {10,9,8,7,6,5,4,3,2,1,11,12,13,14,15,16,17,18,19,20};
	        System.out.println("Given Best Case Array"); 
	        printArray(arr2); 
	        InsertionSort ob = new InsertionSort(); 
	        
	        long startTime = System.nanoTime();
	        ob.sort(arr2); 						//Just calculating the time for the insertion sort.
	        long endTime = System.nanoTime();
	        long totalTime = endTime-startTime;
	        System.out.println("Best Time in nanoseconds: " +totalTime);
	        
	        System.out.println("\nSorted Best Case array"); 
	        printArray(arr2); 
	 
	        System.out.println("Given Worst Case Array"); 
	        printArray(arr);
	        
	         startTime = System.nanoTime();
	        ob.sort(arr); 						//Just calculating the time for the insertion sort.
	         endTime = System.nanoTime();
	         totalTime = endTime-startTime;
	        System.out.println("Worst Time in nanoseconds: " +totalTime);
	        
	        System.out.println("\nSorted Worst Case array"); 
	        printArray(arr2);
	        
	        
	        System.out.println("Given Average Case Array"); 
	        printArray(arr3);
	        
	        
	         startTime = System.nanoTime();
	        ob.sort(arr3); 						//Just calculating the time for the insertion sort.
	         endTime = System.nanoTime();
	         totalTime = endTime-startTime;
	        System.out.println("Avergae Time in nanoseconds: " +totalTime);
	        System.out.println("\nSorted Average Case array"); 
	        printArray(arr3);
	        
	        
	    } 
}
