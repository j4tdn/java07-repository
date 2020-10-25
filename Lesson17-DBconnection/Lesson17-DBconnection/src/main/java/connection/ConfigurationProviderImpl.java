package connection;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationProviderImpl implements ConfigurationProvider{

	public Properties getProperties() {
		Properties props = new Properties();
		FileInputStream input = null;
		try {
			File file = new File("config.properties");
			input = new FileInputStream(file);
			props.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if (input != null) {
					input.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return props;
	}
	
}
