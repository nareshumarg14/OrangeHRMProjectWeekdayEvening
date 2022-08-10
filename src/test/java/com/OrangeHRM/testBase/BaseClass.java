package com.OrangeHRM.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	//1
	public WebDriver driver;
	public Properties prop;
	
	public Logger logger = LogManager.getLogger(this.getClass());
	
	//2
	@BeforeClass
	@Parameters("browser")
	public void setup(String br) throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Training\\Selenium\\ClassTraining_2022\\OrangeHRM\\resources\\config.properties");
		prop.load(fis);
		
		if (br.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("Chrome Browser is launched");
		} else if(br.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			logger.info("Edge Browser is launched");
		}else if (br.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger.info("Firefox Browser is launched");
		}else {
			logger.info("Please enter parameter values as chrome / edge / firefox");
		}
				
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		if (driver.getTitle().equalsIgnoreCase("OrangeHRM")) {
			logger.info("Orange HRM application is opened");
		} else {
			logger.error("Orange HRM application is not opened");
		}
	}
	
	//3
	@AfterClass
	public void teardown() {
		driver.quit();
		logger.info("Orange HRM application is closed");
	}
}
