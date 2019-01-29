package Student;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Result extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(final int marks,final int correctQ) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Result frame = new Result(marks,correctQ);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param marks 
	 * @param correctQ 
	 */
	public Result(final int marks, final int correctQ) {
		setResizable(false);
		setTitle("Result");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 472);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("UOG Test System");
		label.setFont(new Font("Tahoma", Font.BOLD, 27));
		label.setBounds(38, 11, 266, 61);
		contentPane.add(label);
		
		JLabel lblStudentResult = new JLabel("Student Result");
		lblStudentResult.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblStudentResult.setBounds(38, 69, 200, 50);
		contentPane.add(lblStudentResult);
		
		JLabel lblYouHaveSuccessfully = new JLabel("You have successfully completed your test.");
		lblYouHaveSuccessfully.setForeground(new Color(75, 0, 130));
		lblYouHaveSuccessfully.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblYouHaveSuccessfully.setBounds(119, 116, 374, 19);
		contentPane.add(lblYouHaveSuccessfully);
		
		JLabel lblTotalQuestions = new JLabel("Total Questions:");
		lblTotalQuestions.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalQuestions.setBounds(38, 159, 142, 27);
		contentPane.add(lblTotalQuestions);
		
		JLabel label_1 = new JLabel("10");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(289, 159, 55, 27);
		contentPane.add(label_1);
		
		JLabel lblCorrectAnswers = new JLabel("Correct Answers:");
		lblCorrectAnswers.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCorrectAnswers.setBounds(38, 192, 142, 27);
		contentPane.add(lblCorrectAnswers);
		
		JLabel Correct = new JLabel("7");
		Correct.setFont(new Font("Tahoma", Font.BOLD, 14));
		Correct.setBounds(289, 192, 55, 27);
		Correct.setText(correctQ+"");
		contentPane.add(Correct);
		
		JLabel lblWrongAnswers = new JLabel("Wrong Answers:");
		lblWrongAnswers.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWrongAnswers.setBounds(38, 225, 142, 27);
		contentPane.add(lblWrongAnswers);
		
		JLabel Wrong = new JLabel("3");
		Wrong.setFont(new Font("Tahoma", Font.BOLD, 14));
		Wrong.setBounds(289, 225, 55, 27);
		Wrong.setText(10-correctQ+"");
		contentPane.add(Wrong);
		
		JLabel lblTotalMarks = new JLabel("Total Marks:");
		lblTotalMarks.setForeground(new Color(0, 0, 255));
		lblTotalMarks.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalMarks.setBounds(38, 271, 142, 27);
		contentPane.add(lblTotalMarks);
		
		JLabel label_7 = new JLabel(marks+"");
		label_7.setForeground(new Color(0, 0, 255));
		label_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_7.setBounds(289, 271, 55, 27);
		contentPane.add(label_7);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setForeground(new Color(0, 0, 255));
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStatus.setBounds(38, 305, 142, 27);
		contentPane.add(lblStatus);
		
		JLabel lblPass = new JLabel("Pass");
		lblPass.setForeground(new Color(0, 0, 255));
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPass.setBounds(289, 305, 55, 27);
		contentPane.add(lblPass);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExit.setForeground(new Color(255, 0, 0));
		btnExit.setBounds(444, 357, 105, 33);
		contentPane.add(btnExit);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Result.class.getResource("/Images/Result.jpg")));
		label_2.setBounds(0, 0, 579, 443);
		contentPane.add(label_2);
	}

}
