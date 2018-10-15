package HospitalPriority;

//This class simulates a hospital waiting room. The waiting room can be seen as a max-heap priority queue, where an 
//arrayList of patients are seen as a max-heap. In this case, the patients with the most critical condition are at the 
//top of the list, meaning they are the root of the max-heap tree, with the highest number. 


import java.util.ArrayList;
import java.util.Random;

public class MaxHeap {
	private static ArrayList<Patient> patients;

	public MaxHeap(ArrayList<Patient> patients){
		MaxHeap.patients = new ArrayList<Patient>(patients);
	}
	
	
	/*
	 * return the index of the parent node of each child in the heap tree
	 */
	public static int parent(int i){
		return i / 2;
	}
	
	/*
	 * returns the index of the left child of its parent in the heap tree
	 */
	public static int left(int i){
		return 2 * i+1;
	}
	
	/*
	 * returns the index of the right child of its parent in the heap tree
	 */
	public static int right(int i){
		return 2 * i + 2;
	}
	
	/*
	 * MaxHeapify helps maintain the heap property, where the parent is always bigger than its children
	 * This means that the patient with the highest priority is always ahead of patients with less priority 
	 */
	public static void MaxHeapify(ArrayList<Patient>patients, int i, int size){
			if (patients == null && i >= patients.size()){
				return;
			}
			int l = left(i);
			int r = right(i);
			int largest;
			if (l <= size && patients.get(l).id > patients.get(i).id){
				largest = l;
			}
			else largest = i;
			if (r <= size && patients.get(r).id > patients.get(largest).id){
				largest = r;
			}
			//if the max is not the current node, swap it with the max of the left and right children
			if (largest != i){
				swap(patients, i, largest);
				MaxHeapify(patients, largest, size);
			}
			
		}
	
	/*
	 * Calls MaxHeapify to convert the arrayList of patients into a max-heap in a bottom-up manner
	 */
	public static void BuildMaxHeap(ArrayList<Patient> patients){
		for (int i = patients.size()/2 - 1; i >= 0; i--){
			MaxHeapify(patients, i, patients.size()-1);
		}
	}
	
	/*
	 * swaps elements of old index with element of new index
	 */
	private static void swap(ArrayList<Patient> patients, int oldIndex, int newIndex) {
		Patient t = patients.get(oldIndex);
		patients.set(oldIndex, patients.get(newIndex));
		patients.set(newIndex, t);
	}
	
	
	/*
	 * Sorts the arrayList 
	 */
	public static ArrayList<Patient> HeapSort(ArrayList<Patient> patients){
		//ArrayList<Patient> copyPatients = new ArrayList<>(patients);
		int heapSize = patients.size()-1;
		BuildMaxHeap(patients);
		for (int i = heapSize; i > 0; i--){
			swap(patients, 0, i);
			heapSize = heapSize - 1;
			MaxHeapify(patients, 0, heapSize);
		}
		return patients; 
	}
	
	/*
	 * When there is a new patient, the new patient is inserted into the arrayList. 
	 */
	public static ArrayList<Patient> MaxHeapInsert(ArrayList<Patient>patients, Patient key){
		patients.add(key);
		HeapIncreaseKey(patients, patients.size()-1, key);
		
		return patients;
	}
	
	/*
	 * Increases the size of the tree after value is inserted 
	 */
	public static void HeapIncreaseKey(ArrayList<Patient> patients, int i, Patient key) {
		if (key.id < patients.size()){
			throw new RuntimeException("New key is smaller than current key");
		}
		while (i > 1 && patients.get(parent(i)).id < patients.get(i).id){
			swap(patients, parent(i), i);
			i = parent(i);
		}
	}
	
	/*
	 * Removes and returns the element of the max-heap with the largest value
	 */
	public static int HeapExtractMax(ArrayList<Patient> patients){
		if (patients.size() < 0){
			throw new RuntimeException("heap underflow");
		}
		int max = patients.get(0).id;
		patients.set(0, patients.get(patients.size()-1));
		MaxHeapify(patients, 0, patients.size()-1);
		return max;
	}
	
	/*
	 * Returns the maximum of the arrayList, which is the very first element. 
	 */
	public static int HeapMaximum(ArrayList<Patient> patients){
		return patients.get(0).id;
	}
	
	
	/*
	 * Portrays the arrayList in tree form, instead of list form. 
	 * this portion of the code was written with the help of a COSAC tutor 
	 */
	public static String toString(ArrayList<Patient> patients){
		ArrayList<String> lines = new ArrayList<>();
		for (int i = 0; i < patients.size(); i=2*i+1){
			String line="";
			for (int j = i; j < patients.size() && j <= 2 * i; j++){
				line+= patients.get(j)+"  ";
			}
			lines.add(line);
		}
		for (int i = 0; i <lines.size(); i++){
			int numSpaces = 4 * ((lines.size()-1) - i);
			for (int n = 0; n < numSpaces; n++){
				lines.set(i, " " + lines.get(i));
			}
		}
		String ret ="";
		for (String line:lines){
			ret+= line+"\n";
		}
		return ret;
	}
	

	/*
	 * tests for correctness of code
	 */
	public static void main(String[] args){
		String[] patientNames = {"Amelia", "Alexa", "Aiden", "Adeline", "Antonia", "Amelia", "Aiden", "Adelaide", "Abel", "Janiya", "Clinton", "Tahoe", "Cherokee", "Free", "Kimana", "Zayden", "Florida", "Denali", "Reno", "Ellington", "Jett", "Brooklyn", "Jayden", "Tripp", "Kylo", "Montana", "Apple", "Kateri", "Monroe", "Shada", "Alaska", "Navy", "Sierra", "Caleb", "Olivia", "Beatrice", "Theadore", "Penelope", "Josephine", "Isabella", "Sadie", "Ruth", "Frances", "Letitia", "Barnabas", "Millicent", "Cecilia", "Amity", "Amos", "Bear", "Journey", "Blade", "Wolf", "Dimitri", "Blaze", "Zen", "King", "Venus", "Juno", "Zora", "Cleopatra", "Luna", "November", "Zenobia", "Story", "Vivi", "Lou", "Lizzie", "Mitzi", "Zuzu", "Jules", "Mamie", "Gracie"};
		ArrayList<Patient> test = new ArrayList<>();
		Random rand = new Random();
		for (int i = 0; i < 20; i++){
			Patient random = new Patient(patientNames[i], rand.nextInt(1000));
			test.add(random);
		}
		System.out.println("Before HeapSort:");
		System.out.println(toString(test));
		test = HeapSort(test);
		MaxHeap.BuildMaxHeap(test);
		System.out.println("After HeapSort:\n" + toString(test));
		Patient newPatient = new Patient("Bob", 795);
		test = MaxHeapInsert(test, newPatient);
		System.out.println("After inserting a new patient:\n" + toString(test));
		HeapExtractMax(test);
		System.out.println("After a patient with the highest priority is taken care of :\n" + toString(test));

	}
	
	
	
}