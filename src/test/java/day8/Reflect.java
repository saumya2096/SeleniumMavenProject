package day8;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.testng.annotations.Test;

public class Reflect {
  @Test
  public void f() throws Exception {
	  
	  Class CL=Class.forName("import org.openqa.selenium.chrome.ChromeDriver;");
	  
	  Field[] FD=CL.getDeclaredFields();
	  for(Field F: FD) {
		  System.out.println(F.getName());
	  }
	  
	  System.out.println(CL.getSuperclass());
	  //WebDriver is interface which is implemented by remote driver and extended by chrome driver
     
	  Method[] MD=CL.getMethods();
	  for (Method M: MD) {
		  System.out.println(M.getName());
	  }
  
  
  }
}
