package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import models.BucketSortModel;
import models.QuickSortModel;
import models.WebURLModel;

import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JSplitPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionEvent;

public class SearchResult extends JFrame {

	    // these are the components we need.
	    private final JSplitPane splitPane;  // split the window in top and bottom
	    private final JPanel topPanel;       // container panel for the top
	    private final JPanel bottomPanel;    // container panel for the bottom
	    private final JScrollPane scrollPane; // makes the text scrollable
	    private static ArrayList<WebURLModel> results;
	    private JButton btnQuicksort;
	    private JButton btnSearchTree;
	    private JFrame myframe;
	    private int index;
	    private JButton btnUpdateItem;
	    private JButton btnBucketsort;
	
	    public SearchResult(ArrayList<WebURLModel> myList){
	    	myframe=  this;
	    	
	    	results= myList;

	        // first, lets create the containers:
	        // the splitPane devides the window in two components (here: top and bottom)
	        // users can then move the devider and decide how much of the top component
	        // and how much of the bottom component they want to see.
	        splitPane = new JSplitPane();

	        topPanel = new JPanel();         // our top component
	        bottomPanel = new JPanel();      // our bottom component

	        // in our bottom panel we want the text area and the input components
	        scrollPane = new JScrollPane();  // this scrollPane is used to make the text area scrollable

	        // now lets define the default size of our window and its layout:
	        setPreferredSize(new Dimension(1280, 720));     // let's open the window with a default size of 400x400 pixels
	        // the contentPane is the container that holds all our components
	        getContentPane().setLayout(new GridLayout());  // the default GridLayout is like a grid with 1 column and 1 row,
	        // we only add one element to the window itself
	        getContentPane().add(splitPane);
	        splitPane.setDividerLocation(200);                    // the initial position of the divider is 200 (our window is 400 pixels high)
	        splitPane.setTopComponent(topPanel);                  // at the top we want our "topPanel"
	        
	        JLabel lblOperations = new JLabel("Operations:");
	        
	        btnQuicksort = new JButton("QuickSort");
	        btnQuicksort.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		QuickSortModel model = new QuickSortModel();
	        		model.sort(results, 0, results.size()-1);
	        		SearchResult nResult = new SearchResult(results);
	        		nResult.setVisible(true);
	        		myframe.setVisible(false);
	        	}
	        });
	        
	        btnSearchTree = new JButton("Search Tree");
	        btnSearchTree.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		TreeGUIPanel panel = new TreeGUIPanel(results);
	        		panel.setVisible(true);
	        		myframe.setVisible(false);
	        	}
	        });
	        
	        btnUpdateItem = new JButton("Update Item");
	        btnUpdateItem.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		UpdateItem i = new UpdateItem(results, index );
					i.setVisible(true);
					myframe.setVisible(false);
	        	}
	        });
	        
	        btnBucketsort = new JButton("BucketSort");
	        btnBucketsort.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		BucketSortModel model = new BucketSortModel();
	        		model.sort(results);
	        		SearchResult view = new SearchResult(results);
	        		view.setVisible(true);
	        		myframe.setVisible(false);
	        	}
	        });
	        
	        JButton btnRedBlackTree = new JButton("Red Black Tree");
	        btnRedBlackTree.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		TreeGUIPanel2 panel = new TreeGUIPanel2(results);
	        		panel.setVisible(true);
	        		myframe.setVisible(false);
	        	}
	        });
	        GroupLayout gl_topPanel = new GroupLayout(topPanel);
	        gl_topPanel.setHorizontalGroup(
	        	gl_topPanel.createParallelGroup(Alignment.LEADING)
	        		.addGroup(gl_topPanel.createSequentialGroup()
	        			.addGroup(gl_topPanel.createParallelGroup(Alignment.LEADING)
	        				.addGroup(gl_topPanel.createSequentialGroup()
	        					.addGap(72)
	        					.addComponent(lblOperations))
	        				.addGroup(gl_topPanel.createSequentialGroup()
	        					.addGap(54)
	        					.addGroup(gl_topPanel.createParallelGroup(Alignment.LEADING)
	        						.addComponent(btnSearchTree)
	        						.addComponent(btnQuicksort)
	        						.addComponent(btnUpdateItem)
	        						.addComponent(btnBucketsort)
	        						.addComponent(btnRedBlackTree))))
	        			.addContainerGap(42, Short.MAX_VALUE))
	        );
	        gl_topPanel.setVerticalGroup(
	        	gl_topPanel.createParallelGroup(Alignment.LEADING)
	        		.addGroup(gl_topPanel.createSequentialGroup()
	        			.addContainerGap()
	        			.addComponent(lblOperations)
	        			.addGap(35)
	        			.addComponent(btnQuicksort)
	        			.addGap(18)
	        			.addComponent(btnSearchTree)
	        			.addGap(18)
	        			.addComponent(btnUpdateItem)
	        			.addGap(27)
	        			.addComponent(btnBucketsort)
	        			.addGap(26)
	        			.addComponent(btnRedBlackTree)
	        			.addContainerGap(393, Short.MAX_VALUE))
	        );
	        topPanel.setLayout(gl_topPanel);
	        splitPane.setBottomComponent(bottomPanel);            // and at the bottom we want our "bottomPanel"

	        // our topPanel doesn't need anymore for this example. Whatever you want it to contain, you can add it here
	        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS)); // BoxLayout.Y_AXIS will arrange the content vertically

	        bottomPanel.add(scrollPane);                // first we add the scrollPane to the bottomPanel, so it is at the top
	        
	        JLabel lblNewLabel = new JLabel("Search Results:");
	        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
	        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        scrollPane.setColumnHeaderView(lblNewLabel);
	        
	        JList list = new JList();
	        DefaultListModel mode= new DefaultListModel<>();
	        for(int i =0 ; i<results.size(); i++) {
	        	mode.addElement(results.get(i));
	        }
	        scrollPane.setViewportView(list);
	        list.setModel(mode);
	        
	        list.addListSelectionListener(new ListSelectionListener() {
				
				@Override
				public void valueChanged(ListSelectionEvent e) {
					index = list.getSelectedIndex();
			}
			});
	        

	        // let's set the maximum size of the inputPanel, so it doesn't get too big when the user resizes the window
	  
	        pack();   // calling pack() at the end, will ensure that every layout and size we just defined gets applied before the stuff becomes visible
	    }

	    public static void main(String args[]){
	        EventQueue.invokeLater(new Runnable(){
	            @Override
	            public void run(){
	                new SearchResult(results).setVisible(true);
	            }
	        });
	    }
	}
