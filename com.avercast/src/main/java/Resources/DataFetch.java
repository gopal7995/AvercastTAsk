package Resources;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataFetch {
	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	

	public static String dataDriven(String parameter) throws IOException {
		try {
			fis = new FileInputStream(
					(System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\FlipkartData.xlsx"));
			workbook = new XSSFWorkbook(fis);

		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = workbook.getSheet("TestData1");
		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(rowCount).getLastCellNum();
		String value;
		boolean gettingValue = false;
		for (int i = 1; i <= rowCount;) {
			for (int j = 0; j < columnCount;) {

				// Verify The Perticular Parameter That Required And That Will Be Passed 
				// By CallingThis Method

				if (sheet.getRow(i).getCell(j).getStringCellValue().equalsIgnoreCase(parameter)) {
					if (sheet.getRow(i).getCell(j + 1).getCellType() == CellType.NUMERIC) {
						Long lvalue = (long) sheet.getRow(i).getCell(j + 1).getNumericCellValue();
						value = String.valueOf(lvalue);

						gettingValue = true;

					} else {
						value = sheet.getRow(i).getCell(j + 1).getStringCellValue();
						gettingValue = true;

					}
					return value;
				}
				break;
			}
			i++;
			
			if (gettingValue == true) {
				break;
			}

		}
		return null;

	}
	
public static void main(String[] args) throws IOException {
	System.out.println(dataDriven("password"));
}
	
}
