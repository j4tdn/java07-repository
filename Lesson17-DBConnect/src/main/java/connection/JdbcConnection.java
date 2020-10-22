package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection 
{
	private static final String URL ="jdbc:mysql://localhost:3306/java07_shopping";
	private static final String USER ="root";
	private static final String PASSWORD ="123456";
	
	public static Connection getMySQL() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER,PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(connection !=null) {
					connection.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return connection;
	}
	public static void main(String[] args) {
		Connection connection =getMySQL();
		System.out.println(connection);
	}
}
