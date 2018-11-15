package models;

import java.util.ArrayList;

/*
 * BINARYSEARCHTREE CLASS
 * -------------
 * 
 * Node root: the root Node object of the binary tree. Other inserted Node objects will be children of the root
 * 
 * This class is used as an object to store a Process object and be part of a tree structure in a BinarySearchTree 
 */
public class BSTModel {
	Node root;
	ArrayList<WebURLModel> list;
	
	public BSTModel() {
		list = new ArrayList<>();
	} 
	// getter for Node root
	public Node getRoot() {
		return this.root;
	}
	
	// prints the entire binary tree structure from least to greatest following the order of left->node->right
	// @param Node node- the node from which the traversal starts, most typically the root
	public ArrayList<WebURLModel> inOrderTreeWalk(Node node) {
		// checks if root's data exists
		if (node != null) { 
			
			// recursively call left child
			inOrderTreeWalk(node.getLeft()); 
			
			System.out.println(node.getData().toString());
			list.add(node.data);
			// recursively call right child
			inOrderTreeWalk(node.getRight());
		}
		return list;
	}
	
	// searches for a given Node x with given integer k, and returns it
	// @param Node x- the Node the search begins from, typically the root of the binary tree
	// @param int k- the priority key we want to search for in a Node's Process
	public Node treeSearch(Node x, Double x2) {
		while (x != null && x2 != x.data.getPriority()) {
			if (x2 < x.data.getPriority())
				x = x.getLeft();
			else 
				x = x.getRight();
		}
		
		return x;
	}

	// returns the Node with the smallest priority key, which is the farthest left leaf
	// @param Node x- the node we begin traversing left from, typically the root of the binary tree
	public Node treeMinimum(Node x) {
		while (x.getLeft() != null)
			x = x.getLeft();
		return x;
	}
	
	// returns the Node with the largest priority key, which is the farthest right leaf
	// @param Node x- the node we begin traversing right from, typically the root of the binary tree
	public Node treeMaximum(Node x) {
		while (x.getRight() != null)
			x = x.getRight();
		return x;
	}
	
	// returns the successor- the node with the smallest key greater than Node x's key
	// @param Node x- the Node we are finding the next smallest key
	public Node treeSuccessor(Node x) {
		if (x.getRight() != null)
			return this.treeMinimum(x.getRight());
		
		Node y = new Node();
		y = x.getParent();
		
		while (y != null && x.data.getPriority() == y.getRight().data.getPriority()) {
			x = y;
			y = y.getParent();
		}
		
		return y;
	}
	
	// inserts a Node into the binary tree. Finds the correct placement by comparing priority keys and determining if it belongs to the left or right of a given node
	// @param Node z- the Node object we are inserting into the binary tree
	public void treeInsert(Node z) {
		Node y = null;
		Node x = this.root;
		
		while (x != null) {
			y = x;
			if (z.data.getPriority() < x.data.getPriority())
				x = x.getLeft();
			else 
				x = x.getRight();
		}
		
		z.setParent(y);
		
		if (y == null) 
			this.root = z;
		else if (z.data.getPriority() < y.data.getPriority()) 
			y.setLeft(z);
		else
			y.setRight(z);
	}
	
	// replaces subtree of Node u as a child of its parent with Node v
	// @param Node u- a Node being replaced
	// @param Node v- a Node replacing Node u
	public void transplant(Node u, Node v) {
		if (u.getParent() == null)
			this.root = v;
		else if (u == (u.getParent().getLeft())) 
			u.getParent().setLeft(v);
		else
			u.getParent().setRight(v);
		
		if (v != null) 
			v.setParent(u.getParent());
			
	}
	
	// removes given Node z from a the binary search tree. 
	// if Node z has no left child, then Node z is replaced by its right child
	// if Node z has no right child, then Node z is replaced by its left child
	// if Node z has both left and right children, we find the minimum in the right subtree and replace Node z with it
	// @param Node z- a Node inside of the binary search tree that will be deleted
	public void treeDelete(Double x) {
		Node z =  treeSearch( getRoot(), x);
		Node y = null;
		if (z.getLeft() == null)
			transplant(z,z.getRight());
		else if (z.getRight() == null) 
			transplant(z, z.getLeft());
		else {
			y = treeMinimum(z.getRight());
			
			if (y.getParent() != z) {
				transplant(y, y.getRight());
				y.setRight(z.getRight());
				y.getRight().setParent(y);
			}
			transplant(z, y);
			y.setLeft(z.getLeft());
			y.getLeft().setParent(y);
		}
	}
	
	public void InsertList(ArrayList<WebURLModel> list) {
		for(int i=0; i< list.size() ; i++) {
			treeInsert(new Node(list.get(i)));
		}
	}
}
