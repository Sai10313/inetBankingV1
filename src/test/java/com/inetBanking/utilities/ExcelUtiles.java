package com.inetBanking.utilities;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtiles {
	/*
	 * public static String filePath=System.getProperty("user.dir")+
	 * "\\src\\test\\java\\com\\inetBanking\\testData\\TestData.xlsx";
	 */
	public static File file;
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	public static int getRowCount(String path,String sheetName) throws IOException {
		file=new File(path);
		System.out.println("filPath");
		
		fis=new FileInputStream(file);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetName);
		
		int rowcount=sheet.getLastRowNum();
		
		workbook.close();
		fis.close();
		return rowcount;
	}
	
	public static int getColCount(String path,String sheetName,int rowNum) throws IOException
	{
		file=new File(path);
		fis=new FileInputStream(file);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		int colcount=row.getLastCellNum();
		
		workbook.close();
		fis.close();
		return colcount;
	}
	
	public static String getCellData(String path,String sheetName,int rowNum,int colNum) throws IOException
	{
		file=new File(path);
		fis=new FileInputStream(file);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rowNum);
		cell=row.getCell(colNum);
		String data;
		try {
			DataFormatter formatter=new DataFormatter();
			String cellData=formatter.formatCellValue(cell);
			return cellData;
			
		}catch(Exception e){
			data="";
		}
		workbook.close();
		fis.close();
		return data;
	}
	
	

}
