package com.nopcommerce.utils.datareader;

import com.nopcommerce.utils.logs.LogsManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
    private static final String TEST_DATA_PATH = "src/test/resources/test-data/";

    public static String getExcelData(String excelFilename, String sheetName, int rowNum, int colNum) {
        XSSFWorkbook workBook;
        XSSFSheet sheet;

        String cellData;
        try {
            LogsManager.info("Getting excel data from file:", excelFilename, "sheet:", sheetName, "row:", String.valueOf(rowNum), "col:", String.valueOf(colNum));
            workBook = new XSSFWorkbook(TEST_DATA_PATH + excelFilename);
            sheet = workBook.getSheet(sheetName);
            LogsManager.info("Excel file and sheet loaded successfully");
            cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
            LogsManager.info("Excel data retrieved successfully:", cellData);
            return cellData;
        } catch (Exception e) {
            LogsManager.error("Error reading excel file:", excelFilename, e.getMessage());
            return "";
        }

    }
}
