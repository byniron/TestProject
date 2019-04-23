package yeni;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.Font;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

@SuppressWarnings("serial")
public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setTitle("FLIGHT MANAGEMENT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 512);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(244, 204, 119, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(244, 246, 99, 16);
		contentPane.add(lblNewLabel_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		textPane.setBounds(355, 204, 126, 25);
		contentPane.add(textPane);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new LineBorder(Color.BLACK));
		passwordField.setBounds(355, 242, 126, 25);
		contentPane.add(passwordField);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Ceren Keskin\\Desktop\\tav.png"));
		label.setBounds(344, 108, 137, 89);
		contentPane.add(label);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = textPane.getText();
				String pass = String.valueOf(passwordField.getPassword()); 
				Users usr=new Users(user,pass);
				String role_2=usr.Search();
		        if (role_2!=null) {
				    dispose();
			        MenuFrame pnc=new MenuFrame();
			        pnc.setRole(role_2);
			        pnc.setVisible(true);                
			         
				} else {
				    JOptionPane.showMessageDialog(null, "Login Failed!");
				}
			}
		});
		btnLogin.setBounds(358, 300, 97, 25);
		contentPane.add(btnLogin);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textPane, passwordField, btnLogin}));
	}
}
