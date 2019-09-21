package utils;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	Workbook wb;

	public ExcelReader(String path) {
		try {
			if (path.endsWith(".xls")) {
				wb = new HSSFWorkbook(new FileInputStream(path));
			} else if (path.endsWith(".xlsx")) {
				wb = new XSSFWorkbook(new FileInputStream(path));
			}
		} catch (Exception e) {
			System.out.println("Error with File Connection " + e.getMessage());
		}
	}

	public int getRowNum(String sheetName) {
		int num = wb.getSheet(sheetName).getLastRowNum();
		return num;
	}

	public String getData(String sheetName, int Row, int Col) {
		return wb.getSheet(sheetName).getRow(Row).getCell(Col).toString();
	}

	public String[][] getAllData(String sheetName, int Row, int Col) {
		String data[][] = new String[Row][Col];
		for (int i = 0; i < Row; i++) {
			for (int j = 0; j < Col; j++) {
				data[i][j] = wb.getSheet(sheetName).getRow(i+1).getCell(j).toString();
			}
		}
		return data;
	}
}