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
public class Node2 {
	WebURLModel data;
	private Node2 parent;
	private Node2 left;
	private Node2 right;
	private String color;
	
	public Node2(String c) {
		WebURLModel model = new WebURLModel("NIL");
		data= model;
		color = c;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
	
	// constructor that takes a Process as an argument and sets it as Process data in the Node
	public Node2(WebURLModel p) {
		this.data = p;
		this.left = null;
		this.right = null;
		this.parent = null;
		}
	
	// getter for data Process
	public WebURLModel getData() {
		return data;
	}
	
	// getter for parent Process
	public Node2 getParent() {
		return parent;
	}

	// getter for left child Process
	public Node2 getLeft() {
		return left;
	}

	// getter for right child Process
	public Node2 getRight() {
		return right;
	}

	// setter for data Process
	public void setData(WebURLModel p) {
		this.data = p;
	}
	
	// setter for parent Process
	public void setParent(Node2 node) {
		this.parent = node;
	}

	// setter for left child Process
	public void setLeft(Node2 node) {
		this.left = node;
	}

	// setter for right child Process
	public void setRight(Node2 node) {
		this.right = node;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;

	}
	
	@Override
	public String toString() {
		return getData().getPriority() + " C:" + getColor().substring(0, 1);
	}
}