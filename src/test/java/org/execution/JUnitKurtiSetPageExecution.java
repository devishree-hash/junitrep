package org.execution;

import java.time.Duration;

import org.baseclass.BaseClass;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.pagemanager.PageManager;


public class JUnitKurtiSetPageExecution extends BaseClass {
	public static BaseClass baseClass=new BaseClass();
	public static PageManager pageManager=new PageManager();
	@BeforeClass
	public static void browserLaunch_urlLaunch() {
		try {
			baseClass.getDriver(baseClass.readExcell(0, 1), baseClass.readExcell(1, 1));
			baseClass.getScreenShot();
			baseClass.getWindowMax();
		}catch(Exception e) {
			
		}
	}
	@Before
	public void searchItem() {
		try {
			WebElement searchItem =pageManager.getHomePage().getSearchItem();
	    	searchItem.sendKeys(baseClass.readExcell(2, 1));
	    	baseClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
		}catch(Exception e) {
			
		}
		
	}
	@Test
	public void searchButton() {
     try {
    	 WebElement searchButton = pageManager.getHomePage().getSearchButton();
     	Thread.sleep(2000);
     	if(searchButton.isEnabled()) {
    		baseClass.excelReportgetRowcreateCell1(3, 1, "search button is appeared");
       }
    	else {
    		baseClass.excelReportgetRowcreateCell1(3, 1, "search button is not appeared");
        	
    	}
     	baseClass.clickButton(searchButton);
			
		}catch(Exception e) {
			
		}
		
	}
	@After
	public void enterKurtiSet() {
        try {
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
			
		}catch(Exception e) {
			
		}
		
	}
	@AfterClass
	public static void viewCart() {
        try {
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
                
             
			
		}catch(Exception e) {
			
		}
		
	}
	
	

}
