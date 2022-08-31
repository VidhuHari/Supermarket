package com.supermarket.testes;

import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageLocationPage;

public class ManageLocationTest extends Base {
	LoginPage loginpage;
	ManageLocationPage managelocationpage;
@Test
public void verifyTextOfSelectedCountrydropdown()
{
	loginpage=new LoginPage(driver);
	loginpage.login();
	managelocationpage =new ManageLocationPage(driver);
	String actual=managelocationpage.gettextofSelectedContryDropdown("United Kingdom");

}
}