package library;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {
	private String file;
	private Properties pro;
	private FileInputStream input;
	private String value;
 
	public PropertiesManager() {
		pro = new Properties();
		file = "resources/application.properties";
	}
 
	public String getPropertyValue(String key) throws IOException {
		input = new FileInputStream(file);
		pro.load(input);
		value = pro.getProperty(key);
		return value;
	}
	
//	public static void main(String[] args) throws IOException {
//		PropertiesManager pro = new PropertiesManager();
//		System.out.println(pro.getPropertyValue("url"));
//		
//	}


}
