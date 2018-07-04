package Utils;

import org.apache.poi.ss.usermodel.*;
import java.io.File;

public class excelUtils1 {
	public static final String SAMPLE_XLSX_FILE_PATH = "./Data.xlsx";

	public static String getCellData(int RowNum, int ColNum) throws Exception {

		Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

		Sheet sheet = workbook.getSheetAt(0);

		Cell hello = sheet.getRow(RowNum).getCell(ColNum);

		String CellData = hello.getStringCellValue();

		workbook.close();

		return CellData;
	}

}