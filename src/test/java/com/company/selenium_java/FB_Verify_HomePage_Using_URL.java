package com.company.selenium_java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FB_Verify_HomePage_Using_URL {
	@Test
	public void verifyhomepage() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-64bit\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[contains(@name,'email')]")).sendKeys("omkar@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[contains(@name,'pass')]")).sendKeys("Om!9022");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[starts-with(@id,'u_0_5_')]")).click();
		Thread.sleep(2000);
		String expectedTitle = "Facebook";
		String actualTitle = driver.getCurrentUrl();
		System.out.println("Actual Result is " + actualTitle);
		if (actualTitle.contains(expectedTitle)) {
			System.out.println("Home page is displayed");
		} else{
			System.out.println("Home page is NOT displayed");
		}
	}

}
