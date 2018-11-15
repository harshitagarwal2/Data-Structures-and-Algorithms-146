

import java.util.ArrayList;

import models.Crawler;
import models.WebURI;

/**
 * @author harsh
 * Tester method to test the WebURI
 */
public class Tester {
	   /** Main method
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Crawler sc = new Crawler();
				try {
				sc.getURLS(args[0]);
				}catch(Exception e) {
					sc.getURLS("computer science");
				}
			ArrayList<WebURI> myurls = sc.insertWebURIs();
			//Updating the money to pay.
			myurls.get(5).setMoney(5000);
			
			MaxHeap heap = new MaxHeap(myurls);
			System.out.println("Printing out a Heap which does not satisfy max-heap property:\n");
			System.out.println(MaxHeap.toString(myurls));

			heap.BuildMaxHeap(myurls);
			System.out.println("Printing out a Heap which after calling Build Max Heap Method:\n");

			System.out.println(MaxHeap.toString(myurls));
			WebURI m = new WebURI("test.com" , 10000 ,10000,10000 ,1000 );
			heap.maxHeapInsert(myurls, m);
			heap.BuildMaxHeap(myurls);
			System.out.println("Change the amount of money being paid to the simulator by a test case\n");
			System.out.println(MaxHeap.toString(myurls));
			
			System.out.println("Getting the max priority  from the Heap:" + heap.heapExtractMax(myurls));
			
			System.out.println("After extracting the max from the heap.\n");
			System.out.println(MaxHeap.toString(myurls));
			
			System.out.println("Getting the top 10 priority websites:- - ");
			for(int i =0; i<10 ; i++) {
				System.out.println(heap.heapExtractMax(myurls));
			}
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
