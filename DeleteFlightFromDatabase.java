package yeni;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class DeleteFlightFromDatabase {
	private String id;
	public DeleteFlightFromDatabase(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	public void del(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection baglanti=DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanagement_1","root","1234");
			System.out.println("Baglandi");
			String sorgu="DELETE FROM flightss WHERE ID=?";
			PreparedStatement komut = baglanti.prepareStatement(sorgu);
			komut.setString(1, id);
			komut.executeUpdate();
			String sorgu2="DELETE FROM arrivals WHERE id=?";
			PreparedStatement komut2=baglanti.prepareStatement(sorgu2);
			komut2.setString(1, id);
			komut2.executeUpdate();
			String sorgu3="DELETE FROM departures WHERE id=?";
			PreparedStatement komut3=baglanti.prepareStatement(sorgu3);
			komut3.setString(1, id);
			komut3.executeUpdate();
			
		}catch(ClassNotFoundException ex){
			ex.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
