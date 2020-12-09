package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import net.bytebuddy.dynamic.NexusAccessor.InitializationAppender;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage  homePage;
	Logger log = Logger.getLogger(LoginPageTest.class);
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		log.info("****************************** Starting test cases execution  *****************************************");
		
		initialization();
		log.info("launching chrome broswer");
		loginPage = new LoginPage();
		log.info("entering application URL");
		log.warn("Hey this just a warning message");
		log.fatal("hey this is just fatal error message");
		log.debug("this is debug message");
	}
	
	@Test(priority =1)
	public void loginPageTitleTest() {
		
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** freeCrmTitleTest *****************************************");
		String title = loginPage.validationLoginPageTitle();
		log.info("login page title is--->"+title);
		Assert.assertEquals(title, "#1 Free CRM customer relationship management software cloud");
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** freeCrmTitleTest *****************************************");
	}
	
	@Test(priority =2)
	public void crmLogoImageTest() {
		
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** freemCRMLogoTest *****************************************");
		
		boolean flag = loginPage.validateCrmImage();
		Assert.assertTrue(flag);
		log.info("****************************** ending test case *****************************************");
		log.info("****************************** freemCRMLogoTest *****************************************");
		}
	
	@Test(priority =3)
	public void loginInTest() {
		
		loginPage.loginIn();
		
		}
	
	@Test(priority =4)
	public void loginTest() {
		
		loginPageTitleTest();
		crmLogoImageTest();
		loginInTest();
		homePage = loginPage.login(prop.getProperty("email"),prop.getProperty("password"));
		
		}
	
	@AfterMethod
    public void tearDown() {
		
		driver.quit();
	}

}
