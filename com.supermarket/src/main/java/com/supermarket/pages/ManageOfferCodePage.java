package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class ManageOfferCodePage {
	GeneralUtility generalutility;
	PageUtility pageutility;
    WebDriver driver;
    
	@FindBy(linkText ="Manage Offer Code")
	WebElement manageOffer;

	@FindBy(xpath ="//a[@href='https://groceryapp.uniqassosiates.com/admin/Offercode/add']")
	WebElement newButton;

	@FindBy(id ="main_img")
	WebElement uploadImage;
	

	@FindBy(name ="create")
	WebElement saveButton;

	public void clickManageOfferCode()
	{
	manageOffer.click();
	}

	public void clickNewButton()
	{
	newButton.click();
	}
	public void clicksaveButton()
	{
		saveButton.click();
	}
	public void clickchoosefile()
	{
		uploadImage.click();
	}
	public void scrollDown()
	{
	pageutility.scroll_into_View(uploadImage);
	}

	public void imageUpload() 
	{
		generalutility = new GeneralUtility(driver);
		 pageutility=new PageUtility(driver);
		clickManageOfferCode();
		clickNewButton();
		//String destination=System.getProperty("user.dir")+"//ProductImages//"+"dairymilk"+".jpg";
		pageutility.fileUpload(uploadImage,System.getProperty("user.dir")+"//ProductImages//" + "dairymilk" + ".jpg");
		pageutility.scroll_into_View(uploadImage);
	}
public ManageOfferCodePage(WebDriver driver)
{
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
}
