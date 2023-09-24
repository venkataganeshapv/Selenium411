package com.ebs.framework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;



public class WebDriverBrowser {
	
	WebDriver driver = null;
	public ExtentTest extentTest;
	
	public WebDriverBrowser(String browser, ExtentTest extentTest) throws Exception{
		
		 this.extentTest = extentTest;
		 
		 // Get IE Driver
		 if(browser.equals("ie")){
			 driver = new EdgeDriver();				
		  }
		  else if(browser.equals("firefox")){ // Get Firefox Driver
			
			  driver = new FirefoxDriver();	  
		  }
		  else if(browser.equals("chrome")){ // Get Chrome Driver
				  
			  driver = new ChromeDriver();		
		  }
		 
		 
		// Set the Settings
		// Object Wait Time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
											
		// Page Load Wait Time
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(200));
		
		driver.manage().window().maximize();
				
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void open(String url) throws Exception{
		// Opens Browser with Url
		try {
			driver.get(url);
			
			extentTest.log(Status.PASS, "Launched the URL \""+url+ "\" successfully.");
		}catch(Exception e) {
			extentTest.log(Status.FAIL, "Unable to launch the URL \""+url+ "\".");
		}
	}
	
	
	public void navigateToUrl(String url){
    	
    	driver.navigate().to(url);
    }

	public void windowMaximize(){
    	
    	driver.manage().window().maximize();
    	
    }

    public void close(){
		
		// Opens Browser with Url
		driver.close();
	}
    
    public void quit() throws Exception{
    	
    	driver.quit();
    	
    }
    
    public String getTitle() throws Exception{
    	
    	String title = driver.getTitle();
    	
    	return title;
    }
    
    public void setText(String labelName, String xPath, String valueToSet) throws Exception{
    	
    	try {
			
    		driver.findElement(By.xpath(xPath)).clear();
        	
        	driver.findElement(By.xpath(xPath)).sendKeys(valueToSet);
			
			extentTest.log(Status.PASS, "Set the text \""+valueToSet+"\" at the label \""+labelName+ "\".");
			
		}catch(Exception e) {
			
			extentTest.log(Status.FAIL, "Unable to Set the text \""+valueToSet+"\" at the lable\""+labelName+ "\".");
		}
    	
    	

    }
    
    public void clickButton(String labelName, String xPath) throws Exception{  	
    	
    	try {
			
    		driver.findElement(By.xpath(xPath)).click();
			
			extentTest.log(Status.PASS, "Clicked on the button having label \""+labelName+ "\".");
			
		}catch(Exception e) {
			
			extentTest.log(Status.FAIL, "Unable to Click the button having lable\""+labelName+ "\".");
		}
    	
    	

    }

   
}
