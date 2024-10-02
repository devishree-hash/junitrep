package org.execution;

import java.io.IOException;
import java.time.Duration;

import org.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.pageclass.HomePage;
import org.pageclass.KurtiSetPage;
import org.pageclass.LogOutPage;
import org.pagemanager.PageManager;

public class SnapDealExecutionClass  {
	private void tc02() {
		System.out.println("dev excution");

	}
    public static void main(String[] args) throws IOException, InterruptedException {
		BaseClass baseClass=new BaseClass();
		PageManager pageManager=new PageManager();
		baseClass.getDriver(baseClass.readExcell(0, 1), baseClass.readExcell(1, 1));
		baseClass.getScreenShot();
		baseClass.getWindowMax();
		WebElement searchItem =pageManager.getHomePage().getSearchItem();
    	searchItem.sendKeys(baseClass.readExcell(2, 1));
    	baseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	WebElement searchButton = pageManager.getHomePage().getSearchButton();
    	Thread.sleep(2000);
    	if(searchButton.isEnabled()) {
    		baseClass.excelReportgetRowcreateCell1(3, 1, "search button is appeared");
       }
    	else {
    		baseClass.excelReportgetRowcreateCell1(3, 1, "search button is not appeared");
        	
    	}
    	baseClass.clickButton(searchButton);
    	WebElement kurtiSet = pageManager.getKurtiSetPage().getKurtiSet();
    	String text = kurtiSet.getText();
    	System.out.println(text);
	    baseClass.getScreenShot();
    	baseClass.clickButton(kurtiSet);
	    baseClass.handlingWindow();
	    WebElement cart = pageManager.getKurtiSetPage().getCart();
        baseClass.clickButton(cart);
        WebElement checkCartItem = pageManager.getKurtiSetPage().getCheckCartItem();
        if(checkCartItem.getText().equals("1")) {
        	baseClass.excelReportgetRowcreateCell1(4, 1, " The cart has the items which i have added");
        	 }
        else {
        	baseClass.excelReportgetRowcreateCell1(4, 1, " The cart doesn't have the items which i have added");
        		
        }
        WebElement viewCart =pageManager.getKurtiSetPage().getViewCart();
        baseClass.clickButton(viewCart);
        Thread.sleep(2000);
        WebElement shoppingCart =pageManager.getKurtiSetPage().getShoppingCart();
        if(shoppingCart.isDisplayed()) {
        	baseClass.excelReportgetRowcreateCell1(5, 1, "shoppingCart is displayed ");
        	  }
        WebElement deleteButton = pageManager.getKurtiSetPage().getDeleteButton();
        baseClass.clickButton(deleteButton);
        WebElement proceedToCheckOut =pageManager.getKurtiSetPage().getProceedToCheckOut();
        if(proceedToCheckOut.isDisplayed()) {
        	baseClass.excelReportgetRowcreateCell1(6, 1, "Proceed to chekcout is appeared");
        }
        baseClass.clickButton(proceedToCheckOut);
        WebElement homeLogo = pageManager.getLogOutPage().getHomeLogo();
        baseClass.clickButton(homeLogo);
        WebElement searchPage =pageManager.getLogOutPage().getSearchPage();
        if(searchPage.isDisplayed()) {
        	baseClass.excelReportgetRowcreateCell1(7, 1, "searchPage is appeared");
        }
        baseClass.getScreenShot();
    }
	
}
