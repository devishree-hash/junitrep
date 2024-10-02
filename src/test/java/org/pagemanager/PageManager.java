package org.pagemanager;

import org.baseclass.BaseClass;
import org.pageclass.HomePage;
import org.pageclass.KurtiSetPage;
import org.pageclass.LogOutPage;

public class PageManager extends BaseClass{

	private HomePage homePage;
	public HomePage getHomePage() {
		return (homePage==null) ? homePage=new HomePage(): homePage;
	}
	private KurtiSetPage kurtiSetPage;
	public KurtiSetPage getKurtiSetPage() {
		return (kurtiSetPage==null) ? kurtiSetPage=new KurtiSetPage(): kurtiSetPage;
	}
	
	private LogOutPage logOutPage;
	public LogOutPage getLogOutPage() {
		return (logOutPage==null) ? logOutPage=new LogOutPage(): logOutPage;
	}
	
	
	
	
	
}
