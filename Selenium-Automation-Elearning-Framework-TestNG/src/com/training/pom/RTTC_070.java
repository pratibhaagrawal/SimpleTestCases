package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RTTC_070 {
	private WebDriver driver; 
	
	public RTTC_070(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="search_button")
	public WebElement SearchBar; 
	
	@FindBy(id="filter_keyword")
	public WebElement Keyword;
	
	@FindBy(xpath="//*[@id=\"search\"]/div/span/div/div/div[1]/div/div/a/strong")
	public WebElement KeySelect;
	
	@FindBy(xpath="//*[@id=\"ProductsSystem_YD9pMDOx\"]/div[1]/div[1]/div/div[2]/div[1]/a/span/span/img")
	public WebElement Ring;
	
	@FindBy(id="button-cart")
	public WebElement AddToCart;
	
	@FindBy(xpath="//*[@id=\"noty_alert_1581182455181\"]/div/div[1]")
	public WebElement alert;
	
	@FindBy(xpath="//i[@class='tb_icon ico-linea-ecommerce-bag']")
	public WebElement cart;
	
	@FindBy(xpath="//a[@class='btn btn-sm'][contains(text(),'Checkout')]")
	public WebElement checkout;
	
	@FindBy(id="input-email")
	public WebElement email;

	@FindBy(id="input-password")
	public WebElement password;
	
	@FindBy(id="button-login")
	public WebElement loggin;	
	
	@FindBy(id="button-payment-address")
	public WebElement addressConti;
	
	@FindBy(id="button-shipping-address")
	public WebElement shippingConti;
	
	@FindBy(xpath="//*[@id=\"collapse-payment-method\"]/div/p[3]/textarea")
	public WebElement comment;
	
	@FindBy(id="button-shipping-method")
	public WebElement FreeConti;
	
	@FindBy(xpath="//input[@name='agree']")
	public WebElement Iagree;
	
	@FindBy(id="button-payment-method")
	public WebElement payConti;
	
	@FindBy(id="button-confirm")
	public WebElement confirm;
	
	
	
		
	public void KeyWordSearch() {
		this.Keyword.click();
		Actions actions = new Actions(driver);
		WebElement key = driver.findElement(By.id("filter_keyword"));
		actions.moveToElement(key).perform();
		actions.click();
	}

	public void KeyWordSearchResult() {
		this.KeySelect.click();
		Actions actions = new Actions(driver);
		WebElement res = driver.findElement(By.xpath("//div[@class='tb_listing tb_compact_view tb_compact_view-search-results']//div[1]//div[1]//div[1]//a[1]//strong[1]"));
		actions.moveToElement(res).perform();
		actions.click();
	}
	public void CartIcon() {
		this.cart.click();
		Actions actions = new Actions(driver);
		WebElement key = driver.findElement(By.xpath("//i[@class='tb_icon ico-linea-ecommerce-bag']"));
		actions.moveToElement(key).perform();
		//actions.click();
	}
	public void CheckOutIcon() {
		this.checkout.click();
		Actions actions = new Actions(driver);
		WebElement key = driver.findElement(By.xpath("//a[@class='btn btn-sm'][contains(text(),'Checkout')]"));
		actions.moveToElement(key).perform();
		actions.click();
	}
	
/*	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//div[@class='alert alert-success']") 
	public WebElement SuccessMessage;

	
	@FindBy(xpath="//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='menu-sale']/a[1]")
	public WebElement SalesIcon;
	
	@FindBy(xpath="//a[contains(text(),'Orders')]")
	public WebElement OrderLink;
	
	@FindBy(xpath="//div[@class='pull-right']//a[@class='btn btn-primary']")
	public WebElement AddNew;	
	
	@FindBy(id="input-firstname")
	public WebElement FirstName;	
	
	@FindBy(id="input-lastname")
	public WebElement LastName;	
	
	@FindBy(id="input-email")
	public WebElement email;	
	
	@FindBy(id="input-telephone")
	public WebElement Telephone;	

	@FindBy(id="button-customer")
	public WebElement Continue;

	@FindBy(id="input-product")
	public WebElement Product;
	
	@FindBy(id="input-quantity")
	public WebElement Quantity;
	
	@FindBy(id="button-product-add")
	public WebElement AddProduct;	
	
	@FindBy(id="button-cart")
	public WebElement Cont;	
	
	@FindBy(id="input-payment-firstname")
	public WebElement FName;	
	
	@FindBy(id="input-payment-lastname")
	public WebElement LName;	
	
	@FindBy(id="input-payment-address-1")
	public WebElement Add1;	
	
	@FindBy(id="input-payment-address-2")
	public WebElement Add2;	
	
	@FindBy(id="input-payment-city")
	public WebElement City;	
	
	@FindBy(id="input-payment-postcode")
	public WebElement PostCode;	

	@FindBy(id="input-payment-country")
	public WebElement Country;	
	
	@FindBy(id="input-payment-zone")
	public WebElement State;
	
	@FindBy(id="button-payment-address")
	public WebElement ContToPay;
	
	@FindBy(id="button-payment-address")
	public WebElement PaymentCont;
	
	@FindBy(id="input-shipping-method")
	public WebElement ShippingMethod;
	
	@FindBy(id="input-payment-method")
	public WebElement PaymentMethod;
	
	@FindBy(id="button-save")
	public WebElement Save;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void CountryName() {
		this.Country.click();
		Select drpdownCountry = new  Select (driver.findElement(By.id("input-payment-country")));
		drpdownCountry.selectByVisibleText("India");
	}
	
	public void StateName() {
		this.State.click();
		Select drpdownRegion = new  Select (driver.findElement(By.id("input-payment-zone")));
		drpdownRegion.selectByVisibleText("Karnataka");
	}
	
	public void ShipMode() {
		this.ShippingMethod.click();
		Select ship = new  Select (driver.findElement(By.id("input-shipping-method")));
		ship.selectByValue("free.free");
	}

	public void PaymentMode() {
		this.PaymentMethod.click();
		Select pay = new  Select (driver.findElement(By.id("input-payment-method")));
		pay.selectByValue("cod");
	}
	
	public void PaymentModeElse() {
		this.PaymentMethod.click();
		Select payelse = new  Select (driver.findElement(By.id("input-payment-method")));
		payelse.selectByValue("free_checkout");
	} */
		
}


