package com.sukumar.Selenium.core;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Salesforcetest  {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\Automation\\Automation selenium\\Drivers\\chromedriver.exe");
		RemoteWebDriver driver=new ChromeDriver();
		String url="https://login.salesforce.com/";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("sukumar+de@dhruvsoft.com");
		WebElement password = driver.findElement(By.name("pw"));
		password.sendKeys("suku@1221");
		WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
		submit.click();
		String title = driver.getTitle();
		System.out.println("Title Message is " + title);
		driver.findElement(By.id("setupSearch")).sendKeys("object");
		driver.findElement(By.linkText("Objects")).click();
		driver.findElement(By.xpath("//input[@class='btn']")).click();
		/*List<WebElement> elements = driver.findElementsByCssSelector("*");
		for(WebElement webElement:elements)
		{
			String type = webElement.getAttribute("type");
			Optional optional=Optional.ofNullable(type);
			if (optional.isPresent()) {
				if(type.equalsIgnoreCase("checkbox") || type.equalsIgnoreCase("radio"))
				{
					if(!webElement.isSelected())
					{
			       webElement.click();
					}
				}
			}
			
		}*/
		driver.findElement(By.id("MasterLabel")).sendKeys("Address");
		driver.findElement(By.id("PluralLabel")).sendKeys("Address");
		
		
		
		driver.findElement(By.xpath("//*[@type='submit']")).click();
	}

}
