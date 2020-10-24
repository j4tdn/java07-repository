package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class JdbcConnection {
	private static final String url = "jdbc:mysql://localhost:3306/java07_shopping";
	private static final String user = "root";
	private static final String password = "123456";
	
	
	public static Connection getMySql() throws ClassNotFoundException {
		Connection connection = null ;
		try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(url, user, password);
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return connection;
	}

}
