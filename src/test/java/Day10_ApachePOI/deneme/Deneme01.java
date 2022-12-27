package Day10_ApachePOI.deneme;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import utilities.BaseTest;

import java.io.File;
import java.io.IOException;

public class Deneme01 extends BaseTest {




    @Test
    public void test() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        sheet.createRow(0);
        sheet.getRow(0).createCell(0);
        sheet.getRow(0).getCell(0).setCellValue("ahmet");
        System.out.println(sheet.getRow(0).getCell(0));
        workbook.write(new File("C:\\Users\\ilyas\\IdeaProjects\\CWJunitSelenium\\src\\test\\java\\resources\\excelData2.xls"));
        workbook.close();

    }
}
