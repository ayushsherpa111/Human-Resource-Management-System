package user.login.view;

import java.awt.Font;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class LoginView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField userField;
	private JPasswordField passwordField;
	private JLabel lblUserName;
	private JButton btnLogin;



	/**
	 * Create the application.
	 */
	public LoginView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setSize(600,500);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 584, 461);
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(null);
		getContentPane().add(panel);
		
		
		
		JLabel Title = new JLabel("Login");
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setFont(new Font("Serif", Font.BOLD, 50));
		Title.setForeground(Color.WHITE);
		Title.setBounds(163, 11, 216, 85);
		panel.add(Title);
		
		lblUserName = new JLabel("User name: ");
		lblUserName.setFont(new Font("Bell MT", Font.BOLD, 23));
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setBounds(112, 132, 139, 46);
		panel.add(lblUserName);
		
		userField = new JTextField();
		Title.setLabelFor(userField);
		userField.setBounds(247, 143, 162, 30);
		panel.add(userField);
		userField.setColumns(10);
		
		JLabel lblPassoword = new JLabel("Password");
		lblPassoword.setForeground(Color.WHITE);
		lblPassoword.setFont(new Font("Bell MT", Font.BOLD, 23));
		lblPassoword.setBounds(112, 189, 112, 32);
		panel.add(lblPassoword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(247, 189, 162, 29);
		panel.add(passwordField);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(227, 259, 89, 23);
		panel.add(btnLogin);
	}
	
	public String getUserName()
	{
		return userField.getText();
	}
	public String getPassword()
	{
		return String.valueOf(passwordField.getPassword());
	}
	public void login(ActionListener acl)
	{
		btnLogin.addActionListener(acl);
	}
	
}
