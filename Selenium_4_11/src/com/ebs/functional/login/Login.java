package com.ebs.functional.login;

import com.ebs.framework.WebDriverBrowser;

public class Login {
	
	WebDriverBrowser browser;
	
	public Login(WebDriverBrowser browser) {
		this.browser = browser;
	}
	
	
	public void login(String username, String password) throws Exception{
		
		browser.setText("Username", "//*[@id='usernameField']", username);
		
		browser.setText("Password", "//*[@id='passwordField']", password);
		
		browser.clickButton("Login", "//button[text()='Log In']");
	
	}
	
}
