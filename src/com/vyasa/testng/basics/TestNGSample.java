package com.vyasa.testng.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGSample {
	WebDriver driver;
	@BeforeClass
	public void OpenBrowswer()
	{
		System.setProperty("webdriver.chrome.driver","D:\\javaautomation\\TestNGAutomation\\drivers\\chromedriver.exe");
driver=new ChromeDriver();
	driver.get("https://amazon.com");
	driver.manage().window().maximize();
	}
	
  @Test
  public void OpenBrowser() {
	  System.setProperty("webdriver.chrome.driver", "D:\\javaautomation\\AutomationWithSelenium\\jars\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://amazon.com");
        driver.manage().window().maximize();
 
	  
  }
  
  @Test
  public void VerifyHomePageLoaded() {
	  String expectedURL="https://www.amazon.com/";
      String actualUrl=driver.getCurrentUrl();
      System.out.println(actualUrl);
      Assert.assertEquals(actualUrl,expectedURL);//hard assert
}
   @Test
  public void VerifyCartDisplayed() {
         WebElement cartEle	=driver.findElement(By.xpath("//div[@id=\"nav-cart-count-container\"]"));
         boolean actualResult=cartEle.isDisplayed();
         System.out.println(actualResult);
	     Assert.assertTrue( actualResult);
   }	
	@AfterTest
	public void CloseBrowser() {
		driver.close();
		
	}

  }
  
  
