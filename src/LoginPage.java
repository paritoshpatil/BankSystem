import java.awt.EventQueue;

import Operations.DBTest;
import Operations.Services;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginPage {

	private JFrame frame;
	private JTextField userID;
	private JTextField bankUserID;
	private JPasswordField bankUserPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				LoginPage window = new LoginPage();
				try {
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
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		bankUserID = new JTextField();
		bankUserID.setFont(new Font("Noto Sans CJK KR Light", Font.PLAIN, 12));
		bankUserID.setToolTipText("Bank User ID");
		bankUserID.setBounds(164, 88, 114, 19);
		frame.getContentPane().add(bankUserID);
		bankUserID.setColumns(20);
		
		bankUserPassword = new JPasswordField();
		bankUserPassword.setFont(new Font("Noto Sans CJK KR Thin", Font.PLAIN, 12));
		bankUserPassword.setBounds(164, 119, 114, 19);
		frame.getContentPane().add(bankUserPassword);
		
		JLabel userIDLabel = new JLabel("User ID");
		userIDLabel.setFont(new Font("Noto Sans CJK KR Bold", Font.BOLD, 12));
		userIDLabel.setBounds(88, 92, 70, 15);
		frame.getContentPane().add(userIDLabel);
		
		JLabel userPasswordLabel = new JLabel("Password");
		userPasswordLabel.setFont(new Font("Noto Sans CJK KR Bold", Font.BOLD, 12));
		userPasswordLabel.setBounds(88, 121, 70, 15);
		frame.getContentPane().add(userPasswordLabel);
		
		JLabel loginLabel = new JLabel("LHC Bank");
		loginLabel.setForeground(new Color(0, 204, 51));
		loginLabel.setFont(new Font("Noto Sans CJK KR Bold", Font.BOLD, 28));
		loginLabel.setBounds(155, 12, 138, 42);
		frame.getContentPane().add(loginLabel);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DBTest db = new DBTest();
				Services s = new Services();
				
				String uname = bankUserID.getText();
				String upass = new String(bankUserPassword.getPassword());
				try {
					if(db.bankLogin(uname, upass) == true)
					{
						s.newWindow();
					}
					
					else
					{
					JOptionPane.showMessageDialog(null, "Login Failed!");
					bankUserID.setText("");
					bankUserPassword.setText("");
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		loginButton.setFont(new Font("Noto Sans CJK KR Bold", Font.BOLD, 12));
		loginButton.setToolTipText("Login");
		loginButton.setBounds(164, 194, 117, 25);
		frame.getContentPane().add(loginButton);
		
	}
}
