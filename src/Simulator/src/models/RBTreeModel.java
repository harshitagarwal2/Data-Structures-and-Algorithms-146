package models;

import java.util.ArrayList;

/*
 * BINARYSEARCHTREE CLASS
 * -------------
 * 
 * Node2 root: the root Node2 object of the binary tree. Other inserted Node2 objects will be children of the root
 * 
 * This class is used as an object to store a Process object and be part of a tree structure in a BinarySearchTree 
 */
public class RBTreeModel {
	Node2 root;
	Node2 nilNode = new Node2("BLACK");
	ArrayList<WebURLModel> list;
	
	public RBTreeModel() {
		list = new ArrayList<>();
		root = nilNode;
		root.setLeft(nilNode);
		root.setRight(nilNode);
		root.setParent(nilNode);
	} 
	// getter for Node2 root
	public Node2 getRoot() {
		return this.root;
	}
	
	// prints the entire binary tree structure from least to greatest following the order of left->Node2->right
	// @param Node2 Node2- the Node2 from which the traversal starts, most typically the root
	public ArrayList<WebURLModel> inOrderTreeWalk(Node2 Node2) {
		// checks if root's data exists
		if (Node2 != nilNode) { 
			
			// recursively call left child
			inOrderTreeWalk(Node2.getLeft()); 
			
			System.out.println(Node2.getData().toString());
			list.add(Node2.data);
			// recursively call right child
			inOrderTreeWalk(Node2.getRight());
		}
		return list;
	}
	
	// searches for a given Node2 x with given integer k, and returns it
	// @param Node2 x- the Node2 the search begins from, typically the root of the binary tree
	// @param int k- the priority key we want to search for in a Node2's Process
	public Node2 treeSearch(Node2 x, Double x2) {
		while (x != nilNode && x2 != x.data.getPriority()) {
			if (x2 < x.data.getPriority())
				x = x.getLeft();
			else 
				x = x.getRight();
		}
		
		return x;
	}

	// returns the Node2 with the smallest priority key, which is the farthest left leaf
	// @param Node2 x- the Node2 we begin traversing left from, typically the root of the binary tree
	public Node2 treeMinimum(Node2 x) {
		while (x.getLeft() != nilNode)
			x = x.getLeft();
		return x;
	}
	
	// returns the Node2 with the largest priority key, which is the farthest right leaf
	// @param Node2 x- the Node2 we begin traversing right from, typically the root of the binary tree
	public Node2 treeMaximum(Node2 x) {
		while (x.getRight() != nilNode)
			x = x.getRight();
		return x;
	}
	
	// returns the successor- the Node2 with the smallest key greater than Node2 x's key
	// @param Node2 x- the Node2 we are finding the next smallest key
	public Node2 treeSuccessor(Node2 x) {
		if (x.getRight() != nilNode)
			return this.treeMinimum(x.getRight());
		
		Node2 y = x.getParent();
		
		while (y != nilNode && x.data.getPriority() == y.getRight().data.getPriority()) {
			x = y;
			y = y.getParent();
		}
		
		return y;
	}
	

	// inserts a Node into the red black tree. Finds the correct placement by comparing priority keys and determining if it belongs to the left or right of a given node. the insertion then uses rbInsertFixup to make appropriate rotations and recolors
	// @param Node z- the Node object we are inserting into the red black tree
	public void rbInsert(Node2 z) {
		Node2 y=  nilNode;
		
		Node2 x = root;
		
		while (x != nilNode) {
			y = x;
			if (z.getData().getPriority() < x.getData().getPriority()) {
				x = x.getLeft();
			}
			else 
				x = x.getRight();
		}
		
		z.setParent(y);
		
		if (y == nilNode) {
			root = z;
		}
		else if (z.getData().getPriority() < y.getData().getPriority()) {
			y.setLeft(z);
		}
		else 
			y.setRight(z);
		
		z.setLeft(nilNode);
		z.setRight(nilNode);
		z.setColor("RED");
		rbInsertFixup(z);
	}
	
	// performed at the end of rbInsert to perform appropriate rotations and recoloring. 
	// @param Node z: the node which was inserted into the red black tree and causing a potential need for restructuring of the red black tree.
	public void rbInsertFixup(Node2 z) {
		Node2 y;
		
		while (z.getParent() != nilNode && z.getParent().getColor() == "RED") {
			if (z.getParent() == z.getParent().getParent().getLeft()) {
				y = z.getParent().getParent().getRight();
				
				if (y != nilNode && y.getColor() == "RED") {
					z.getParent().setColor("BLACK");
					y.setColor("BLACK");
					z.getParent().getParent().setColor("RED");
					z = z.getParent().getParent();
				}
				else {
					if (z == z.getParent().getRight()) {
					z = z.getParent();
					leftRotate(z);
					}
					z.getParent().setColor("BLACK");
					z.getParent().getParent().setColor("RED");
					rightRotate(z.getParent().getParent());
				}
			}
			else {
				y = z.getParent().getParent().getLeft();
				
				if (y != nilNode && y.getColor() == "RED") {
					z.getParent().setColor("BLACK");
					y.setColor("BLACK");
					z.getParent().getParent().setColor("RED");
					z = z.getParent().getParent();
				}
				else {if (z == z.getParent().getLeft()) {
					z = z.getParent();
					rightRotate(z);
					}
					z.getParent().setColor("BLACK");
					z.getParent().getParent().setColor("RED");
					leftRotate(z.getParent().getParent());
				}
			}
		}
		root.setColor("BLACK");
	}
	
	// replaces subtree of Node u as a child of its parent with Node v
	// @param Node u- a Node being replaced
	// @param Node v- a Node replacing Node u
	public void rbTransplant(Node2 u, Node2 v) {
		if (u.getParent() == nilNode) {
			root = v;
		}
		else if (u == u.getParent().getLeft()) {
			u.getParent().setLeft(v);
		}
		else 
			u.getParent().setRight(v);
		
		v.setParent(u.getParent());
	}
	
	// removes given Node z from a the red black tree. 
	// if Node z has no left child, then Node z is replaced by its right child
	// if Node z has no right child, then Node z is replaced by its left child
	// if Node z has both left and right children, we find the minimum in the right subtree and replace Node z with it
	// @param Node z- a Node inside of the red black tree that will be deleted
	public void rbTreeDelete(double d) {
		Node2 z = treeSearch(root, d);
		Node2 y;
		Node2 x ;
		
		y = z;
		String yOriginalColor = y.getColor();
		
		if (z.getLeft() == nilNode) {
			x = z.getRight();
			rbTransplant(z, z.getRight());
		}
		else if (z.getRight() == nilNode) {
			x = z.getLeft();
			rbTransplant(z, z.getLeft());
		}
		else {
			y = treeMinimum(z.getRight());
			yOriginalColor = y.getColor();
			x = y.getRight();
			
			if (y.getParent() == z) {
				x.setParent(y);
			}
			else {
				rbTransplant(y, y.getRight());
				y.setRight(z.getRight());
				y.getRight().setParent(y);
			}
			
			rbTransplant(z, y);
			y.setLeft(z.getLeft());
			y.getLeft().setParent(y);
			y.setColor(z.getColor());
		}
		
		if (yOriginalColor == "BLACK")
			rbDeleteFixup(x);
	}
	
	// performed at the end of rbDelete to perform appropriate rotations and recoloring. 
	// @param Node x: the node which is used as a reference point for restructuring and recoloring the tree after deletion of a node
	public void rbDeleteFixup(Node2 x) {
		Node2 w;
		
	    while(x != root & x.getColor() == "BLACK"){

            if(x == x.getParent().getLeft()){
                w = x.getParent().getRight();

                // Case 1: W's getColor() is "RED"
                if(w.getColor() == "RED"){
                    w.setColor("BLACK");
                    x.getParent().setColor("RED");
                    leftRotate(x.getParent());
                    w = x.getParent().getRight();
                }

                // Case 2: Both W's children are "BLACK"
                if(w.getLeft().getColor() == "BLACK" & w.getRight().getColor() == "BLACK"){
                    w.setColor("RED");
                    x = x.getParent();
                }

                // Case 3:
                else if(w.getRight().getColor() == "BLACK"){
                    w.getLeft().setColor("BLACK");
                    w.setColor("RED");
                    rightRotate(w);
                    w = x.getParent().getRight();
                }

                // Case 4
                else{
                    w.setColor(x.getParent().getColor());
                    x.getParent().setColor("BLACK");
                    w.getRight().setColor("BLACK");
                    leftRotate(x.getParent());
                    x = root;
                }
            }

            else {
                w = x.getParent().getLeft();

                // Case 1: W's getColor() is "RED"
                if(w.getColor() == "RED"){
                    w.setColor("BLACK");
                    x.getParent().setColor("RED");
                    rightRotate(x.getParent());
                    w = x.getParent().getLeft();
                }

                // Case 2: Both W's children are "BLACK"
                if(w.getRight().getColor() == "BLACK" & w.getLeft().getColor() == "BLACK"){
                    w.setColor("RED");
                    x = x.getParent();
                }

                // Case 3: W's left child
                else if(w.getLeft().getColor() == "BLACK"){
                    w.getRight().setColor("BLACK");
                    w.setColor("RED");
                    leftRotate(w);
                    w = x.getParent().getLeft();
                }

                // Case 4: W is "BLACK" and W.left is "RED"
                else{
                    w.setColor(x.getParent().getColor());
                    x.getParent().setColor("BLACK");
                    w.getLeft().setColor("BLACK");
                    rightRotate(x.getParent());
                    x = root;
                }

            }
        } // end of while loogetParent()
        x.setColor("BLACK");
    }
	
	// causes a left rotation of nodes so that the red black tree can maintain its balanced structure
	public void leftRotate(Node2 x) {
		Node2 y;
		
		y = x.getRight();
		x.setRight(y.getLeft());
		
		if (y.getLeft() != nilNode) {
			y.getLeft().setParent(x);
		}
		
		y.setParent(x.getParent());
		
		if (x.getParent() == nilNode) {
			root = y;
		}
		else if (x == x.getParent().getLeft()) {
			x.getParent().setLeft(y);
		}
		else
			x.getParent().setRight(y);
		
		y.setLeft(x);
		x.setParent(y);
	}
	
	// causes a right rotation of nodes so that the red black tree can maintain its balanced structure
	public void rightRotate(Node2 x) {
		Node2 y ;
		
		y = x.getLeft();
		x.setLeft(y.getRight());
		
		if (y.getRight() != nilNode) {
			y.getRight().setParent(x);
		}
		
		y.setParent(x.getParent());
		
		if (x.getParent() == nilNode) {
			root = y;
		}
		else if (x == x.getParent().getRight()) {
			x.getParent().setRight(y);
		}
		else
			x.getParent().setLeft(y);
		
		y.setRight(x);
		x.setParent(y);
	}
	
	public void InsertList(ArrayList<WebURLModel> list) {

		for(int i=1; i< 2 ; i++) {
			rbInsert(new Node2(list.get(i)));
		}
	}
}