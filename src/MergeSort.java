
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
			sort(A, p, q);
			sort(A, q+1, r);
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
    public static void main(String args[]) 
    { 
        int arr[] = {12, 11, 13, 5, 6, 7}; 
  
        System.out.println("Given Array"); 
        printArray(arr); 
  
        MergeSort ob = new MergeSort(); 
        ob.sort(arr, 0, arr.length-1); 
  
        System.out.println("\nSorted array"); 
        printArray(arr); 
    } 
} 