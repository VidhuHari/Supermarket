package com.supermarket.testes;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageExpensePage;
import com.supermarket.pages.ManageUsersPage;
@Test
public class ManageExpenseTest extends Base {
	ManageExpensePage manageexpensepage;
	LoginPage loginpage;
	@Test
	public void verifyExpensecategoryRadioButtonIsSelected()
	{
		manageexpensepage=new ManageExpensePage(driver);
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageexpensepage.clickOnTab();
		Assert.assertTrue(true);
		
}
	@Test
	public void verifyExpenseCategorySearchButton()
	{  
		manageexpensepage=new ManageExpensePage(driver);
		loginpage=new LoginPage(driver);
		loginpage.login();
		String actual=manageexpensepage.Searchbuttonchecking();
		System.out.println(actual);
		String expt="cereals";
		Assert.assertEquals(actual, expt);
		
}
	
@Test
	
	public void verifywhetherDeleteButtonisWorking()
	{
		
		loginpage=new LoginPage(driver);
		loginpage.login();
		manageexpensepage=new ManageExpensePage(driver);
		String actual=manageexpensepage.deleteButtonchecking();
		String expt="Alert!";
		Assert.assertEquals(actual, expt);
		
		
}
}
