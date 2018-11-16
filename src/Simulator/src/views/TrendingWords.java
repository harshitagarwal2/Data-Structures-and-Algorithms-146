package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import models.CrawlerModel;
import models.WebURLModel;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class TrendingWords extends JFrame {
	private static ArrayList<String> results;
	private JPanel contentPane;
	private JTextField textField;
	private JFrame myfrale;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrendingWords frame = new TrendingWords(results);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TrendingWords(ArrayList<String> list) {
		myfrale = this;
		results = list;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTrendingWords = new JLabel("Trending Words");
		lblTrendingWords.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblTrendingWords.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTrendingWords, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = textField.getText();
				CrawlerModel m = new CrawlerModel();
				try {
					m.getURLS(query);
					ArrayList<WebURLModel> urls= m.insertWebURIs();
					SearchResult view= new SearchResult(urls);
					view.setVisible(true);
					myfrale.setVisible(false);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		panel.add(btnSearch);
		
		DefaultListModel model = new DefaultListModel<>();
			for(int i=0 ; i<results.size(); i++) {
				model.addElement(results.get(i));
				}
			JList mylist = new JList();
		mylist.setModel(model);
		
		mylist.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				textField.setText(mylist.getSelectedValue().toString());
			}
		});
		contentPane.add(mylist, BorderLayout.CENTER);
	}

}
