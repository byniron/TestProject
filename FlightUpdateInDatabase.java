package yeni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FlightUpdateInDatabase {
	private String id,arrDate,depDate,arrTime,depTime;
	public FlightUpdateInDatabase(String id,String arrDate,String arrTime,String depDate,String depTime){
		this.id=id;
		this.arrDate=arrDate;
		this.arrTime=arrTime;
		this.depDate=depDate;
		this.depTime=depTime;
	}
	public String getId() {
		return id;
	}
	public String getArrDate() {
		return arrDate;
	}
	public String getArrTime() {
		return arrTime;
	}
	public String getDepDate() {
		return depDate;
	}
	public String getDepTime() {
		return depTime;
	}
	
	public void up(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection baglanti=DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanagement_1","root","1234");
			String sorgu="UPDATE flightss SET date=? WHERE id=?";
			java.sql.PreparedStatement komut = baglanti.prepareStatement(sorgu);
			komut.setString(1, depDate);
			komut.setString(2, id);
			komut.executeUpdate();
			String sorgu2="UPDATE arrivals SET arrivalDate=?,time=? WHERE id=?";
			java.sql.PreparedStatement komut2 = baglanti.prepareStatement(sorgu2);
			komut2.setString(1, arrDate);
			komut2.setString(2, arrTime);
			komut2.setString(3, id);
			komut2.executeUpdate();
			String sorgu3="UPDATE departures SET departureDate=?, time=? WHERE id=?";
			java.sql.PreparedStatement komut3 = baglanti.prepareStatement(sorgu3);
			komut3.setString(1, depDate);
			komut3.setString(2, depTime);
			komut3.setString(3, id);
			komut3.executeUpdate();
			baglanti.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("not inserted!");
		}
	}
}
