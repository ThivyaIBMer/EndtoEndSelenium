package DataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData {
	
	public static String username="";
	public static String password="";
	
	
	public static void readExcel(int rowCount,String sheetName) throws IOException {
		
		File src= new File(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\TestData.xlsx");
		
		FileInputStream fis=new FileInputStream(src);	
		Workbook excel_Wb=new XSSFWorkbook(fis);
		
		if(sheetName.equals("Credentials")) {
			
			Sheet ExcelSheet=excel_Wb.getSheet(sheetName);
			
			for(int i=rowCount;i<=rowCount;i++) {
				username=ExcelSheet.getRow(i).getCell(0).getStringCellValue();
				password=ExcelSheet.getRow(i).getCell(1).getStringCellValue();
				
			}
		}
		excel_Wb.close();
		
	}

}
