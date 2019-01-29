package TestSystem;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Delete extends JFrame {

	private JPanel contentPane;
	ResultSet rs=null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete frame = new Delete();
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
	public Delete() {
		setResizable(false);
		setTitle("Delete Question");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 725, 518);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel lblQuestion = new JLabel("Select Question:");
		lblQuestion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuestion.setBounds(38, 161, 133, 24);
		contentPane.add(lblQuestion);
		
		JLabel label = new JLabel("");
		label.setBounds(98, 11, 533, 76);
		label.setIcon(new ImageIcon(Select_Panel.class.getResource("/Images/Logo.png")));
		contentPane.add(label);
		
		JLabel lblAddQuestion = new JLabel("Delete QUESTION");
		lblAddQuestion.setFont(new Font("Serif", Font.PLAIN, 25));
		lblAddQuestion.setBounds(249, 95, 217, 33);
		contentPane.add(lblAddQuestion);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(110, 205, 521, 55);
		contentPane.add(comboBox);
		
		JButton btnDelete = new JButton("");
		btnDelete.setToolTipText("Delete Question from database");
		btnDelete.setIcon(new ImageIcon(Select_Panel.class.getResource("/Images/Delete_Button.jpg")));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * Delete Button Code
				 */
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					String URL="jdbc:mysql://localhost/studenttestsystem";
					Connection con=DriverManager.getConnection(URL,"root","");
					Statement st=con.createStatement();
					st.executeUpdate("Delete from questions where question='"+comboBox.getSelectedItem()+"'");
					con.close();
					JOptionPane.showConfirmDialog(null, "Record Deleted Successfully!");
					
					/*
					 * Reload Combobox
					 */
					rs=st.executeQuery("Select Question from questions");
				    if(rs!=null){
				    	while(rs.next()){
				    		comboBox.addItem(rs.getString("Question"));
				    	}
				    }
				}
				catch(Exception e){
					JOptionPane.showConfirmDialog(null, "Error! Please try again later");
				}
			}
		});
		btnDelete.setBounds(544, 362, 87, 69);
		contentPane.add(btnDelete);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Saif Ur Rehman\\Downloads\\82d24d2a163a2399091a1d342b3d596a.jpg"));
		label_1.setBounds(0, 0, 719, 489);
		contentPane.add(label_1);
		
		/*
		 * ComboBox Code in form Load
		 */
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String URL="jdbc:mysql://localhost/studenttestsystem";
			Connection con=DriverManager.getConnection(URL,"root","");
			Statement st=con.createStatement();
			rs=st.executeQuery("Select Question from questions");
		    if(rs!=null){
		    	while(rs.next()){
		    		comboBox.addItem(rs.getString("Question"));
		    	}
		    }	
		}
		catch(Exception ex){
			JOptionPane.showConfirmDialog(null, "Error! Please check your database");
		}		
	}
}
