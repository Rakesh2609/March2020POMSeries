package com.qa.hubspot.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.ConstantsUtil;
import com.qa.hubspot.utils.ElementUtil;

public class LoginPage extends BasePage {
  
	public WebDriver driver;
	
	//1.By locators--OR
	By username=By.id("username");
	By password=By.id("password");
	By loginbutton=By.id("loginBtn");
	By signuplink=By.linkText("Sign up");
	
	

	//2. Create Constructor of  page class
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		elementutil=new ElementUtil(this.driver);
		
	}
	
    //3.Page actions
	 public String getLoginpagetitle(){
		 
		String title=elementutil.waitForTitleToBePresent(ConstantsUtil.LOGIN_PAGE_TILE, 15);
		 return title;
	  }
	
	public boolean	verifySignupLink(){
		//return driver.findElement(signuplink).isDisplayed();
		return elementutil.doIsDisplayed(signuplink);
	}
   
	public HomePage dologin(String username,String password){
    
	elementutil.waitForElementToBeVisible(this.username, 10);
	elementutil.doSendKeys(this.username, username);
	elementutil.doSendKeys(this.password, password);
	elementutil.doClick(this.loginbutton);
	try {
		Thread.sleep(25000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return new HomePage(driver);
	 
 }

}

