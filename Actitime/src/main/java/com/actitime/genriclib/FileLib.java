package com.actitime.genriclib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class is basically devloped to get the data from the excle sheet and properties file, this is the commom data fetch code which can be used for any of the project.
 * 
 * @author ADMIN
 *
 */
public class FileLib {
	
	String excelsheetfilepath="./Data/testdata.xlsx";
	
	String propertiesfilepath="./Data/commondata.properties";
	
	/**
	 * this method will provide you data from properties file based on the key value
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyValue(String key) throws Throwable {
		
		
		FileInputStream fis= new FileInputStream(propertiesfilepath);
		
		Properties pobj= new Properties();
		
		pobj.load(fis);
		
		String data=pobj.getProperty(key);
		
		
		return data;
	}
	
	/**
	 * This method will give you data from excel sheet based on the sheetname, rowNumber and colNumber
	 * @param sheetname
	 * @param rowNum
	 * @param colNum
	 * @return
	 * @throws Throwable
	 */
	
	public String getExcelData(String sheetname, int rowNum, int colNum) throws Throwable {
		
		FileInputStream fis= new FileInputStream(excelsheetfilepath);
		
		Workbook wb= WorkbookFactory.create(fis);
		
		Sheet sh= wb.getSheet(sheetname);
		
		Row rw= sh.getRow(rowNum);
		
		Cell cel= rw.getCell(colNum);
		
		String data= cel.getStringCellValue();
		
		wb.close();
		
		return data;
		
	}
	
	/**
	 * This method will set the data value in excel sheet based on the sheetname , rounumber and colum number
	 * @param sheetname
	 * @param rowNum
	 * @param colNum
	 * @param data
	 * @throws Throwable
	 */
	
	public void setExcelData(String sheetname, int rowNum, int colNum, String data) throws Throwable {
		
		FileInputStream fis= new FileInputStream(excelsheetfilepath);
		
		Workbook wb= WorkbookFactory.create(fis);
		
		Sheet sh= wb.getSheet(sheetname);
		
		Row rw= sh.getRow(rowNum);
		
		Cell cel=rw.createCell(colNum);
		
		cel.setCellValue(data);
		
		FileOutputStream fout= new FileOutputStream(excelsheetfilepath);
		
		wb.write(fout);
		
		wb.close();
		
		
		
		
		
		
	}

}
