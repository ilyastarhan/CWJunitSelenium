package Day11_ApachePOI_WriteExcel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class C02_WriteExcelExample {

    @Test
    public void changeCellValue() throws IOException {







     // Create an object of File class to open xlsx file.
        String path = "src/test/java/resources/excelData.xlsx";
        File file = new File(path);
     // Create an object of FileInputStream class to read excel file.
        FileInputStream fis = new FileInputStream(file);
     // Creating workbook instance that refers to .xlsx file.
        Workbook workbook = WorkbookFactory.create(fis);
     // Creating a Sheet object.
        Sheet informationData = workbook.getSheet("informationData");

     // Get all rows in the sheet.
        int totalRowsUsed = informationData.getLastRowNum()-informationData.getFirstRowNum();

     // Create a row object to retrieve row at index 3.
        Row row5 = informationData.createRow(4);
     // Create a cell object to enter value in it using cell Index.
        row5.createCell(0).setCellValue("ilyas");
        row5.createCell(1).setCellValue("tarhan");
        row5.createCell(2).setCellValue("ilyastarhan.de@gmail.com");
        row5.createCell(3).setCellValue("Male");
        row5.createCell(4).setCellValue("1232563312");
        row5.createCell(5).setCellValue("Adress");
     // Write the data in excel using output stream.
        FileOutputStream fos = new FileOutputStream(path);
        workbook.write(fos);
        fis.close();
        fos.close();
        workbook.close();

    }




}
