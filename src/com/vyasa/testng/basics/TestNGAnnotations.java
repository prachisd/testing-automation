package com.vyasa.testng.basics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {

	@Test 
	void TestMethod() {
		System.out.println("Test Method");
		
	}
	
	
	@BeforeSuite 
	void BeforeSuiteMethod() {
		System.out.println("Before Suite Method");
		
	}
	@AfterSuite 
	void AfterSuiteMethod() {
		System.out.println("After Suite Method");
		
	}
	@BeforeTest
	void BeforeTestMethod() {
		
		System.out.println("Before Test Method");
	}
	@AfterTest
	void AfterTestMethod() {
		System.out.println("After Test Method");
		
	}
	@BeforeClass 
	void BeforeClassMethod() {
		System.out.println("Before Class Method");
		
	}
	@AfterClass 
	void AfterClassMethod() {
	System.out.println("After Class Method");	
		
	}
	@BeforeMethod
	void BeforeMethod1() {
		
		System.out.println("Before Method1");
	}
	
	@AfterMethod
	void AfterMethod1() {
		
		System.out.println("After Method1");
	}
	@BeforeGroups
	void BeforeGroupsMethod() {
		System.out.println("Before Groups Method");
	}
	
	@AfterGroups
	void AfterGroupsMethod() {
		System.out.println("After Groups Method");
	}
	
	
}
