package com.company.selenium_java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Frames_Handling_Test {
	public static WebDriver driver;
	@BeforeTest
	public void launch() {
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-64bit\\geckodriver.exe");
		driver = new FirefoxDriver();	
	}
	@Test
	public void frames_usingIndex () throws InterruptedException{
		driver.get("file:///C:/Selenium/page1.html");
		//using index of the frame - [ int value] [ index of frames starts with zero]
		driver.switchTo().frame(0);
		driver.findElement(By.id("t1")).sendKeys("omkar");
		driver.switchTo().defaultContent();
		driver.findElement(By.id("t2")).sendKeys("chikane");	
	}
	@Test
	public void frames_usingId () throws InterruptedException{
		driver.get("file:///C:/Selenium/page2.html");
		//using id attribute of the frame -string
		driver.switchTo().frame("f1");
		driver.findElement(By.id("t1")).sendKeys("omkar");
		driver.switchTo().defaultContent();
		driver.findElement(By.id("t2")).sendKeys("chikane");
	}
	@Test
	public void frames_usingName () throws InterruptedException{
		driver.get("file:///C:/Users/Lenovo/Documents/page2.html");
		//using name attribute of the frame -string
		driver.switchTo().frame("n1");
		driver.findElement(By.id("t1")).sendKeys("omkar");
		driver.switchTo().defaultContent();
		driver.findElement(By.id("t2")).sendKeys("chikane");
	}
	@Test
	public void frames_usingAddressFrame () throws InterruptedException{
		driver.get("file:///C:/Users/Lenovo/Documents/page2.html");
		//using address of the frame -webelement
		WebElement f = driver.findElement(By.className("c1"));
		driver.switchTo().frame(f);
		driver.findElement(By.id("t1")).sendKeys("omkar");
		driver.switchTo().defaultContent();
		driver.findElement(By.id("t2")).sendKeys("chikane");
		//driver.close();
	}
	@Test
	public void frames_ThreeTextField() {
		driver.get("file:///C:/Selenium/page3.html");
		// frames handling for three text field
		//using ID attribute
		driver.switchTo().frame("f1");
		driver.findElement(By.id("t1")).sendKeys("omkar");
		driver.switchTo().defaultContent();
		driver.findElement(By.id("t2")).sendKeys("M");
		driver.findElement(By.id("t3")).sendKeys("chikane");

	}
}
