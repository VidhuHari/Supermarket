package com.supermarket.testes;

import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageOfferCodePage;

public class ManageOfferCodeTest extends Base {
	LoginPage loginpage;
	ManageOfferCodePage manageoffercode;
	@Test
	public void verifyImageuploading()
	{

		loginpage=new LoginPage(driver);
		loginpage.login();
		manageoffercode=new ManageOfferCodePage(driver);
		manageoffercode.clickManageOfferCode();
		manageoffercode.clickNewButton();
		manageoffercode.clickchoosefile();
		manageoffercode.clicksaveButton();
		manageoffercode.scrollDown();
		
}
}