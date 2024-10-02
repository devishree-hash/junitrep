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

import com.aventstack.extentreports.Status;

public class JUnitLogOutPageExecution extends BaseClass {
	public static BaseClass baseClass=new BaseClass();
	public static PageManager pageManager=new PageManager();
	
	@Before
	public void searchItem() {
		try {
			baseClass.getDriver(baseClass.readExcell(0, 1), baseClass.readExcell(1, 1));
			baseClass.getScreenShot();
			baseClass.getWindowMax();
		}catch(Exception e) {
			
		}
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
     		test.log(Status.PASS, "search button is appeared");
    		
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
            	test.log(Status.PASS, "The cart has the items which i have added");
        		
            }else {
            	test.log(Status.FAIL, "The cart doesnt have the items which i have added");
            }
		}catch(Exception e) {
			
		}
        try {
       	 WebElement viewCart =pageManager.getKurtiSetPage().getViewCart();
            baseClass.clickButton(viewCart);
            Thread.sleep(2000);
            WebElement shoppingCart =pageManager.getKurtiSetPage().getShoppingCart();
            if(shoppingCart.isDisplayed()) {
            	test.log(Status.PASS, "shoppingCart is displayed ");
        		
            	  }
            else{
            	test.log(Status.FAIL, "shoppingCart is not displayed ");
        		
            }
            WebElement deleteButton = pageManager.getKurtiSetPage().getDeleteButton();
            baseClass.clickButton(deleteButton);
            WebElement proceedToCheckOut =pageManager.getKurtiSetPage().getProceedToCheckOut();
            if(proceedToCheckOut.isDisplayed()) {
            	test.log(Status.PASS, "proceed to chekcout is appeared");
            }
            else {
            	test.log(Status.FAIL, "proceed to chekcout is not appeared");
        		
            }
            baseClass.clickButton(proceedToCheckOut);
            WebElement homeLogo = pageManager.getLogOutPage().getHomeLogo();
            baseClass.clickButton(homeLogo);
            WebElement searchPage =pageManager.getLogOutPage().getSearchPage();
            if(searchPage.isDisplayed()) {
            	test.log(Status.PASS, "searchPage is appeared");
            }
            else{
            	test.log(Status.PASS, "searchPage is not appeared");
            }
            baseClass.getScreenShot();
        
            
			
		}catch(Exception e) {
			
		}
		
	}
	
}
