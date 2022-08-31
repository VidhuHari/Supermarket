package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class ManageLocationPage {
	WebDriver driver;
	GeneralUtility generalutility;
	PageUtility pageutility;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-location'])[1]")
	private WebElement managelocation;

	@FindBy(xpath = "(//select[@class='form-control selectpicker'])[1]")
	private WebElement countryName;
	
	@FindBy(xpath="//select[@id='country_id']/option[2]")
	private WebElement countryNameDropdown;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;

	public void clickOnManageLocationTab() {
		managelocation.click();
	}

	public void clickOnNewbutton() {
		newButton.click();
	}
	public String gettextofSelectedContryDropdown(String country) {
		generalutility = new GeneralUtility(driver);
		pageutility = new PageUtility(driver);
		clickOnManageLocationTab();
		clickOnNewbutton();
		pageutility.select_ByVisibleText(countryName, country);
		return generalutility.getTextOfElements(countryNameDropdown);
	}
	public ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
}
