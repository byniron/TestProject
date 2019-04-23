package yeni;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;

public class Search {
	ResultSet result;
	private String id,tableName;
	public Search(String id,String tableName){
		this.id=id;
		this.tableName=tableName;
	}
	public String getId(){
		return id;
	}
	public String getTableName(){
		return tableName;
	}
	public void src(String id){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection baglanti=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/flightmanagement_1","root","1234");
			String sorgu="SELECT FROM='"+tableName+"'WHERE id=?";
			result=
			
		}
	}
}
