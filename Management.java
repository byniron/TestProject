package yeni;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Management extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Management frame = new Management();
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
	public Management() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 514);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Ceren Keskin\\Desktop\\tav-airports.png"));
		label.setBounds(242, 24, 539, 175);
		contentPane.add(label);
		
		JButton btnUserManagement = new JButton("User Management");
		btnUserManagement.setBounds(94, 248, 150, 64);
		contentPane.add(btnUserManagement);
		
		JButton btnAirlineManagement = new JButton("Airline Management");
		btnAirlineManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AirlineManagementFrame pnc=new AirlineManagementFrame();
				pnc.setVisible(true);
			}
		});
		btnAirlineManagement.setBounds(285, 248, 155, 64);
		contentPane.add(btnAirlineManagement);
		
		JButton btnCityManagement = new JButton("City Management");
		btnCityManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				CityManagementFrame pnc=new CityManagementFrame();
				pnc.setVisible(true);
			}
		});
		btnCityManagement.setBounds(482, 248, 161, 64);
		contentPane.add(btnCityManagement);
		
		JButton btnRoleManagement = new JButton("Role Management");
		btnRoleManagement.setBounds(674, 248, 140, 64);
		contentPane.add(btnRoleManagement);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginFrame lg=new LoginFrame();
				lg.setVisible(true);
			}
		});
		btnLogout.setBounds(455, 354, 175, 46);
		contentPane.add(btnLogout);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuFrame pnc=new MenuFrame();
				pnc.setVisible(true);
			}
		});
		btnHome.setBounds(266, 354, 174, 46);
		contentPane.add(btnHome);
	}
}
