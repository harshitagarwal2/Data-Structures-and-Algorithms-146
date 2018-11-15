package models;

/*
 * NODE CLASS
 * -------------
 * 
 * Process data: the data stored in the node, which is a Process object
 * Node parent: a Node object which is the parent of the current node in a binary tree structure
 * Node left: a Node object which is the left child of the current node in a binary tree structure
 * Node right: a Node object which is the right child of the current node in a binary tree structure
 * 
 * This class is used as an object to store a Process object and be part of a tree structure in a BinarySearchTree 
 */
public class Node {
	WebURLModel data;
	private Node parent;
	private Node left;
	private Node right;

	// default constructor
	// creates a randomized Process to store as the Node's data
	public Node() {
	}
	
	// constructor that takes a Process as an argument and sets it as Process data in the Node
	public Node(WebURLModel p) {
		this.data = p;
	}
	
	// getter for data Process
	public WebURLModel getData() {
		return data;
	}
	
	// getter for parent Process
	public Node getParent() {
		return parent;
	}

	// getter for left child Process
	public Node getLeft() {
		return left;
	}

	// getter for right child Process
	public Node getRight() {
		return right;
	}

	// setter for data Process
	public void setData(WebURLModel p) {
		this.data = p;
	}
	
	// setter for parent Process
	public void setParent(Node node) {
		this.parent = node;
	}

	// setter for left child Process
	public void setLeft(Node node) {
		this.left = node;
	}

	// setter for right child Process
	public void setRight(Node node) {
		this.right = node;
	}
}
