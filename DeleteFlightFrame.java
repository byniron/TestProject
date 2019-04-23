package yeni;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class DeleteFlightFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteFlightFrame frame = new DeleteFlightFrame();
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
	@SuppressWarnings("unchecked")
	public DeleteFlightFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 514);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ceren Keskin\\Desktop\\tav.png"));
		lblNewLabel.setBounds(24, 13, 155, 87);
		contentPane.add(lblNewLabel);
		
		
		JLabel lblSelectFlightId = new JLabel("Select Flight Id");
		lblSelectFlightId.setBounds(39, 189, 126, 16);
		contentPane.add(lblSelectFlightId);
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(177, 186, 142, 22);
		FlightsFromDatabase fli=new FlightsFromDatabase();
		LinkedList<String> arr;
		arr=fli.fly();
		for(String item:arr){
			comboBox.addItem(item);
			
		}
		contentPane.add(comboBox);
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteFlightFromDatabase del=new DeleteFlightFromDatabase(comboBox.getSelectedItem().toString());
				del.del();
				JOptionPane.showMessageDialog(null, "Delete success!");
			}
		});
		btnDelete.setBounds(197, 267, 97, 25);
		contentPane.add(btnDelete);
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FlightManagementFrame pnc2=new FlightManagementFrame();
				pnc2.setVisible(true);
			}
		});
		btnHome.setBounds(680, 32, 97, 25);
		contentPane.add(btnHome);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginFrame pnc2=new LoginFrame();
				pnc2.setVisible(true);
			}
		});
		btnLogout.setBounds(789, 32, 97, 25);
		contentPane.add(btnLogout);
	}
}
