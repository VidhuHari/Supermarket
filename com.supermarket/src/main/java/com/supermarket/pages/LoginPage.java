package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.ExcelUtility;
import com.supermarket.utilities.GeneralUtility;

public class LoginPage {
	ExcelUtility excelutility=new ExcelUtility() ;
	GeneralUtility generalutility;
	WebDriver driver;
	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameField;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordField;

	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	private WebElement signinButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']/h5")
	private WebElement invalidLoginAlertMessage;
	
	@FindBy(xpath="//span[text()='7rmart supermarket']")
	private WebElement profileImage;
	
	@FindBy(xpath="//div[@class='icheck-dark']")
	private WebElement Rememberme;
	
	public void enterUserName(String userName) {
		userNameField.sendKeys(userName);
	}
	public void enterpassword(String password) {
		passwordField.sendKeys(password);
	}
	public void clickOnLoginbutton() {
		signinButton.click();
	}
	public void login(String userName,String password)
	{
		enterUserName(userName);
		enterpassword(password);
		clickOnLoginbutton();
	}
	public void login()
	{
		excelutility.setExcelFile("LoginData", "ValidLoginCredentials");
		String userName=excelutility.getCellData(1,0);
		String password=excelutility.getCellData(1,1);
		enterUserName(userName);
		enterpassword(password);
		clickOnLoginbutton();
	}
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public String getinvalidLoginErrorMessage()
	{
		generalutility=new GeneralUtility(driver);
		excelutility.setExcelFile("LoginData", "InvalidLoginCredentials");
		String userName=excelutility.getCellData(1,0);
		String password=excelutility.getCellData(1,1);
		login(userName, password);
		return generalutility.getTextOfElements(invalidLoginAlertMessage);
		
}
	public boolean getLoginStatus()
	{
		generalutility=new GeneralUtility(driver);
		return generalutility.isElementDisplayed(profileImage);
		 
	}
	public boolean checkRememberMeButton()
	{
		
		generalutility=new GeneralUtility(driver);
		Rememberme.click();
		return generalutility.isElementSelected(Rememberme);
		
			}
	}
