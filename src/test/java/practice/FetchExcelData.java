package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchExcelData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//path of file
		File src = new File("./Excel/MARKS.xlsx");
		FileInputStream fis = new FileInputStream(src);
		//create excel
		Workbook book = WorkbookFactory.create(fis);
		//select sheet
		Sheet sheet = book.getSheet("sheet1");
		//select row
		Row row = sheet.getRow(0);
		//select cell
		Cell cell = row.getCell(1);
		//get cell value
		String value = cell.getStringCellValue();
		System.out.println(value);
		
		book.close();
		
		
		

	}

}
