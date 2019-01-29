package Student;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import TestSystem.Admin_SignUp;

public class Student_SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_SignUp frame = new Student_SignUp();
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
	public Student_SignUp() {
		setTitle("Student SignUp");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 622, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(217, 334, 250, 36);
		contentPane.add(passwordField_1);
		
		JLabel lblCreateAccount = new JLabel("Create Account");
		lblCreateAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAccount.setBounds(0, 0, 616, 96);
		lblCreateAccount.setFont(new Font("Sitka Display", Font.PLAIN, 36));
		getContentPane().add(lblCreateAccount);
		
		JLabel lblUserName = new JLabel("Full Name:");
		lblUserName.setBounds(132, 146, 82, 36);
		lblUserName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserName.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		getContentPane().add(lblUserName);
		
		JLabel lblLastName = new JLabel("Username:");
		lblLastName.setBounds(93, 193, 121, 36);
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		getContentPane().add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(170, 240, 44, 36);
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Enter Password:");
		lblPassword.setBounds(93, 287, 121, 36);
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		getContentPane().add(lblPassword);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(152, 381, 62, 29);
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGender.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		getContentPane().add(lblGender);
		
		textField = new JTextField();
		textField.setBounds(217, 146, 250, 36);
		textField.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(217, 193, 250, 36);
		textField_1.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		textField_1.setColumns(10);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(217, 240, 250, 36);
		textField_2.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		textField_2.setColumns(10);
		getContentPane().add(textField_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(217, 287, 250, 36);
		passwordField.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		getContentPane().add(passwordField);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(217, 383, 250, 20);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		getContentPane().add(comboBox);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(378, 478, 89, 50);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Login.main(null);		        
		        }
		});
		btnCancel.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		getContentPane().add(btnCancel);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(152, 478, 82, 50);
		btnCreate.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fullname=textField.getText();
				String username=textField_1.getText().trim();
				String email=textField_2.getText();
				String password=passwordField.getText();
				String cpassword=passwordField_1.getText();
				String gender=comboBox.getSelectedItem().toString();
				//String gender=comboBox
				
				
				//Connection
				if(password.equals(cpassword))
				{
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						String URL="jdbc:mysql://localhost/studenttestsystem";
						Connection con=DriverManager.getConnection(URL,"root","");
						Statement st=con.createStatement();
						
						st.executeUpdate("INSERT INTO student_signup(Name,Username,Email,Password,Gender) Values('"+fullname+"','"+username+"','"+email+"','"+password+"','"+gender+"')");
						con.close();
					}
					catch(Exception e)
					{
						JOptionPane.showConfirmDialog(null, e);
					}
				}
				else
				{
					JOptionPane.showConfirmDialog(null, "Password does not match");
					passwordField.setText("");
					passwordField_1.setText("");
				}
			}
		});
		getContentPane().add(btnCreate);
		
		JLabel lblConformPassword = new JLabel("Conform Password:");
		lblConformPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConformPassword.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		lblConformPassword.setBounds(72, 334, 142, 36);
		contentPane.add(lblConformPassword);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 616, 554);
		lblNewLabel.setIcon(new ImageIcon(Admin_SignUp.class.getResource("/Images/Admin_SignUp.jpg")));
		getContentPane().add(lblNewLabel);
	}
}

