package org.pageclass;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage extends BaseClass {
	public LogOutPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Snapdeal']")
    private WebElement homeLogo;
	public WebElement getHomeLogo() {
		return homeLogo;
	}
	@FindBy(xpath="//div[@class='col-xs-14 search-box-wrapper']")
	private WebElement searchPage;
	public WebElement getSearchPage() {
		return searchPage;
	}
}
