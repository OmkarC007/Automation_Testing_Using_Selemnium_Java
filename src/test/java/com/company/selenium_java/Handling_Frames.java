package com.company.selenium_java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Handling_Frames {
	@Test
	public void framesByIndex() throws InterruptedException{
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-64bit\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	
//using index of the frame - [ int value] [ index of frames starts with zero]
		driver.get("file:///C:/Selenium/page2.html");
		driver.switchTo().frame(0);
		driver.findElement(By.id("t1")).sendKeys("Omkar");
		driver.switchTo().defaultContent();
		driver.findElement(By.id("t2")).sendKeys("Omkar");
	}	
	@Test
	public void framesUsingIdAttribute() throws InterruptedException{
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-64bit\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	
		driver.get("file:///C:/Selenium/page2.html");
//using id attribute of the frame -string
		driver.switchTo().frame("f1");
		driver.findElement(By.id("t1")).sendKeys("om");
		driver.switchTo().defaultContent();
		driver.findElement(By.id("t2")).sendKeys("om");
	}	
	@Test
	public void framesUsingNameAttribute() throws InterruptedException{
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-64bit\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	
		driver.get("file:///C:/Selenium/page2.html");
//using name attribute of the frame -string
		driver.switchTo().frame("n1");
		driver.findElement(By.id("t1")).sendKeys("Omkar");
		driver.switchTo().defaultContent();
		driver.findElement(By.id("t2")).sendKeys("Chikane");
	}
	@Test
	public void framesAddress() throws InterruptedException{
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-64bit\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	
		driver.get("file:///C:/Selenium/page2.html");
//using address of the frame -webelement
		WebElement f = driver.findElement(By.className("c1"));
		driver.switchTo().frame(f);
		driver.findElement(By.id("t1")).sendKeys("D ");
		driver.switchTo().defaultContent();
		driver.findElement(By.id("t2")).sendKeys("Chikane");
	}	
}
