package com.sukumar.Selenium.core;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.xml.ISuiteParser;

public class Testadp {
	
	public static void main(String[] args) {
		
		
			
			System.setProperty("webdriver.chrome.driver","D:\\Automation\\Automation selenium\\Drivers\\chromedriver.exe");
			RemoteWebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.adp.com");
			
			List<WebElement> elements = driver.findElementsByXPath("//*");
			int adpcount=0;
			
			for(WebElement ele:elements)
			{
				
				String words = ele.getText();
				Optional optional=Optional.ofNullable(words);
				if (optional.isPresent()) {
					
					if (words.contains("ADP") || words.contains("adp")) {
						
						adpcount++;
						
						
					}
					
				}
		
				
				
				
			}
			System.out.println("NO. of occurence of word count :" + adpcount);
		
		
		
		
	}

}
