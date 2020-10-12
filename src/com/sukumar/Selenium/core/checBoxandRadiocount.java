package com.sukumar.Selenium.core;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class checBoxandRadiocount {
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
	public  void count() {
		driver.get("https://www.facebook.com");;
		
		List<WebElement> elements = driver.findElementsByCssSelector("*");
		int count=0;
		for(int i=0;i<=elements.size()-1;i++)
		{
			WebElement webElement=elements.get(i);
			String type = webElement.getAttribute("type");

			Optional options = Optional.ofNullable(type);
			if (options.isPresent()) {
				if (type.contains("checkbox") || type.contains("radi")) {
					
					count++;
					
				}
				
			}
		}
		System.out.println("checkbox count is :" + count);
		
		
	}
	
	
	
	@AfterTest
	public  void takescreenshot() throws IOException {
		String imagepath="D:\\Automation\\Automation selenium\\Screenshots";
		TakesScreenshot takesScreenshot=driver;
		File file=takesScreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(imagepath +"\\checBoxandRadiocount" +".jpeg" ));
		
	}
	public  void driverint() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	}

}
