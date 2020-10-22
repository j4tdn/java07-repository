package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public  class jdbcConnection {
	private static final String URL ="jdbc:mysql://localhost:3306/java07_shopping";
	private static final String USERNAME ="root";
	private static final String PASSWORD ="nhatphi010199";
	
	public static Connection getMySQL() {
		Connection connecion = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connecion = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (Exception e ) {
			e.printStackTrace();
		} finally {
			try {
				if (connecion != null) {
					connecion.close(); 
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connecion;
	}
}
