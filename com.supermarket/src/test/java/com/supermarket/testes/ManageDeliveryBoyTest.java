package com.supermarket.testes;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.ManageDeliveryBoyPage;


public class ManageDeliveryBoyTest  extends Base{
	LoginPage loginpage;
	ManageDeliveryBoyPage managedeliveryboy;
	@Test
	public void verifyDeliveryboyDeactivation()
	{
		loginpage=new LoginPage(driver);
		managedeliveryboy=new ManageDeliveryBoyPage(driver);
		loginpage.login();
		managedeliveryboy.clickOnManageUser();
		String Actual=managedeliveryboy.clickOnDelieveryBoyDeactivateButton("ammu986");
		String expt="Alert!";
		Assert.assertEquals(Actual, expt);
	
		}
	@Test
	public void verifyDeliveryboyPhonenumberUpdation()
	{
		loginpage=new LoginPage(driver);
		managedeliveryboy=new ManageDeliveryBoyPage(driver);
		loginpage.login();
		managedeliveryboy.clickOnManageUser();
		String actual=managedeliveryboy.editDelieveryBoyInformation("Aryananda");
		System.out.println(actual);
		managedeliveryboy.updatePhoneField("9876543229");
		managedeliveryboy.clickOnupdateButton();
		
		
		//String expt="Alert!";
		//Assert.assertEquals(Actual, expt);
	
		}
}
