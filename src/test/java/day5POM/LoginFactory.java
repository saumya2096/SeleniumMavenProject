package day5POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFactory {
 public	LoginFactory(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

@FindBy(css="input[value='Getting Started']") WebElement e_loginbutton;
//WebElement e_un;

WebElement p_t01;
WebElement p_t02;

public void LoginProcess(String UN, String PWD) {
	p_t01.sendKeys(UN);
	p_t02.sendKeys(PWD);
	e_loginbutton.click();
	
}


}
