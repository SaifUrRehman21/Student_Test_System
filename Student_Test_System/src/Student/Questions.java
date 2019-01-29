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
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Questions extends JFrame {

	private JPanel contentPane;
	public static int interval=300;
	public static Timer timer;
	public static int minute;
	public static int second;
	public String Option="";
	public String correct="";
	public int Qno=1;
	public static int marks;
	public static int correctQ=0;
	ResultSet rs=null;
	int arr[]=new int[10]; 
	public int id;
	
	
	/*
	 * Funtion for Timer
	 */
	private static final int minuteInterval(){
		minute=interval/60;
	    return minute;
	}
	private static final int secondsInterval(){
		if(interval==1)
		{	
			Questions a=new Questions();
			a.setVisible(false);
			
			Result b=new Result(marks,correctQ);
			b.setVisible(true);
			
		}
	    
	    return --interval;
	}

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Questions frame = new Questions();
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
	public Questions() {
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				Questions a=new Questions();
				a.setVisible(false);
				
				Result b=new Result(marks,correctQ);
				b.setVisible(true);
				dispose();
			}
		});
		setResizable(false);
		setTitle("Questions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 472);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel label = new JLabel("00:04:45");
		label.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label.setBounds(480, 98, 135, 37);
		contentPane.add(label);
		
		final JLabel label_2 = new JLabel("Time Remaining");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(480, 65, 123, 39);
		contentPane.add(label_2);
		
		JLabel lblQuestion = new JLabel("Question #");
		lblQuestion.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblQuestion.setBounds(22, 80, 123, 50);
		contentPane.add(lblQuestion);
		
		JLabel lblA = new JLabel("A");
		lblA.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblA.setBounds(34, 240, 21, 29);
		contentPane.add(lblA);
		
		final JRadioButton radioA = new JRadioButton("4");
		radioA.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				Questions a=new Questions();
				a.setVisible(false);
				
				Result b=new Result(marks,correctQ);
				b.setVisible(true);
				dispose();
			}
		});
		radioA.setBackground(Color.WHITE);
		radioA.setBounds(53, 244, 123, 23);
		contentPane.add(radioA);
		
		JLabel lblB = new JLabel("B");
		lblB.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblB.setBounds(361, 240, 21, 29);
		contentPane.add(lblB);
		
		final JRadioButton radioB = new JRadioButton("8");
		radioB.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				Questions a=new Questions();
				a.setVisible(false);
				
				Result b=new Result(marks,correctQ);
				b.setVisible(true);
				dispose();
			}
		});
		radioB.setBackground(Color.WHITE);
		radioB.setBounds(380, 244, 123, 23);
		contentPane.add(radioB);
		
		JLabel lblC = new JLabel("C");
		lblC.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblC.setBounds(34, 284, 21, 29);
		contentPane.add(lblC);
		
		final JRadioButton radioC = new JRadioButton("16");
		radioC.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				Questions a=new Questions();
				a.setVisible(false);
				
				Result b=new Result(marks,correctQ);
				b.setVisible(true);
				dispose();
			}
		});
		radioC.setBackground(Color.WHITE);
		radioC.setBounds(53, 288, 123, 23);
		contentPane.add(radioC);
		
		JLabel lblD = new JLabel("D");
		lblD.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblD.setBounds(361, 284, 21, 29);
		contentPane.add(lblD);
		
		final JRadioButton radioD = new JRadioButton("32");
		radioD.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				Questions a=new Questions();
				a.setVisible(false);
				
				Result b=new Result(marks,correctQ);
				b.setVisible(true);
				dispose();
			}
		});
		radioD.setBackground(Color.WHITE);
		radioD.setBounds(380, 288, 123, 23);
		contentPane.add(radioD);
		
		JButton btnFinish = new JButton("Next >");
		btnFinish.setBounds(470, 344, 89, 38);
		contentPane.add(btnFinish);
		
		JLabel lblPleaseNoteThat = new JLabel("Please note that you can not go back to any question when you press Next.");
		lblPleaseNoteThat.setForeground(Color.RED);
		lblPleaseNoteThat.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPleaseNoteThat.setBounds(48, 393, 537, 29);
		contentPane.add(lblPleaseNoteThat);
		
		final JLabel QNo = new JLabel("1");
		QNo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		QNo.setBounds(120, 80, 72, 50);
		contentPane.add(QNo);

		
		/*
		 * ButtonGroup
		 */
		ButtonGroup o=new ButtonGroup();
		o.add(radioA);
		o.add(radioB);
		o.add(radioC);
		o.add(radioD);
		
		JLabel label_4 = new JLabel("");
		label_4.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				Questions a=new Questions();
				a.setVisible(false);
				
				Result b=new Result(marks,correctQ);
				b.setVisible(true);
				dispose();
			}
		});
		label_4.setBackground(SystemColor.inactiveCaption);
		label_4.setBounds(0, 0, 645, 443);
		contentPane.add(label_4);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(98, 11, 533, 76);
		label_1.setIcon(new ImageIcon(Questions.class.getResource("/Images/Logo.png")));
		contentPane.add(label_1);
		
		final JLabel label_3 = new JLabel("Time Remaining");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(421, 145, 123, 39);
		contentPane.add(label_3);
		
		final JLabel statement = new JLabel("What is the square of 4?");
		statement.setBounds(22, 136, 554, 100);
		contentPane.add(statement);
		
		
		
		
		
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * Radio Button
				 */
				if(radioA.isSelected()==true){
					Option="A";
				}
				else if(radioB.isSelected()==true){
					Option="B";
				}
				else if(radioC.isSelected()==true){
					Option="C";
				}
				else if(radioD.isSelected()==true){
					Option="D";
				}
				else{
					Option="";
				}
				
				
				
				
				/*
				 * marks
				 */
				if(Option.equals(correct)){
	    			marks+=5;
	    			correctQ+=1;
	    		}
	    		else if(Option.isEmpty()){
	    		}
	    		else{
	    			marks-=2;
	    		}
				label_3.setText(marks+"");
				
				
				
				/*
				 * Question Number Increment
				 */
				Qno++;
				QNo.setText(Qno+"");
				if(Qno==11)
				{
					Questions a=new Questions();
					a.setVisible(false);
					
					Result b = new Result(marks,correctQ);
					b.setVisible(true);
					dispose();
		            
				}
				
				
				
				/*
				 * Database
				 */
				
					try{
						//int i=1;
						Class.forName("com.mysql.jdbc.Driver");
						String URL="jdbc:mysql://localhost/studenttestsystem";
						Connection con=DriverManager.getConnection(URL,"root","");
						Statement st=con.createStatement();
						rs=st.executeQuery("Select * from questions Order by RAND() LIMIT 10");
					    //if(rs!=null){
					    	while(rs.next()){
					    		statement.setText(rs.getString("Question"));
					    		radioA.setText(rs.getString("a"));
					    		radioB.setText(rs.getString("b"));
					    		radioC.setText(rs.getString("c"));
					    		radioD.setText(rs.getString("d"));
					    		
					    		correct=rs.getString("correct");
					    		/*i++;
					    		arr[i]=Integer.parseInt(rs.getString("ID"));
					    		id=Integer.parseInt(rs.getString("ID"));*/
					    	}
					//}
					}
					catch(Exception ex){
						JOptionPane.showConfirmDialog(null, "Error! Please check your database");
					}
			}
		});
		
		
		
		
		/*
		 * Timer Code
		 */
	    timer = new Timer();
	    timer.scheduleAtFixedRate(new TimerTask() {
	        public void run() {
	            label.setText("00:0"+minuteInterval()+":"+secondsInterval()%60);
	        }
	    }, 1000, 1000);
	    
	    
	    
	    
	    /*
	     * DataBase in form load
	     */
	    try{
			Class.forName("com.mysql.jdbc.Driver");
			String URL="jdbc:mysql://localhost/studenttestsystem";
			Connection con=DriverManager.getConnection(URL,"root","");
			Statement st=con.createStatement();
			rs=st.executeQuery("Select * from questions Order by RAND() LIMIT 10");
		    if(rs!=null){
		    	while(rs.next()){
		    		statement.setText(rs.getString("Question"));
		    		radioA.setText(rs.getString("a"));
		    		radioB.setText(rs.getString("b"));
		    		radioC.setText(rs.getString("c"));
		    		radioD.setText(rs.getString("d"));
		    		
		    		correct=rs.getString("correct");
		    		arr[0]=Integer.parseInt(rs.getString("ID"));
		    	}
		    }	
		}
		catch(Exception ex){
			JOptionPane.showConfirmDialog(null, "Error! Please check your database");
		}
	}
}
