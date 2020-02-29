package com.ActiTime.genaric;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData  
{
	public static String getData(String filepath,String sheetname,int rn,int cn)
	{
		try 
		{
			FileInputStream fis = new FileInputStream(filepath);
			Workbook wb = WorkbookFactory.create(fis);
			Cell c = wb.getSheet(sheetname).getRow(rn).getCell(cn);
			//String data = c.toString();
			String data = c.getStringCellValue();
			return data;
		} 
		catch (Exception e) 
		{
			return " ";

		}
	}
	
	public static int getLastRowCount(String filepath,String sheetname)
	{
		try 
		{
			FileInputStream fis = new FileInputStream(filepath);
			Workbook wb = WorkbookFactory.create(fis);
			int rc = wb.getSheet(sheetname).getLastRowNum();
			return rc;
		}
		catch (Exception e)
		{
			return -1;
		}
	}
	
	public static int getLastCellCount(String filepath,String sheetname,int rn)
	{
		try 
		{
			FileInputStream fis = new FileInputStream(filepath);
			Workbook wb = WorkbookFactory.create(fis);
			int cc = wb.getSheet(sheetname).getRow(rn).getLastCellNum();
			return cc;
		}
		catch (Exception e)
		{
			return -1;
		}
	}

}
