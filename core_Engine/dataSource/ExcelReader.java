package dataSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelReader {
	private static XSSFWorkbook excelWBook;
	private static XSSFSheet excelWSheet;
	private static XSSFRow row;
	private static XSSFCell cell;
	
	//This method is to set the File path and to open the Excel file, 
	//Pass Excel Path and Sheetname as Arguments to this method
	public static void setExcelFile(String Path,String SheetName) throws Exception {
		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(Path);
			// Access the required test data sheet
			excelWBook = new XSSFWorkbook(ExcelFile);
			excelWSheet = excelWBook.getSheet(SheetName);
		} catch (Exception e){
			throw (e);
		}
	}
	//This method is to read the test data from the Excel cell, 
	//in this we are passing parameters as Row num and Col num

	public static String getCellData(String Path,String SheetName,
			int RowNum, int ColNum) throws Exception{
		try{
			setExcelFile(Path,SheetName);
			row = excelWSheet.getRow(RowNum);//to get a specific row
			cell = row.getCell(ColNum);	//to get a specific cell value		
			String CellData = cell.getStringCellValue();//to get only string value
			return CellData;
		}catch (Exception e){
			return "Exception";
		}
	}
	//This method is to write in the Excel cell, 
	//Row num and Col num are the parameters

	public static void setCellData(String Result,int RowNum,int ColNum) throws Exception	{
		try{
			row  = excelWSheet.getRow(RowNum);
			cell = row.getCell(ColNum, row.RETURN_BLANK_AS_NULL);
			if (cell == null) {
				cell = row.createCell(ColNum);//Create a new cell at runtime
				cell.setCellValue(Result);//Set the value at any specific cell
			} else {
				cell.setCellValue(Result);
			}
			// Constant variables Test Data path and Test Data file name
			FileOutputStream fileOut = new 
					FileOutputStream("C:/Selenium/Jan2024/TestData/Testdata.xlsx");
			excelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		}catch(Exception e){
			throw (e);
		}
	}

	public static Sheet getCompleteSheetData(String filePath,
			String fileName,String sheetName) throws IOException{
		//Create a instance of File class to open xlsx file
		File file =	new File(filePath+"\\"+fileName);
		//Create an instance of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workBook = null;
		//Find the file extension by spliting file name in substing and getting only extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		//Check condition if the file is xlsx file
		if(fileExtensionName.equals(".xlsx")){
			//If it is xlsx file then create object of XSSFWorkbook class
			workBook = new XSSFWorkbook(inputStream);
		}
		//Check condition if the file is xls file
		else if(fileExtensionName.equals(".xls")){
			//If it is xls file then create object of XSSFWorkbook class
			workBook = new HSSFWorkbook(inputStream);
		}
		//Read sheet inside the workbook by its name
		Sheet  Sheet = workBook.getSheet(sheetName);
		return Sheet;	
	}
	public static void main(String[] args) throws Exception {
		String user = getCellData("C:/Selenium/Jan2024/TestData/Testdata.xlsx", 
				"Sheet1", 4, 1);
		System.out.println(user);
		
		//setCellData("Pass", 4, 6);

		Sheet Sheet = getCompleteSheetData("C:/Selenium/Jan2024/TestData/",
				"TestData.xlsx" , "Sheet2");

		int rowCount = Sheet.getLastRowNum();//Sheet.getFirstRowNum();
		System.out.println(rowCount);
		//Row row = Sheet.getRow(3);
		//int col = row.getLastCellNum();//Get total column number
		//System.out.println(col);
		//Create a loop over all the rows of excel file to read it
		//Sheet 1
		for (int i = 1; i <= rowCount; i++) {
			//Loop over all the rows
			Row row = Sheet.getRow(i);
			//Check if the first cell contain a value, 
			//if yes, That means it is the new testcase name
			if(row.getCell(5).toString().equals("Yes")){
				System.out.println("I want to run this test -- "+row.getCell(0));
			}else{
				//System.out.println("Jump to new test case");
			}
		}
		//Sheet 2
		for (int i = 1; i <= rowCount; i++) {
			//Loop over all the rows
			Row row = Sheet.getRow(i);
			//Check if the first cell contain a value, 
			//if yes, That means it is the new testcase name
			if(row.getCell(0).toString().length()>0 && row.getCell(5).toString().equals("Yes")){
				System.out.println("I want to run this test -- "+row.getCell(0));
			}else{
				performAction(row.getCell(1).toString(), row.getCell(2).toString(), 
						row.getCell(3).toString(), row.getCell(4).toString());
			}
		}

			/*
			 * Find Excel File
			 * Open Excel/Workbook
			 * Open Excel Sheet
			 * Jump to Row & get data
			 * Edit and save data
			 */

		
	}
	public static void performAction(String keyword, String object, String loc, String val) {
		switch (keyword) {
		case "GOTOURL": 
			System.out.println("Open URL");
			break;
		case "SETETXT": 
			System.out.println("Enter Text on "+loc+"identify by element "+object);
			break;	
		}
	}
}