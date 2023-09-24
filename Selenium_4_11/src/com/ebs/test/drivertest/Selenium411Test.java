package com.ebs.test.drivertest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ebs.functional.login.Login;

public class Selenium411Test {

	public static void main(String[] args) throws Exception {
		
		
		 WebDriver driver = new ChromeDriver();

		// Object Wait Time
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
									
	    // Page Load Wait Time
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(200));
			
			//driver.get("http://rws3511456.us.oracle.com:8000/OA_HTML/AppsLogin");
	    driver.get("https://mz5st213.appsdev1.fusionappsdphx1.oraclevcn.com:4443/OA_HTML/AppsLogin");
	    
	    //Login login = new Login(driver);
	    
	    //login.login("operations", "welcome");
		

	}

}
