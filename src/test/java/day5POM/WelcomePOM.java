package day5POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePOM
{
	WebDriver driver;
	
	WelcomePOM(WebDriver driver){
		this.driver=driver;
	}
	
	By e_logout= By.linkText("logout");
	
	public void logoutClick() {
		driver.findElement(e_logout).click();
	}
	
}
