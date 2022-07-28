package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePageTest;
import com.qa.hubspot.utils.ConstantsUtil;

public class LoginPageTest extends BasePageTest {

	
@Test(priority=2)
public void verifyLoginPageTitleTest() {
	
	String title=loginPage.getLoginpagetitle();
	System.out.println("Login Page Title is" +title);
	Assert.assertEquals(title, ConstantsUtil.LOGIN_PAGE_TILE,"Login Page Title is not Matched");
}

@Test(priority=1)
public void verifySignupLinkTest() {
	
	Assert.assertTrue(loginPage.verifySignupLink());
}

@Test(priority=3)
public void loginTest() {
	loginPage.dologin(prop.getProperty("username"), prop.getProperty("password"));
}



}
