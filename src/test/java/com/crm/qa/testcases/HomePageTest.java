package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import net.bytebuddy.dynamic.NexusAccessor.InitializationAppender;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage  homePage;
	ContactsPage contactPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		contactPage = new ContactsPage();
		loginPage = new LoginPage();
		loginPage.loginIn();
		homePage = loginPage.login(prop.getProperty("email"),prop.getProperty("password"));
	}
	
	@Test(priority =1)
	public void homePageTitleTest() {
		
		String title = homePage.verifHomePageTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	
	@Test(priority =2  )
	public void verifUserNameTest() {
		
			Assert.assertTrue(homePage.verifCorrectUserName());
	}
	
	@Test(priority =3)
	public void verifContactslinkTest() throws InterruptedException {
		
			contactPage = homePage.clickOnContactsLink();
			Thread.sleep(2000);
	}
	
	@AfterMethod
    public void tearDown() {
		
		driver.quit();
	}

}
