package day5POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class WelcomeFactory {
	public WelcomeFactory(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Logout")
	WebElement e_logout;
	
	public void clickLogout() {
		
		e_logout.click();
	}

}
