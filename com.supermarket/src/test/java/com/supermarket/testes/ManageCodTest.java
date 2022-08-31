package com.supermarket.testes;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageCodPage;



public class ManageCodTest extends Base{
	LoginPage loginpage;
	ManageCodPage managecodpage;
@Test
public void verifyAddCodYesRadiobutton()
{
	managecodpage =new ManageCodPage(driver);
	loginpage=new LoginPage(driver);
	loginpage.login();
	String actual=managecodpage.selectYesRadioButton();
	String expt= "Alert!";
	Assert.assertEquals(actual,expt);
	
}
@Test
public void verifyAddCodNoRadiobutton()
{
	managecodpage =new ManageCodPage(driver);
	loginpage=new LoginPage(driver);
	loginpage.login();
	managecodpage.selectNoRadioButton();
	Assert.assertTrue(managecodpage.selectNoRadioButton());
}
}
