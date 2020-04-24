package com.home.excel;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReader {
	public static void main(String[] args) {
		int recordCount = readFile(args[0]);
		System.out.println("\n\nRecord Count is : " + recordCount);
	}

	@SuppressWarnings("deprecation")
	public static int readFile(String fileName) {
		int recordCount = 0;
		try {
			
			//"C:\\Users\\202097\\Documents\\sample.xlsx"
			File file = new File(fileName); // creating a new
																// file instance
			FileInputStream fis = new FileInputStream(file); // obtaining bytes
																// from the file
			// creating Workbook instance that refers to .xlsx file
			@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0); // creating a Sheet object to
												// retrieve object
			Iterator<Row> itr = sheet.iterator(); // iterating over excel file
			while (itr.hasNext()) {
				Row row = itr.next();
				Iterator<Cell> cellIterator = row.cellIterator(); // iterating
																	// over each
																	// column
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING: // field that represents string
												// cell type
						System.out.print(cell.getStringCellValue() + "\t\t\t");
						break;
					case Cell.CELL_TYPE_NUMERIC: // field that represents number
													// cell type
						System.out.print(cell.getNumericCellValue() + "\t\t\t");
						break;
					default:
					}
				}
				System.out.println("");
				recordCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recordCount;
		
	}
}
