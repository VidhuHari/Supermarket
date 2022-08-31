package com.supermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.supermarket.utilities.GeneralUtility;
import com.supermarket.utilities.PageUtility;

public class ManageExpensePage {
	WebDriver driver;
	GeneralUtility generalutility;
	PageUtility pageutility;
	@FindBy(xpath="//i[@class='nav-icon fas fa-money-bill-alt']")
	private WebElement manageExpenseTab;
	
	@FindBy(xpath="(//i[@class='far fa-circle nav-icon'])[1]")
	private WebElement expenseCategoryButton;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	
	@FindBy(xpath="//input[@class='form-control']")
	private WebElement searchfield;
	
	@FindBy(xpath="//button[@name='Search']")
	private WebElement searchtitle;
	
	@FindBy(xpath="//tbody//tr//td[1]")
	private WebElement title;

	@FindBy(xpath="(//a[@class='btn btn-sm btn btn-danger btncss'])[1]")
	private WebElement deletebutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']/h5")
	private WebElement alertButton;
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-expense']")
	private WebElement manageExpensesubTab;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newbutton;
	
	@FindBy(xpath="//input[@id='ex_date']")
	private WebElement datepicker;
	
	public void clickOnManageExpenseTab()
	{
		manageExpenseTab.click();
	}
	public void clickOnExpenseCategoryTab()
	{
		expenseCategoryButton.click();
	}
	public void clickOnSearchButton()
	{
		searchButton.click();
	}
	public void enterdataonSearchfield()
	{
		searchfield.sendKeys("cereals");
	}
	public void clickOnSearchTitleButton()
	{
		searchtitle.click();
	}
	public void clickOnDeleteButton()
	{
		deletebutton.click();
	}
public boolean clickOnTab() {
	generalutility=new GeneralUtility(driver);
	clickOnManageExpenseTab();
	clickOnExpenseCategoryTab();
	return generalutility.isElementSelected(expenseCategoryButton);
}
public String Searchbuttonchecking()
{
generalutility=new GeneralUtility(driver);
clickOnManageExpenseTab();
clickOnExpenseCategoryTab();
clickOnSearchButton();
enterdataonSearchfield();
clickOnSearchTitleButton();
return generalutility.getTextOfElements(title);
}
public String deleteButtonchecking()
{
	generalutility=new GeneralUtility(driver);
	PageUtility pageutility=new PageUtility(driver);
	clickOnManageExpenseTab();
	clickOnExpenseCategoryTab();
	clickOnDeleteButton();
	pageutility.handlealerts();
	return generalutility.getTextOfElements(alertButton);
}
public ManageExpensePage(WebDriver driver)
{
this.driver=driver;
PageFactory.initElements( driver,this);
}
}
