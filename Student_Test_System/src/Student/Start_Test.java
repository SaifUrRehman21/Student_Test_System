package Student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Start_Test extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start_Test frame = new Start_Test();
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
	public Start_Test() {
		setResizable(false);
		setTitle("University of Gujrat, Test System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 474);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("UOG Test System");
		label.setFont(new Font("Sylfaen", Font.PLAIN, 30));
		label.setBounds(38, 11, 267, 61);
		contentPane.add(label);
		
		JLabel lblStudentResult = new JLabel("Welcome to UOG Test System");
		lblStudentResult.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblStudentResult.setBounds(38, 69, 322, 50);
		contentPane.add(lblStudentResult);
		
		JLabel lblYouHaveSuccessfully = new JLabel("Please read instructions below before start the test");
		lblYouHaveSuccessfully.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouHaveSuccessfully.setForeground(Color.RED);
		lblYouHaveSuccessfully.setFont(new Font("Arial Unicode MS", Font.ITALIC, 18));
		lblYouHaveSuccessfully.setBounds(10, 116, 529, 19);
		contentPane.add(lblYouHaveSuccessfully);
		
		JButton btnExit = new JButton("I AM READY! START MY TEST");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Start_Test a=new Start_Test();
				a.setVisible(false);
				
				Questions b=new Questions();
				b.setVisible(true);
				dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExit.setForeground(Color.BLACK);
		btnExit.setBounds(289, 368, 218, 33);
		contentPane.add(btnExit);
		
		JLabel lblTotalQuestions = new JLabel("Your Test will contain 100 MCQ Questions.");
		lblTotalQuestions.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotalQuestions.setBounds(76, 163, 352, 19);
		contentPane.add(lblTotalQuestions);
		
		JLabel lblYouWillHave = new JLabel("You will have 5 minutes to solve the test.\r\n");
		lblYouWillHave.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblYouWillHave.setBounds(76, 178, 352, 19);
		contentPane.add(lblYouWillHave);
		
		JLabel lblYouAreNot = new JLabel("You are not allowed to use keyboard, Otherwise test will be cancelled.");
		lblYouAreNot.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblYouAreNot.setBounds(76, 297, 352, 19);
		contentPane.add(lblYouAreNot);
		
		JLabel lblAfterMinutes = new JLabel("After 5 minutes your test will be closed automatically.");
		lblAfterMinutes.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAfterMinutes.setBounds(76, 208, 352, 17);
		contentPane.add(lblAfterMinutes);
		
		JLabel lblEachCorrectAnswer = new JLabel("Each correct answer has +5 marks.");
		lblEachCorrectAnswer.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEachCorrectAnswer.setBounds(76, 222, 352, 19);
		contentPane.add(lblEachCorrectAnswer);
		
		JLabel lblEachWrongAnswer = new JLabel("Each wrong answer has-2 marks.");
		lblEachWrongAnswer.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEachWrongAnswer.setBounds(76, 236, 352, 19);
		contentPane.add(lblEachWrongAnswer);
		
		JLabel lblYouWillGet = new JLabel("You will get result after completion of test.");
		lblYouWillGet.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblYouWillGet.setBounds(76, 266, 352, 19);
		contentPane.add(lblYouWillGet);
		
		JLabel lblGoodLuckFor = new JLabel("Good Luck for your test from UOG!");
		lblGoodLuckFor.setForeground(Color.BLUE);
		lblGoodLuckFor.setBounds(76, 313, 352, 33);
		contentPane.add(lblGoodLuckFor);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Start_Test.class.getResource("/Images/Start_Test.jpg")));
		label_1.setBounds(0, 0, 549, 445);
		contentPane.add(label_1);
	}

}
