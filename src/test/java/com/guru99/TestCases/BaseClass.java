package com.guru99.TestCases;




import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.utils.FileUtil;
import com.guru99.Utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig rconfig=new ReadConfig();
	
	String baseUrl=rconfig.getApplicationUrl();
	String username=rconfig.getUsername();
	String password=rconfig.getPassword();
	public static WebDriver driver;
	public static Logger log;
	
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String br)
	{
		log=Logger.getLogger("miniBanking");
	    PropertyConfigurator.configure("log4j.properties");
	    if(br.contains("chrome"))
	    {
		//System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		System.setProperty("webdriver.chrome.driver" , rconfig.getChromepath());
		driver=new ChromeDriver();
	    }
	    else if (br.contains("firefox"))
	    {
	    	System.setProperty("webdriver.gecko.driver" , rconfig.getFirefoxpath());
			driver=new FirefoxDriver();	
	    }	
	    
	    else if (br.contains("ie"))
	    {
	    	System.setProperty("webdriver.ie.driver" , rconfig.getIEpath());
			driver=new InternetExplorerDriver();	
	    }	
	    	
	    
	    driver.get(baseUrl);
	    log.info("website is opened");
	    driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	public static void captureScreenshot(String screenshotPath)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(screenshotPath);
		try {
			FileHandler.copy(source, target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		
		
	}
	
	public static boolean isAlertPresent()
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
		return false;
		}
		
	}
	
	
	
}
