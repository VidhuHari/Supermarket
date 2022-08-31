package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;

public class ManageCodPage {
	WebDriver driver;
	GeneralUtility generalutility;

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/add-cod']")
	private WebElement manageCOD;

	@FindBy(xpath = "//input[@value='yes']")
	private WebElement yesRadiobutton;

	@FindBy(xpath = "//input[@value='no']")
	private WebElement noRadiobutton;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement savebutton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']/h5")
	private WebElement alert;

	public void clickManagecod() {
		manageCOD.click();
	}

	public void clickRadiobuttonYes() {
		yesRadiobutton.click();
	}

	public void clickRadiobuttonNo() {
		noRadiobutton.click();
	}

	public void clickSaveButton() {
		savebutton.click();
	}

	public String selectYesRadioButton() {
		generalutility = new GeneralUtility(driver);
		clickManagecod();
		clickRadiobuttonYes();
		clickSaveButton();
		return generalutility.getTextOfElements(alert);
	}

	public boolean selectNoRadioButton() {
		generalutility = new GeneralUtility(driver);
		clickManagecod();
		clickRadiobuttonNo();
		clickSaveButton();
		return generalutility.isElementSelected(noRadiobutton);

	}

	public ManageCodPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
}
