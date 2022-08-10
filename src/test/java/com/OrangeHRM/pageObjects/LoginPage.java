package com.OrangeHRM.pageObjects;
//Constructor should be non-static
//Will not have any return types.
//When references are created, constructor will be called.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//1
	public WebDriver driver;
	 
	//2 --> Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//3. Locator for Username
	@FindBy(id="txtUsername")
	WebElement txtUname;
	
	//4. Locator for Password
	@FindBy(name="txtPassword")
	WebElement txtPwd;
	
	//5. Locator for Login button.
	@FindBy(id="btnLogin")
	WebElement loginBtn;
	
	//Locator for Forgot Password? link.
	@FindBy(id="forgotPasswordLink")
	WebElement lnkforgotPassword;
	
	public boolean forgotPasswordLinkStatus() {
		boolean val = lnkforgotPassword.isDisplayed();
		return val;
	}
	
	//6. Entering value in Username field.
	public void setUsername(String username) {
		txtUname.clear();
		txtUname.sendKeys(username);
		String val = txtUname.getAttribute("value");
		System.out.println("Value entered in Username field is - " + val);
	}
	
	//7. Entering value in Password field.
	public void setPassword(String password) {
		txtPwd.clear();
		txtPwd.sendKeys(password);
		String val = txtPwd.getAttribute("value");
		System.out.println("Value entered in Password field is - " + val);
	}
	
	//8. Clicking on Login button.
	public void clickLoginButton() {
		boolean status = loginBtn.isEnabled();
		if (status == true) {
			System.out.println("Login button is enabled");
			loginBtn.click();
			System.out.println("Clicked on Login button");
		} else {
			System.out.println("Login button is not enabled");
		}
	}

	

}
