package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtility;

public class PushNotificationsPage {
	WebDriver driver;
	GeneralUtility generalutility;
	ExcelUtility excelutility = new ExcelUtility();

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-notifications']")
	private WebElement pushnotification;

	@FindBy(xpath = "//input[@id='title']")
	private WebElement enterTitle;

	@FindBy(xpath = "//input[@id='description']")
	private WebElement enterDescription;

	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	private WebElement sendButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']/h5")
	private WebElement alertbutton;

	public PushNotificationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void enterTitles(String title) {
		enterTitle.sendKeys(title);
	}

	public void enterDescriptn(String description) {
		enterDescription.sendKeys(description);
	}

	public void clickOnSendbutton() {
		sendButton.click();
	}

	public void clickOnPushnotification() {
		pushnotification.click();
	}

	public String checkPushNotificationInformation() {
		generalutility = new GeneralUtility(driver);
		clickOnPushnotification();
		excelutility.setExcelFile("pushnotification", "PushnotificationInformation");
		String title = excelutility.getCellData(0, 0);
		String description = excelutility.getCellData(0, 1);
		enterTitles(title);
		enterDescriptn(description);
		clickOnSendbutton();
		return generalutility.getTextOfElements(alertbutton);
	}
}
