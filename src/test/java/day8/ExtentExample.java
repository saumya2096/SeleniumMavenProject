package day8;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utils.basic;

public class ExtentExample extends basic{
	  ExtentReports ex;
  @Test(priority=1)
  public void f() {
	  ExtentHtmlReporter html= new ExtentHtmlReporter("Oracle.html");
	  html.setAppendExisting(true);

	  
	ex=new ExtentReports();
	  ex.attachReporter(html);
	  
	  ExtentTest LoginLog=ex.createTest("Login");
	  LoginLog.assignAuthor("saumya");
	  
	  LoginLog.info("Opening URL");
	  driver.get("http://127.0.0.1:8080/htmldb");
	  LoginLog.info("Typing UN & PWD");
	  driver.findElement(By.name("p_t01")).sendKeys("sys");
	  driver.findElement(By.name("p_t02")).sendKeys("Newuser123");
	  driver.findElement(By.xpath("//*[@value='Login']")).click();
	  Assert.assertEquals(driver.getTitle(),"Oracle");
	  LoginLog.pass("Login Success");
	//  driver.findElement(By.xpath("//*[text()='Logout']")).click();
	 
	  
	  //extentreports.com /doc/version4/basic usage
	  
  }
  @Test(priority=2,dependsOnMethods= {"f"})
  public void autoCommit() throws IOException {
	  ExtentTest auto=ex.createTest("AutoCommit");
	  auto.info("clicking on SQL & SQL commands");
	  
	  driver.findElement(By.xpath("//*[text()='SQL']")).click();
	  driver.findElement(By.xpath("//*[text()='SQL Commands']")).click();
	  WebElement E=driver.findElement(By.name("p_v02"));
	  auto.info("Checking status about selection");
	  
	  Assert.assertEquals((E.isSelected()), true);
	  Assert.assertTrue(E.isSelected());
	  auto.pass("AutoCommit Passed");
	  
	 File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 FileHandler.copy(src, new File(".//Autocommit.png"));
	 auto.addScreenCaptureFromPath(".//Autocommit.png");
	  
	  ex.flush(); //exporting report 
	  
	  
	  
  }
}
