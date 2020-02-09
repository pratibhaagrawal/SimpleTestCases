package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RTTC_054_M_Incoice_PlaceOrder {
	private WebDriver driver; 
	
	public RTTC_054_M_Incoice_PlaceOrder(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
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
	}
		
}


