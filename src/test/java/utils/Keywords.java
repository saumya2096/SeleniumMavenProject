package utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Keywords
{
	WebDriver driver;
 public Keywords(WebDriver driver)
 {
	 this.driver = driver;
 }
 public void getURL(String URL) {
	 driver.get(URL);
 }
 
 public void closeBrowser() {
	 driver.quit();
	 
 }
 
 public void clear1(String Locator) {
	 getElement(Locator).clear();
 }
 
 
 public void type(String Locator, String data) {
	 //id:=P11_USERNAME
	 getElement(Locator).sendKeys(data);
 }
 
 public void click(String Locator) {
	 getElement(Locator).click();
 }
 public void takeScreenshot(String LocationWithName)
 {
	 TakesScreenshot screen=(TakesScreenshot)driver;
	 File src= screen.getScreenshotAs(OutputType.FILE);
	 Date date=new Date() ;
	 String newDate=date.toString().replaceAll(" ", "_").replaceAll(":", "_ ");
	 System.out.println(newDate);
	 try {
		FileHandler.copy(src, new File(".//bing"+newDate+".png"));
	} catch (IOException e) {
		System.out.println("exception occured");
	}}
	 
	 
 public void dropDownSelect(String Locator, String data)
	 
	 {
		Select s=new Select( getElement(Locator));
		s.selectByVisibleText(data);
		}
		 
	 
	 private WebElement getElement(String Locator) {
	 String LocatorType= Locator.split(":=")[0];
	 String LocatorValue= Locator.split(":=")[1];
	 WebElement E=null;
	 switch(LocatorType) {
 case "id":
	 E=driver.findElement(By.id(LocatorValue));
	 break;
 case "name":
	E= driver.findElement(By.name(LocatorValue));
	 break;
 case "css":
	 E=driver.findElement(By.cssSelector(LocatorValue));
	 break;
 case "xpath":
	E= driver.findElement(By.xpath(LocatorValue));
	 break;
 case "link":
	E= driver.findElement(By.linkText(LocatorValue));
	 break;
	 default:
		 System.out.println("invalid locator");
	 
	 }
	return E;
	 }}

