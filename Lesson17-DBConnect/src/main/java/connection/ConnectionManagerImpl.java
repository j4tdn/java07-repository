package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManagerImpl implements ConnectionManager {
	private final ConfigurationProvider provider;

	 public ConnectionManagerImpl() {
		provider = new ConfigurationProviderImpl();
	}

	@Override
	public Connection getConnection() {
		Properties pro = provider.getProperties();
		Connection connection = null;
		try {
			Class.forName(pro.getProperty("driverClassName"));
			connection = DriverManager.getConnection(pro.getProperty("URL"),pro.getProperty("USER"),pro.getProperty("PASSWORD"));
			System.out.println("Ket noi thanh cong");
		} catch (Exception e) {
			System.out.println("ket noi that bai");
			e.printStackTrace();
		} 
		return connection;
	}
}