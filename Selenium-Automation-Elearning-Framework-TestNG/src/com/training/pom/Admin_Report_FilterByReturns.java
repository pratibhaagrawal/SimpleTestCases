package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_Report_FilterByReturns {
	private WebDriver driver; 
	
	public Admin_Report_FilterByReturns(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//i[@class='fa fa-bar-chart-o fw']")
	public WebElement Report;
	
	@FindBy(xpath="//a[contains(text(),'Sales')]")
	public WebElement Sales;
	
	@FindBy(xpath="//ul[@class='collapse in']//a[contains(text(),'Returns')]")
	public WebElement Returns;
	
	@FindBy(xpath="//*[contains(text(),' Returns List')]")
	public WebElement RetHead;
	
	@FindBy(xpath="//td[@class='text-right']")
	public WebElement ResultText;
	
	@FindBy(id="input-group")
	public WebElement GrpByFilter;
	
	@FindBy(id="button-filter")
	public WebElement FilterButton;
		
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
