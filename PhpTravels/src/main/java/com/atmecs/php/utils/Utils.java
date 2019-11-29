package com.atmecs.php.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * purpose:Read data from external file (property reader,excel reader,csv
 * reader)
 * 
 * @author ranjitha.selvam
 */

public class Utils {
	
    public File file;
	public FileInputStream stream;
	public Properties propertyFile = new Properties();
	public XSSFWorkbook book;
	public XSSFSheet sheet;
	public XSSFCell cell;
	

	/**
	 * Property file Reader(read the data from property file)
	 * 
	 */
	public String propertyRead(String path, String elements) {
		String data = null;
		propertyFile = new Properties();
		FileInputStream reader = null;
		try {
			reader = new FileInputStream(path);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			propertyFile.load(reader);
			data = propertyFile.getProperty(elements);

		} catch (IOException e) {
           e.printStackTrace();
		}
		return data;
	}

	/**
	 * Read specific cell value via excel reader
	 * 
	 * @param path
	 */
		
		public String readData(String path,String sheetName,int row,int column)
		{
			
			String data=null;
			try {
				 file=new File(path);
				 stream=new FileInputStream (path);
;				
			stream=new FileInputStream(file);
				try {
					 book=new XSSFWorkbook(stream);
				} catch (IOException e) {
					e.printStackTrace();
				}
				sheet=book.getSheet(sheetName);
				cell = sheet.getRow(row).getCell(column);
				data = cell.toString();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			return data;
			

		
		}

	
}

