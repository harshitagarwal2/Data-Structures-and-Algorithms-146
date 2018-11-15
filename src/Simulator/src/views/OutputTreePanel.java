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

public class OutputTreePanel extends JPanel {
	private static BSTModel tree;
    @Override
    public void paintComponent(Graphics g) {
    	 drawNode(g, getWidth()/2, tree.getRoot(), getWidth()/2, 0);

    }
    
    public OutputTreePanel(BSTModel btree) {
		tree = btree;
		
	}

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.add(new OutputTreePanel(tree));
        jFrame.setSize(500, 500);
        jFrame.setVisible(true);
    }
    
	private void drawNode(Graphics g, int subtreeW, Node tree, int x, int y) {
		 Node left, right;
		 g.drawString(tree.getData().toString(), x-10, y+10);
		 left = tree.getLeft();
		 right = tree.getRight();
		 if (left != null)
		    { g.drawLine(x, y+10, x-subtreeW/2, y+50);
		      drawNode(g, subtreeW/2, left, x-subtreeW/2, y+50);
		    };
		 if (right != null)
		    { g.drawLine(x, y+10, x+subtreeW/2, y+50);
		      drawNode(g, subtreeW/2, right, x+subtreeW/2, y+50);
		    }
	}

}



