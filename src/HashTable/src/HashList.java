import java.util.EmptyStackException;

public class HashList {
	
	private HashNode first;
	private HashNode current;
	private HashNode last;
	
	public HashList() {
		setFirst(null);
		setCurrent(null);
		setLast(null);
	}
	
	public void addNode(HashNode p) {
		if(isEmpty()) {
			first = last= p;
		}else {
			p.setNext(first);
			first = p;
		}
	}
	
	
	public void removeNode(HashNode p) {
		if(isEmpty()) throw new EmptyStackException();
		if(first== last) {
			first = last = null;
		}else {
			HashNode prev = null;
			HashNode curr = first;
			while(curr != p && curr.getNext()!= null) {
				prev = curr;
				curr= curr.getNext();
			}
			if(curr == p)
			prev.setNext(first.getNext());
			else System.out.println("Enter a valid Node to remove.");
		}
	}
	
	public Boolean isEmpty() {
		if(first==null && last ==null) {
			return true;
		}
		return false;
	}

	/**
	 * @return the last
	 */
	public HashNode getLast() {
		return last;
	}

	/**
	 * @param last the last to set
	 */
	public void setLast(HashNode last) {
		this.last = last;
	}

	/**
	 * @return the current
	 */
	public HashNode getCurrent() {
		return current;
	}

	/**
	 * @param current the current to set
	 */
	public void setCurrent(HashNode current) {
		this.current = current;
	}

	/**
	 * @return the first
	 */
	public HashNode getFirst() {
		return first;
	}

	/**
	 * @param first the first to set
	 */
	public void setFirst(HashNode first) {
		this.first = first;
	}
	
	


}
