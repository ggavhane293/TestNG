package excelFileDataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream file = new FileInputStream("C://Automation//Data//data.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);//it will open the workbook
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");//getting data with name of sheet
		
		//XSSFSheet sheet = workbook.getSheet(0);//getting data with index no of sheet
		
		int rowcount = sheet.getLastRowNum();// we can count the row numbers
		
		int columncount=sheet.getRow(0).getLastCellNum();//this will gives the no of columns available in sheet
		
		for(int i=0;i<rowcount;i++)// it will iterate the row
		{
			XSSFRow currentrow=sheet.getRow(i);//it will focus on particular row
			
			for(int j=0;j<columncount;j++)// it will iterate the columns
			{
				String value=currentrow.getCell(j).toString();//read the value from cell
				
				System.out.print(value+""+"        ");//print the data from excel
			}
			System.out.println();
		}
		
	}
}
