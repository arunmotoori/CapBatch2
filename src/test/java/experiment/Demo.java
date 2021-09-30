package experiment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Demo {

	public static void main(String[] args) throws IOException {
		
		Properties prop = new Properties();
		
		File propFile = new File("C:\\QAFox Drive\\cgw5\\SelePOMPFProj\\ProjectData.properties");
		
		FileInputStream fis = new FileInputStream(propFile);
		
		prop.load(fis);
		
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("validEmailAddress"));
		System.out.println(prop.getProperty("validPassword"));
		System.out.println(prop.getProperty("InvalidPassword"));
	}

}
