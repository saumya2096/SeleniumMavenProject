package day8;

import org.testng.annotations.Test;

public class GroupingExample {
  @Test(groups= {"smoke","regression"})
  public void f1() {
	  
	  System.out.println("In smoke and regression");
  }
  @Test(groups= {"regression"})
  public void f2() {
	  System.out.println("in regression");
}
  @Test(groups= {"smoke"})
  public void f3() {
	  System.out.println("In smoke");
  }
  @Test(groups= {"sanity"})
  public void f4() {
	  System.out.println("in sanity");
  }
  }