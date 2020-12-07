package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory:
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;

	@FindBy(xpath="//span[contains(.,'Log In')]")
	WebElement loginBtn;
	
	@FindBy(xpath="(//div[contains(.,'Login')])[5]")
	WebElement signBtn;
	
	@FindBy(xpath="(//span[contains(.,'free')])[1]")
	WebElement crmlogo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validationLoginPageTitle() {
		
		return driver.getTitle();
	}
	public boolean validateCrmImage() {
		
		return crmlogo.isDisplayed();
	}
	
	public void loginIn() {
		
	
		loginBtn.click();
		
	
	}
	
	public void setUserName(String strUserName){

		email.sendKeys(strUserName);     
    }

    //Set password in password textbox

    public void setPassword(String strPassword){

    	password.sendKeys(strPassword);

    }
	public HomePage login(String strUserName, String strPassword) {
		
		this.setUserName(strUserName);
		this.setPassword(strPassword);
//		email.sendKeys(us);
//		password.sendKeys(pwd);
		signBtn.click();
		
		return new HomePage();
		
	}
}
