package com.company.selenium_java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FBWebElement_InterfaceMethods { 
	@Test
	public void  VerifyFB_UNandPWDfieldsAreAligned_intheSameRow() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-64bit\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	
		driver.get("https://www.facebook.com/");
		WebElement unTB = driver.findElement(By.xpath("//input[contains(@name,'email')]"));
		// get the y-coordinate of username field
		int username_Ycordinate = unTB.getLocation().getY();
		System.out.println("UN YCord -"+username_Ycordinate);
		WebElement pwdTB = driver.findElement(By.xpath("//input[contains(@name,'pass')]"));
		// get the y-coordinate of password field
		int password_Ycordinate = pwdTB.getLocation().getY();
		System.out.println("PW YCord -"+password_Ycordinate);
		//check whether the Y-coordinate of username and password field are same
		if (username_Ycordinate==password_Ycordinate) {
			System.out.println("Both username and password fields are displayed in the same row");
		}else{
			System.out.println("username and password fields are NOT aligned in the same row");
		}
	}
	@Test
	public void VerifyFB_UNandPassword_HeightandWidth() throws InterruptedException{
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-64bit\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		//find the username field
		WebElement unTB = driver.findElement(By.xpath("//input[contains(@name,'email')]"));
		//store the height of username
		int username_height = unTB.getSize().getHeight();
		//store the width of username
		int username_width = unTB.getSize().getWidth();
		System.out.println( "UN height -"+username_height);
		System.out.println("UN Width - "+username_width);
		//find the password field
		WebElement pwdTB = driver.findElement(By.xpath("//input[contains(@name,'pass')]"));
		//store the height of password
		int password_height = pwdTB.getSize().getHeight();
		//store the width of password
		int password_width = pwdTB.getSize().getWidth();
		System.out.println("PW Height -"+password_height);
		System.out.println("PW width -"+password_width);
		//check the height and width of username and password fields are same
		if (username_height==password_height && username_width==password_width) {
			System.out.println("Username and password fields are aligned");
		}else{
			System.out.println("Username and password fields are NOT aligned");
		}
	}
	@Test
	public void VerifyFB_Usernamefield_lessthanMobileNumberField() throws InterruptedException{
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-64bit\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();	
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement unTB = driver.findElement(By.xpath("//input[contains(@name,'email')]"));
		int username_width = unTB.getSize().getWidth();
		System.out.println(username_width);
		//Identify the mobile number text box
		WebElement mobileNumTB = driver.findElement(By.xpath("//input[contains(@aria-label,'Email address or phone number')]"));
		int mobNumWidth = mobileNumTB.getSize().getWidth();
		System.out.println(mobNumWidth);
		//Compare the width of both username and mobilenumber text box
		if (username_width==mobNumWidth) {
		System.out.println("Size of Both username and password fields are same" +username_width+" =" + mobNumWidth);
		}
		else{
			System.out.println("Size of username and password fields are NOT same that is : "
				+username_width+" Not equals to " + mobNumWidth);
		}
	}
}
