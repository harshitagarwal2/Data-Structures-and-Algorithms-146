package sorting;

import views.QuickSort;

/**
 * The following Class implements a Quicksort algorithm with 2 pivots in it.
 * @author harsh
 *
 */
public class DualPivotQuickSort {
	
	/**
	 * The sort methods calls the partition recursively which sorts the given array elements.
	 * @param arr
	 * @param p
	 * @param r
	 */
	public void sort(int [] arr, int p , int r) {
		if(p<r) {
			int [] indexes = partition(arr, p, r);
			sort(arr,p,indexes[0]-1);
			sort(arr,indexes[0]+1, indexes[1]-1 );
			sort(arr,indexes[1]+1 ,r);
		}
		
	}
	
	/*
	 * It partitions the array into 3-subarrays , one having valeus less than pivot-1
	 * Second array have values between pivot-1 and pivot=2
	 * Third array have values greater than pivot-3
	 *  Returns an array as we have two pivot values to be returned.
	 */
	public int[] partition(int [] a, int p , int r) {
		int p1 = a[p];
		int p2 = a[r];
		if(p1>p2) swap(a,p,r);
		int i,k;
		 i = k = p-1;
		for(int j= p ; j<r; j++) {
			if(a[j]<= p1) {
				i= i+1;
				k = k+1;
				swap(a , j, i);
			}else if(a[j]<= p2) {
				k= k+1;
				swap(a,j , k);
			}
		}
		swap(a,p , i+1);
		swap(a,r , k+1 );
		int [] indexes = {i+1, k+1};
		return indexes;
	}
	
	
	public void swap(int[] arr , int  o, int n) {
		int temp = arr[o];
		arr[o] = arr[n];
		arr[n] = temp;
	}
	
	static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i] + " "); 
        System.out.println(); 
    } 
  
    public static void main(String args[]) 
    { 
        int arr[] = {20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1}; 
        int arr2[] = {4 ,1 ,3, 5, 6 ,7 ,2 , 8, 10, 11, 9 , 14, 13, 12 , 15, 19 ,20 ,16 , 17, 18};
        int arr3[] = {10,9,8,7,6,5,4,3,2,1,11,12,13,14,15,16,17,18,19,20};
        System.out.println("Given Best Case Array"); 
        printArray(arr2); 
        QuickSort ob = new QuickSort(); 
        
        long startTime = System.nanoTime();
        ob.sort(arr2,0,arr2.length-1); 						//Just calculating the time for the Quick sort.
        long endTime = System.nanoTime();
        long totalTime = endTime-startTime;
        System.out.println("Best Time in nanoseconds: " +totalTime);
        
        System.out.println("Sorted Best Case array"); 
        printArray(arr2); 
 
        System.out.println("\nGiven Worst Case Array"); 
        printArray(arr);
        
         startTime = System.nanoTime();
        ob.sort(arr,0,arr.length-1); 						//Just calculating the time for the Quick sort.
         endTime = System.nanoTime();
         totalTime = endTime-startTime;
        System.out.println("Worst Time in nanoseconds: " +totalTime);
        
        System.out.println("Sorted Worst Case array"); 
        printArray(arr);
        
        
        System.out.println("\nGiven Average Case Array"); 
        printArray(arr3);
        
        
         startTime = System.nanoTime();
        ob.sort(arr3,0,arr3.length-1); 						//Just calculating the time for the Quick sort.
         endTime = System.nanoTime();
         totalTime = endTime-startTime;
        System.out.println("Avergae Time in nanoseconds: " +totalTime);
        System.out.println("Sorted Average Case array"); 
        printArray(arr3);
        
        
    } 

}

/*
 * Given Best Case Array
4 1 3 5 6 7 2 8 10 11 9 14 13 12 15 19 20 16 17 18 
Best Time in nanoseconds: 55000
Sorted Best Case array
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 

Given Worst Case Array
20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 
Worst Time in nanoseconds: 121000
Sorted Worst Case array
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 

Given Average Case Array
10 9 8 7 6 5 4 3 2 1 11 12 13 14 15 16 17 18 19 20 
Avergae Time in nanoseconds: 178300
Sorted Average Case array
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 
*/

