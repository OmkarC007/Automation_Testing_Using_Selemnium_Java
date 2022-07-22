package com.company.selenium_java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class FaceBook_SignUp {
	@Test
	public void login() throws InterruptedException{		
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-64bit\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	
		driver.get("https://www.facebook.com/"); 
		Thread.sleep(1000);
			
//********************** For Register**********************************************
		//create new account button
		driver.findElement(By.linkText("Create New Account")).click();
		Thread.sleep(1000);
		//firstname
		driver.findElement(By.name("firstname")).sendKeys("omkar");
		Thread.sleep(2000);
		//lastname
		driver.findElement(By.name("lastname")).sendKeys("chikane");
		Thread.sleep(2000);
		//email or phone number
		driver.findElement(By.name("reg_email__")).sendKeys("omkar@gmail.com");
		Thread.sleep(2000);
		//re-enter email or phone number
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("omkar@gmail.com");
		Thread.sleep(2000);
		//password
		driver.findElement(By.name("reg_passwd__")).sendKeys("pmkar@123");
		Thread.sleep(2000);
		//dropbox date
		WebElement day = driver.findElement(By.id("day"));
		Select select = new Select(day);
		select.selectByVisibleText("18");
		Thread.sleep(2000);
		//dropbox month
        WebElement month = driver.findElement(By.id("month"));
        Select select1 = new Select(month);
        select1.selectByVisibleText("Jul");
        Thread.sleep(2000);
        //dropbox year
        WebElement year = driver.findElement(By.id("year"));        
        Select select2 = new Select(year);
        select2.selectByVisibleText("1999");
        Thread.sleep(2000);
        //gender radio button
        driver.findElement(By.xpath("//input[@value='2']")).click();
        Thread.sleep(2000);
        //signup button
        driver.findElement(By.name("websubmit")).click();
		Thread.sleep(2000);    
	}	
}
