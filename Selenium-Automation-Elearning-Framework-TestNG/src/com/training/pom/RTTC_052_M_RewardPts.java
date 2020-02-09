package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RTTC_052_M_RewardPts {
	private WebDriver driver; 
	
	public RTTC_052_M_RewardPts(WebDriver driver) {
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
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/nav[1]/ul[1]/li[7]/ul[1]/li[1]/a[1]")
	public WebElement Custlink;
	
	@FindBy(id="input-name")
	public WebElement custName;
	
	@FindBy(id="button-filter")
	public WebElement filterbtn;

	@FindBy(xpath="//tr[1]//td[8]//a[1]//i[1]")
	public WebElement edit;	
	
	@FindBy(id="input-firstname")
	public WebElement FirstName;
	
	@FindBy(xpath="//a[contains(text(),'Address 1')]")
	public WebElement Address1;
	
	@FindBy(id="input-postcode1")
	public WebElement postcode;
	
	@FindBy(xpath="//ul[@class='nav nav-tabs']//a[contains(text(),'Reward Points')]")
	public WebElement rewardpt;
	
	@FindBy(id="input-reward-description")
	public WebElement desc;
	
	@FindBy(id="input-points")
	public WebElement points;
	
	@FindBy(id="button-reward")
	public WebElement Addpoints;
		
	@FindBy(xpath="//i[@class='fa fa-save']")
	public WebElement savepts;
		
	@FindBy(xpath="//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='menu-report']/a[1]")
	public WebElement report;
		
	@FindBy(xpath="//a[@class='parent'][contains(text(),'Customers')]")
	public WebElement reportCust;
		
	@FindBy(xpath="//a[contains(text(),'Reward Points')]")
	public WebElement CustPts;	

	@FindBy(xpath="//h1[contains(text(),'Customer Reward Points Report')]")
	public WebElement pointsMessage;
	
	@FindBy(xpath="//div[@class='alert alert-success']") 
	public WebElement SuccessMessage;
	
	
	@FindBy(xpath="//div[@id='container']//tbody//tr[1]//td[1]") 
	public WebElement searchresult;
	
	@FindBy(id="input-customer")
	public WebElement updatedcust;
	
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
		

}

