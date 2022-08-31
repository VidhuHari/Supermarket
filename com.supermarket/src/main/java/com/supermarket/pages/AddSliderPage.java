package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class AddSliderPage {
	WebDriver driver;
	GeneralUtility generalutility;
	PageUtility pageutility;

	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-mobileslider'])[1]")
	WebElement mobileSlider;

	@FindBy(xpath = "//input[@id='main_img']")
	WebElement loadImage;

	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement selectcategory;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	
	
	@FindBy(xpath = "//button[@name='create']")
	WebElement saveButton;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']/h5")
	WebElement alertmessage;
	
	public void clickOnmobileslider()
	{
		mobileSlider.click();
	}
	
	public void clickOnnewButton()
	{
		newButton.click();
	}
	public void scrollDown()
	{
	pageutility.scroll_into_View(loadImage);
	}
	public void selectCategory()
	{
		pageutility = new PageUtility(driver);
		pageutility.select_ByIndex(selectcategory, 2);
	}
public String uploadImage()
{  
	generalutility = new GeneralUtility(driver);
	 pageutility=new PageUtility(driver);
	 clickOnmobileslider();
	 clickOnnewButton();
	 selectCategory();
	//pageutility.scroll_into_View(uploadImage);
	pageutility.fileUpload(loadImage,System.getProperty("user.dir")+"//ProductImages//" + "dairymilk" + ".jpg");
	saveButton.click();
	return generalutility.getTextOfElements(alertmessage);

}
public AddSliderPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}
}