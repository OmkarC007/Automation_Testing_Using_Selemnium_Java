package com.company.selenium_java;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Facebook_xpath {
	@Test
	public void login  ()throws InterruptedException{
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-64bit\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	
		Thread.sleep(1000);
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@name,'email')]")).sendKeys("omkar@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@name,'pass')]")).sendKeys("Omkar@123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[starts-with(@id,'u_0_5_')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Forgotten password?']")).click();
		Thread.sleep(2000);
}
	@Test
	public void CreateAccount () throws InterruptedException{
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-64bit\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	
		Thread.sleep(1000);
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a [text ()='Create New Account']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@name,'firstname')]")).sendKeys("Omkar");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@name,'lastname')]")).sendKeys("Chikane");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@name,'reg_email__')]")).sendKeys("omkar@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@name,'reg_email_confirmation__')]")).sendKeys("omkar@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@name,'reg_passwd__')]")).sendKeys("omkar@123");
		Thread.sleep(2000);
		
		WebElement dateElement= driver.findElement(By.xpath("//select[contains(@name,'birthday_day')]"));
		Select dateDropdown = new Select(dateElement); 
		dateDropdown.selectByVisibleText("18");		
		Thread.sleep(2000);
		WebElement monthElement = driver.findElement(By.xpath("//select[contains(@id,'month')]"));
		Select monthDropdown = new Select(monthElement);
		monthDropdown.selectByVisibleText("Jul");		
		Thread.sleep(2000);
		WebElement yearElement = driver.findElement(By.xpath("//select[contains(@id,'year')]"));
		Select yearDropdown = new Select(yearElement);
		yearDropdown.selectByVisibleText("1999");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//label[text()='Male']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'Sign')]")).click();
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//a[text()='Learn more']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//a[text()='Terms']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//a[text()='Data Policy']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//a[text()='Cookie Policy']")).click();
//		Thread.sleep(2000);	
		//driver.close();
	}
	
}
