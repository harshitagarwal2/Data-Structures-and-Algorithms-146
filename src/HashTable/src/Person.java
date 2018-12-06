
public class Person {
	private String name;
	private int friendsCount;
	private HashList friends;

	public Person(String string) {
		name = string;
		friends= new HashList();
		friendsCount = 0; 
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		int total= 0;
		// TODO Auto-generated method stub
		for(int i =0 ; i< name.length(); i++) {
			 total += (int)name.charAt(i);
		}
		return total;
	}
	
	public void addFriend(Person p) {
		friends.addNode(new HashNode(p));
		friendsCount++;
		System.out.println(this.name + " added" + p.name + "as a friend.");
	}
	
	public void removeFriend(String name) {
		HashNode n = findNode(name);
		friends.removeNode(n);
		friendsCount--;
		System.out.println(this.name + " removed " + name + "as a friend.");

	}
	
    public void delete(String name){
      
        if (friends.getFirst() == null) { // if no list at the key
            System.out.print("No friends in the account");
        }
        else {
            HashNode prev = friends.getFirst(); // Set previous pointer to the first link in the list
            HashNode current = prev.getNext(); // Set current pointer to the 2nd link in the list

            if(prev.getData().getName().equalsIgnoreCase(name)){
                // Node in question is the head
            	friends.setFirst(current);
System.out.print("\nDeleted patient "+prev.getData().name);
            }
            else{
                // Traverse the list and find the node in question
                while(current != null){ // We know certainly that the root is not our guy
                    if(current.getData().getName().equalsIgnoreCase(name)){
                        prev.setNext(current.getNext()); // Connect previous next pointer to the next node of the current
                        
                        System.out.print("\nDeleted friend "+current.getData().name);
                        current = null; // Delete node in question
                    }
                    else{
                        // Increment pointers
                        prev = prev.getNext();
                        current = prev.getNext();
                    }

                }
            }
        }
    }
	
	public HashNode findNode(String name) {
		HashNode curr = friends.getFirst();
		HashNode del = null;
		while(curr.getNext()!= null && curr.getData().name.equalsIgnoreCase(name) ) {
			if(curr.getData().name.equals(name)) {
				del=curr;
			}else {
				curr= curr.getNext();
			}
		}
		if(del==null) {
			System.out.println("invalid name");
		}
		return del;
	

	}
	

	  public void printFriends(){
		  System.out.println("Printing all the friends:-");
		  HashNode first = friends.getFirst();
		  
		  while(first!= null) {
			  System.out.println(first.getData().name);
			  first = first.getNext();	  
		  }
	        
	    }
	
}
