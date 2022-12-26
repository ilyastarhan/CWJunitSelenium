package Day10_ApachePOI;

import org.apache.poi.ss.usermodel.*;
import utilities.BaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ExcelMethods {

    public static void main(String[] args) throws IOException {
        String path="src\\test\\java\\resources\\excelfile.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet1 =workbook.getSheetAt(0);
        Row row1 = sheet1.getRow(0);
        Cell cell1 = row1.getCell(0);
        System.out.println("cell1 = " + cell1);
        //hücremizde string operasyonlari gerceklestirmek istersek toString() methodu ile hücreyi stringe cevirebiliriz
        System.out.println("cell1.toString().toLowerCase() = " + cell1.toString().toLowerCase());

    }
}
