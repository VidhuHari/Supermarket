package com.supermarket.testes;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.supermarket.base.Base;
import com.supermarket.pages.AdminUsersPage;
import com.supermarket.pages.LoginPage;

public class AdminUsersTest extends Base {
	AdminUsersPage adminuserpage;
	LoginPage loginpage;

	@Test(priority=2)
	public void verifyNewAdminUserInformation() {

		loginpage = new LoginPage(driver);
		loginpage.login();
		adminuserpage = new AdminUsersPage(driver);
		String actual = adminuserpage.getAdminUserInformation();
		String expt = "Alert!";
		Assert.assertEquals(actual, expt);
	}

	@Test(priority=1)
	public void verifyAlreadyExistUserName() {

		loginpage = new LoginPage(driver);
		loginpage.login();
		adminuserpage = new AdminUsersPage(driver);
		String actual = adminuserpage.getAlreadyExistUserInformation();
		String expt = "Alert!";
		Assert.assertEquals(actual, expt);

	}
}
