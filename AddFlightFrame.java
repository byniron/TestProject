package yeni;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Statement;

import connectToServer.FlightInsertToDatabase;
import models.Flight;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AddFlightFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFlightFrame frame = new AddFlightFrame();
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
	public AddFlightFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 512);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(225, 157, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection baglanti=DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanagement_1","root","1234");
			String sorgu="SELECT name FROM cities";
			Statement komut = (Statement) baglanti.createStatement();
			ResultSet rs=komut.executeQuery(sorgu);
			while(rs.next()){
				comboBox.addItem(rs.getString("name"));
			}
		}catch(ClassNotFoundException ex){
			ex.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		comboBox.setOpaque(false);
		comboBox.setEditable(true);
		comboBox.setBounds(225, 208, 116, 22);
		contentPane.add(comboBox);
		
		JLabel lblFlightNo = new JLabel("Flight No");
		lblFlightNo.setBounds(146, 159, 80, 19);
		contentPane.add(lblFlightNo);
		
		JLabel lblOrigin = new JLabel("Origin");
		lblOrigin.setBounds(146, 210, 80, 19);
		contentPane.add(lblOrigin);
		
		JLabel lblArrDate = new JLabel("Arr. Date");
		lblArrDate.setBounds(463, 159, 70, 19);
		contentPane.add(lblArrDate);
		
		textField_1 = new JTextField();
		textField_1.setBounds(545, 157, 150, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(545, 192, 150, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblArrTime = new JLabel("Arr. Time");
		lblArrTime.setBounds(463, 195, 56, 16);
		contentPane.add(lblArrTime);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox_1 = new JComboBox();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection baglanti=DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanagement_1","root","1234");
			String sorgu="SELECT name FROM airlines";
			Statement komut = (Statement) baglanti.createStatement();
			ResultSet rs=komut.executeQuery(sorgu);
			while(rs.next()){
				comboBox_1.addItem(rs.getString("name"));
			}
		}catch(ClassNotFoundException ex){
			ex.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		comboBox_1.setEditable(true);
		comboBox_1.setBounds(545, 228, 150, 22);
		contentPane.add(comboBox_1);
		
		JLabel lblAirline = new JLabel("Airline");
		lblAirline.setBounds(463, 231, 56, 16);
		contentPane.add(lblAirline);
		
		JLabel lblArrivalInformation = new JLabel("Arrival Information");
		lblArrivalInformation.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblArrivalInformation.setBounds(346, 104, 141, 22);
		contentPane.add(lblArrivalInformation);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Ceren Keskin\\Desktop\\tav.png"));
		label.setBounds(12, 13, 141, 86);
		contentPane.add(label);
		
		JLabel lblDepartureInformation = new JLabel("Departure Information");
		lblDepartureInformation.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDepartureInformation.setBounds(346, 297, 167, 22);
		contentPane.add(lblDepartureInformation);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox_2 = new JComboBox();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection baglanti=DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanagement_1","root","1234");
			String sorgu="SELECT name FROM cities";
			Statement komut = (Statement) baglanti.createStatement();
			ResultSet rs=komut.executeQuery(sorgu);
			while(rs.next()){
				comboBox_2.addItem(rs.getString("name"));
			}
		}catch(ClassNotFoundException ex){
			ex.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		comboBox_2.setEditable(true);
		comboBox_2.setBounds(225, 397, 116, 22);
		contentPane.add(comboBox_2);
		
		JLabel lblDeparture = new JLabel("Departure");
		lblDeparture.setBounds(146, 400, 80, 16);
		contentPane.add(lblDeparture);
		
		textField_4 = new JTextField();
		textField_4.setBounds(545, 343, 150, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblDepDate = new JLabel("Dep. Date");
		lblDepDate.setBounds(463, 346, 70, 16);
		contentPane.add(lblDepDate);
		
		textField_5 = new JTextField();
		textField_5.setBounds(545, 378, 150, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblDepTime = new JLabel("Dep. Time");
		lblDepTime.setBounds(463, 381, 70, 16);
		contentPane.add(lblDepTime);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Flight fly=new Flight(textField.getText(),comboBox.getSelectedItem().toString(),comboBox_2.getSelectedItem().toString(),comboBox_1.getSelectedItem().toString(),textField_1.getText(),textField_2.getText(),textField_5.getText(),textField_4.getText());
				FlightInsertToDatabase ekle=new FlightInsertToDatabase();
				ekle.baglanti(fly);
				JOptionPane.showMessageDialog(null, "Insert success!");			}
		});
		
		btnSave.setBounds(763, 251, 108, 68);
		contentPane.add(btnSave);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(225, 346, 116, 22);
		contentPane.add(textField_3);
		
		JLabel label_1 = new JLabel("Flight No");
		label_1.setBounds(146, 345, 80, 19);
		contentPane.add(label_1);
		
		@SuppressWarnings("rawtypes")
		JComboBox comboBox_3 = new JComboBox();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection baglanti=DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanagement_1","root","1234");
			String sorgu="SELECT name FROM airlines";
			Statement komut = (Statement) baglanti.createStatement();
			ResultSet rs=komut.executeQuery(sorgu);
			while(rs.next()){
				comboBox_3.addItem(rs.getString("name"));
			}
		}catch(ClassNotFoundException ex){
			ex.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		comboBox_3.setEditable(true);
		comboBox_3.setEditable(true);
		comboBox_3.setBounds(545, 413, 150, 22);
		contentPane.add(comboBox_3);
		
		JLabel label_2 = new JLabel("Airline");
		label_2.setBounds(463, 416, 56, 16);
		contentPane.add(label_2);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginFrame pnc2=new LoginFrame();
				pnc2.setVisible(true);
			}
		});
		btnLogout.setBounds(795, 13, 97, 25);
		contentPane.add(btnLogout);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				FlightManagementFrame pnc2=new FlightManagementFrame();
				pnc2.setVisible(true);
			}
		});
		btnHome.setBounds(686, 13, 97, 25);
		contentPane.add(btnHome);
	}
}
