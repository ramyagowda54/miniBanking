package com.guru99.TestCases;

import static org.testng.Assert.assertFalse;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99.PageObjects.LoginPage;
import com.guru99.Utilities.excelUtilities;



public class LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData")
	public void loginCheck(String uname,String pwd)
	{
		LoginPage login=new LoginPage(driver);
		login.setUsername(uname);
		log.info("username is entered");
		login.setPassword(pwd);
		log.info("password is entered");
		login.clickSubmit();
		log.info("Login button is clicked");
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			log.info("Invalid login credentials");
			Assert.assertTrue(false);
			
		}
		else
		{
			driver.findElement(By.partialLinkText("Log out")).click();
			driver.switchTo().alert().accept();
			log.info("Valid credentials");
			Assert.assertTrue(true);
		}
	}
	
	@DataProvider(name="LoginData")
	public String[][] readData() throws IOException
	{
		String xlPath=System.getProperty("user.dir")+"/src/test/java/com/guru99/TestData/LoginData.xlsx";
		String xlSheet="sheet1";
		int totRows=excelUtilities.getRowCount(xlPath, xlSheet);
		int totCols=excelUtilities.getColCount(xlPath, xlSheet);
		String[][] data=new String[totRows][totCols];
		for (int i=1;i<=totRows;i++)
		{
			for(int j=0;j<totCols;j++)
			{
				data[i-1][j]=excelUtilities.getCellData(xlPath, xlSheet, i, j);
			}
		}
		
		return data;
	}
}
