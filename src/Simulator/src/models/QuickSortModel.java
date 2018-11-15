package models;

import java.util.ArrayList;

/** QuickSort implementation
 * @author harsh
 *
 */
public class QuickSortModel {

	
	/**
	 * Sorts the given element
	 * @param arr array input
	 * @param p The first index
	 * @param r The last element index
	 */
	public void sort(ArrayList<WebURLModel> arr , int p , int r) {
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
	public int partition(ArrayList<WebURLModel> arr, int p, int r) {
		double x = arr.get(r).getPriority();
		int i = p-1;
		for(int j = p ; j<r ; j++) {
			if(arr.get(p).getPriority()<= x) {
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
	public void swap(ArrayList<WebURLModel> arr , int  o, int n) {
		WebURLModel temp = arr.get(o);
		arr.set(o, arr.get(n));
		arr.set(n, temp);
	}
	
}