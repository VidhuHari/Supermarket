package com.supermarket.testes;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.supermarket.base.Base;
import com.supermarket.pages.AdminUsersPage;
import com.supermarket.pages.LoginPage;

public class AdminUsersTest extends Base {
	AdminUsersPage adminuserpage;
	LoginPage loginpage;

	@Test(priority = 2)
	public void verifyAddNewAdminUserInformation() {

		loginpage = new LoginPage(driver);
		loginpage.login();
		adminuserpage = new AdminUsersPage(driver);
		String actual = adminuserpage.createNewAdminUser("adminUsers", "UserDetails");
		String expt = "Alert!";
		Assert.assertEquals(actual, expt);
	}

	@Test(priority = 1)
	public void verifyAlreadyExistUserName() {

		loginpage = new LoginPage(driver);
		loginpage.login();
		adminuserpage = new AdminUsersPage(driver);
		String actual = adminuserpage.getAlreadyExistUserInformation();
		String expt = "Alert!";
		Assert.assertEquals(actual, expt);

	}

	@Test(priority = 3)
	public void verifyNewAdminUserLogin() {

		loginpage = new LoginPage(driver);
		loginpage.login();
		adminuserpage = new AdminUsersPage(driver);
		adminuserpage.createNewAdminUser("adminUsers", "UserDetails");
		String actual = adminuserpage.verifynewUserLogin();
		String expt = "Aadi";
		Assert.assertEquals(actual, expt);

	}
}
