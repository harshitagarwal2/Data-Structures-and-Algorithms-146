import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.LinkedList;

public class HashTable {
	private int hashSize;
	private int count =0; 
	private HashNode[] table;

	
	public HashTable() {
		hashSize = 11;
		table = new HashNode[hashSize];
		initTable();
	}
	
 /** Utility function to fill primitive array table with null. Used at initialization. */
    private void initTable() {
        for (int i = 0; i < hashSize; i++){
            table[i] = null;
        }
    }
	
	public int Hash(Person p) {
		int total = p.hashCode();
		 final double A = (Math.sqrt(5) -1)/2;
		 int newHash = (int) Math.floor(hashSize*(total*A %1));
		 return newHash;
		 
	}
	
	public void chainedHashInsert(Person p){
		int key = Hash(p);
		
		if(table[key] == null) {
			table[key] = new HashNode(p);
			System.out.println("Person " + p.getName() + " added to the key Number of the Table: " + key);
		}else {
			HashNode first= table[key];
			HashNode n = new HashNode(p);
			n.setNext(first);
			table[key] = n;
			System.out.println("Person " + p.getName() + " added to the key Number of the Table: " + key);
		}
		
	}
	
    public Person search(String name) {
        int key = Hash(new Person(name)); //
        Person dummy = new Person("Null"); // Dummy object

        if (table[key] == null) {
            return null; // Empty key
        }
        else {
            HashNode root =table[key]; // Initialize root object and set it to the first link in the list

            // Traverse the list and compare priority number of each link
            while(root != null){
                if(root.getData().getName().equalsIgnoreCase(name)){
                    return root.getData();
                }
                else{
                    root = root.getNext();
                }
            }
        }
        return null;
    }

	  public void printList(){
	        System.out.print("\nHash table by level: \n");
	        for(int i = 0; i < hashSize; i++){
	            if(table[i] != null) {
	                HashNode current = table[i]; // Get the head node of the linked list at key i
	                System.out.print("Level "+i+": ");
	                while(current != null){
	                    Person temp = current.getData();
	                    System.out.print(temp.getName()+"; ");
	                    current = current.getNext();
	                }
	                System.out.print("\n");
	            }
	        }
	    }
}


