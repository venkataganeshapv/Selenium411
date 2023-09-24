package com.ebs.framework;

import java.io.File;

import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class fwkBrowser {
	
	public WebDriverBrowser browser = null;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	public static ThreadLocal<ExtentTest> extentSyncTest = new ThreadLocal<>();

	
	@BeforeSuite
	public void beforesetup(ITestContext textContext) throws Exception {
		
	
		System.out.println("Before Suite");	
		
		//Report object
		reportInitialization(textContext.getSuite().getName());
	}
	
	@AfterSuite
	public void tearDown() throws Exception {		
					
		System.out.println("After Suite");	
		
		//Report Generation
		reportGeneration();	
		
	}
	
	
	@Parameters({"url","browser"})
	@BeforeTest
	public synchronized void setup(String url, String browser, ITestContext textContext) throws Exception{
		
			
				
		//Creating TestName
		extentTest = extentReports.createTest(textContext.getName());
		
		extentSyncTest.set(extentTest);
		
		
		System.out.println("test_BeforeTest:"+textContext.getName());
		
		//Launch browser
		launchBrowser(browser, extentSyncTest.get());
		
		this.browser.open(url);
	
	}
	
	@AfterTest
	public void tearTest() throws Exception{
		
		System.out.println("After Test: quit driver");	
		
		browser.getDriver().close();		
	}
	
	
	public void launchBrowser(String browserType, ExtentTest extentTest) throws Exception
	{		
		//Launch browser
		System.out.println("Before Test :Launch Browser");
		browser = new WebDriverBrowser(browserType, extentTest);
		
	}
	
	public void reportInitialization(String testName) throws Exception{
		
		
		String reportPath = getProjectPath()+"target\\"+testName+".html";
		System.out.println("Report path:"+reportPath);
		
		extentReports = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
		
		
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		extentReports.setSystemInfo("Test Name", testName);
		
		extentReports.attachReporter(sparkReporter);
		
	}
	
	public void reportGeneration() throws Exception{
		
		extentReports.flush();
		
		//Opening the result file after execution
		//Desktop.getDesktop().browse(new File(reportPath).toURI());
	}
	
	
	public String getProjectPath() 
	{
		String projectPath = "";
		
		 File currentDir = new File(".");
		 
		 // currDir : D:\DOCUMENTS\SELENIUM_PROJECTS\Webdriver_Projects\OracleEBS\
		 projectPath =  currentDir.getAbsolutePath().replace(".", "");
		 
		 return projectPath; 
	}
	

}
