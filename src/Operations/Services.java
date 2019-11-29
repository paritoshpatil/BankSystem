package Operations;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Services {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void newWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Services window = new Services();
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
	public Services() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 200, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLhcBankServices = new JLabel("LHC BANK SERVICES");
		lblLhcBankServices.setForeground(new Color(0, 153, 0));
		lblLhcBankServices.setFont(new Font("Noto Sans CJK SC Bold", Font.BOLD, 22));
		lblLhcBankServices.setBounds(106, 12, 220, 33);
		frame.getContentPane().add(lblLhcBankServices);
	}
}
