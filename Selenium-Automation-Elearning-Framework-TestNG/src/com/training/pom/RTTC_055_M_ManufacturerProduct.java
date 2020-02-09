package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RTTC_055_M_ManufacturerProduct {
	private WebDriver driver; 
	
	public RTTC_055_M_ManufacturerProduct(WebDriver driver) {
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
	
	@FindBy(xpath="//*[@id=\"menu-catalog\"]/ul/li[7]/a")
	public WebElement Manufacturer;	

	@FindBy(xpath="//*[@id=\"menu-catalog\"]/a")
	public WebElement Catalog;	
	
	@FindBy(xpath="//i[@class='fa fa-plus']")
	public WebElement AddNew;
	
	@FindBy(id="input-name")
	public WebElement ManuName;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	public WebElement Save;
	
	@FindBy(xpath="//*[@id=\"menu-dashboard\"]/a")
	public WebElement Dashboard;
	
	@FindBy(xpath="//*[@id=\"menu-catalog\"]/ul/li[2]/a")
	public WebElement Product;	
	
	@FindBy(id="input-name1")
	public WebElement ProductName;
	
	@FindBy(id="input-meta-title1")
	public WebElement MetaTag;
	
	@FindBy(xpath="//a[contains(text(),'Data')]")
	public WebElement DataTab;
	
	@FindBy(id="input-model")
	public WebElement Model;
	
	@FindBy(id="input-price")
	public WebElement Price;
	
	@FindBy(id="input-quantity")
	public WebElement Quantity;
	
	@FindBy(xpath="//a[contains(text(),'Links')]")
	public WebElement Linktab;
	
	@FindBy(id="input-manufacturer")
	public WebElement ManuText;
	
	@FindBy(id="input-category")
	public WebElement CatagoryList;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button")
	public WebElement SaveFinal;
		
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
	
	public void CatagoryListss() {
		this.CatagoryList.click();
		Select cata = new  Select (driver.findElement(By.id("input-category")));
		cata.selectByIndex(1);
	}
	
/*	public void StateName() {
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


