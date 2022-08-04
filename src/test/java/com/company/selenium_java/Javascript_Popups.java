package com.company.selenium_java;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Javascript_Popups {
	public static WebDriver driver;
	@BeforeTest
	public void launch() {
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-64bit\\geckodriver.exe");
		driver = new FirefoxDriver();	
	}
	@Test
	public void Alert_Promptpopup() throws InterruptedException {
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("alertButton")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	@Test
	public void ConformationPopUp() throws InterruptedException{
		driver.get("https://nxtgenaiacademy.com/alertandpopup/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.name("confirmalertbox")).click();
		Thread.sleep(2000);
		Alert conformationAlert = driver.switchTo().alert();
		String alertText = conformationAlert.getText();
		System.out.println("the alert test is: " +alertText);
		conformationAlert.accept();
	}
	@Test
	public void promptPopup() throws InterruptedException{
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='promtButton']")).click();
		Thread.sleep(2000);
		Alert promptAlert = driver.switchTo().alert();
		Thread.sleep(2000);
		promptAlert.sendKeys("divya");
		Thread.sleep(2000);
		promptAlert.accept();
	}
}
