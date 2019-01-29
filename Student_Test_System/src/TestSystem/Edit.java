package TestSystem;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class Edit extends JFrame {
	private JPanel contentPane;
	private JTextField a;
	private JTextField b;
	private JTextField d;
	private JTextField c;
	
	ResultSet rs=null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit frame = new Edit();
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
	public Edit() {
		
		
		
		setResizable(false);
		setTitle("Update Question");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 725, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setBounds(53, 197, 53, 24);
		contentPane.add(lblQuestion);
		
		a = new JTextField();
		a.setBounds(105, 331, 190, 24);
		contentPane.add(a);
		a.setColumns(10);
		
		JLabel lblOptionA = new JLabel("Option A");
		lblOptionA.setBounds(53, 331, 53, 24);
		contentPane.add(lblOptionA);
		
		final JTextArea statement = new JTextArea();
		statement.setBounds(105, 197, 578, 100);
		contentPane.add(statement);
		
		JLabel lblOptionB = new JLabel("Option B");
		lblOptionB.setBounds(441, 331, 53, 24);
		contentPane.add(lblOptionB);
		
		b = new JTextField();
		b.setColumns(10);
		b.setBounds(493, 331, 190, 24);
		contentPane.add(b);
		
		JLabel lblOptionD = new JLabel("Option D");
		lblOptionD.setBounds(441, 366, 53, 24);
		contentPane.add(lblOptionD);
		
		d = new JTextField();
		d.setColumns(10);
		d.setBounds(493, 366, 190, 24);
		contentPane.add(d);
		
		JLabel lblOptionC = new JLabel("Option C");
		lblOptionC.setBounds(53, 366, 53, 24);
		contentPane.add(lblOptionC);
		
		c = new JTextField();
		c.setColumns(10);
		c.setBounds(105, 366, 190, 24);
		contentPane.add(c);
		
		JLabel lblCorrectAnswer = new JLabel("Correct Answer");
		lblCorrectAnswer.setBounds(34, 410, 102, 24);
		contentPane.add(lblCorrectAnswer);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D"}));
		comboBox.setBounds(141, 412, 83, 24);
		contentPane.add(comboBox);
		
		JLabel lblDifficulityLevel = new JLabel("Difficulity Level");
		lblDifficulityLevel.setBounds(34, 447, 102, 24);
		contentPane.add(lblDifficulityLevel);
		
		final JRadioButton Easy = new JRadioButton("Easy");
		Easy.setBounds(151, 448, 73, 23);
		contentPane.add(Easy);
		
		final JRadioButton Medium = new JRadioButton("Medium");
		Medium.setBounds(336, 448, 73, 23);
		contentPane.add(Medium);
		
		final JRadioButton Hard = new JRadioButton("Hard");
		Hard.setBounds(534, 448, 73, 23);
		contentPane.add(Hard);
		
		
		ButtonGroup o=new ButtonGroup();
		o.add(Easy);
		o.add(Medium);
		o.add(Hard);

		
		
		final JButton btnUpdateQuestion = new JButton("Update Question");
		btnUpdateQuestion.setBounds(523, 478, 160, 42);
		contentPane.add(btnUpdateQuestion);
		
		JLabel lblAddQuestion = new JLabel("Update Question");
		lblAddQuestion.setFont(new Font("Serif", Font.PLAIN, 25));
		lblAddQuestion.setBounds(249, 95, 217, 33);
		contentPane.add(lblAddQuestion);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(108, 149, 488, 37);
		contentPane.add(comboBox_1);
		
		JLabel lblSelectQuestion = new JLabel("Select Question");
		lblSelectQuestion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSelectQuestion.setBounds(10, 149, 88, 33);
		contentPane.add(lblSelectQuestion);
		
		JLabel label = new JLabel("");
		label.setBounds(98, 11, 533, 76);
		label.setIcon(new ImageIcon(Select_Panel.class.getResource("/Images/Logo.png")));
		contentPane.add(label);
		
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{statement, a, b, c, d, comboBox, Easy, Medium, Hard, btnUpdateQuestion, lblQuestion, lblOptionA, lblOptionB, lblOptionD, lblOptionC, lblCorrectAnswer, lblDifficulityLevel, lblAddQuestion}));
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/*
				 * Search Button Code
				 */
				String Difficulty="";
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					String URL="jdbc:mysql://localhost/studenttestsystem";
					Connection con=DriverManager.getConnection(URL,"root","");
					Statement st=con.createStatement();
					rs=st.executeQuery("Select * from questions where question='"+comboBox_1.getSelectedItem()+"'");
					

				    if(rs!=null){
				    	while(rs.next()){
				    		statement.setText(rs.getString("Question"));
				    		a.setText(rs.getString("a"));
				    		b.setText(rs.getString("b"));
				    		c.setText(rs.getString("c"));
				    		d.setText(rs.getString("d"));
				    		comboBox.setSelectedItem(rs.getString("correct"));
				    		
				    		Difficulty=rs.getString("Difficulty");
				    		if(Difficulty.equals("Easy")){
				    			Easy.setSelected(true);
				    		}
				    		else if(Difficulty.equals("Medium")){
				    			Medium.setSelected(true);
				    		}
				    		else if(Difficulty.equals("Hard")){
				    			Hard.setSelected(true);
				    		}
				    	}
				    }
				}
				catch(Exception ex){
					JOptionPane.showConfirmDialog(null, "Error! Please Try again later.");
				}
				
			}
		});
		btnNewButton.setBounds(606, 147, 83, 40);
		contentPane.add(btnNewButton);
		
		btnUpdateQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/*
				 * Update Button Code
				 */
				String Question=statement.getText();
				String A=a.getText();
				String B=b.getText();
				String C=c.getText();
				String D=d.getText();
				String correct=comboBox.getSelectedItem().toString();
				String Difficulty="";
				String OldQuestion=comboBox_1.getSelectedItem().toString();
				
				if(Easy.isSelected()==true){
					Difficulty=Easy.getText();
				}
				else if(Medium.isSelected()==true){
					Difficulty=Medium.getText();
				}
				else if(Hard.isSelected()==true){
					Difficulty=Hard.getText();
				}			
				/*
				 * Database+connection
				 */
				try{
					Class.forName("com.mysql.jdbc.Driver");
					String URL="jdbc:mysql://localhost/studenttestsystem";
					Connection con=DriverManager.getConnection(URL,"root","");
					Statement st=con.createStatement();
					
					st.executeUpdate("Update question SET Question='"+Question+"',a='"+A+"',b='"+B+"',c='"+C+"',d='"+D+"',correct='"+correct+"',Difficulty='"+Difficulty+"' where Question='"+OldQuestion+"' ");
					con.close();				
					JOptionPane.showConfirmDialog(null, "Record Saved Successfully!");
				}
				catch(Exception e){
					JOptionPane.showConfirmDialog(null, "Error! Try again later.");
				}
			}
		});

		
		/*
		 * Fill ComboBox in form Load
		 */
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String URL="jdbc:mysql://localhost/studenttestsystem";
			Connection con=DriverManager.getConnection(URL,"root","");
			Statement st=con.createStatement();
			
			rs=st.executeQuery("Select Question from questions");
		    if(rs!=null){
		    	while(rs.next()){
		    		comboBox_1.addItem(rs.getString("Question"));
		    	}
		    }	
		}
		catch(Exception ex){
			JOptionPane.showConfirmDialog(null, "Error! Please check your database");
		}
	}
}
