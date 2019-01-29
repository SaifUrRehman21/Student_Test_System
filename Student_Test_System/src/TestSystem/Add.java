package TestSystem;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
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
import javax.swing.border.EmptyBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class Add extends JFrame {

	private JPanel contentPane;
	private JTextField a;
	private JTextField b;
	private JTextField d;
	private JTextField c;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add frame = new Add();
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
	public Add() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Add New Question");
		setBounds(100, 100, 725, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setBounds(53, 153, 53, 24);
		contentPane.add(lblQuestion);
		
		a = new JTextField();
		a.setBounds(105, 287, 190, 24);
		contentPane.add(a);
		a.setColumns(10);
		
		JLabel lblOptionA = new JLabel("Option A");
		lblOptionA.setBounds(53, 287, 53, 24);
		contentPane.add(lblOptionA);
		
		final JTextArea statement = new JTextArea();
		statement.setBounds(105, 153, 550, 100);
		contentPane.add(statement);
		
		JLabel lblOptionB = new JLabel("Option B");
		lblOptionB.setBounds(413, 287, 53, 24);
		contentPane.add(lblOptionB);
		
		b = new JTextField();
		b.setColumns(10);
		b.setBounds(465, 287, 190, 24);
		contentPane.add(b);
		
		JLabel lblOptionD = new JLabel("Option D");
		lblOptionD.setBounds(413, 322, 53, 24);
		contentPane.add(lblOptionD);
		
		d = new JTextField();
		d.setColumns(10);
		d.setBounds(465, 322, 190, 24);
		contentPane.add(d);
		
		JLabel lblOptionC = new JLabel("Option C");
		lblOptionC.setBounds(53, 322, 53, 24);
		contentPane.add(lblOptionC);
		
		c = new JTextField();
		c.setColumns(10);
		c.setBounds(105, 322, 190, 24);
		contentPane.add(c);
		
		JLabel lblCorrectAnswer = new JLabel("Correct Answer");
		lblCorrectAnswer.setBounds(40, 366, 96, 24);
		contentPane.add(lblCorrectAnswer);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D"}));
		comboBox.setBounds(141, 368, 83, 24);
		contentPane.add(comboBox);
		
		JLabel lblDifficulityLevel = new JLabel("Difficulity Level");
		lblDifficulityLevel.setBounds(40, 403, 96, 24);
		contentPane.add(lblDifficulityLevel);
		
		final JRadioButton Easy = new JRadioButton("Easy");
		Easy.setBounds(151, 404, 73, 23);
		contentPane.add(Easy);
		
		final JRadioButton Medium = new JRadioButton("Medium");
		Medium.setBounds(288, 404, 73, 23);
		contentPane.add(Medium);
		
		final JRadioButton Hard = new JRadioButton("Hard");
		Hard.setBounds(444, 404, 73, 23);
		contentPane.add(Hard);
		
		
		ButtonGroup o=new ButtonGroup();
		o.add(Easy);
		o.add(Medium);
		o.add(Hard);
		
		

		JButton btnSaveQuestion = new JButton("Save Question");
		btnSaveQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				/*
				 * Save Button Code
				 */
				String Question=statement.getText();
				String A=a.getText();
				String B=b.getText();
				String C=c.getText();
				String D=d.getText();
				String correct=comboBox.getSelectedItem().toString();
				String Difficulty="";
				
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
				 * Connection for save button
				 */
				try{
					Class.forName("com.mysql.jdbc.Driver");
					String URL="jdbc:mysql://localhost/studenttestsystem";
					Connection con=DriverManager.getConnection(URL,"root","");
					Statement st=con.createStatement();
					
					st.executeUpdate("INSERT INTO questions(Question,a,b,c,d,correct,Difficulty) Values('"+Question+"','"+A+"','"+B+"','"+C+"','"+D+"','"+correct+"','"+Difficulty+"')");
					con.close();
					JOptionPane.showConfirmDialog(null, "Record Saved Successfully!");
				}
				catch(Exception e){
					JOptionPane.showConfirmDialog(null, "Error! Check your database connection");
				}
			}
		});
		btnSaveQuestion.setBounds(507, 434, 160, 42);
		contentPane.add(btnSaveQuestion);
		
		JLabel label = new JLabel("");
		label.setBounds(98, 11, 533, 76);
		label.setIcon(new ImageIcon(Select_Panel.class.getResource("/Images/Logo.png")));
		contentPane.add(label);
		
		JLabel lblAddQuestion = new JLabel("ADD QUESTION");
		lblAddQuestion.setFont(new Font("Serif", Font.PLAIN, 25));
		lblAddQuestion.setBounds(249, 95, 217, 33);
		contentPane.add(lblAddQuestion);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{statement, a, b, c, d, comboBox, Easy, Medium, Hard, btnSaveQuestion, lblQuestion, lblOptionA, lblOptionB, lblOptionD, lblOptionC, lblCorrectAnswer, lblDifficulityLevel, label, lblAddQuestion}));
	}
}
