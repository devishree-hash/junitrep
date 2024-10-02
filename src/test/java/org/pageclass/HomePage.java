package org.pageclass;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass{

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@placeholder='Search products & brands']")
	private WebElement searchItem;
	public WebElement getSearchItem() {
		return searchItem;
	}
	@FindBy(xpath="//button[@class='searchformButton col-xs-4 rippleGrey']")
	private WebElement searchButton;
	public WebElement getSearchButton() {
		return searchButton;
	}
	
	
}
