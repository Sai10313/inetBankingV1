package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;



public class TC_LoginPageTest_001 extends BaseClass {
	
	@Test
	public void loginTest() {
		
		LoginPage loginPage=new LoginPage(driver);
		
		loginPage.setUserName(userName);
		
		loginPage.setPassword(password);
		
		loginPage.clickLogin();
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			
			Assert.assertTrue(true);
		}else {
			
			Assert.assertTrue(false);
		}
	}

}
