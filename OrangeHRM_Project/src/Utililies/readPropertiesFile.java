package Utililies;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class readPropertiesFile {

	public static String getMyProperty(String key) throws IOException {

		Properties prop = new Properties();
		FileInputStream fi = new FileInputStream(System.getProperty("user.dir") + "\\PropertiesFiles\\Test1.properties");
		prop.load(fi);
		String data = prop.getProperty(key);
		return data;
	}
}
