
public class HashNode {
    private Person data;
    private HashNode next;
    
    // Constructor
    HashNode( Person data){
        this.data = data;
        this.next = null;
    }


    public Person getData(){
        return data;
    }

    public HashNode getNext(){
        return next;
    }

    /** Setters */

    public void setNext(HashNode next){
        this.next = next;
    }
    
    
    @Override
    public int hashCode() {
    	// TODO Auto-generated method stub
    return data.getName().hashCode();
    }
    
    @Override
    public String toString() {
    	return "Node Object Data: " + data.getName(); 
    }
    
    @Override
    public boolean equals(Object obj) {
    	HashNode node = (HashNode) obj;
    	if(node == null)return false;
    	if(node.getClass() != this.getClass()) return false;
    	return this.data.getName() == node.getData().getName();
    }


}
