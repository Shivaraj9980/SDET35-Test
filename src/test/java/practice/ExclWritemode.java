package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExclWritemode {

	public static void main(String[] args) throws IOException {
		File src = new File("./Excel/MARKS.xlsx");
		FileInputStream fis = new FileInputStream(src);
		Workbook book = WorkbookFactory.create(fis);
		//select sheet
		Sheet sheet = book.getSheet("sheet1");
		//select row
		Row row = sheet.getRow(1);
		Cell cell = row.createCell(13);
		cell.setCellValue("abcdef");
		FileOutputStream fout=new FileOutputStream(src);
		book.write(fout);

	}

}
