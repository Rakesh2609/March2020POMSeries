package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utils.ConstantsUtil;
import com.qa.hubspot.utils.ElementUtil;

public class ContactsPage extends BasePage {
	public WebDriver driver;
	
	By header=By.cssSelector("h1.IndexPageRedesignHeader__StyledH1-ljkrr-1");
	By createcontactPrimary=By.xpath("//span[text()='Create contact']");
	By email=By.xpath("//input[@data-field='email']");
	By firstname=By.xpath("//input[@data-field='firstname']");
	By lastname=By.xpath("//input[@data-field='lastname']");
	By jobtitle=By.xpath("//input[@data-field='jobtitle']");
//	By phone=By.xpath("//input[@data-field='phone']");
	By createsecondarycontact=By.xpath("(//span[text()='Create contact'])[last()]");
	By ContactsBackLink=By.xpath("(//*[text()='Contacts'])[position()=1]");
	
	
	
	public ContactsPage(WebDriver driver) {
		this.driver=driver;
		 elementutil=new ElementUtil(driver);
	}
	
	public String getContactsPageTitle() {
		return elementutil.waitForTitleToBePresent(ConstantsUtil.CONTACTS_PAGE_TILE, 10);
	}
	
	public String getContactsPageheader() {
		elementutil.waitForElementToBeVisible(header, 10);
		return elementutil.doGetText(header);
	}
	
	public void createContact(String email,String firstname,String lastname,String jobtitle) {
		
		elementutil.waitForElementToBeVisible(createcontactPrimary, 10);
		elementutil.doClick(createcontactPrimary);
		
		elementutil.waitForElementToBeVisible(this.email, 10);
		elementutil.doSendKeys(this.email, email);
		elementutil.doSendKeys(this.firstname, firstname);
		elementutil.doSendKeys(this.lastname, lastname);
		elementutil.waitForElementToBeVisible(this.jobtitle, 5);
		elementutil.doSendKeys(this.jobtitle, jobtitle);
		
		elementutil.clickWhenReady(createsecondarycontact, 5);
		
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		elementutil.clickWhenReady(ContactsBackLink, 5);
		
		
}
}