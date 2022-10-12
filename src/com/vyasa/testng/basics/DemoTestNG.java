package com.vyasa.testng.basics;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoTestNG {
  @Test(alwaysRun=true,dependsOnGroups={"Regression"})
  public void TestCase1 () { 
	  System.out.println("Testcase 1 executed");
	  	  
  }
	  
  @Test(groups={"sanity"},dependsOnMethods={"TestCase3"})
  public void TestCase2 () { 
	  System.out.println("Testcase2 executed");
	  	  
  }
  
  @Test(groups={"Regression"})
  public void TestCase3() { 
	  
	  System.out.println("Testcase 3 executed");
	  Assert.assertTrue(false);
  }
  
  @Test(groups={"Regression","Sanity"})
  public void TestCase4 () { 
	  System.out.println("Testcase4 executed");
	  	  
  }
  @Test(groups={"Regression"},invocationCount=2,invocationTimeOut=500)
  public void TestCase5 () { 
	  System.out.println("Testcase 5executed");
	  	  
  }
  
	      
  @Test(priority=1)
  public void TestCase6 () { 
	  System.out.println("Testcase 6 executed");
	  	  
  }
  @Test (priority=2,groups={"sanity"})
  public void TestCase7 () { 
	  System.out.println("Testcase 7 executed");
	  	  
  }
  @Test (priority=3,groups={"sanity"})
  public void TestCase8 () { 
	  System.out.println("Testcase8 executed");
	  	  
  }
  @Test(priority=4,description="testcase to verify cartis displayed")
  public void TestCase9 () { 
	  System.out.println("Testcase 9 executed");
	  	  
  }
  @Test(enabled=false,priority=5,groups={"sanity"})
  public void TestCase10 () { 
	  System.out.println("Testcase10 executed");
	  	  
  }
  @Test(priority=6,groups={"sanity"})
  public void TestCase11 () { 
	  System.out.println("Testcase 11 executed");
	  	  
  }
  @Test(groups={"Regression"})
  public void TestCase12 () { 
	  System.out.println("Testcase 12 executed");
	  	  
  }
  
	  
	  
  }

