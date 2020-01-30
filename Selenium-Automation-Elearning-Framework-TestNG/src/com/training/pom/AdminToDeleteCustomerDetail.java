package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminToDeleteCustomerDetail {
	private WebDriver driver; 
	
	public AdminToDeleteCustomerDetail(WebDriver driver) {
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
	public WebElement customer;
	
	@FindBy(id="input-name")
	public WebElement CustName;
	
	@FindBy(id="button-filter")
	public WebElement FilterButton;
	
	@FindBy(xpath="//tbody/tr[1]/td[1]/input[1]")
	public WebElement customerToBeDeleted;
	
	@FindBy(xpath="//button[@class='btn btn-danger']")
	public WebElement deletebutton;
	
	@FindBy(xpath="//*[contains(text(),'Success: You have modified customers!')]") //this xpath is capturing X along with the required text
	public WebElement SuccessMessage;
	
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
