package views;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import models.BSTModel;
import models.WebURLModel;

public class TreeGUIPanel extends javax.swing.JFrame{
	private static ArrayList<WebURLModel> results;
	

    // these are the components we need.
    private final JSplitPane splitPane;  // split the window in top and bottom
    private final JPanel topPanel;       // container panel for the top
    private final JPanel bottomPanel;    // container panel for the bottom

    public TreeGUIPanel(ArrayList<WebURLModel> list){
    	results = list;
         splitPane = new JSplitPane();

        topPanel = new JPanel();         // our top component
        bottomPanel = new JPanel();
        BSTModel model = new BSTModel();
        model.InsertList(results);
        
        OutputTreePanel panel = new OutputTreePanel(model);
        setPreferredSize(new Dimension(1280, 720));     // let's open the window with a default size of 400x400 pixels
        getContentPane().setLayout(new GridLayout());  // the default GridLayout is like a grid with 1 column and 1 row,
        getContentPane().add(splitPane);
        splitPane.setDividerLocation(200);                    // the initial position of the divider is 200 (our window is 400 pixels high)
        splitPane.setTopComponent(topPanel);                  // at the top we want our "topPanel"
        splitPane.setBottomComponent(panel);            // and at the bottom we want our "bottomPanel"
        
  
        
        

        pack();  
     }

    public static void main(String args[]){
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                new TreeGUIPanel(results).setVisible(true);
            }
        });
    }
}