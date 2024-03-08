package Utililies;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelReader {

	public static String readData(int r, int c) throws IOException {
		File file = new File(System.getProperty("user.dir") + "\\TestDataFiles\\OranageHRM_Login.xlsx");
		FileInputStream fi = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(fi);

		XSSFSheet sheet = wb.getSheetAt(0);

		String data = sheet.getRow(r).getCell(c).getStringCellValue();

		return data;
	}
}
