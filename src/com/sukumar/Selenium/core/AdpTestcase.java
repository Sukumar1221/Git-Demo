package com.sukumar.Selenium.core;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

public class AdpTestcase {
	private RemoteWebDriver driver;
	private String Curid;
	private String name;
	
	
	@BeforeSuite
	public  void openBrowser() {
		 Curid=System.getProperty("user.dir");
			
			System.setProperty("webdriver.chrome.driver","D:\\Automation\\Automation selenium\\Drivers\\chromedriver.exe");
			 driver=new ChromeDriver();
			 driverint();
			
	}
	@BeforeMethod
	
	public  void methodname(Method method) {
		
		name=method.getName();
		System.out.println(" currently executed method name is " + name);

	}
	@Test
	public  void adpCount() {
		driver.get("https://www.adp.com");
		//driver.findElements(By.cssSelector("*"));
		List<WebElement> elements = driver.findElementsByCssSelector("*");
		int count=0;
		
		for(WebElement ele:elements)
		{
			try {
				String type = ele.getAttribute("type");
				String text = ele.getText();
				java.util.Optional<String> options = java.util.Optional.ofNullable(text);
				if (options.isPresent()) {
					if (text=="ADP" || text=="adp") {
					
						count++;
						
					}
					
				}
			
				
			
			
			}
			
				
			catch (Exception e) {
				String type = ele.getAttribute("type");
				String text = ele.getText();
				java.util.Optional<String> options = java.util.Optional.ofNullable(text);
				if (options.isPresent()) {
					if (text=="ADP" || text=="adp") {
					
						count++;
						
					}
					
				}
			
				
			}
			
			}
			
		System.out.println("ADP count is :"  + count);
		
	}
	@AfterTest
	public  void takescreenshot() throws IOException {
		TakesScreenshot takesScreenshot=driver;
		File file=takesScreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(Curid +"//Screenshots" + name +".jpeg" ));
		
	}
	public  void driverint() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	}
	 
	

}
