package com.vyasa.testng.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
	WebDriver driver;
	
  @BeforeClass
  public void OpenBrowser() {
	  System.setProperty("webdriver.chrome.driver","D:\\javaautomation\\TestNGAutomation\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://practice.automationtesting.in/my-account/");
		driver.manage().window().maximize();
		
	}
	
 	
	
  @Test(dataProvider="LoginData")
  public void  VerifyUserLogin(String tcName,String username,String password){
	  WebElement userEle=driver.findElement(By.xpath("//input[@name=\"username\"]"));
	  userEle.clear();
	  userEle.sendKeys(username);
	  WebElement passEle=driver.findElement(By.xpath("(//input[@name=\"password\"])[1]"));
	  passEle.clear();
	  passEle.sendKeys(password);
	driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
  
			  
			  //validation
	if(tcName.equalsIgnoreCase("blank"))
	{
		String errormsg=driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li")).getText();
		Assert.assertEquals(errormsg, "Error: Username is required.");
			
	}else if(tcName.equalsIgnoreCase("blankpass"))
	{
		String errormsg=driver.findElement(By.xpath("//li[contains(text(), \"Password is required.\")]")).getText();
		Assert.assertEquals(errormsg, "Error: Password is required.");
		
	}else if(tcName.equalsIgnoreCase("wrongcredentials"))
	{
		String errormsg=driver.findElement(By.xpath("//li[contains(text(), \" A user could not be found with this email address.\")]")).getText();
		Assert.assertEquals(errormsg, "Error: A user could not be found with this email address.");
	}else if(tcName.equalsIgnoreCase("sucesslogin"))
	{
		boolean disply=driver.findElement(By.xpath("//p[contains(text(),\"Hello\")]")).isDisplayed();
		Assert.assertEquals(disply, true);
	}
	
}
  @DataProvider
	public Object[][] LoginData()
	{ 
	  return new Object [][] {{"blank","",""},{"blankpass","kulkarni.prachi9834@gmail.com",""},{"wrongcredentials","prachi.kulkarni983@gmail.com","admin123"},{"sucesslogin","kulkarni.prachi9834@gmail.com","Prachi1234@"}};
	  }
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
	
	}
	

  
  
  
  
  

