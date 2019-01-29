package TestSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

public class Logo extends JFrame {

	private JPanel contentPane;
	JProgressBar	pb;
	
	public void update()
	{
		int i=0;
		while(i<101)
		{
			pb.setValue(i);
			i++;
			try
			{
				Thread.sleep(100);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logo frame = new Logo();
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
	public Logo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(63, 203, 252, 33);
		contentPane.add(progressBar);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 434, 261);
		contentPane.add(label);
		
		this.setSize(450,450);
		getContentPane().setLayout(null);
	}
}
