package com.ebs.test.drivertest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_Profile {
	
	public static void main(String[] args) throws Exception{
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Page Load Wait Time
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(200));
		
		driver.manage().window().maximize();
		
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		
		
		
		
		
		
		
		
	}
	
}
