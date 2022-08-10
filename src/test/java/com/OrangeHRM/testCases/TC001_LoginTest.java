package com.OrangeHRM.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.OrangeHRM.pageObjects.DashboardPage;
import com.OrangeHRM.pageObjects.LoginPage;
import com.OrangeHRM.testBase.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_LoginTest extends BaseClass{	
	@Test
	public void loginTest() {
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(prop.getProperty("uname"));
		lp.setPassword(prop.getProperty("Pwd"));
		lp.clickLoginButton();
		
		DashboardPage dp = new DashboardPage(driver);
		String val = dp.getDashboardLinkName();
		Assert.assertEquals(val, "Dashboard","User did not logged in successfully");
		logger.info("User has logged in successfully");
	}
	
	

}
