package connection;

import java.sql.*;
import java.util.Properties;

public class ConnectionManagerImpl implements ConnectionManager {

	private final ConfigurationProvider provider;

	public ConnectionManagerImpl() {
		provider = new ConfigurationProviderImpl();
	}

	public Connection getConnection() {

		Properties props = new Properties();
		Connection connection = null;
		try {
			try {
				Class.forName(props.getProperty("driverClassName"));
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			connection = DriverManager.getConnection(props.getProperty("URL"), props.getProperty("USER"),
					props.getProperty("PASSWORD"));
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return connection;
	}

}
