package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Medium_CreateNewGrpAndRegisterUser {
	private WebDriver driver; 
	
	public Medium_CreateNewGrpAndRegisterUser(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//i[@class='fa fa-user fw']")
	public WebElement customericon;
	
	@FindBy (xpath="/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[7]/ul[1]/li[2]/a[1]")
	public WebElement CustGrp;
	
	@FindBy(xpath="//div[@class='pull-right']//a[@class='btn btn-primary']")
	public WebElement AddButton;
	
	@FindBy(xpath="//input[@placeholder='Customer Group Name']")
	public WebElement GrpName;
	
	@FindBy(id="input-description1")
	public WebElement Desc;
	
	@FindBy(xpath="//div[@class='col-sm-10']//label[1]")
	public WebElement ApproveYes;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	public WebElement SaveNewCust;
	
	@FindBy(xpath="//div[@class='alert alert-success']") //this xpath is capturing X along with the required text
	public WebElement SuccessMessage;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[7]/ul[1]/li[1]/a[1]")
	public WebElement Custlink;
	
	@FindBy(xpath="//div[@class='pull-right']//a[@class='btn btn-primary']")
	public WebElement AddCust;
	
	@FindBy(id="input-customer-group")
	public WebElement CustGrpName;
	
	@FindBy(id="input-firstname")
	public WebElement FirstName;
	
	@FindBy(id="input-lastname")
	public WebElement LastName;
	
	@FindBy(id="input-email")
	public WebElement email;
	
	@FindBy (id="input-telephone")
	public WebElement tele;
	
	@FindBy(id="input-password")
	public WebElement enterpassword;
	
	@FindBy(id="input-confirm")
	public WebElement confpassword;
	
	@FindBy(xpath="//i[@class='fa fa-plus-circle']")
	public WebElement AddAddress;
	
	@FindBy(id="input-firstname1")
	public WebElement firstname1;
	
	@FindBy(id="input-lastname1")
	public WebElement lastname1;
	
	@FindBy(id="input-address-11")
	public WebElement Address1;
	
	@FindBy(id="input-address-21")
	public WebElement Address2;	
	
	
	@FindBy(id="input-city1")
	public WebElement City;
	
	@FindBy(id="input-postcode1")
	public WebElement postcode;
	
	@FindBy(id="input-country1")
	public WebElement Country;	
	
	@FindBy(id="input-zone1")
	public WebElement Region;	
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	public WebElement WarningMsg;
	
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
	
		
	public void privilegedCustGrp() {
		this.CustGrpName.click();
		Select drpdownCustGrp = new  Select (driver.findElement(By.id("input-customer-group")));
		drpdownCustGrp.selectByVisibleText("privileged customer");
	}
	
	public void CountryName() {
		this.Country.click();
		Select drpdownCountry = new  Select (driver.findElement(By.id("input-country1")));
		drpdownCountry.selectByVisibleText("India");
	}
	
	public void RegionName() {
		this.Region.click();
		Select drpdownRegion = new  Select (driver.findElement(By.id("input-zone1")));
		drpdownRegion.selectByVisibleText("Karnataka");
}
}
