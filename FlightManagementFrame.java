package yeni;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class FlightManagementFrame extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane_1;
	private JTable table_2;
	private JTable table;
	ResultSet result;
	Statement statement ;
	private int sutunSayisi,satir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlightManagementFrame frame = new FlightManagementFrame();
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
	public FlightManagementFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 512);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(12, 27, 125, 84);
		label.setIcon(new ImageIcon("C:\\Users\\Ceren Keskin\\Desktop\\tav.png"));
		contentPane.add(label);
		
		tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(12, 178, 888, 255);
		contentPane.add(tabbedPane_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane_1.addTab("Arrivals", null, scrollPane_1, null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				satir=table.getSelectedRow();
				result=
			}
		});
		table.setRowHeight(25);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Flight No", "Arrival", "Arrival Date Time", "Airline"
			}
		));
		tab();
		scrollPane_1.setViewportView(table);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane_1.addTab("Departures", null, scrollPane, null);
		
		table_2 = new JTable();
		table_2.setRowHeight(25);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Flight No", "Destination", "Departure Date Time", "Airline"
			}
			
		));
		tab2();
		scrollPane.setViewportView(table_2);
		
		JButton btnNew = new JButton("New");
		btnNew.setBounds(642, 86, 78, 58);
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				AddFlightFrame pnc=new AddFlightFrame();
				pnc.setVisible(true);
			}
		});
		contentPane.add(btnNew);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(732, 86, 78, 58);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				UpdateFlightFrame pnc2=new UpdateFlightFrame();
				pnc2.setVisible(true);
			}
		});
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(822, 86, 78, 58);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				DeleteFlightFrame pnc3=new DeleteFlightFrame();
				pnc3.setVisible(true);
			}
		});
		contentPane.add(btnDelete);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				LoginFrame pnc1=new LoginFrame();
				pnc1.setVisible(true);
			}
		});
		btnLogout.setBounds(803, 27, 97, 25);
		contentPane.add(btnLogout);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
		        MenuFrame pnc=new MenuFrame();
		        pnc.setVisible(true); 
			}
		});
		btnHome.setBounds(687, 27, 97, 25);
		contentPane.add(btnHome);
		
		JTextPane textPane = new JTextPane();
		textPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		textPane.setBounds(22, 122, 145, 22);
		contentPane.add(textPane);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\Ceren Keskin\\Desktop\\arama-icon.png"));
		button.setBounds(179, 117, 33, 27);
		contentPane.add(button);
	}
	public  void tab(){
		try {
		      Connection baglanti=DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanagement_1","root","1234");
		      Class.forName("com.mysql.jdbc.Driver");
			  statement=(Statement) baglanti.createStatement();
		      result=statement.executeQuery("Select * from arrivals ");
		      sutunSayisi=result.getMetaData().getColumnCount();
		      DefaultTableModel table1=new DefaultTableModel();
		      for(int i=1;i<=sutunSayisi;i++)
		            table1.addColumn(result.getMetaData().getColumnName(i));
		      while(result.next()){
		              Object[] row=new Object[sutunSayisi];
		               for(int i=1;i<=sutunSayisi;i++)
		                  row[i-1]=result.getObject(i);
		              table1.addRow(row);
		         }
	
		      table.setModel(table1);
		      result.close();
		    }
		    catch (Exception ex) {
		        JOptionPane.showMessageDialog(null, "VeriTabani Baglanti Hatasi"); 
		    }
	}
	public  void tab2(){
		try {
		      Connection baglanti=DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanagement_1","root","1234");
		      Class.forName("com.mysql.jdbc.Driver");
			  statement=(Statement) baglanti.createStatement();
		      result=statement.executeQuery("Select * from departures ");
		      sutunSayisi=result.getMetaData().getColumnCount();
		      DefaultTableModel table1=new DefaultTableModel();
		      for(int i=1;i<=sutunSayisi;i++)
		            table1.addColumn(result.getMetaData().getColumnName(i));
		      while(result.next()){
		              Object[] row=new Object[sutunSayisi];
		               for(int i=1;i<=sutunSayisi;i++)
		                  row[i-1]=result.getObject(i);
		              table1.addRow(row);
		         }
	
		      table_2.setModel(table1);
		      result.close();
		    }
		    catch (Exception ex) {
		        JOptionPane.showMessageDialog(null, "VeriTabani Baglanti Hatasi"); 
		    }
	}

	public int getSatir() {
		return satir;
	}

	public void setSatir(int satir) {
		this.satir = satir;
	}
}
