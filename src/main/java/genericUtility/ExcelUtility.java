package genericUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * This method is used to fetch data from Excel
	 * created by shivu
	 * @return 
	 * @throws Throwable
	 * 
	 */
	public String getExceldata(String sheetname, int rownum, int cellnum) throws Throwable
	{
	File src = new File(Constants.excelpath);
	FileInputStream fis1 = new FileInputStream(src);
	Workbook book = WorkbookFactory.create(fis1);
	Sheet sheet = book.getSheet(sheetname);
	Row row = sheet.getRow(rownum);
	Cell cell = row.getCell(cellnum);
	String value = cell.toString();
	book.close();
	return value;
	}
	
	/**
	 * used to get the last used row number on specified Sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable 
	{
		FileInputStream fis  = new FileInputStream(Constants.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
	}
	
	/**
	 * used to write data back to Excel based on below parameter
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @param data
	 * @throws Throwable
	 */
		public void setDataExcel(String sheetName, int rowNum , int celNum ,String data) throws Throwable 
		{
		FileInputStream fis2  = new FileInputStream(Constants.excelpath);
		Workbook wb1 = WorkbookFactory.create(fis2);
		Sheet sh1 = wb1.getSheet(sheetName);
		Row row = sh1.getRow(rowNum);
		Cell cel = row.createCell(celNum);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(Constants.excelpath);
		wb1.write(fos);
		wb1.close();
		}

	
}




