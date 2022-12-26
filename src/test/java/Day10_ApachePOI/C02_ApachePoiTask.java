package Day10_ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.Test;
import utilities.BaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C02_ApachePoiTask extends BaseTest {

    @Test
    public void apacheTest() throws IOException {

        //  Add the excel file on the resources folder.
        //  Open the file.
        String path = "src/test/java/resources/excelfile.xlsx";
        FileInputStream fis = new FileInputStream(path);
        //  Open the workbook using file input stream.
        Workbook workbook = WorkbookFactory.create(fis);
        //  Open the first worksheet.
        Sheet sheet1 = workbook.getSheetAt(0);
        //  Go to first row.
        Row row1 = sheet1.getRow(0);
        //  Go to first cell on that first row and print.
        Cell row1cell1 = row1.getCell(0);
        System.out.println("cell1 = " + row1cell1);
        //  Go to second cell on that first row and print.
        Cell row1cell2 = row1.getCell(1);
        System.out.println("cell2 = " + row1cell2);
        //  Go to 2nd row first cell and assert if the data equal to Russia.
        Row row2 = sheet1.getRow(1);
        Cell row2cell1 = row2.getCell(0);
        Assert.assertEquals("Rusya", row2cell1.toString());

        //  Go to 3rd row 2nd cell-chain the row and cell.
        Row row3 = sheet1.getRow(2);
        Cell row3cell2 = row3.getCell(1);
        System.out.println(row3cell2);

        //  Find the number of used row.
        int totalRow = sheet1.getLastRowNum();
        int totalRow2 = sheet1.getPhysicalNumberOfRows();
        System.out.println("totalRow = " + totalRow);

        //  Print country, area key value pairs as map object.
        int totalCell = row1.getLastCellNum();
        System.out.println("totalCell = " + totalCell);
        Map<String, String> data = new HashMap<>();
        for (int i = 1; i <= totalRow; i++) {
            String country = sheet1.getRow(i).getCell(0).toString();
            String area = sheet1.getRow(i).getCell(1).getStringCellValue();
            data.put(country,area);
        }
        System.out.println(data);

    }
}
