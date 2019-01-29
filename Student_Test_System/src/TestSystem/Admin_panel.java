package TestSystem;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Admin_panel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_panel frame = new Admin_panel();
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
	public Admin_panel() {
		setTitle("Admin Panel");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 722, 542);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnQuestions = new JMenu("Questions");
		menuBar.add(mnQuestions);
		
		JMenuItem mntmAddQuestion = new JMenuItem("Add Question");
		mntmAddQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Admin_panel a=new Admin_panel();
				a.setVisible(false);
				
				Add b=new Add();
				b.setVisible(true);
			}
		});
		mnQuestions.add(mntmAddQuestion);
		
		JMenuItem mntmDeleteQuestion = new JMenuItem("Delete Question");
		mntmDeleteQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin_panel a=new Admin_panel();
				a.setVisible(false);
				
				Delete b=new Delete();
				b.setVisible(true);
			}
		});
		mnQuestions.add(mntmDeleteQuestion);
		
		JMenuItem mntmUpdateQuestion = new JMenuItem("Update Question");
		mntmUpdateQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin_panel a=new Admin_panel();
				a.setVisible(false);
				
				Edit b=new Edit();
				b.setVisible(true);
			}
		});
		mnQuestions.add(mntmUpdateQuestion);
		
		JMenuItem mntmSearchQuestion = new JMenuItem("Search Question");
		mntmSearchQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin_panel a=new Admin_panel();
				a.setVisible(false);
				
				Search b=new Search();
				b.setVisible(true);
			}
		});
		mnQuestions.add(mntmSearchQuestion);
		
		JMenuItem mntmShowQuestions = new JMenuItem("Show Questions");
		mntmShowQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin_panel a=new Admin_panel();
				a.setVisible(false);
				
				Show_All b=new Show_All();
				b.setVisible(true);
			}
		});
		mnQuestions.add(mntmShowQuestions);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenu mnLogout = new JMenu("Logout");
		menuBar.add(mnLogout);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFdddddddg = new JLabel("Add  New  Question");
		lblFdddddddg.setForeground(Color.WHITE);
		lblFdddddddg.setBounds(46, 254, 114, 35);
		contentPane.add(lblFdddddddg);
		
		JButton btnAdd = new JButton("");
		btnAdd.setToolTipText("Add Question");
		btnAdd.setIcon(new ImageIcon(Select_Panel.class.getResource("/Images/Plus_icon.jpg")));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin_panel a=new Admin_panel();
				a.setVisible(false);
				
				Add b=new Add();
				b.setVisible(true);
			}
		});
		btnAdd.setBounds(46, 170, 120, 90);
		contentPane.add(btnAdd);
		
		JLabel lblDeleteQuestion = new JLabel("Delete Question");
		lblDeleteQuestion.setForeground(Color.WHITE);
		lblDeleteQuestion.setBounds(541, 254, 91, 35);
		contentPane.add(lblDeleteQuestion);
		
		JLabel lblUpdateQuestion = new JLabel("Update Question");
		lblUpdateQuestion.setForeground(Color.WHITE);
		lblUpdateQuestion.setBounds(304, 254, 98, 35);
		contentPane.add(lblUpdateQuestion);
		
		JLabel lblSearchQuestion = new JLabel("  Search Question");
		lblSearchQuestion.setForeground(Color.WHITE);
		lblSearchQuestion.setBounds(173, 369, 108, 49);
		contentPane.add(lblSearchQuestion);
		
		JLabel lblShowAllQuestion = new JLabel("  Show all Question");
		lblShowAllQuestion.setForeground(Color.WHITE);
		lblShowAllQuestion.setBounds(412, 369, 108, 49);
		contentPane.add(lblShowAllQuestion);
		
		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon(Select_Panel.class.getResource("/Images/Logo.png")));
		Logo.setBounds(95, 0, 511, 78);
		contentPane.add(Logo);
		
		JLabel lblNewLabel = new JLabel("Main Menu");
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 26));
		lblNewLabel.setBounds(270, 69, 160, 55);
		contentPane.add(lblNewLabel);
		
		JButton btnUpdate = new JButton("");
		btnUpdate.setIcon(new ImageIcon(Select_Panel.class.getResource("/Images/Update_icon.jpg")));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin_panel a=new Admin_panel();
				a.setVisible(false);
				
				Edit b=new Edit();
				b.setVisible(true);
			}
		});
		btnUpdate.setBounds(294, 170, 120, 90);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("");
		btnDelete.setIcon(new ImageIcon(Select_Panel.class.getResource("/Images/Delete_icon.jpg")));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin_panel a=new Admin_panel();
				a.setVisible(false);
				
				Delete b=new Delete();
				b.setVisible(true);
			}
		});
		btnDelete.setBounds(531, 170, 120, 90);
		contentPane.add(btnDelete);
		
		JButton btnShow = new JButton("");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin_panel a=new Admin_panel();
				a.setVisible(false);
				
				Show_All b=new Show_All();
				b.setVisible(true);
			}
		});
		btnShow.setIcon(new ImageIcon(Select_Panel.class.getResource("/Images/Show_icon.jpg")));
		btnShow.setBounds(412, 290, 120, 90);
		contentPane.add(btnShow);
		
		JButton btnSerach = new JButton("");
		btnSerach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin_panel a=new Admin_panel();
				a.setVisible(false);
				
				Search b=new Search();
				b.setVisible(true);
			}
		});
		btnSerach.setIcon(new ImageIcon(Select_Panel.class.getResource("/Images/Search_icon.jpg")));
		btnSerach.setBounds(173, 290, 120, 90);
		contentPane.add(btnSerach);
		
		JButton btnNewButton = new JButton("Log Out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin_panel a=new Admin_panel();
				a.setVisible(false);
				
				Admin_login b=new Admin_login();
				b.setVisible(true);
				
				dispose();
			}
		});
		btnNewButton.setBounds(574, 89, 132, 35);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Select_Panel.class.getResource("/Images/Admin_panel.jpg")));
		label.setBounds(0, 0, 716, 492);
		contentPane.add(label);
	}
}
