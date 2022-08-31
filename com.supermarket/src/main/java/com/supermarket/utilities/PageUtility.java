package com.supermarket.utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
WebDriver driver;
Select select;
Actions actions;
public PageUtility(WebDriver driver)
{
	this.driver=driver;
}
public void ClearTextField(WebElement element)
{
element.clear();
}
public void select_ByIndex(WebElement element,int index)
{
select=new Select(element);
select.selectByIndex(index);
}
public void select_ByValue(WebElement element,String value)
{
select=new Select(element);
select.selectByValue(value);
}
public void select_ByVisibleText(WebElement element,String visibletext)
{
select=new Select(element);
    select.selectByVisibleText(visibletext);

}
public void moveTo_Element(WebElement element )
{
	actions=new Actions(driver);
	actions.moveToElement(element).build().perform();
}

public void Element_RightClick(WebElement element )
{
	actions=new Actions(driver);
	actions.contextClick(element).build().perform();
}
public void Element_DoubleClick(WebElement element )
{
	actions=new Actions(driver);
	actions.doubleClick(element).build().perform();
}
public void Element_dragAndDrop(WebElement sourceelement,WebElement destnelement )
{
	actions=new Actions(driver);
	actions.dragAndDrop(sourceelement,destnelement).build().perform();
}
public void switch_To_Frame_by_Name(String name) {
	driver.switchTo().frame(name);
}
public void fileUpload(WebElement element, String path) {
    element.sendKeys(path);
}
public void scroll_By(int x,int y)
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(" + x + "," + y + ")");
}
public void scroll_into_View(WebElement element) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", element);
}
public void pageRefresh()
{
	driver.navigate().refresh();
}

public boolean checkClickstatus(WebElement element) {
	try {
		element.click();
		return false;

	} catch (Exception e) {

		return true;
	}

}

public void scrollAndclick(WebElement element) {
	int x = 0;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	while(checkClickstatus(element))
	{
		js.executeScript("window.scrollBy(0," + x + ")");
		x=x+50;
	}
}
public void handlealerts()
{
	driver.switchTo().alert().accept();
}
public void dismissalerts()
{
	driver.switchTo().alert().dismiss();
}
public String gettextalerts()
{
	return driver.switchTo().alert().getText();
}
public boolean isElementPresent(String xpath)
{
	try {
		WebElement element=driver.findElement(By.xpath(xpath));
		return true;
	} catch (Exception e) {
		return false;
	}
}
}