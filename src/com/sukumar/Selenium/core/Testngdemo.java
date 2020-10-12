package com.sukumar.Selenium.core;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Testngdemo {
	
	@BeforeSuite
	public  void beforeSuite() {
		
		System.out.println("Before suite");

	}
	@BeforeClass
	public  void beforeClass() {
		
		System.out.println("Before class");

	}
	@BeforeMethod
	public  void beforeMethod() {
		
		System.out.println("before Method");
	}
	@BeforeTest
	public  void beforeTest() {
		
		System.out.println("before Test");
	}
	@org.testng.annotations.Test
	public  void Test() {
	
		System.out.println("Test");

	}
	@AfterTest
	public  void afterTest() {
		System.out.println("after Test");
	}
	@AfterMethod
	
	public  void afterMethod() {
		
		System.out.println("after Method ");
	}
	@AfterSuite
	public  void afterSuite() {
		
		System.out.println("after suite");
		curid();
	}
	@AfterClass
	public  void afterClass() {
		
		System.out.println("after class");

	}
	public  void curid() {
		String cur = System.getProperty("user.dir");
		System.out.println("Cur id" + cur);

	}

}
