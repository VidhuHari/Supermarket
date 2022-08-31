package com.supermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class ManageOrdersPage {
	WebDriver driver;
	GeneralUtility generalutility ;
	PageUtility pageutility;
	
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-order'])[1]")
	private WebElement manageorders;
	
	public ManageOrdersPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	public void getDeliveryboyStatus(String userName)
	{
	
}
	public void manageorderclick() {
		manageorders.click();
	}
}