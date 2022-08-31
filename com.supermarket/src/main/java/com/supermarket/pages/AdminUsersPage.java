package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class AdminUsersPage {
	WebDriver driver;
	GeneralUtility generalutility;
	PageUtility pageutility;

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[1]")
	WebElement adminUsers;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;

	@FindBy(id = "user_type")
	WebElement dropSelect;

	@FindBy(id = "user_type")
	WebElement dropSelecttext;

	@FindBy(xpath = "//input[@id='username']")
	WebElement userName;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//button[@name='Create']")
	WebElement save;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//h5")
	WebElement savealert;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']//h5")
	WebElement alertMessage;

	public void clickAdminUsers() {
		adminUsers.click();
	}

	public void clickNewButton() {
		newButton.click();
	}

	public void clickSaveButton() {
		save.click();
	}

	public String getAdminUserInformation() {
		clickAdminUsers();
		clickNewButton();
		userName.sendKeys("Dhwanikrishnan2");
		password.sendKeys("vidhu");
		pageutility = new PageUtility(driver);
		pageutility.select_ByIndex(dropSelect, 2);
		generalutility = new GeneralUtility(driver);
		clickNewButton();
		clickSaveButton();
		return generalutility.getTextOfElements(savealert);
	}

	public String getAlreadyExistUserInformation() {

		clickAdminUsers();
		clickNewButton();
		userName.sendKeys("Dhwanikrishna");
		password.sendKeys("vidhu");
		pageutility = new PageUtility(driver);
		pageutility.select_ByIndex(dropSelect, 2);
		generalutility = new GeneralUtility(driver);
		clickNewButton();
		clickSaveButton();
		return generalutility.getTextOfElements(alertMessage);
	}
	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}
