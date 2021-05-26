package TestUtills;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import hacpee.pages.TestExecutor;

public class DataUtils extends TestExecutor {
	
	int rowCount;
	
    public void setSheetName(String sheetName){
    	// this.sheetName = sheetName;
           sheet = book.getSheet(sheetName);
    }
    
    public DataUtils() throws IOException {
           //file = new FileInputStream(System.getProperty("user.dir")+"\\src\\TestData\\Data.xlsx");     
           file = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/hacpee/TestData/Data.xlsx"); 
        //   book = new XSSFWorkbook(file);
         
           // sheet = book.getSheet(this.sheetName);
    }      
  
    public void getRowData(int rowVal) throws IOException {

           try{
                  rowCount = sheet.getLastRowNum() + 1;
                  int colCount = sheet.getRow(0).getLastCellNum();
                  Row firstRow = sheet.getRow(0);
                  Row currRow = sheet.getRow(rowVal);
                  for (int j = 0; j < colCount; j++) {
                        System.out.println(formatter.formatCellValue(firstRow.getCell(j)) + " = "+ formatter.formatCellValue(currRow.getCell(j)));
                        map.put(formatter.formatCellValue(firstRow.getCell(j)), formatter.formatCellValue(currRow.getCell(j)));
                  }
               //  book.close();
           }
           catch (NullPointerException e) {
                  System.out.println("Row number entered exceeds the actual row count of excel data sheet");
           }            
    }

    public int noOfRows() {
           return sheet.getLastRowNum();
    }

    public String getMapValue(String mapData) {
           return map.get(mapData);
    }
}
