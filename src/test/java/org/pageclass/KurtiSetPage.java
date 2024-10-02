package org.pageclass;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KurtiSetPage extends BaseClass{
	public KurtiSetPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p[contains(@title,'Lee Moda ')]")
    private WebElement kurtiSet;
	public WebElement getKurtiSet() {
		return kurtiSet;
	}
	@FindBy(id="add-cart-button-id")
	private WebElement cart;
	public WebElement getCart() {
		return cart;
	}
	@FindBy(xpath="//span[@class='cartQuantity']")
	private WebElement checkCartItem;
	public WebElement getCheckCartItem() {
		return checkCartItem;
	}
	@FindBy(xpath="//div[text()='View Cart']")
	private WebElement viewCart;
	public WebElement getViewCart() {
		return viewCart;
	}
	@FindBy(xpath="//h3[text()='Shopping Cart ']")
	private WebElement shoppingCart;
	public WebElement getShoppingCart() {
		return shoppingCart;
	}
	@FindBy(xpath="//span[@class='icon-font-grey-size24 close-popup-icon']")
	private WebElement deleteButton;
	public WebElement getDeleteButton() {
		return deleteButton;
	}
	@FindBy(xpath="//a[text()='Proceed To Checkout']")
	private WebElement proceedToCheckOut;
	public WebElement getProceedToCheckOut() {
		return proceedToCheckOut;
	}
	
	
	
	
	
}
