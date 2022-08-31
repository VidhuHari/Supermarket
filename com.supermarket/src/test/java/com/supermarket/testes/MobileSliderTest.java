package com.supermarket.testes;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.AddSliderPage;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageOfferCodePage;


public class AddSliderTest extends Base {
	LoginPage loginpage;
	AddSliderPage addsliderpage;
	@Test
	public void verifyImageuploading()
	{
		loginpage=new LoginPage(driver);
		loginpage.login();
		addsliderpage=new AddSliderPage(driver);
       String actual= addsliderpage.uploadImage();
       String expt="Alert!";
       Assert.assertEquals(actual,expt);
}
}