package Day11_ApachePOI_WriteExcel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import utilities.BaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_WriteExcelExample {

    @Test
    public void writeExcel() throws IOException {

        //   Store the path of the file as string and open the file.
        String path = "src/test/java/resources/excelfile.xlsx";

        //   Open the workbook.
        FileInputStream fis = new FileInputStream(path);

        //   Open the first worksheet.
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet2 = workbook.getSheetAt(1);

        //   Go to the first row.
        Row row1 = sheet2.getRow(0);

        //   Create a cell on the 3rd column (2nd index) on the first row.
        Cell row1cell3 = row1.createCell(2);

        //   Write “POPULATION” on that cell.
        row1cell3.setCellValue("Population");

        //   Create a cell on the 2nd row 3rd cell(index2), and write data.
        sheet2.getRow(1).createCell(2).setCellValue("Russia");

        //   Create a cell on the 3rd row 3rd cell(index2), and write data.
        sheet2.getRow(2).createCell(2).setCellValue("China");

        //   Create a cell on the 4th row 3rd cell(index2), and write data.
        sheet2.getRow(3).createCell(2).setCellValue("USA");

        //   Write and save the workbook.
        FileOutputStream fos = new FileOutputStream(path);
        workbook.write(fos);
        //   Close the file.
        fis.close();
        fos.close();

        workbook.close();


    }
}
