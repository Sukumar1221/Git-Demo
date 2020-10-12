package com.sukumar.Selenium.core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testing {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\Automation\\Automation selenium\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	    driver.get("https:www.facebook.com");
		WebElement element = driver.findElement(By.id("email"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript(element.getText(), "email");
	}

}
