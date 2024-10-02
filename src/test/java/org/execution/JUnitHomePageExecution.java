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

public class JUnitHomePageExecution extends BaseClass {
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
	public void tc4() {
        try {
			
		}catch(Exception e) {
			
		}
		
	}
	@AfterClass
	public static void tc5() {
        try {
			
		}catch(Exception e) {
			
		}
		
	}
	
	
	
}
