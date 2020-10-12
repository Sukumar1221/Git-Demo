package com.sukumar.Selenium.core;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class Testcase1 {
	private  RemoteWebDriver driver;
	@BeforeSuite
	public  void openBrowser() {
		
		System.setProperty("webdriver.chrome.driver","D:\\Automation\\Automation selenium\\Drivers\\chromedriver.exe");
		
 driver=new ChromeDriver();
		
		

	}
	@BeforeTest
public void mathodname(Method method ) {
	String name = method.getName();
	
	System.out.println("Currently executing test case : " + name);

}
	@AfterTest
	public  void executetestcase(ITestResult result) {
		
		String tcname = result.getName();
		if (result.getStatus()==ITestResult.SUCCESS) {
			System.out.println();
			
			
		}
	

	}
	
	public void driverint() {
	driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);

	}
	
	public RemoteWebDriver getDriver() {
		return driver;
	}
	
	
	
	
	
	
}
