package Day12_ScreenShots;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

public class Task02_WebTables extends BaseTest {

    static WebElement table1;
    static WebElement table2;


    @Test
    public void webTableTest() {
        //   Go to URL: https://the-internet.herokuapp.com/tables
        driver.get("https://the-internet.herokuapp.com/tables");
        //   Print the entire table
        table1 = driver.findElement(By.id("table1"));
        table2 = driver.findElement(By.id("table2"));
        int rows = table1.findElements(By.xpath(".//tbody//tr")).size();

        WebElement row1 = table1.findElement(By.xpath(".//tbody//tr"));
        int columns = row1.findElements(By.xpath(".//td")).size();

        String xpath = "";
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j < columns; j++) {
                xpath = "//table[@id='table1']//tbody//";
                By locator = By.xpath(xpath + "tr[" + i + "]//td[" + j + "]");
                WebElement tableData = driver.findElement(locator);
                System.out.print("||" + tableData.getText());
            }
            System.out.println();
        }

        //   Print All Rows
        for (int i = 1; i <= rows; i++) {
            By locator = By.xpath("//table[@id='table1']//tbody//tr[" + i + "]");
            WebElement row = driver.findElement(locator);
            System.out.println(row.getText());
        }

        //   Print Last row data only
        for (int i = rows; i >= rows; i--) {
            By locator = By.xpath("//table[@id='table1']//tbody//tr[" + i + "]");
            WebElement row = driver.findElement(locator);
            System.out.println(row.getText());
        }

        //   Print column 5 data in the table body
        for (int i = 1; i <= rows; i++) {
            By locator = By.xpath("//table[@id='table1']//tbody//tr[" + i + "]//td[5]");
            WebElement col5 = driver.findElement(locator);
            System.out.print("||" + col5.getText());
        }
        printData(3, 5);
        printData(3, 4, "table1");

    }

    //   Write a method that accepts 2 parameters
    //   parameter 1 = row number
    //   parameter 2 = column number
    //   printData(3,4); => prints
    public void printData(int rowNumber, int columnNumber) {
        WebElement data = table1.findElement(By.xpath("//tr[" + rowNumber + "]//td[" + columnNumber + "]"));
        System.out.println(data.getText());
    }

    //   parameter 3 = table id
    //   printData(3,4,"table1") => prints data in 3rd row 4th
    //   Column with table id
    public void printData(int rowNumber, int columnNumber, String tableId) {
        WebElement data = driver.findElement(By.id(tableId)).findElement(By.xpath("//body//tr[" + rowNumber + "]//td[" + columnNumber + "]"));
        System.out.println(data.getText());

    }
}
