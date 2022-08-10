package com.OrangeHRM.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHRM.pageObjects.LoginPage;
import com.OrangeHRM.testBase.BaseClass;

public class TC002_ForgotPasswordLinkDisplayed extends BaseClass{
	@Test
	public void forgotPasswordLinkStatus() {
		LoginPage lp = new LoginPage(driver);
		boolean status = lp.forgotPasswordLinkStatus();
		Assert.assertEquals(status, true,"Forgot Password Link is missing");
		logger.info("Forgot Password link is displayed");
	}
}
