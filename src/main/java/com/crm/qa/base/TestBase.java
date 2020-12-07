package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.analysis.function.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogCombiner;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;


public class TestBase {
	
	   public static WebDriver driver ; 
	   public static Properties prop;
	   public  static EventFiringWebDriver e_driver;
	   public static WebEventListener eventListener;
	   
    public TestBase() {
    	try {
    		prop = new Properties();
    		FileInputStream ip = new FileInputStream("C:\\Users\\Mehdi Gourija\\eclipse-workspace\\Test2PageObjectModel\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
    		prop.load(ip);
    		
    	}catch(FileNotFoundException e){
    		e.printStackTrace();
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    public void initialization() {
    	
    		String browserName = prop.getProperty("browser");
    		
    		if(browserName.equals("chrome")) {
    			System.setProperty("webdriver.chrome.driver","C:\\Users\\Mehdi Gourija\\Downloads\\chromedriver.exe");
    			driver = new ChromeDriver();
    		}
    		else if(browserName.equals("FF")) {
    			System.setProperty("webdriver.chrome.driver","C:\\Users\\Mehdi Gourija\\Downloads\\geckodriver.exe");
    			driver = new FirefoxDriver();
    		}
    		
    	
    		e_driver = new EventFiringWebDriver(driver);
    		// Now create object of EventListerHandler to register it with EventFiringWebDriver
    		eventListener = new WebEventListener();
    		e_driver.register(eventListener);
    		driver = e_driver;
    		
    		driver.manage().window().maximize();
    		driver.manage().deleteAllCookies();
    		driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    		driver.get(prop.getProperty("url"));
    		//Log.info("app url is:" + prop.getProperty("url"));
    		//"http://www.freecrm.com"
        }
         

}