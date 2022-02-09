package com.guru99.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtilities {
	
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xlPath,String xlSheet) throws IOException
	{
		fis=new FileInputStream(xlPath);
		wb=new XSSFWorkbook(fis);
		sheet=wb.getSheet(xlSheet);
		int rowCount=sheet.getLastRowNum();
		wb.close();
		fis.close();
		return rowCount;
		
	}
	
	public static int getColCount(String xlPath,String xlSheet) throws IOException
	{
		fis=new FileInputStream(xlPath);
		wb=new XSSFWorkbook(fis);
		sheet=wb.getSheet(xlSheet);
		row=sheet.getRow(1);
		int colCount=row.getLastCellNum();
		wb.close();
		fis.close();
		return colCount;
		
	}
	
	public static String getCellData(String xlPath,String xlSheet, int rowNum, int colNum) throws IOException
	{
		fis=new FileInputStream(xlPath);
		wb=new XSSFWorkbook(fis);
		sheet=wb.getSheet(xlSheet);
		row=sheet.getRow(rowNum);
		cell=row.getCell(colNum);
		DataFormatter formatter=new DataFormatter();
		String cellData=formatter.formatCellValue(cell);
		wb.close();
		fis.close();
		return cellData;
		
	}
	
	public static void createCellData(String xlPath,String xlSheet, int rowNum, int colNum,String data) throws IOException
	{
		fis=new FileInputStream(xlPath);
		wb=new XSSFWorkbook(fis);
		sheet=wb.getSheet(xlSheet);
		row=sheet.getRow(rowNum);
		cell=row.createCell(colNum);
		cell.setCellValue(data);
		fos=new FileOutputStream(xlPath);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
		
	}
	

}
