package day5POM;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.ExcelReader;
import utils.basic;

public class executePOM extends basic {
  @Test(enabled=false)
  public void f() {
	  
	  driver.get("http://127.0.0.1:8080/htmldb");
	  LoginPOM login=new LoginPOM(driver);
	  login.loginProcess("system","Newuser123");
	  Assert.assertEquals(driver.getTitle(), "Oracle","LoginFailed");
	  
	  WelcomePOM welcome=new WelcomePOM(driver);
	  welcome.logoutClick();
	  
  }
  
  @Test(dataProvider="dp",enabled=true,description="It is using page factory method")
  public void f2(String UN,String PWD) {
	  
	  driver.get("http://127.0.0.1:8080/htmldb");
	  LoginFactory LF=new LoginFactory(driver);
	  LF.LoginProcess(UN,PWD);
	  Assert.assertEquals(driver.getTitle(), "Oracle","LoginFailed");
	  
	  WelcomeFactory welcome1=new WelcomeFactory(driver);
	  welcome1.clickLogout();
	 }
  
  @DataProvider
  public Object[][] dp()
  {
	  ExcelReader ex= new ExcelReader(".//files//data.xls");
	  Object data[][]=ex.getAllData("sheet1", 4, 2);
	return data;
  }
  
  
}
