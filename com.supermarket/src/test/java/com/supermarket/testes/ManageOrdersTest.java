package com.supermarket.testes;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageOrdersPage;
import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class ManageOrdersTest extends Base {
	LoginPage loginpage;
	ManageOrdersPage manageorderspage;
	GeneralUtility generalutility;
	PageUtility pageutility;
	@Test
	public void verifyAssigndeliveryBoyStatus(String userName) {
		loginpage = new LoginPage(driver);
		loginpage.login();
		
	}
}
