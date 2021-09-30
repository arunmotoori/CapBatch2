package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public Properties prop = null;
	public WebDriver driver = null;
	
	public void openBrowserAndURL(String browserName) throws IOException {
		
		loadPropertiesFile();
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}else if(browserName.equalsIgnoreCase("ie")) {
			
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			
		}else if(browserName.equalsIgnoreCase("edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}else if(browserName.equalsIgnoreCase("opera")) {
			
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
	public void loadPropertiesFile() throws IOException {
		
		prop = new Properties();
		
		File file = new File("C:\\QAFox Drive\\cgw5\\SelePOMPFProj\\ProjectData.properties");
		
		FileInputStream fis = new FileInputStream(file);
		
		prop.load(fis);
	
	}
	
	public String getTimeStamp() {
		
		Date date = new Date();
		
		return date.toString().replace(" ","_").replace(":","_");
		
	}

}
