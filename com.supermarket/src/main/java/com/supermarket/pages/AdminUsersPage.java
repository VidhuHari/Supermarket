package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class AdminUsersPage {
	WebDriver driver;
	GeneralUtility generalutility;
	PageUtility pageutility;
	ExcelUtility excelutility = new ExcelUtility();

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[1]")
	WebElement adminUsers;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;

	@FindBy(id = "user_type")
	WebElement dropSelect;

	@FindBy(id = "user_type")
	WebElement dropSelecttext;
	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement userTypeOption;

	@FindBy(xpath = "//input[@name='username']")
	WebElement userName;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//button[@name='Create']")
	WebElement save;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//h5")
	WebElement successAlert;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']//h5")
	WebElement alertMessage;

	@FindBy(xpath = "(//a[@class='nav-link'])[2]")
	private WebElement admin;

	@FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
	private WebElement logout;

	@FindBy(xpath = "(//a[@class='nav-link'])[2]")
	private WebElement loginverificatntext;

	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	@CacheLookup
	private WebElement signinButton;

	public void clickAdminUsers() {
		adminUsers.click();
	}

	public void clickNewButton() {
		newButton.click();
	}

	public void clickSaveButton() {
		save.click();
	}

	

	public void enterUserName(String username) {
		userName.sendKeys(username);
	}

	public void enterpassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void clickLogoutButton() {

		generalutility = new GeneralUtility(driver);
		admin.click();
		logout.click();

	}

	public void clickOnLoginbutton() {
		signinButton.click();
	}

	public void login() {
		excelutility.setExcelFile("adminUsers", "UserDetails");
		String userName = excelutility.getCellData(2, 0);
		String password = excelutility.getCellData(2, 1);
		enterUserName(userName);
		enterpassword(password);
		clickOnLoginbutton();
	}

	public void selectUserType(String userType) {
		pageutility = new PageUtility(driver);
		if (userType.equals("Staff")) {
			pageutility.select_ByVisibleText(userTypeOption, "Staff");
		} else if (userType.equals("Admin")) {
			pageutility.select_ByVisibleText(userTypeOption, "Admin");
		} else if (userType.equals("Partner")) {
			pageutility.select_ByVisibleText(userTypeOption, "Partner");
		} else if (userType.equals("Delivery Boy")) {
			pageutility.select_ByVisibleText(userTypeOption, "Delivery Boy");
		}

	}

	public String createNewAdminUser(String excelFile, String excelSheet) {
		generalutility = new GeneralUtility(driver);
		pageutility = new PageUtility(driver);
		excelutility.setExcelFile(excelFile, excelSheet);
		String userName = excelutility.getCellData(2, 0);
		String password = excelutility.getCellData(2, 1);
		String userType = excelutility.getCellData(2, 2);
		clickAdminUsers();
		clickNewButton();
		enterUserName(userName);
		enterpassword(password);
		selectUserType(userType);
		clickSaveButton();
		return generalutility.getTextOfElement(successAlert);

	}
	public String getAlreadyExistUserInformation() {

		generalutility = new GeneralUtility(driver);
		clickAdminUsers();
		clickNewButton();
		excelutility.setExcelFile("adminUsers", "UserDetails");
		String userName = excelutility.getCellData(0, 0);
		String Password = excelutility.getCellData(0, 1);
		enterUserName(userName);
		enterpassword(Password);
		pageutility = new PageUtility(driver);
		pageutility.select_ByIndex(dropSelect, 2);
		clickSaveButton();
		return generalutility.getTextOfElement(alertMessage);
	}

	public String verifynewUserLogin() {
		generalutility = new GeneralUtility(driver);
		clickLogoutButton();
		login();
		return generalutility.getTextOfElement(loginverificatntext);
	}

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}
