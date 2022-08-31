package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;

public class ManageProductPage {
	WebDriver driver;
	GeneralUtility generalutility;

	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	private WebElement resetButton;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product']")
	private WebElement manageproducts;

	public void clickOnManageProducts() {
		manageproducts.click();
	}

	public String newButtonBackgroundColor() {
		clickOnManageProducts();
		generalutility = new GeneralUtility(driver);
		return generalutility.getCssSelectorValue(newButton, "background-color");
	}

	public String searchButtonFontSize() {
		clickOnManageProducts();
		generalutility = new GeneralUtility(driver);
		return generalutility.getCssSelectorValue(searchButton, "font-size");

	}

	public String resetButtonTextAlignment() {

		clickOnManageProducts();
		generalutility = new GeneralUtility(driver);
		return generalutility.getCssSelectorValue(resetButton, "text-align");
	}

	public String searchbuttonAttributeChecking() {

		generalutility = new GeneralUtility(driver);
		clickOnManageProducts();
		return generalutility.get_AttributeValue(searchButton, "Class");
	}
}
