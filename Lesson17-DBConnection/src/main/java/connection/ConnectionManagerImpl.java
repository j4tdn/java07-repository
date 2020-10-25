package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

public class ConnectionManagerImpl implements ConnectionManager{
	
	private final ConfigurationProvider provider;
	public ConnectionManagerImpl() {
		provider = new ConfigurationProviderImpl();
	}
		
	
	@Override
	public Connection getConnection()  {
		Properties props = provider.getProperties();
		
		Connection connection = null ;
		try {
		Class.forName(props.getProperty("driverClassName"));
		connection = DriverManager.getConnection(props.getProperty("url"), props.getProperty("user"),props.getProperty("password"));
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		return connection;
	}

}

