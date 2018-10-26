

import java.util.ArrayList;


/**
 * @author harsh
 * A max Heap simulating the Priority Queue in the WebURI simulator.
 */
public class MaxHeap {
	private ArrayList<WebURI> urls;
	private int size;
	
	/**
	 * constructor
	 * @param urls the arraylist
	 */
	public MaxHeap(ArrayList<WebURI> urls) {
		this.setUrls(urls);
		size = urls.size();
	}
	
	/**
	 * Builds a max heap by calling the max heapify property on each parent node of the heap.
	 * 
	 * @param urls takes the heap as an input.
	 */
	public void BuildMaxHeap(ArrayList<WebURI> urls){
		for (int i = size/2 - 1; i >= 0; i--){
			maxHeapify(urls, i);
		}
	}
	
	/**
	 * Swaps the elements if they does not follow the heap property parent> child.
	 * @param urls takes a heap as an input
	 * @param index takes the index of the parent node.
	 */
	private void maxHeapify(ArrayList<WebURI> urls, int index ) {
		if (urls == null && index >= size){
			return;
		}
		int l = left(index);
		int r = right(index);
		int largest;
		if (l < size && urls.get(l).getPriority() > urls.get(index).getPriority()){
			largest = l;
		}
		else largest = index;
		if (r < size && urls.get(r).getPriority() > urls.get(largest).getPriority()){
			largest = r;
		}
		//if the max is not the current node, swap it with the max of the left and right children
		if (largest != index){
			swap(urls, index, largest);
			maxHeapify(urls, largest);
	}
	}
	
	/**
	 * Prints out the heap in the Almost complete Binary tree form.
	 * @param urls Arraylist to get the heap printed
	 * @return returns a string format.
	 */
	public static String toString(ArrayList<WebURI> urls){
		ArrayList<String> lines = new ArrayList<>();
		for (int i = 0; i < urls.size(); i=2*i+1){
			String line= "     ";
			for (int j = i; j < urls.size() && j <= 2 * i; j++){
				line+= urls.get(j)+"   ";
			}
			lines.add(line);
			lines.add("\n");
		
		}
		for (int i = 0; i <lines.size(); i++){
			int spaces = 4 * ((lines.size()-1) - i);
			for (int n = 0; n < spaces; n++){
				lines.set(i, " " + lines.get(i));
			}
		}
		String result ="";
		for (String line:lines){
			result+= line+"\n";
		}
		return result;
	}
	
	/**
	 * Gets the maximum of the heap
	 * @param urls takes heap as an input 
	 * @return returns the maximum.
	 */
	public double HeapMaximum(ArrayList<WebURI> urls){
		return urls.get(0).getPriority();
	}
	
	/**
	 * @param urls extracts the maximum and sets the new maximum by calling the max heapify again on the heap.
	 * @return maxheap.
	 * @throws Exception
	 */
	public WebURI heapExtractMax(ArrayList<WebURI> urls) throws Exception {
		if(urls.size() < 0  ) throw new Exception("heap underflow");
		WebURI max = urls.get(0);
		urls.set(0, urls.get(size-1));
		size = size-1;
		maxHeapify(urls, 0);
		return max;	   
	}
	
	/**
	 * It increases the value of the given index and call themaxHeapify to restore the property of max heaps.
	 * @param urls The heap to be updated
	 * @param i the index of the place of being updated
	 * @param key the value to be updated.
	 */
	public void HeapIncreaseKey(ArrayList<WebURI> urls, int i, WebURI key) {
		if (key.getPriority() < urls.get(i).getPriority()){
			throw new RuntimeException("New key is smaller than current key");
		}
		urls.set(i, key);
		while (i > 0 && urls.get(parent(i)).getPriority() < urls.get(i).getPriority()){
			swap(urls, parent(i), i);
			i = parent(i);
		}
	}
	
	/**
	 * Inserts a new key to the heap data structure.
	 * @param urls
	 * @param key
	 */
	public void maxHeapInsert(ArrayList<WebURI> urls , WebURI key) {
		urls.add(key);
		HeapIncreaseKey(urls, size-1, key);
	}
	/*
	 * Sorts the heap inplace and gives the maximum;
	 */
	public ArrayList<WebURI> HeapSort(ArrayList<WebURI> urls){
		BuildMaxHeap(urls);
		for (int i = size-1; i > 1; i--){
			swap(urls, 0, i);
			size = size - 1;
			maxHeapify(urls, 0);
		}
		return urls; 
	}
	
	
	/**
	 * @param index
	 * @return
	 */
	private int parent(int index)
	   {
	       return (index - 1)/2;
			    
	   }
	   
	/**
	 * @param index
	 * @return
	 */
	private static int left(int index)
	   {
	       return 2 * index + 1;
	   }
	   
	/**
	 * @param index
	 * @return
	 */
	private static int right(int index)
	   {
	       return 2 * index + 2;
	   }
	   
	/** 
	 * As the size of heap deceases everytime in the heapsort we need another variable to hold the size of the heap.
	 * get size of the heap 
	 * @return return the size of heap.
	 */
	@SuppressWarnings("unused")
	private int size()
	   {
	       return size;
	   }
	
	/**
	 *  It swaps two elements in the specific index.
	 * @param urls gets the heap to be sorted
	 * @param oldIndex the old index in the heap
	 * @param newIndex the new index for the sort
	 */
	private static void swap(ArrayList<WebURI> urls, int oldIndex, int newIndex) {
		WebURI t = urls.get(oldIndex);
		urls.set(oldIndex, urls.get(newIndex));
		urls.set(newIndex, t);
	}

	/*
	 * getters
	 */
	public ArrayList<WebURI> getUrls() {
		return urls;
	}
	/*
	 * setters
	 */
	public void setUrls(ArrayList<WebURI> urls) {
		this.urls = urls;
	}
	   
}
