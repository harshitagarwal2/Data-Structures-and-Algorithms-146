package sorting;

/** QuickSort implementation
 * @author harsh
 *
 */
public class QuickSort {

	
	/**
	 * Sorts the given element
	 * @param arr array input
	 * @param p The first index
	 * @param r The last element index
	 */
	public void sort(int[] arr , int p , int r) {
		if(p<r) {
			int q = partition(arr,p,r);
			sort(arr,p,q-1);
			sort(arr,q+1,r);
		}
	}
	
	
	/**
	 * @param arr Array
	 * @param p index-1
	 * @param r index-2
	 * @return middle part
	 * It generates two subarrays making all elements in left array to have values less than pivot 
	 * and right array to have value greater than pivot
	 */
	public int partition(int[] arr, int p, int r) {
		int x = arr[r];
		int i = p-1;
		for(int j = p ; j<r ; j++) {
			if(arr[j]<= x) {
				i = i+1;
				swap(arr, j, i);
			}
		}
		swap(arr,r, i+1);
		return i+1;
		
	}
	
	/*
	 * Swaps the element in an array
	 */
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
 * 
 * Output
* 
Given Best Case Array
4 1 3 5 6 7 2 8 10 11 9 14 13 12 15 19 20 16 17 18 
Best Time in nanoseconds: 59100
Sorted Best Case array
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 

Given Worst Case Array
20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1 
Worst Time in nanoseconds: 275400
Sorted Worst Case array
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 

Given Average Case Array
10 9 8 7 6 5 4 3 2 1 11 12 13 14 15 16 17 18 19 20 
Avergae Time in nanoseconds: 61400
Sorted Average Case array
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
 * 
 * */
