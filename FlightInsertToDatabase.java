package yeni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FlightInsertToDatabase {
	private String id,arrival,departure,arrDate,airline,depDate,arrTime,depTime;
	public FlightInsertToDatabase(String id,String arrival,String departure,String airline,String arrDate,String arrTime,String depTime,String depDate){
		this.id=id;
		this.arrival=arrival;
		this.departure=departure;
		this.airline=airline;
		this.arrDate=arrDate;
		this.arrTime=arrTime;
		this.depTime=depTime;
		this.depDate=depDate;
	}
	public String getId() {
		return id;
	}

	public String getArrival() {
		return arrival;
	}

	public String getDeparture() {
		return departure;
	}

	public String getArrDate() {
		return arrDate;
	}

	public String getAirline() {
		return airline;
	}

	public String getDepDate() {
		return depDate;
	}

	public String getArrTime() {
		return arrTime;
	}

	public String getDepTime() {
		return depTime;
	}
	public void baglanti(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection baglanti=DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanagement_1","root","1234");
			String sorgu="INSERT INTO flightss(Id,Arrival,Departure,Airline,Date)"+"VALUES(?,?,?,?,?)";
			PreparedStatement komut =baglanti.prepareStatement(sorgu);
			komut.setString(1, id);
			komut.setString(2, arrival);
			komut.setString(3, departure);
			komut.setString(3, airline);
			komut.setString(4, depDate);
			komut.executeUpdate();
			String sorgu2="INSERT INTO arrivals(id,arrival,airline,arrivalDate,time)"+"VALUES(?,?,?,?,?)";
			PreparedStatement komut2=baglanti.prepareStatement(sorgu2);
			komut2.setString(1, id);
			komut2.setString(2, arrival);
			komut2.setString(3, airline);
			komut2.setString(4, arrDate);
			komut2.setString(5, arrTime);
			komut2.executeUpdate(sorgu2);
			String sorgu3="INSERT INTO departures(id,departure,airline,departureDate,time)"+"VALUES(?,?,?,?,?)";
			PreparedStatement komut3=baglanti.prepareStatement(sorgu3);
			komut3.setString(1, id);
			komut3.setString(2, departure);
			komut3.setString(3, airline);
			komut3.setString(4, depDate);
			komut3.setString(5, depTime);
			komut3.executeUpdate(sorgu3);
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
