package com.crm.qa.testcases;

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
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		
		loginPage = new LoginPage();
	}
	
	@Test(priority =1)
	public void loginPageTitleTest() {
		
		String title = loginPage.validationLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM customer relationship management software cloud");
	}
	
	@Test(priority =2)
	public void crmLogoImageTest() {
		
		boolean flag = loginPage.validateCrmImage();
		Assert.assertTrue(flag);
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
