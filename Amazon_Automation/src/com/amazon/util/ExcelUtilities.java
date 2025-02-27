package com.amazon.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;;



public class ExcelUtilities {


	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	private static XSSFRow xRow;

	private static MissingCellPolicy Row;
	
	private static Map map=null;
	private static ArrayList temp=null;
	private static FileInputStream fis=null;
	private static ArrayList moduleRecord=null;
	static DataFormatter formatter = new DataFormatter();

   
	//
	// Create an ArrayList to store the data read from excel sheet.
	//
	private static List sheetData = new ArrayList();
	private static List sheetDataCol =  new ArrayList();


	//This method is to write in the Excel cell, Row num and Col num are the parameters

	public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{

		try{

			xRow  = ExcelWSheet.getRow(RowNum);

			Cell = xRow.getCell(ColNum, Row.RETURN_BLANK_AS_NULL );

			if (Cell == null) {

				Cell = xRow.createCell(ColNum);

				Cell.setCellValue(Result);

			} else {

				Cell.setCellValue(Result);

			}

			// Constant variables Test Data path and Test Data file name

			FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);

			ExcelWBook.write(fileOut);

			fileOut.flush();

			fileOut.close();

		}catch(Exception e){

			throw (e);

		}

	}

	//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

	public static void setExcelFile(String Path,String SheetName) throws Exception {

		try {

			// Open the Excel file

			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e){

			throw (e);

		}

	}


	public static Object[][] getTableArray(String FilePath, String SheetName, int iTestCaseRow)    throws Exception

	{   

		String[][] tabArray = null;

		try{

			FileInputStream ExcelFile = new FileInputStream(FilePath);

			// Access the required test data sheet

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			int startCol = 1;

			int ci=0,cj=0;

			int totalRows = 1;

			int totalCols = 4;

			tabArray=new String[totalRows][totalCols];

			for (int j=startCol;j<=totalCols;j++, cj++)

			{

				tabArray[ci][cj]=getCellData(iTestCaseRow,j);

				System.out.println("TestData:"+tabArray[ci][cj]);

			}

		}

		catch (FileNotFoundException e)

		{

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		catch (IOException e)

		{

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		return(tabArray);

	}


	//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

	public static String getCellData(int RowNum, int ColNum) throws Exception{

		try{

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			String CellData = Cell.getStringCellValue();

			return CellData;

		}catch (Exception e){

			return"";

		}

	}

	public static String getTestCaseName(String sTestCase)throws Exception{

		String value = sTestCase;

		try{

			int posi = value.indexOf("@");

			value = value.substring(0, posi);

			posi = value.lastIndexOf(".");	

			value = value.substring(posi + 1);

			return value;

		}catch (Exception e){

			throw (e);

		}

	}

	public static int getRowContains(String sTestCaseName, int colNum) throws Exception{

		int i;

		try {

			int rowCount = getRowUsed();

			for ( i=0 ; i<rowCount; i++){

				if  (getCellData(i,colNum).equalsIgnoreCase(sTestCaseName)){

					break;

				}

			}

			return i;

		}catch (Exception e){

			throw(e);

		}

	}

	public static int getRowUsed() throws Exception {

		try{

			int RowCount = ExcelWSheet.getLastRowNum();

			return RowCount;

		}catch (Exception e){

			System.out.println(e.getMessage());

			throw (e);

		}

	}
	
	
	public static List excelgetTableData(String moduleName) throws Exception 
	{
		try {
			String workingdirectory = System.getProperty("user.dir");
			System.out.println("Current working directory-"+workingdirectory);
			// Open the Excel file
			FileInputStream fis = new FileInputStream(workingdirectory+"\\src\\resources\\"+Constant.File_TestData);
			// Access the required test data sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet(moduleName); //Sheet Name
			// Loop through all rows in the sheet
			// Start at row 1 as row 0 is our header row
			
			Iterator rows = sheet.rowIterator();
			while (rows.hasNext()) {

				XSSFRow row = (XSSFRow) rows.next();
				Iterator cells = row.cellIterator();

				List data = new ArrayList();
				while (cells.hasNext()) {
					XSSFCell cell = (XSSFCell) cells.next();
					sheetData.add(cell);
				}

				//sheetData.add(data);
			}
			fis.close();
		} catch (Exception e) {
			System.out.println("Error Occured:"+e);
		}  
		System.out.println("Table data:"+sheetData);
		return sheetData;
	}

	public static List excelgetColumnName(String moduleName) throws Exception {
		try {  
			String workingdirectory = System.getProperty("user.dir");
			// Open the Excel file
			FileInputStream fis = new FileInputStream(workingdirectory+"\\src\\resources\\"+Constant.File_TestData);
			// Access the required test data sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet(moduleName);
			// Loop through all rows in the sheet
			// Start at row 1 as row 0 is our header row
			for(int count = 0;count<=0;count++){

				XSSFRow row = sheet.getRow(count);
				Iterator cells = row.cellIterator();
				// List data = new ArrayList();
				while (cells.hasNext()) {
					XSSFCell cell = (XSSFCell) cells.next();
					if(!cell.equals(" "))
						sheetDataCol.add(cell);

				}

			}

			fis.close();


		} catch (Exception e) {
			System.out.println("Error Occured:"+e);
		} 
		System.out.println("Table Coloumn data:"+sheetDataCol);
		return sheetDataCol;
	}

	public static ArrayList excelSetDBRecord (String moduleName) throws Exception{


		List exceltableRecord = null; 
		List exceltableColumns=null;
		XSSFCell cell = null;
		moduleRecord=new ArrayList();

		try{

			exceltableRecord =excelgetTableData(moduleName);
			exceltableColumns=excelgetColumnName(moduleName);
			
             System.out.println("Table records count:"+exceltableRecord.size());
             System.out.println("Table coloumns count:"+exceltableColumns.size());

             for(int j=0;j<exceltableRecord.size();) //if more than one record in tableRecord
 			{   


 				map=new HashMap();

 				for (int i = 0; i < exceltableColumns.size(); i++) {
 					++j;

 					if(j<exceltableRecord.size())
 					{
 						cell = (XSSFCell) exceltableRecord.get(j-1);
 						String colName=exceltableColumns.get(i).toString();
 						//System.out.println("Col name:"+colName);
 						//System.out.println("Cell val:"+cell.getStringCellValue().toString());
 						//String val = formatter.formatCellValue(sheet.getRow(row).getCell(col));
 						map.put(colName,formatter.formatCellValue(cell));
 						//map.put(colName,cell.getStringCellValue().toString());	//Mapping the columnNames with respective value at runtime 

 					}


 				}
 				//System.out.println("Map:"+map);

 				moduleRecord.add(map);	

 			}
		
			System.out.println("Excel Data in the file:"+moduleRecord);
			return moduleRecord;
		}
		
		catch(Exception e){
			
			System.out.println("Exception occured:"+e);
			return moduleRecord;
		}


	}
	
	 public static Map getTestData(String testCaseName) throws Exception{
		   
		 
		    Map map=null;
			
		    System.out.println("Getting TestData for testcase:"+testCaseName);
			System.out.println("Module size:"+moduleRecord.size());
			
			for(int i=0;i<moduleRecord.size();i++)
			{
				map=(Map)moduleRecord.get(i);
            
				/*Printing Table Data to the console. */
		        //System.out.println("Tabledata:"+map);
				
				if(map.get("TEST_METHOD_NAME").toString().equalsIgnoreCase(testCaseName)){
					
					System.out.println("TestMethod Found in TestData.");
                    break;
				}
				else
					continue;
			}
			System.out.println("Map for testcase:"+map);
			return map;
	    
		    
	}
    
	 
	 
	

}


