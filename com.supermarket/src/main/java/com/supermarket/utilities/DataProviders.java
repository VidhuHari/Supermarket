package com.supermarket.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	ExcelUtility excelutility=new ExcelUtility();

	@DataProvider(name = "adminUserProfileName")
	public Object[][] adminUse() {
		return new Object[][] { { "deliveryboy1", "deliveryboy1","vidhu" }, { "admin123", "admin" ,"gayathri"}, { "vidhu", "vidhu","devu" },
				{ "qwerty", "qwerty","qwerty123" } };
	}

	@DataProvider(name = "adminUser")
	public Object[][] adminUser() {
		
		excelutility.setExcelFile("loginData", "AdminUserCredentials");
		Object data[][] = excelutility.getMultidimentionalData(4, 2);
		return data;
	}
	
	
}