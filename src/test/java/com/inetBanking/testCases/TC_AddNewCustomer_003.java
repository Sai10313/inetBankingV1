package com.inetBanking.testCases;


import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_AddNewCustomer_003 extends BaseClass {
	
	
	@Test
	public void addCustomerTest() throws IOException, InterruptedException {
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPassword(password);
		lp.clickLogin();
		
		Thread.sleep(3000);
		
		AddCustomerPage acp=new AddCustomerPage(driver);
		acp.addCustomer();
		
		acp.setName("lkjhlkjh");
		acp.setDob("13","10","2001");
		acp.setAddress("Street");
		acp.setCity("sdkjfhg");
		acp.setState("askdjfhkhf");
		acp.setPinNumber("561003");
		acp.setPhNumber("8231425609");
		acp.setEmail(randomString()+"@gmail.com");
		acp.setPassword("asdflkjhasd");
		Thread.sleep(2000);
		acp.submitBtn();
		Thread.sleep(2000);
		
		boolean flag=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(flag==true)
		{
			Assert.assertTrue(flag);
		}
		else {
			captureScreen(driver,"addCustomerTest");
			Assert.assertTrue(false);
		}
		
		
	}
	
}
