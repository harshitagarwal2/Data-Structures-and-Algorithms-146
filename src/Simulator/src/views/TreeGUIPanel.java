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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.awt.event.ActionEvent;

public class TreeGUIPanel extends javax.swing.JFrame{
	private static ArrayList<WebURLModel> results;
	private static BSTModel tree;
	private JFrame myframe;
	
	private final JSplitPane splitPane;  // split the window in top and bottom
    private final JPanel topPanel;       // container panel for the top
    private final JPanel bottomPanel;    // container panel for the bottom
    private JTextField txtPriority;
    private JTextField txtInserUrl;
    private JTextField txtInsertAge;
    private JTextField txtInsertFrequency;
    private JTextField txtEnterPriority;

    public TreeGUIPanel(ArrayList<WebURLModel> list){
    	myframe = this;
    	results = list;
         splitPane = new JSplitPane();

        topPanel = new JPanel();         // our top component
        bottomPanel = new JPanel();
        BSTModel model = new BSTModel();
        model.InsertList(results);
        tree = model;
        
        OutputTreePanel panel = new OutputTreePanel(model);
        setPreferredSize(new Dimension(1280, 720));     // let's open the window with a default size of 400x400 pixels
        getContentPane().setLayout(new GridLayout());  // the default GridLayout is like a grid with 1 column and 1 row,
        getContentPane().add(splitPane);
        splitPane.setDividerLocation(200);                    // the initial position of the divider is 200 (our window is 400 pixels high)
        splitPane.setTopComponent(topPanel);                  // at the top we want our "topPanel"
        
        JLabel lblOperations = new JLabel("Operations");
        
        JLabel lblSearch = new JLabel("Search:");
        
        txtPriority = new JTextField();
        txtPriority.setText("Priority");
        txtPriority.setColumns(10);
        
        JButton btnSearch = new JButton("Search");
        
        JLabel lblAdd = new JLabel("Add:");
        
        txtInserUrl = new JTextField();
        txtInserUrl.setText("Inser Url:");
        txtInserUrl.setColumns(10);
        
        txtInsertAge = new JTextField();
        txtInsertAge.setText("Insert Age");
        txtInsertAge.setColumns(10);
        
        txtInsertFrequency = new JTextField();
        txtInsertFrequency.setText("Insert Frequency:");
        txtInsertFrequency.setColumns(10);
        
        JButton btnAdd = new JButton("Add");
        
        JLabel lblDelete = new JLabel("Delete:");
        
        txtEnterPriority = new JTextField();
        txtEnterPriority.setText("Enter Priority ");
        txtEnterPriority.setColumns(10);
        
        JButton btnDelete = new JButton("Delete");
        
        JLabel lblSort = new JLabel("Sort");
        
        JButton btnSort = new JButton("Sort");
        btnSort.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		ArrayList<WebURLModel> resu = tree.inOrderTreeWalk(tree.getRoot());
        		SearchResult on = new SearchResult(resu);
        		on.setVisible(true);
        		myframe.setVisible(false);
        		
        	}
        });
        GroupLayout gl_topPanel = new GroupLayout(topPanel);
        gl_topPanel.setHorizontalGroup(
        	gl_topPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, gl_topPanel.createSequentialGroup()
        			.addContainerGap(78, Short.MAX_VALUE)
        			.addComponent(lblOperations)
        			.addGap(75))
        		.addGroup(gl_topPanel.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_topPanel.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_topPanel.createSequentialGroup()
        					.addGroup(gl_topPanel.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblSearch)
        						.addComponent(lblAdd))
        					.addGap(18)
        					.addGroup(gl_topPanel.createParallelGroup(Alignment.LEADING)
        						.addComponent(btnAdd)
        						.addComponent(txtInsertAge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(txtInserUrl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(btnSearch)
        						.addComponent(txtPriority, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(txtInsertFrequency, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(gl_topPanel.createSequentialGroup()
        					.addGroup(gl_topPanel.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblDelete)
        						.addComponent(lblSort))
        					.addGap(18)
        					.addGroup(gl_topPanel.createParallelGroup(Alignment.LEADING)
        						.addComponent(btnSort)
        						.addComponent(btnDelete)
        						.addComponent(txtEnterPriority, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
        			.addContainerGap(47, Short.MAX_VALUE))
        );
        gl_topPanel.setVerticalGroup(
        	gl_topPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_topPanel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblOperations)
        			.addGap(38)
        			.addGroup(gl_topPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblSearch)
        				.addComponent(txtPriority, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(btnSearch)
        			.addGap(18)
        			.addGroup(gl_topPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblAdd)
        				.addComponent(txtInserUrl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(txtInsertAge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(txtInsertFrequency, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnAdd)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_topPanel.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblDelete)
        				.addComponent(txtEnterPriority, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(btnDelete)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(gl_topPanel.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblSort)
        				.addComponent(btnSort))
        			.addContainerGap(339, Short.MAX_VALUE))
        );
        topPanel.setLayout(gl_topPanel);
        splitPane.setBottomComponent(panel);         
        
  
        
        

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