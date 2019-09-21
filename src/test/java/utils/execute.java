package utils;

import org.testng.annotations.Test;

@Test
public class execute {
  public void f() {
	  ExcelReader ex=new ExcelReader(".//files//data.xls");
	  //  for(int i=0; i<= ex.getRowNum("sheet1"); i++) {
		//	  System.out.println(ex.getData("sheet1", 0, 1));
  //}
	  
	  String A[][]=ex. getAllData("Sheet1", 3, 2);
	  for(int i=0;i<A.length;i++) //reading row
	  {
		  for(int j=0;j<A[i].length;j++) //reading column
		  {
			  System.out.print(A[i][j]+ " ");
		  }
		  System.out.println();
	  }
  }
}