package com.inetBanking.testCases;

import java.io.IOException;

import com.inetBanking.utilities.ExcelUtiles;

public class ReadData {

	public static void main(String[] args) throws IOException 
	{
		
			String proDir=System.getProperty("user.dir");
			String path=proDir+"\\src\\test\\java\\com\\inetBanking\\testData\\TestData.xlsx";
			System.out.println(path);
			int rowNum=ExcelUtiles.getRowCount(path, "Sheet1");
			System.out.println(rowNum);
			int colNum=ExcelUtiles.getColCount(path, "Sheet1",1);
			String [][]loginData=new String[rowNum][colNum];
			for(int r=1;r<rowNum;r++) 
			{
				
				for(int c=0;c<colNum;c++) 
				{
					loginData[r-1][c]=ExcelUtiles.getCellData(path, "Sheet1", r, c);
					System.out.println(loginData[r-1][c]);
				}
				
			}
			
			
		}

	


	

}
