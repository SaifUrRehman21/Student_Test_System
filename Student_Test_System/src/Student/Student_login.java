package Student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import TestSystem.Admin_SignUp;
import TestSystem.Admin_login;
import TestSystem.Admin_panel;
import TestSystem.Select_Panel;

public class Student_login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblClickHere;
	private JLabel lblForgetPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_login frame = new Student_login();
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
	public Student_login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(140, 156, 273, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(140, 218, 273, 29);
		contentPane.add(passwordField);
		
		JButton btnCreateAccount = new JButton("");
		btnCreateAccount.setIcon(new ImageIcon(Select_Panel.class.getResource("/Images/CreateAccount_Button.jpg")));
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin_login a=new Admin_login();
				a.setVisible(false);
				
				Admin_SignUp b=new Admin_SignUp();
				b.setVisible(true);
			}
		});
		btnCreateAccount.setBounds(48, 360, 427, 70);
		contentPane.add(btnCreateAccount);
		
		JButton btnLogin = new JButton("");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				{
					String user=textField.getText();
					String pass=passwordField.getText();
					
					if (user.isEmpty() ||pass.isEmpty()) 
					{
						JOptionPane.showConfirmDialog(null, "Username & Password must not be empty.");
					}
					else
					{
						try
						{
							Class.forName("com.mysql.jdbc.Driver");
							String URL="jdbc:mysql://localhost/studenttestsystem";
							Connection con=DriverManager.getConnection(URL,"root","");
							Statement st=con.createStatement();
							
							PreparedStatement pst = con.prepareStatement("select * from Student_Signup where Username=? and Password=?");
							pst.setString(1, user);
				            pst.setString(2, pass);
				            ResultSet rs = pst.executeQuery();
				            if (rs.next()) 
				            {
				            	JOptionPane.showConfirmDialog(null, "Login Successfull");
				            	textField.setText("");
								passwordField.setText("");
								
								Student_login a=new Student_login();
								a.setVisible(false);
								
								Start_Test b=new Start_Test();
								b.setVisible(true);
				            } 
				            else 
				            {		            	
				            	JOptionPane.showConfirmDialog(null, "Login Unsuccessfull");
				                textField.setText("");
								passwordField.setText("");
				            }
						}
						catch(Exception e)
						{
							System.out.println(e);
						}
					}

				}
			}
		});
		btnLogin.setIcon(new ImageIcon(Select_Panel.class.getResource("/Images/Login_Button.jpg")));
		btnLogin.setBounds(48, 279, 427, 70);
		contentPane.add(btnLogin);
		
		lblClickHere = new JLabel("Click Here");
		lblClickHere.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showConfirmDialog(null, "Successfully! Remember your password and Try again");
			}
		});
		lblClickHere.setForeground(new Color(0, 0, 255));
		lblClickHere.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblClickHere.setBounds(282, 430, 93, 38);
		contentPane.add(lblClickHere);
		
		lblForgetPassword = new JLabel("Forget Password?");
		lblForgetPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblForgetPassword.setBounds(180, 430, 102, 38);
		contentPane.add(lblForgetPassword);
		
		JLabel label = new JLabel("");
		label.setBackground(Color.YELLOW);
		label.setIcon(new ImageIcon(Student_login.class.getResource("/Images/Student_login.jpg")));
		label.setBounds(0, 0, 514, 514);
		contentPane.add(label);
	}
}
