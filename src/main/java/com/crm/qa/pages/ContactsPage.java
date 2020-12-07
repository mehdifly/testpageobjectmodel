package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	

	//Page Factory:
	
	@FindBy(how =How.XPATH, using="//span[contains(.,'sdsdfd zzz')]")
	WebElement contactsLabel;
	
	@FindBy(xpath = "(//button[contains(@class,'ui icon button')])[1]")
	WebElement viewdetailContactsLink;
	
	@FindBy(xpath="//span[contains(.,'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//button[contains(.,'New')]")
	WebElement createcontacts;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastname;
	
	@FindBy(name="description")
	WebElement descp;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

     public Boolean verifContactLabel() {
		
		return contactsLabel.isDisplayed();
	}
     
     public ContactsPage clickOnDetailContactsLink() {
    	 
    	 viewdetailContactsLink.click();
 		return new ContactsPage();
     }
     
     public void selectContactsByName(String name) {
    	driver.findElement(By.xpath("//i[contains(@class,'unhide icon')]"));
     }
     
     public ContactsPage clickOnContactsLink() {
    	 contactsLink.click();
		return new ContactsPage();
     }
     
     public ContactsPage NewContactscreate() {
    	 createcontacts.click();
		return new ContactsPage();
     }
     
     public void createNewContact(String fsttName, String lstName, String dscp) {
    	
//    	 Select select = new Select(driver.findElement(By.name("title")));
//    	 select.selectByVisibleText(title);
    	 
    	
    	 firstName.sendKeys(fsttName);
    	 lastname.sendKeys(lstName);
    	 descp.sendKeys(dscp);
     }
     
}
