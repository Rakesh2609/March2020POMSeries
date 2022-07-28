package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.hubspot.utils.ConstantsUtil;
import com.qa.hubspot.utils.ElementUtil;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BasePage  {
	
	public WebDriver driver;
	public Properties prop;
	public ElementUtil elementutil;

	/**
	 * This Method is used to initialize the WebDriver on the basis of browser
	 * @param browser
	 * @return driver
	 */
	
	public WebDriver init_driver(Properties prop){
		
		String browser=prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		else if(browser.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver=new FirefoxDriver();
			
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		 return driver;
		 
	}

	
	/**
	 * This Method is used to initialize properties from config properties file
	 * @return prop
	 */
	public Properties init_prop() {
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream(ConstantsUtil.configpath);
			prop.load(ip);

		} catch (FileNotFoundException e) {
			
			System.out.println("File not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Unable to load properties");
			e.printStackTrace();
		}
		 return prop;
		 
	}

}
