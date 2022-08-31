package com.supermarket.testes;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.supermarket.base.Base;
import com.supermarket.pages.LoginPage;
import com.supermarket.pages.PushNotificationsPage;

public class PushNotificationsTest extends Base {
	PushNotificationsPage pushnotificationpage;
	LoginPage loginpage;

	@Test(groups = {"smoke","sanity"})
	public void verifyPushNotificationInformation() {
		loginpage = new LoginPage(driver);
		pushnotificationpage = new PushNotificationsPage(driver);
		loginpage.login();
		String actual = pushnotificationpage.checkPushNotificationInformation();
		String expt = "Alert!";
		Assert.assertEquals(actual, expt);
	}
}
