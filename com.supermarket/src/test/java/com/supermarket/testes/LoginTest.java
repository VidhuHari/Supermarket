package com.supermarket.testes;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.utilities.DataProviders;

public class LoginTest extends Base {
	LoginPage loginpage;

	@Test
	public void verifyLogin() {
		loginpage = new LoginPage(driver);
		loginpage.login();
	}

	@Test(groups="smoke")
	public void VerifyInvalidCredentialErrorMessage() {
		loginpage = new LoginPage(driver);
		String actualalertMessage = loginpage.getinvalidLoginErrorMessage();
		System.out.println(actualalertMessage);
		String expectAlertMessage = "Alert!";
		Assert.assertEquals(actualalertMessage, expectAlertMessage);
	}

	@Test(dataProvider = "adminUser", dataProviderClass = DataProviders.class)
	public void verifyCreatedAdminLogin(String userName, String password) {
		loginpage = new LoginPage(driver);
		loginpage.login(userName, password);
		Assert.assertTrue(loginpage.getLoginStatus());

	}

	@Test(priority=1)
	public void verifyRemebermeButton() {
		loginpage = new LoginPage(driver);
		loginpage.checkRememberMeButton();
		Assert.assertTrue(true);

	}

}