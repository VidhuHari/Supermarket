package com.supermarket.utilities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeneralUtility {
	WebDriver driver;

	public GeneralUtility(WebDriver driver) {
		this.driver = driver;

	}

	public String getTextOfElements(WebElement element) {
		return element.getText();
	}

	public boolean isElementtextmatches(String expectedText, WebElement element) {
		return element.getText().equals(expectedText);

	}

	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}

	public boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}

	public String getPage_Title() {
		return driver.getTitle();
	}

	public String getCurrent_Url() {
		return driver.getCurrentUrl();
	}

	public String get_AttributeValue(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}

	public List<String> getElementsText(String xpath) {
		List<String> text = new ArrayList<String>();
		List<WebElement> elements = driver.findElements(By.xpath(xpath));
		for (WebElement web : elements) {
			text.add(web.getText());
		}
		return text;
	}

	public String getCssSelectorValue(WebElement element, String property) {
		return element.getCssValue(property);

	}

	public String get_TimeStamp() {
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		return timeStamp;
	}

	public boolean isAttributeValueMatched(WebElement element, String attribute, String expextvalue) {
		return element.getAttribute(attribute).equals(expextvalue);

	}

	public String getTextalerts() {
		return driver.switchTo().alert().getText();
	}
}