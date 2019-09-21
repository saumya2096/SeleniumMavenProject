package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class basic {
	public WebDriver driver;
	Properties prop; 
	
	 @BeforeTest
	  public void beforeTest() throws FileNotFoundException, IOException {
		 Properties prop=new Properties();
		  prop.load(new FileInputStream(".//settings.property"));
		  
		//  System.out.println(prop.getProperty("url"));
		  
		  if(prop.getProperty("browser").equals("chrome"))
		  {
			  System.setProperty("webdriver.chrome.driver",".//driver//chromedriver.exe");
			  driver= new ChromeDriver();
			  
			  
		  }
		  else if(prop.getProperty("browser").equals("firefox"))
		  {
			  System.setProperty("webdriver.gecko.driver", ".//driver//geckodriver.exe");
			  driver=new FirefoxDriver();
			  
		  }
		  
		 //pre conditions
		//  System.setProperty("webdriver.chrome.driver",".//driver//chromedriver.exe");
		  // driver=new ChromeDriver();
	  }

	  @AfterTest
	  public void afterTest() throws InterruptedException {
		  Thread.sleep(4000);
		//  driver.quit();
	  }
}
