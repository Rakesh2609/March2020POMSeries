package com.qa.hubspot.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.hubspot.base.BasePageTest;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.utils.ConstantsUtil;

public class HomePageTest extends BasePageTest{
	
	HomePage homepage;
	
	@BeforeClass
	public void homesetup(){	
		homepage=loginPage.dologin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=2)
	public void VerifyHomePageTitle() {
		String title=homepage.getHomePagetitle();
		System.out.println("Home page title is:"+title);
		Assert.assertEquals(title, ConstantsUtil.HOME_PAGE_TILE,"Title of the Home page is not M");
	}
	
	@Test(priority=1)
	public void verifypageheading() {
		String header=homepage.getHomePageHeader();
		System.out.println("Home page header is:"+header);
		Assert.assertEquals(header,ConstantsUtil.HOME_PAGE_HEADER ,"Header is not found");
	}
	
	@Test(priority=3)
	public void verifyloggedinuser() {
		String loggedinuser=homepage.getloggedinUser();
		System.out.println("logged in User Name is:"+loggedinuser);
		Assert.assertEquals(loggedinuser,prop.getProperty("accountname"),"Loggedin user is not found");
	}
	
	
}
