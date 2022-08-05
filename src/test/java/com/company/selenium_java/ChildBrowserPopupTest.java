package com.company.selenium_java;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChildBrowserPopupTest {
	
	public static WebDriver driver;
	@BeforeTest
	public void launch() { 
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\geckodriver-64bit\\geckodriver.exe");
	    driver = new FirefoxDriver();
	}
	@Test
	public void  Print_windowHandle() throws InterruptedException{
		driver.get("https://www.naukri.com/");
		//get the window handle id of the browser
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
	}
	@Test
	public void   ChildBrowserPopUp() throws InterruptedException{
		driver.get("https://www.naukri.com/");
		//using getWindowHandles(), get a set of window handle IDs
		Set<String> allWindowHandles = driver.getWindowHandles();
		//using size(), get the count of total number of browser windows
		int count = allWindowHandles.size();
		System.out.println("Number of browser windows opened on the system is : "+ count);
		for (String windowHandle : allWindowHandles) {
		//switch to each browser window
		driver.switchTo().window(windowHandle);
		String title = driver.getTitle();
		//print the window handle id of each browser window
		System.out.println("Window handle id of page -->"+ title +" --> is : "+windowHandle);
		//close all the browsers one by one
		driver.close();
		}
		/*Instead of using driver.close(), we can use driver.quit() to close all the browsers at
		once*/
		//driver.quit(); 
	}
	
	@Test
	public void CloseMainBrowserOnly() throws InterruptedException{
		driver.get("https://www.naukri.com/");
		//get the window handle id of the parent browser window
		String parentWindowhandleID = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		int count = allWindowHandles.size();
		System.out.println("Number of browser windows opened on the system is : "+ count);
		for (String windowHandle : allWindowHandles) {
		//switch to each browser window
		driver.switchTo().window(windowHandle);
		String title = driver.getTitle();
		/* compare the window id with the Parent browser window id, if both are equal, then
		only close the main browser window.*/
		if (windowHandle.equals(parentWindowhandleID)) {
		driver.close();
		System.out.println("Main Browser window with title -->"+title+" --> is closed");
		}}
	}
	@Test
	public void CloseALLChildbrowsersONLY() throws InterruptedException{
		driver.get("https://www.naukri.com/");
		//get the window handle id of the parent browser window
		String parentWindowhandleID = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		int count = allWindowHandles.size();
		System.out.println("Number of browser windows opened on the system is : "+ count);
		for (String windowHandle : allWindowHandles) {
		//switch to each browser window
		driver.switchTo().window(windowHandle);
		String title = driver.getTitle();
		/* compare the window id of all the browsers with the Parent browser window id, if it
		is not equal, then only close the browser windows.*/
		if (!windowHandle.equals(parentWindowhandleID)) {
		driver.close();
		System.out.println("Child Browser window with title -->"+ title +" --> is closed");
		}}
	}
	
	@Test
	public void  CloseAnySpecifiedBrowse() throws InterruptedException{
		driver.get("https://www.naukri.com/");
		//Set the expected title of the browser window which you want to close
		String expected_title = "Tech Mahindra";
		Set<String> allWindowHandles = driver.getWindowHandles();
		int count = allWindowHandles.size();
		System.out.println("Number of browser windows opened on the system is : "+ count);
		for (String windowHandle : allWindowHandles) {
		//switch to each browser window
		driver.switchTo().window(windowHandle);
		String actual_title = driver.getTitle();
		//Checks whether the actual title contains the specified expected title
		if (actual_title.contains(expected_title)) {
		driver.close();
		System.out.println("Specified Browser window with title -->"+ actual_title +" --> isclosed");
		}
		}
	}
	@Test
	public void HandleTabs_using_getWindowHandles() throws InterruptedException{
		//enter actitime login url
		driver.get("https://demo.actitime.com/login.do");
		//get the window handle id of the parent browser window
		String parentwindowHandle = driver.getWindowHandle();
		//enter username
		driver.findElement(By.id("username")).sendKeys("admin");
		//enter password
		driver.findElement(By.name("pwd")).sendKeys("manager");
		//click on actiTIME INC link
		driver.findElement(By.xpath("//a[text()='actiTIME Inc.']")).click();
		//get the number of windows currently opened on the system
		Set<String> allwhs = driver.getWindowHandles();
		//switch to all the browser windows
		for (String wh : allwhs) {
		driver.switchTo().window(wh);
		}
		//get the title of the tab
		String childtitle = driver.getTitle();
		System.out.println("Title of the child tab is :"+ childtitle);
		//close the child tab
		driver.close();
		//switch back to the main browser window
		driver.switchTo().window(parentwindowHandle);
		//close the main browser window
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		//closing the parent window
		driver.close();
	}
}
