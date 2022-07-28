package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePageTest;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.ConstantsUtil;
import com.qa.hubspot.utils.ExcelUtil;

public class ContactsPageTest extends BasePageTest{

	
	HomePage homepage;
	ContactsPage contactpage;
	
	@BeforeClass
	public void contactsetup() {
		homepage=loginPage.dologin(prop.getProperty("username"), prop.getProperty("password"));
		contactpage=homepage.goToContactsPage();
	}
	
	@Test(priority=1)
	public void verifycontactpagetitle() {
		String title=contactpage.getContactsPageTitle();
		Assert.assertEquals(title,ConstantsUtil.CONTACTS_PAGE_TILE,"Title is not correct");
	}
	
	@Test(priority=2)
	public void verifycontactpageheader() {
		String header=contactpage.getContactsPageheader();
		Assert.assertEquals(header, ConstantsUtil.CONTACT_PAGE_HEADER,"Header is not correct");
	}
	
	@DataProvider 
	public Object[][] getContactsTestData() {
		Object data[][] =ExcelUtil.getTestData(ConstantsUtil.CONTACT_SHEET_NAME);
		return data;
	}
	
	@Test(priority=3,dataProvider="getContactsTestData")
	public void creatinganewcontact(String email,String firstname,String lastname,String jobTitle) {
		
		contactpage.createContact(email,firstname,lastname,jobTitle);
	}
}
