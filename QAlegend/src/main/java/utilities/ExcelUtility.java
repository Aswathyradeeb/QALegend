package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtility {
	static FileInputStream f;
    static XSSFWorkbook w;
    static XSSFSheet sh;
    
    public static String getStringData(int row,int column,String sheet) {
    	try
    	{
    		f= new FileInputStream("C:\\Users\\hp\\git\\QALegend\\QAlegend\\src\\main\\resources\\TestData.xlsx");
        	w= new XSSFWorkbook(f);
        	sh= w.getSheet(sheet);
        	Row r= sh.getRow(row);
        	Cell c= r.getCell(column);
            return c.getStringCellValue();
    	}
    	catch(Exception e) {
    		throw new RuntimeException("Invalid Excel");
    	}
    	
    }
    
    public static String getIntData(int row, int column,String sheet) {
    	try {
    		f= new FileInputStream("C:\\Users\\hp\\git\\QALegend\\QAlegend\\src\\main\\resources\\TestData.xlsx");
        	w= new XSSFWorkbook(f);
        	sh= w.getSheet(sheet);
        	Row r= sh.getRow(row);
        	Cell c= r.getCell(column);
        	int x= (int) c.getNumericCellValue();
        	return String.valueOf(x);
    	}
    	catch(Exception e) {
    		throw new RuntimeException("Invalid Excel");
    	}
    	
    }
}
