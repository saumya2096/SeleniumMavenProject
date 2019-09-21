package day8;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import com.graphbuilder.math.func.Function;

import utils.basic;

public class FluentWaitExample extends basic{
  @Test
  public void f() {
	  driver.get("http://bing.com");
	  
	  Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		       .withTimeout(30, TimeUnit.SECONDS)
		       .pollingEvery(5, TimeUnit.SECONDS)
		       .ignoring(NoSuchElementException.class);

	  Wait<WebDriver> wait2 = new FluentWait<WebDriver>(driver)
		       .withTimeout(Duration.ofSeconds(30))
		       .pollingEvery(Duration.ofSeconds(5))
		       .ignoring(NoSuchElementException.class);
	  
		//   WebElement foo = wait2.until(new Function<WebDriver, WebElement>()
		  // {
		    // public WebElement apply(WebDriver driver) {
		      // return driver.findElement(By.id("q"));
		     //}
		   //});
		   //implementation technique is of anonymous classes
		   
  }
}
