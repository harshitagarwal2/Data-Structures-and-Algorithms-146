package sorting;
public class MergeSort {
	
	public void merge(int[] A , int p, int q ,int r) {
		int n1 = q-p+1;
		int n2 = r-q;
		
		// Creating Temporary Arrays to Divide the Main Array.
		int[] L = new int [n1+1];
		int[] R = new int [n2+1];
		// Array Index from 0 thus 1 changed to 0 and redued the size.
		for(int i=0; i< n1 ; i++)
			L[i] = A[p+i];
		
		for(int j =0 ; j< n2; j++)
			R[j] = A[q+j+1];
		
		L[n1] = Integer.MAX_VALUE;	// Sentinal Value
		R[n2] = Integer.MAX_VALUE; // Sentinal Value
		
		 // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 

        for(int k=p; k<= r ; k++ ) {
        	if(L[i] <= R[j])
        		{
        			A[k] = L[i];
        			i = i+1;
        		}
        	else {
        		A[k] = R[j];
        		j = j+1;
        	}
        }
	}
	
	public void sort(int A[], int p, int r) {
		if(p< r) {
			int q = (p+r)/2;
			sort(A, q+1, r);
			sort(A, p, q);
			merge(A, p, q, r);
		}
	}
	
	  /* A utility function to print array of size n */
    static void printArray(int arr[]) 
    { 
  
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
  
    // Driver method 
    // Driver method 
    public static void main(String args[]) 
    { 
        int arr[] = {20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1}; 
        int arr2[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int arr3[] = {10,9,8,7,6,5,4,3,2,1,11,12,13,14,15,16,17,18,19,20};
        int arr5[] = {6,2,8,12,7,5,15};
        printArray(arr5);
        
    /*    System.out.println("Given Best Case Array"); 
        printArray(arr2); 
       
        
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
       */
        InsertionSort ob = new InsertionSort();
      
        ob.sort(arr5);
        printArray(arr5);
    } 
}