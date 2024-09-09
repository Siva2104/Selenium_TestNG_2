package maven_project;
import org.apache.poi.ss.usermodel.*;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.IOException;

public class ExcelUtils {

    private static Workbook workbook;

    private static Sheet sheet;

    private static String excelFilePath;

    public static void setExcelFile(String excelFilePath, String sheetName) throws IOException {

        FileInputStream excelFile = new FileInputStream(excelFilePath);

        workbook = new XSSFWorkbook(excelFile);

        sheet = workbook.getSheet(sheetName);

        ExcelUtils.excelFilePath = excelFilePath;

    }

    public static Object[][] getTableArray() {

        int totalRows = sheet.getPhysicalNumberOfRows();

        int totalCols = sheet.getRow(0).getPhysicalNumberOfCells();

        String[][] tabArray = new String[totalRows - 1][totalCols];

        for (int i = 1; i < totalRows; i++) {

            for (int j = 0; j < totalCols; j++) {

                tabArray[i - 1][j] = getCellData(i, j);

            }

        }

        return tabArray;

    }

    public static String getCellData(int rowNum, int colNum) {

        Row row = sheet.getRow(rowNum);

        Cell cell = row.getCell(colNum);

        return cell.getStringCellValue();

    }

    public static void setCellData(String data, int rowNum, int colNum) throws IOException {

        Row row = sheet.getRow(rowNum);

        if (row == null) {

            row = sheet.createRow(rowNum);

        }

        Cell cell = row.createCell(colNum);

        cell.setCellValue(data);

        FileOutputStream fileOut = new FileOutputStream(excelFilePath);

        workbook.write(fileOut);

        fileOut.flush();

        fileOut.close();

    }

    public static void addErrorMessage(String errorMessage) throws IOException {

        int totalRows = sheet.getPhysicalNumberOfRows();

        setCellData(errorMessage, totalRows, 0); // Assumes error message is added in the first column

    }

}
 