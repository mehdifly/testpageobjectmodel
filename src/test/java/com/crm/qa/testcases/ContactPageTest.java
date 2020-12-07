/*
 * 
 * @gourija mehdi
 * 
 * 
 */


package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

import net.bytebuddy.dynamic.NexusAccessor.InitializationAppender;

public class ContactPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage  homePage;
	ContactsPage contactPage;
	
	String sheetName = "contacts";
	
	public ContactPageTest() {
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
	
//	@Test(priority =1)
//	public void verifyPageContactsPageLabel() {
//		
//		contactPage.verifContactLabel();
//	}
//	@Test(priority =1)
//	public void verifContactslinkTest() throws InterruptedException {
//		
//			contactPage.clickOnContactsLink();
//			contactPage.clickOnDetailContactsLink();
//			Thread.sleep(2000);
//	}
//	
	//hada test f git o github okk"
	
//	@Test(priority =2)
//	public void verifDetailContactslinkTest() throws InterruptedException {
//		
//			contactPage.clickOnDetailContactsLink();
//			Thread.sleep(2000);
//	}

	@DataProvider
	public Object[][] getTestData() {
		
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
    }


	@Test(priority =1, dataProvider = "getTestData")
	public void createNewContactsTest(String firstName, String lastName, String descp) throws InterruptedException  {
		
		    //contactPage.verifContactLabel();
			contactPage.clickOnContactsLink();
			//contactPage.createNewContact("Mr.","Tom","Peter","Google");
			contactPage.NewContactscreate();
			//Thread.sleep(1000);
			contactPage.createNewContact(firstName, lastName, descp);
			//contactPage.clickOnDetailContactsLink();
			
	}
	

}
