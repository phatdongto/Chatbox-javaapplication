import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.lang.ModuleLayer.Controller;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class GUI {

	private JFrame frame;
	private JTextField usernameText;
	private JPasswordField password;
	private DataController controller = new DataController();
	private JLabel loginStatusLable = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 583, 423);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		usernameText = new JTextField();
		usernameText.setBounds(189, 125, 208, 31);
		frame.getContentPane().add(usernameText);
		usernameText.setColumns(10);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setBounds(90, 125, 89, 31);
		frame.getContentPane().add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setBounds(90, 184, 89, 31);
		frame.getContentPane().add(passwordLabel);
		
		password = new JPasswordField();
		password.setBounds(189, 185, 208, 31);
		frame.getContentPane().add(password);
		
		JButton loginButton = new JButton("Login");
//		loginButton.addActionListener(this);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginButtonAction();
			}	
		});
		loginButton.setBounds(163, 243, 110, 39);
		frame.getContentPane().add(loginButton);
		
		JButton signUpButton = new JButton("Sign up");
		signUpButton.addActionListener(new ActionListener() { //action listener Signup
			public void actionPerformed(ActionEvent e) {
				SignUpButtonAction();
			}
		});
		signUpButton.setBounds(311, 243, 110, 39);
		frame.getContentPane().add(signUpButton);
		
		
		loginStatusLable.setHorizontalAlignment(SwingConstants.CENTER);
		loginStatusLable.setBounds(214, 218, 147, 14);
		frame.getContentPane().add(loginStatusLable);
	}
	
	void SignUpButtonAction() {
		// TODO Auto-generated method stub
		
		frame.setVisible(false);
		SignUpView signUpView = new SignUpView();
		signUpView.main2(null);
	}

	@SuppressWarnings("deprecation")
	public void LoginButtonAction() {
		if (controller.CheckAcccount(usernameText.getText(), password.getText())) {
			loginStatusLable.setText("correct");
		}
		else loginStatusLable.setText("incorrect");	
	}
	
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		if(e.getActionCommand().equals("loginButton")){
//	        //Process Button 1 action event here 
//			System.out.print("here");
//			if (controller.CheckAcccount(usernameText.getText(), password.getText())) {
//				loginStatusLable.setText("correct");
//			}
//			else loginStatusLable.setText("incorrect");	
//	    }
////	    else if(e.getActionCommand().equals("Button 2")){
////	        //Process Button 2 action event here 
////	    }
//	}
}

