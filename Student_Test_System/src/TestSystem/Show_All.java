package TestSystem;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

public class Show_All extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Show_All frame = new Show_All();
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
	public Show_All() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Add New Question");
		setBounds(100, 100, 725, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("UOG Test System");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Sylfaen", Font.PLAIN, 30));
		label.setBounds(0, 0, 709, 61);
		contentPane.add(label);
		
		JLabel lblAllQuestionsAre = new JLabel("All Questions are displayed below:");
		lblAllQuestionsAre.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAllQuestionsAre.setBounds(58, 72, 322, 50);
		contentPane.add(lblAllQuestionsAre);
		
		table = new JTable();
		table.setBounds(10, 157, 699, 342);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Show_All.class.getResource("/Images/Start_Test.jpg")));
		lblNewLabel.setBounds(0, 0, 719, 510);
		contentPane.add(lblNewLabel);
		
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String URL="jdbc:mysql://localhost/studenttestsystem";
			Connection con=DriverManager.getConnection(URL,"root","");
			Statement st=con.createStatement();
			
			rs=st.executeQuery("Select * from questions");
		    if(rs!=null){
		    	while(rs.next()){
		    		//comboBox_1.addItem(rs.getString("Question"));
		    		table.setModel(DbUtils.resultSetToTableModel(rs));
		    	}
		    }	
		}
		catch(Exception ex){
			JOptionPane.showConfirmDialog(null, "Error! Please check your database");
		}
	}
}
