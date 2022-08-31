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

public class ManageDeliveryBoyPage {
	WebDriver driver;
	GeneralUtility generalutility;
	PageUtility pageutility;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy']")
	private WebElement manageDeliveryBoy;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//h5")
	private WebElement alert;
	
	@FindBy(xpath = "//input[@id='phone']")
	private WebElement phonenumber;
	
	@FindBy(xpath = "//input[@id='name']")
	private WebElement name;
	
	@FindBy(xpath = "//textarea[@id='address']")
	private WebElement address;
	
	
	
	@FindBy(xpath = "//input[@id='name']")
	private WebElement userName;;
	
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement updatebutton;;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']/h5")
	private WebElement updatealert;

	public void clickOnManageUser() {
		manageDeliveryBoy.click();
	}

	public String clickOnDelieveryBoyDeactivateButton(String userName) {
		int j = 0;
		List<String> UsersName = new ArrayList<String>();
		generalutility = new GeneralUtility(driver);
		pageutility = new PageUtility(driver);
		UsersName = generalutility.getElementsText("//tr//td[1]");
		for (j = 0; j < UsersName.size(); j++) {
			if (UsersName.get(j).equals(userName)) {
				j++;
				break;
			}
		}
		WebElement deactivateButton = driver.findElement(By.xpath("//tbody//tr[" + j + "]//td[6]//a"));
		pageutility.scrollAndclick(deactivateButton);
		return generalutility.getTextOfElements(alert);

	}
	

	public String editDelieveryBoyInformation(String userName) {

		int j = 0;
		List<String> UsersName = new ArrayList<String>();
		generalutility = new GeneralUtility(driver);
		pageutility = new PageUtility(driver);
		UsersName = generalutility.getElementsText("//tr//td[1]");
		for (j = 0; j < UsersName.size(); j++) {
			if (UsersName.get(j).equals(userName)) {
				j++;
				break;
			}
		}
		WebElement editbutton = driver.findElement(By.xpath("//tbody//tr[" + j + "]//td[8]//a"));
		pageutility.scrollAndclick(editbutton);
		
		clickOnupdateButton();
		return generalutility.getTextOfElements(updatealert);
		
	}public void updatePhoneField(String phonenum) {
		phonenumber.clear();
		phonenumber.sendKeys(phonenum);
		
	}
	public void clickOnupdateButton() {
		pageutility = new PageUtility(driver);
		pageutility.scrollAndclick(updatebutton);
	}

public ManageDeliveryBoyPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}





}
