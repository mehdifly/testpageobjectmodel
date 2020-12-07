package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	

	//Page Factory:
	
	@FindBy(xpath="//span[contains(.,'sdsdfd zzz')]")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath="//span[contains(.,'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//span[contains(.,'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="(//span[contains(.,'free')])[1]")
	WebElement crmlogo;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

     public Boolean verifCorrectUserName() {
		
		return userNameLabel.isDisplayed();
	}
     
    public String verifHomePageTitle() {
 		
 		return driver.getTitle();
 	}
     
     public ContactsPage clickOnContactsLink() {
    	 contactsLink.click();
		return new ContactsPage();
     }
     
     public DealsPage clickOnDealsLink() {
    	 dealsLink.click();
		return new DealsPage();
     }
}
