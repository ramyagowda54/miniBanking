package com.guru99.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99.PageObjects.LoginPage;

public class LoginTest extends BaseClass {
	
	
	 
	
	@Test
	public void loginTest()
	{
		LoginPage login=new LoginPage(driver);
		login.setUsername(username);
		log.info("username is entered");
		login.setPassword(password);
		log.info("password is entered");
		login.clickSubmit();
		log.info("Login button is clicked");
		
		
	}
		
	
	
	  @Test 
	  public void verifyPageTitle()
	  {
		  LoginPage login=new LoginPage(driver);
		  String title=driver.getTitle();
		  System.out.println(title);
		  Assert.assertEquals(title, "Guru99 Bank");
	 
	  }
	 
	

}
