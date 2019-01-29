package TestSystem;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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
import javax.swing.border.EmptyBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class Search extends JFrame {

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
					Search frame = new Search();
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
	public Search() {
		setResizable(false);
		setTitle("Search Question");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 725, 579);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuestion.setForeground(Color.BLACK);
		lblQuestion.setBounds(53, 197, 53, 24);
		contentPane.add(lblQuestion);
		
		a = new JTextField();
		a.setBounds(105, 331, 190, 24);
		contentPane.add(a);
		a.setColumns(10);
		
		JLabel lblOptionA = new JLabel("Option A");
		lblOptionA.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOptionA.setForeground(Color.WHITE);
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
		lblOptionC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOptionC.setForeground(Color.WHITE);
		lblOptionC.setBounds(53, 366, 53, 24);
		contentPane.add(lblOptionC);
		
		c = new JTextField();
		c.setColumns(10);
		c.setBounds(105, 366, 190, 24);
		contentPane.add(c);
		
		JLabel lblCorrectAnswer = new JLabel("Correct Answer");
		lblCorrectAnswer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCorrectAnswer.setForeground(Color.WHITE);
		lblCorrectAnswer.setBounds(34, 410, 102, 24);
		contentPane.add(lblCorrectAnswer);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(143, 188, 143));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D"}));
		comboBox.setBounds(152, 410, 83, 24);
		contentPane.add(comboBox);
		
		JLabel lblDifficulityLevel = new JLabel("Difficulity Level");
		lblDifficulityLevel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDifficulityLevel.setForeground(Color.WHITE);
		lblDifficulityLevel.setBounds(34, 447, 102, 24);
		contentPane.add(lblDifficulityLevel);
		
		final JRadioButton Easy = new JRadioButton("Easy");
		Easy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Easy.setForeground(Color.BLACK);
		Easy.setBackground(new Color(143, 188, 143));
		Easy.setBounds(151, 448, 73, 23);
		contentPane.add(Easy);
		
		final JRadioButton Medium = new JRadioButton("Medium");
		Medium.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Medium.setBackground(new Color(152, 251, 152));
		Medium.setBounds(336, 448, 73, 23);
		contentPane.add(Medium);
		
		final JRadioButton Hard = new JRadioButton("Hard");
		Hard.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Hard.setBackground(new Color(152, 251, 152));
		Hard.setBounds(534, 448, 73, 23);
		contentPane.add(Hard);
		
		
		Easy.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Medium.setSelected(false);
				Hard.setSelected(false);
			}
		});

		Medium.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Easy.setSelected(false);
				Hard.setSelected(false);
			}
		});
		
		Hard.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				Easy.setSelected(false);
				Medium.setSelected(false);
			}
		});
		
		JLabel label = new JLabel("");
		label.setBounds(98, 11, 533, 76);
		label.setIcon(new ImageIcon(Select_Panel.class.getResource("/Images/Logo.png")));
		contentPane.add(label);
		
		JLabel lblAddQuestion = new JLabel("Search Question");
		lblAddQuestion.setFont(new Font("Serif", Font.PLAIN, 25));
		lblAddQuestion.setBounds(277, 98, 217, 33);
		contentPane.add(lblAddQuestion);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(105, 147, 485, 39);
		contentPane.add(comboBox_1);
		
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
		btnNewButton.setBounds(600, 146, 83, 40);
		contentPane.add(btnNewButton);
		
		JLabel lblSearchQuestion = new JLabel("Search Question");
		lblSearchQuestion.setForeground(Color.BLACK);
		lblSearchQuestion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSearchQuestion.setBounds(10, 145, 96, 41);
		contentPane.add(lblSearchQuestion);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Select_Panel.class.getResource("/Images/Search.jpg")));
		label_1.setBounds(0, 0, 719, 550);
		contentPane.add(label_1);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{comboBox_1, btnNewButton, statement, a, b, c, d, comboBox, Easy, Medium, Hard, lblQuestion, lblOptionA, lblOptionB, lblOptionD, lblOptionC, lblCorrectAnswer, lblDifficulityLevel, lblAddQuestion}));

		
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
