package com.company.selenium_java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Facebook_Login {
	@Test
	public void login() throws InterruptedException{		
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-64bit\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	
	
		
//***************************For Login******************************************	
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//email field
		driver.findElement(By.name("email")).sendKeys("omkarchikane607@gmail.com");
		Thread.sleep(2000);
		//password field
		driver.findElement(By.id("pass")).sendKeys("OmChikane!9022");
		Thread.sleep(2000);
		//login button
		driver.findElement(By.name("login")).click();    
	}	
}
