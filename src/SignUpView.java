import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class SignUpView {

	public JFrame frame;
	private JTextField usernameText;
	private JTextField passwordField;
	private DataController controller = new DataController();
	JLabel createStatus = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main2(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpView window = new SignUpView();
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
	public SignUpView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 15));
		frame.setBounds(100, 100, 469, 298);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 19, 0, 24, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel locationMarkerLable = new JLabel("               ");
		GridBagConstraints gbc_locationMarkerLable = new GridBagConstraints();
		gbc_locationMarkerLable.insets = new Insets(0, 0, 5, 5);
		gbc_locationMarkerLable.gridx = 1;
		gbc_locationMarkerLable.gridy = 0;
		frame.getContentPane().add(locationMarkerLable, gbc_locationMarkerLable);
		
		JLabel titleLable = new JLabel("Sign up");
		titleLable.setFont(new Font("Unispace", Font.PLAIN, 27));
		GridBagConstraints gbc_titleLable = new GridBagConstraints();
		gbc_titleLable.gridwidth = 5;
		gbc_titleLable.gridheight = 2;
		gbc_titleLable.insets = new Insets(0, 0, 5, 5);
		gbc_titleLable.gridx = 7;
		gbc_titleLable.gridy = 2;
		frame.getContentPane().add(titleLable, gbc_titleLable);
		
		JLabel usernameLable = new JLabel("Username");
		usernameLable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_usernameLable = new GridBagConstraints();
		gbc_usernameLable.insets = new Insets(0, 0, 5, 5);
		gbc_usernameLable.gridx = 4;
		gbc_usernameLable.gridy = 5;
		frame.getContentPane().add(usernameLable, gbc_usernameLable);
		
		usernameText = new JTextField();
		GridBagConstraints gbc_usernameText = new GridBagConstraints();
		gbc_usernameText.gridwidth = 5;
		gbc_usernameText.insets = new Insets(0, 0, 5, 5);
		gbc_usernameText.fill = GridBagConstraints.HORIZONTAL;
		gbc_usernameText.gridx = 7;
		gbc_usernameText.gridy = 5;
		frame.getContentPane().add(usernameText, gbc_usernameText);
		usernameText.setColumns(10);
		
		JLabel passwordLable = new JLabel("Password");
		passwordLable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_passwordLable = new GridBagConstraints();
		gbc_passwordLable.insets = new Insets(0, 0, 5, 5);
		gbc_passwordLable.gridx = 4;
		gbc_passwordLable.gridy = 7;
		frame.getContentPane().add(passwordLable, gbc_passwordLable);
		
		passwordField = new JTextField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.gridwidth = 5;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 7;
		gbc_passwordField.gridy = 7;
		frame.getContentPane().add(passwordField, gbc_passwordField);
		passwordField.setColumns(10);
		
		JButton createAccountButton = new JButton("Create account");
		createAccountButton.setHorizontalAlignment(SwingConstants.LEFT);
		createAccountButton.addActionListener(new ActionListener() {   //Action listener
			public void actionPerformed(ActionEvent e) {
				CreateAccountButtonAction();
			}
			private void CreateAccountButtonAction() {
				// TODO Auto-generated method stub
				if(DataController.Add_slang_word(usernameText.getText(), passwordField.getText()) == 0) {
//					createStatus.setText("create successfull");
					JOptionPane.showMessageDialog(frame, "create succesfully");
					frame.setVisible(false);
					GUI.main(null);	
				}
				else {
					createStatus.setText("username already exist");
				}
			}
		});
		
		
		GridBagConstraints gbc_createStatus = new GridBagConstraints();
		gbc_createStatus.insets = new Insets(0, 0, 5, 5);
		gbc_createStatus.gridx = 8;
		gbc_createStatus.gridy = 8;
		frame.getContentPane().add(createStatus, gbc_createStatus);
		createAccountButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GridBagConstraints gbc_createAccountButton = new GridBagConstraints();
		gbc_createAccountButton.insets = new Insets(0, 0, 5, 5);
		gbc_createAccountButton.gridx = 8;
		gbc_createAccountButton.gridy = 9;
		frame.getContentPane().add(createAccountButton, gbc_createAccountButton);
	}

}
