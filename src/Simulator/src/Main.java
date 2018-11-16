import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import models.CrawlerModel;
import models.QuickSortModel;
import models.TrendingKeywordsModel;
import models.WebURLModel;
import views.SearchResult;
import views.TrendingWords;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;
	private JTextField textField;
	private Main myframe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		myframe = this;
		frame = new JFrame();
		frame.setBounds(0, 0, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Crawl Searcher");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JLabel lblSearchAKeyword = new JLabel("Search a KeyWord:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				models.QuickSortModel ob = new QuickSortModel();
				String query = textField.getText();
				System.out.println(query);
				CrawlerModel my = new CrawlerModel();
				try {
					my.getURLS(query);
					ArrayList<WebURLModel> result = my.insertWebURIs();
					SearchResult search = new SearchResult(result);
							search.setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		});
		
		JLabel lblSearchForUrls = new JLabel("Search For URLS:");
		lblSearchForUrls.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		JLabel lblTrendingKeywords = new JLabel("Trending Keywords");
		lblTrendingKeywords.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		
		JButton btnSearchTrends = new JButton("Search Trends");
		btnSearchTrends.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrendingKeywordsModel model = new TrendingKeywordsModel();
				ArrayList<String> result = model.getTrends();
				TrendingWords view = new TrendingWords(result);
				view.setVisible(true);
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(155)
							.addComponent(lblSearchAKeyword)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
							.addGap(376)
							.addComponent(btnSearchTrends))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(228)
							.addComponent(btnSearch))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(232)
							.addComponent(lblSearchForUrls)
							.addGap(379)
							.addComponent(lblTrendingKeywords)))
					.addContainerGap(476, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(108)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSearchForUrls)
						.addComponent(lblTrendingKeywords))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(68)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSearchAKeyword)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(btnSearch))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(52)
							.addComponent(btnSearchTrends)))
					.addContainerGap(396, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
	}
}
