package com.sukumar.Selenium.core;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testcase {
	
	private RemoteWebDriver driver;
	private String Curid;
	@BeforeSuite
	public  void openBrowser() throws InterruptedException {
		
		 Curid=System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver","D:\\Automation\\Automation selenium\\Drivers\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driverint();
	
	}
	@BeforeTest
	public  void methodname(Method method) {
		
		String methodname = method.getName();
		System.out.println("method name" + methodname);

	}
	@Test
	public  void loginPage() {
		String url="https://www.gmail.com";
		driver.get(url);

	}
	@AfterTest
	public  void testresult(ITestResult result) throws IOException {
		String tcName=result.getName();
		
		String imagepath="D:\\Automation\\Automation selenium\\Screenshots";
		if (result.getStatus()==ITestResult.FAILURE) {
			TakesScreenshot ts=driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File(imagepath +tcName+".jpeg"));
			
		}
	
	}
	public  void driverint() throws InterruptedException {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Thread.sleep(1000);
		
	}

}
