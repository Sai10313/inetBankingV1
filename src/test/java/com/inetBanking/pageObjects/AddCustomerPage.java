package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;

	
	@FindBy(linkText="New Customer")
	WebElement addCustomer;
	
	@FindBy(name="name")
	WebElement namefeild;
	
	@FindBy(id="dob")
	WebElement dob;
	
	@FindBy(name="addr")
	WebElement address;
	
	@FindBy(name="city")
	WebElement cityFeild;
	
	@FindBy(name="state")
	WebElement stateFeild;
	
	@FindBy(name="pinno")
	WebElement pincode;
	
	@FindBy(name="telephoneno")
	WebElement phNumber;
	
	@FindBy(name="emailid")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="sub")
	WebElement submit;
	
	public AddCustomerPage(WebDriver rdriver) {
		this.ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
		
	}
	
	
	public void addCustomer()
	{
		addCustomer.click();
	}
	
	public void setName(String name) {
		namefeild.sendKeys(name);
	}
	public void setDob(String day,String month, String year)
	{
		dob.sendKeys(day);
		dob.sendKeys(month);
		dob.sendKeys(year);
	}
	public void setAddress(String addres) {
		address.sendKeys(addres);
	}
	
	public void setCity(String city) {
		cityFeild.sendKeys(city);
	}
	
	public void setState(String state) {
		stateFeild.sendKeys(state);
	}
	
	public void setPinNumber(String pinNumber) {
		pincode.sendKeys(pinNumber);
	}
	public void setPhNumber(String mobile) {
		phNumber.sendKeys(mobile);
	}
	
	public void setEmail(String mail) {
		email.sendKeys(mail);
	}
	
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void submitBtn() {
		submit.click();
	}
		

}
