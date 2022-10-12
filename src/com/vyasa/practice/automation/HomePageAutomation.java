package com.vyasa.practice.automation;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class HomePageAutomation {
  WebDriver driver;
  
  @BeforeClass
  public void BrowserSetUp() {
	  
	 System.setProperty("webdriver.chrome.driver","D:\\javaautomation\\TestNGAutomation\\drivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  	driver.get("https://practice.automationtesting.in/");
	  	driver.manage().window().maximize();
	  
  }

  @Test(priority=1,description="verify homepage is loaded")
  public void VerifyHomePageIsLoaded() 
  {  
	String actualResult = driver.getTitle();
	Assert.assertEquals(actualResult, "Automation Practice Site");
	 }
  
  
  @Test (priority=2,description="Verify New Arrivals Displayed")
  public void VerifyNewArrivalsDisplayed() 
  {
	  boolean actualText  =driver.findElement(By.tagName("h2")).isDisplayed();
	  Assert.assertTrue(actualText);	  
  }
  
  @Test(priority=3,description="Verify HomePaege With 3Sliders")
  public void VerifyHomePaegeWith3Sliders() 
  {  
     int slidersCount = driver.findElements(By.xpath("//img[@class=\"n2-ss-slide-background-image n2-ss-slide-fill n2-ow\"]")).size();
     Assert.assertEquals(slidersCount,3);
     }
  
  @Test (priority=4,description="Verify HomePaege With 3arrivals")
  public void VerifyHomePaegeWith3Arrivals() {
	  
  int arrivalsCount = driver.findElements(By.xpath("//img[@loading=\"lazy\"]")).size();
  Assert.assertEquals(arrivalsCount,3);
}
  
  
  @Test (priority=5,description="Verify HomePaege With 3arrivals Navigate")
  public void VerifyHomePaegeWithArrivalsNavigate() {
	  
 List <WebElement> listimgBooks= driver.findElements(By.xpath("//img[@loading=\"lazy\"]"));
  
 for (WebElement imgBook : listimgBooks) {
	 
	 if (imgBook.getAttribute("title").equalsIgnoreCase("Selenium Ruby")) {
		 imgBook.click();
		String actualBookTitle=driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals(actualBookTitle, "Selenium Ruby");
		 
		
	} else if(imgBook.getAttribute("title").equalsIgnoreCase("Thinking in HTML")) 
 {imgBook.click();
		String actualBookText=driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals(actualBookText, "Thinking in HTML");
		
 }
           else {
			 imgBook.click();
				String actualBookText=driver.findElement(By.tagName("h1")).getText();
				Assert.assertEquals(actualBookText, "Mastering JavaScript");
				
           }
	 driver.navigate().back();
	 }
	
}

  
  
  
  
  @AfterClass
  public void BrowserClose() {
	  driver.close();
	  
	  
  }

}
