package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFetchAllvalue {

	public static void main(String[] args) throws IOException {
		File src = new File("./Excel/Data.xlsx");
		FileInputStream fis = new FileInputStream(src);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet1");
		int rn= sheet.getPhysicalNumberOfRows();
		for(int i=0; i<rn; i++)
		{
			Row row = sheet.getRow(i);

			//short lc = row.getLastCellNum();
			for(int j=0;j<row.getLastCellNum(); j++)
			{
				Cell cell = row.getCell(j);
				String value = cell.toString();
				System.out.println(value);
			}

		}
	}
}



