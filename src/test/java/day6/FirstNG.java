package day6;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.basic;

public class FirstNG extends basic{
  @Test
  public void f() throws MalformedURLException {
	 // Keywords Key=new Keywords(driver);
	  
	  driver.get("http://agiletestingalliance.org/");
	  
	 driver.findElement(By.xpath("//a[contains(text(),'Certifications')]")).click();
	 
   	List<WebElement>	allcourse =driver.findElements(By.tagName("area"));
	System.out.println("Total courses are "+ allcourse.size()); 
  
   String url=  driver.findElement(By.xpath("/html/body/section/div/div[2]/map/area[5]")).getAttribute("href");
     System.out.println("href of cp sat is " +url);
  }
}
