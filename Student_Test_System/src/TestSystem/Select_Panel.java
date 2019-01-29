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
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Select_Panel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Select_Panel frame = new Select_Panel();
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
	public Select_Panel() {
		setTitle("Select Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdminPanel = new JButton("");
		btnAdminPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Select_Panel a=new Select_Panel();
				a.setVisible(false);
				
				Admin_login b=new Admin_login();
				b.setVisible(true);
			}
		});
		
		JLabel label = new JLabel("");
		label.setBounds(98, 11, 533, 76);
		label.setIcon(new ImageIcon(Select_Panel.class.getResource("/Images/Logo.png")));
		contentPane.add(label);
		
		btnAdminPanel.setToolTipText("Admin Panel");
		btnAdminPanel.setBackground(Color.WHITE);
		btnAdminPanel.setIcon(new ImageIcon(Select_Panel.class.getResource("/Images/Admin_icon.jpg")));
		btnAdminPanel.setBounds(71, 166, 195, 191);
		contentPane.add(btnAdminPanel);
		
		JButton btnUserPanel = new JButton("");
		btnUserPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Select_Panel a=new Select_Panel();
				a.setVisible(false);
				
				Student.Student_login b=new Student.Student_login();
				b.setVisible(true);
				dispose();
			}
		});
		btnUserPanel.setToolTipText("Student Panel");
		btnUserPanel.setIcon(new ImageIcon(Select_Panel.class.getResource("/Images/Student_icon.jpg")));
		btnUserPanel.setBounds(374, 166, 195, 191);
		contentPane.add(btnUserPanel);
		
		JLabel lblAdminPanel = new JLabel("Admin Panel");
		lblAdminPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminPanel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdminPanel.setForeground(Color.WHITE);
		lblAdminPanel.setBounds(81, 374, 195, 27);
		contentPane.add(lblAdminPanel);
		
		JLabel lblStudentPanel = new JLabel("Student Panel");
		lblStudentPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentPanel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStudentPanel.setForeground(Color.WHITE);
		lblStudentPanel.setBounds(374, 374, 195, 27);
		contentPane.add(lblStudentPanel);
		
		JLabel lblSelectPanel = new JLabel("");
		lblSelectPanel.setIcon(new ImageIcon(Select_Panel.class.getResource("/Images/Select_panel.jpg")));
		lblSelectPanel.setBounds(0, 0, 697, 477);
		contentPane.add(lblSelectPanel);
	}
}
