package yeni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Users {
	private String kullaniciAdi,pass,role;
	public Users(String kullaniciAdi, String pass){
		this.kullaniciAdi=kullaniciAdi;
		this.pass=pass;
	}
	public String getKullaniciAdi() {
		return kullaniciAdi;
	}
	public String getPass() {
		return pass;
	}
	public String Search(){
		try{
			String name,password;
			Class.forName("com.mysql.jdbc.Driver");
			Connection baglanti=DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanagement_1","root","1234");
			String sorgu="SELECT userName,password,role FROM users";
			Statement komut = (Statement) baglanti.createStatement();
			ResultSet rs=komut.executeQuery(sorgu);
			while(rs.next()){
				name=rs.getString("userName");
				password=rs.getString("password");
				role=rs.getString("role");
				if(kullaniciAdi.equals(name) && pass.equals(password)){
					return role;
				}
			}
			
		}catch(ClassNotFoundException ex){
			ex.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}
