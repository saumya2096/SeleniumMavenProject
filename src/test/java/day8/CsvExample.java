package day8;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import au.com.bytecode.opencsv.CSVReader;
import day5POM.LoginFactory;
import day5POM.WelcomeFactory;
import utils.ExcelReader;
import utils.basic;

public class CsvExample extends basic{
  @Test(dataProvider = "dp")
  public void f(String UN, String PWD) throws Exception
  {
	//CSVReader cs=new CSVReader(new FileReader())  
   
	  //CSVReader CS=new CSVReader(new FileReader(".//data.csv"));
	  
	//   List<String[]> allData = CS.readAll();  
	   
	 //  for(int i=1;i<allData.size();i++) {
	//	   String UN=allData.get(i)[0];
	//	   String PWD=allData.get(i)[1];
		   
		   driver.get("http://127.0.0.1:8080/htmldb");
		   LoginFactory Login=new LoginFactory(driver);
		   WelcomeFactory WF=new WelcomeFactory(driver);
		   Login.LoginProcess(UN, PWD);
		   try {
			WF.clickLogout();
			System.out.println("Login Pass");
		} catch (NoSuchElementException N) {
		
			System.out.println("Login Failed");
		}}
		   
	   
	   
	   @DataProvider
		public Object[][] dp() throws IOException {
		   Object[][] arrayData=null;
		   try {
		   CSVReader CS=new CSVReader(new FileReader(".//data.csv"));
			  
		   List<String[]> allData = CS.readAll();  
		   System.out.println(allData.size() -1);
		   
		   Object[][] data=new Object[allData.size() -1] [allData.get(0).length];
		   
		   for(int i=0; i < allData.size() -1; i++) {
			   
			   arrayData[i][0] = allData.get(i + 1)[0];
			   arrayData[i][1]= allData.get(i + 1)[1];
		   }
		   }catch (Exception e) {
			   
			   System.out.println(e);
		   }
		return arrayData;
	   
  }
}
