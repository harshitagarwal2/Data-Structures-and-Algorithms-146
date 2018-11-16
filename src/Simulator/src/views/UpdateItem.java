package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.WebURLModel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class UpdateItem extends JFrame {

	private JPanel contentPane;
	private JTextField txtFrequency;
	private JTextField txtAge;
	private JTextField txtUrl;
	private JTextField txtMoney;
	private JTextField txtLinks;
	private static ArrayList<WebURLModel> list;
	private static int index;
	private JFrame myframe;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateItem frame = new UpdateItem(list,index);
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
	public UpdateItem(ArrayList<WebURLModel> r, int index) {
		myframe = this;
		list = r;
		this.index = index;
		WebURLModel m = list.get(index);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblUpdateElement = new JLabel("Update Element");
		lblUpdateElement.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateElement.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblUpdateElement, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblUrl = new JLabel("URL:");
		
		JLabel lblAge = new JLabel("Age:");
		
		JLabel lblFreq = new JLabel("Freq:");
		
		txtFrequency = new JTextField();
		txtFrequency.setText(Integer.toString(m.getFrequency()));
		txtFrequency.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setText(Integer.toString(m.getAge()));
		txtAge.setColumns(10);
		
		txtUrl = new JTextField();
		txtUrl.setText(m.getURL());
		txtUrl.setColumns(10);
		
		JLabel lblMoney = new JLabel("Money:");
		
		txtMoney = new JTextField();
		txtMoney.setText(Double.toString(m.getMoney()));
		txtMoney.setColumns(10);
		
		JLabel lblLinks = new JLabel("Links:");
		
		txtLinks = new JTextField();
		txtLinks.setText(Integer.toString(m.getLinks()));
		txtLinks.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				m.setAge(Integer.parseInt(txtAge.getText()));
				m.setFrequency(Integer.parseInt(txtFrequency.getText()));
				m.setURL(txtUrl.getText());
				m.setMoney(Double.parseDouble(txtMoney.getText()));
				list.set(index, m);
				SearchResult view = new SearchResult(list);
				view.setVisible(true);
				myframe.setVisible(false);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblUrl)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtUrl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblAge)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtAge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFreq)
								.addComponent(lblMoney))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtMoney, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtFrequency, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblLinks)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtLinks, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnUpdate))
					.addContainerGap(288, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUrl)
						.addComponent(txtUrl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAge)
						.addComponent(txtAge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFreq)
						.addComponent(txtFrequency, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMoney)
						.addComponent(txtMoney, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblLinks)
						.addComponent(txtLinks, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
					.addComponent(btnUpdate)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
	}

}
