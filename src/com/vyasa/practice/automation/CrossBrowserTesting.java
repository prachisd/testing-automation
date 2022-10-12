package com.vyasa.practice.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.microsoft.edge.seleniumtools.EdgeDriver;

public class CrossBrowserTesting {
	
	public WebDriver driver;
	@Parameters ("browser")
	
	@BeforeClass
	public void BrowserLaunch (String browser) {
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","D:\\javaautomation\\TestNGAutomation\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			System.out.println("firefox opened succesfully");	
		}
		else if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","D:\\javaautomation\\TestNGAutomation\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			System.out.println("chrome opened succesfully");	
		}
		else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver","D:\\javaautomation\\TestNGAutomation\\drivers\\msedgedriver.exe");
			driver=new EdgeDriver();
			System.out.println("edge opened succesfully");	
		}
		
		driver.get("https://practice.automationtesting.in/my-account/"); 
		driver.manage().window().maximize();	
		
	}
	
	@Parameters({"username","password"})
	
  @Test
  public void VerifyUserlogin(String username,String password) {
		
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(username);
		driver.findElement(By.xpath("(//input[@name=\"password\"])[1]")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		boolean actualDisplayed=driver.findElement(By.xpath("//p[contains(text(),\"Hello\")]")).isDisplayed();
		Assert.assertTrue(actualDisplayed);
  }
@AfterClass
public void CloseBrowser() {
	
	driver.quit();
}

	

}
