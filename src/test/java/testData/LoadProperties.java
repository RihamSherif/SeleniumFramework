package testData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
//load the properties file from the folder "userdata.properties"
	
	//public static Properties userData = loadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\userdata.properties");
	
	public static Properties userData = loadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\userdata.properties");
	
	private static  Properties loadProperties(String path)
	{
		Properties pro = new Properties();
		//stream for reading file
		try {
			FileInputStream stream = new FileInputStream(path);
			pro.load(stream);
		} catch (FileNotFoundException e) {
			System.out.println("Error Occured:" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error Occured:" + e.getMessage());
		}
		
	return pro;
	}
}
