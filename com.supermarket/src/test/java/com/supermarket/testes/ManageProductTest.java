package com.supermarket.testes;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageProductPage;


public class ManageProductTest  extends Base {
	ManageProductPage manageproductpage;
	LoginPage loginpage;
	
	@Test
	
 public void VerifyNewButtonBackgroundcolor() {
	manageproductpage=new ManageProductPage(driver);
	loginpage=new LoginPage(driver);
	loginpage.login();
	manageproductpage.newButtonBackgroundColor();
	String actual=manageproductpage.newButtonBackgroundColor();
	String expected="rgba(220, 53, 69, 1)";
	Assert.assertEquals(actual, expected);
}
	
	@Test(groups = "sanity")
	
	 public void VerifySearchButtonFontSize() {
		manageproductpage=new ManageProductPage(driver);
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageproductpage.searchButtonFontSize();
		String actual=manageproductpage.searchButtonFontSize();
		String expected="16px";
		Assert.assertEquals(actual, expected);
	}
	@Test(groups = "smoke")
	
	 public void VerifyResetButtonTextAlignment() {
		manageproductpage=new ManageProductPage(driver);
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageproductpage.resetButtonTextAlignment();
		String actual=manageproductpage.resetButtonTextAlignment();
		String expected="center";
		Assert.assertEquals(actual, expected);
	}
	@Test
	public void VerifyTheAttributeoftheSearchbutton() {
		manageproductpage=new ManageProductPage(driver);
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageproductpage.searchbuttonAttributeChecking();
		String actual=manageproductpage.searchbuttonAttributeChecking();
		String expected="btn btn-rounded btn-primary";
		Assert.assertEquals(actual, expected);
	}
	
}
