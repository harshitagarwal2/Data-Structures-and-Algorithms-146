package views;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import models.*;

import java.awt.FlowLayout;

public class OutputTreePanel2 extends JPanel {
	private static BSTModel2 tree;
    @Override
    public void paintComponent(Graphics g) {
    	 drawNode(g, getWidth()/2, tree.getRoot(), getWidth()/2, 0);

    }
    
    private void drawNode(Graphics g, int subtreeW, Node2 root, int x, int y) {
   	 Node2 left, right;
   	 if(!root.getData().getURL().equalsIgnoreCase("NIL")) g.drawString(root.toString(), x-10, y+10);
	 left = root.getLeft();
	 right = root.getRight();
	 if (left != null && !left.getData().getURL().equalsIgnoreCase("NIL"))
	    {
		 g.drawLine(x, y+10, x-subtreeW/2, y+50);
	      drawNode(g, subtreeW/2, left, x-subtreeW/2, y+50);
	    };
	 if (right != null && !right.getData().getURL().equalsIgnoreCase("NIL"))
	    { g.drawLine(x, y+10, x+subtreeW/2, y+50);
	      drawNode(g, subtreeW/2, right, x+subtreeW/2, y+50);
	    }
	 }

	public OutputTreePanel2(BSTModel2 btree) {
		tree = btree;
		
	}

	public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.add(new OutputTreePanel2(tree));
        jFrame.setSize(500, 500);
        jFrame.setVisible(true);
    }
   
}



