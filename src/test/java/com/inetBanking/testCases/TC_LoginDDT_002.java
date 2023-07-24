package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.ExcelUtiles;



public class TC_LoginDDT_002 extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) {
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		lp.setPassword(pwd);
		lp.clickLogin();
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
			lp.logOut();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
		
	}
	
	public boolean isAlertPresent()
	{
		try {
			driver.switchTo().alert();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException {
		String proDir=System.getProperty("user.dir");
		String path=proDir+"\\src\\test\\java\\com\\inetBanking\\testData\\TestData.xlsx";
		int rowcount=ExcelUtiles.getRowCount(path, "Sheet1");
		System.out.println(rowcount);
		int colcount=ExcelUtiles.getColCount(path, "Sheet1",1);
		System.out.println(colcount);
		String loginData[][]=new String[rowcount][colcount];
		
		for(int r=1; r<rowcount; r++) {
			
			for(int c=0; c<colcount; c++) {
				loginData[r-1][c]=ExcelUtiles.getCellData(path, "Sheet1", r, c);
				
			}
		}
		return loginData;
		
	}

}
