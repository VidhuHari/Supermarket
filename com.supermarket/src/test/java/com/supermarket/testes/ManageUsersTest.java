package com.supermarket.testes;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageUsersPage;

public class ManageUsersTest extends Base {
	ManageUsersPage manageuserpage;
	LoginPage loginpage;
	@Test
	public void verifyAdminUserDeactivation()
	{
		loginpage=new LoginPage(driver);
		manageuserpage=new ManageUsersPage(driver);
		loginpage.login();
		manageuserpage.clickOnManageUser();
		manageuserpage.clickOnUsersDeactivateButton("Surabhi vishnu");
		
		}
	
}