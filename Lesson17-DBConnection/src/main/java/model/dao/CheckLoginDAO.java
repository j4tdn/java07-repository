package model.dao;

import java.sql.*;
import java.util.ArrayList;

import model.bean.Wife;

public class CheckLoginDAO {
	
	
	public boolean isExistUser(String userName,String passWord)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/ltm";
			Connection conn = DriverManager.getConnection("billeeloan21980108");
			Statement stmt=conn.createStatement();  
			String sql = "select * from login where username='" + userName +
					"' and pass='" + passWord + "'";
			ResultSet rs= stmt.executeQuery(sql);
			if (rs.next()) {
				return true;
			} 
			} catch (Exception e) {
			System.out.println("SQLException caught: " + e.getMessage());
			}
		return false;
	}		
	public ArrayList<Wife> getWifeList(String userName)
	{
		ArrayList<Wife> result = new ArrayList<Wife>();
		String name,address;
		boolean alive;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/ltm";System.out.println("á");
			Connection conn = DriverManager.getConnection(url,"root","billeeloan21980108");
			Statement stmt=conn.createStatement();  
			System.out.println("ad");
			String sql = "select * from login";
			ResultSet rs= stmt.executeQuery(sql);
			if (rs.next()) {
				name =rs.getString(1);
				address = rs.getString(3);
				alive = rs.getBoolean(4);
				
				Wife wife = new Wife();
				wife.setName(name);
				wife.setAddress(address);
				wife.setAlive(alive);
				result.add(wife);		
			} 
			} catch (Exception e) {
			System.out.println("SQLException caught: " + e.getMessage());
			}
		return result;
	}
}
