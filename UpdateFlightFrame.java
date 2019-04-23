package yeni;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.util.LinkedList;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class UpdateFlightFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateFlightFrame frame = new UpdateFlightFrame();
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
	public UpdateFlightFrame() {
		setForeground(Color.BLACK);
		setTitle("FLIGHT MANAGEMENT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 512);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Ceren Keskin\\Desktop\\tav.png"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(12, 23, 162, 87);
		contentPane.add(label);
		
		JLabel lblSelectFlight = new JLabel("Select Flight");
		lblSelectFlight.setBounds(218, 173, 113, 16);
		contentPane.add(lblSelectFlight);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(Color.WHITE);
		textPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		textPane.setBounds(182, 253, 141, 22);
		contentPane.add(textPane);
		
		JLabel lblFlightDate = new JLabel("Departure Date");
		lblFlightDate.setBounds(71, 253, 103, 16);
		contentPane.add(lblFlightDate);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		textPane_1.setBounds(552, 253, 149, 22);
		contentPane.add(textPane_1);
		
		JLabel lblFlightTime = new JLabel("Departure Time");
		lblFlightTime.setBounds(437, 253, 103, 22);
		contentPane.add(lblFlightTime);
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		textPane_3.setBounds(552, 301, 149, 22);
		contentPane.add(textPane_3);
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		textPane_2.setBackground(Color.WHITE);
		textPane_2.setBounds(182, 301, 141, 22);
		contentPane.add(textPane_2);
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		
	    comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setForeground(Color.BLACK);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(304, 170, 186, 22);
		FlightsFromDatabase fli=new FlightsFromDatabase();
		LinkedList<String> arr;
		arr=fli.fly();
		for(String item:arr){
			comboBox.addItem(item);
			
		}
		comboBox.setEditable(true);
		contentPane.add(comboBox);
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FlightUpdateInDatabase upd=new FlightUpdateInDatabase(comboBox.getSelectedItem().toString(), textPane_2.getText(), textPane_3.getText(),textPane.getText(), textPane_1.getText());
				upd.up();
			}
		});
		btnSave.setBounds(365, 350, 97, 48);
		contentPane.add(btnSave);
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FlightManagementFrame pnc2=new FlightManagementFrame();
				pnc2.setVisible(true);
			}
		});
		
		btnHome.setBounds(683, 23, 97, 25);
		contentPane.add(btnHome);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginFrame pnc2=new LoginFrame();
				pnc2.setVisible(true);
			}
		});
		btnLogout.setBounds(792, 23, 97, 25);
		contentPane.add(btnLogout);
		
		
		
		JLabel lblArrivalDate = new JLabel("Arrival Date");
		lblArrivalDate.setBounds(71, 307, 103, 16);
		contentPane.add(lblArrivalDate);
		
		
		
		JLabel lblArrivalTime = new JLabel("Arrival Time");
		lblArrivalTime.setBounds(437, 301, 103, 22);
		contentPane.add(lblArrivalTime);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane}));
	}
}
