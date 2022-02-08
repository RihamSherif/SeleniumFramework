package testData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static FileInputStream fis1; // = null;
	
	public FileInputStream getFileInputStream()
	{
		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\testData\\UserData.xlsx";
		//String filePath = "C:\\Riham\\Personal\\Automation\\Eclipse-Workspace1\\TestAutoFramework-TAF\\src\\test\\java\\testData\\UserData.xlsx";
		File srcFile = new File(filePath);
		try {
		fis1 = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			System.out.println("Test Data File is not found!!");
		}
		return fis1;
	}

	public Object[][] getExcelData() throws IOException
      {
		
	FileInputStream fis2  = null;
		fis2 = getFileInputStream();
		XSSFWorkbook wb = new XSSFWorkbook(fis2);
		XSSFSheet sheet = wb.getSheetAt(0);
		
	int totalNumberOfRows = (sheet.getLastRowNum()+1);
	int totalNumberOfColumns = 4;
	
	String[][] arrayExcelData = new String[totalNumberOfRows][totalNumberOfColumns];
	for (int i = 0; i < totalNumberOfRows; i++)
	{
		for (int j = 0; j < totalNumberOfColumns; j++) 
		{
			XSSFRow row = sheet.getRow(i);
			arrayExcelData[i][j] = row.getCell(j).toString();
		}
	}
	wb.close();
	return arrayExcelData;
      }
}
