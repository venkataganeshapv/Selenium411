package com.ebs.test.drivertest;

import org.testng.annotations.Test;

import com.ebs.framework.fwkBrowser;
import com.ebs.functional.login.Login;



public class Seleniumt11TestNgTest extends fwkBrowser{
	

	Login login;
	
	@Test
	public void login() throws Exception{
				
		login = new Login(browser);
		 
	    login.login("operations", "welcome");
	    Thread.sleep(10000);
	}
	
	
	@Test(dependsOnMethods= {"login"})
	public void logout() throws Exception{
		
	}
	
}
