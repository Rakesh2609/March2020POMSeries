package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.ConstantsUtil;
import com.qa.hubspot.utils.ElementUtil;

public class HomePage extends BasePage {
	
	private WebDriver driver;
	By header=By.tagName("h1"); /*By header=By.cssSelector("h1.private-header__heading")*/
   
	By accountName=By.cssSelector("span.account-name ");
	
	By primarycontactname=By.id("nav-primary-contacts-branch");
	By secondarycontactname=By.id("nav-secondary-contacts");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		elementutil=new ElementUtil(this.driver);
	}
     
	
	public String getHomePagetitle() {
		
		return elementutil.waitForTitleToBePresent(ConstantsUtil.HOME_PAGE_TILE, 15);
	}
	
	public String getHomePageHeader() {
		

		if(elementutil.doIsDisplayed(header)) {
			
			return elementutil.doGetText(header);
		}
		return null;
		
	    
		
   }
	
	public String getloggedinUser() {
		
		if(elementutil.doIsDisplayed(accountName)) {
		return elementutil.doGetText(accountName);
		}
		else {
		return null;
		}
		
	}

  public ContactsPage goToContactsPage() {
	  clickonContacts();
	  return new ContactsPage(driver);
  }
  
  private void clickonContacts() {
	  elementutil.waitForElementToBeVisible(primarycontactname, 10);
	  elementutil.doClick(primarycontactname);
	  elementutil.waitForElementToBeVisible(secondarycontactname, 5);
	  elementutil.doClick(secondarycontactname);
  }
	
}
