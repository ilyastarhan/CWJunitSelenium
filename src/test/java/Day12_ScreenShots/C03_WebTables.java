package Day12_ScreenShots;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

public class C03_WebTables extends BaseTest {


    @Test
    public void webTableExample() {

     //  Go to URL: http://demo.guru99.com/test/web-table-element.php
        driver.get("http://demo.guru99.com/test/web-table-element.php");
     //  To find third row of table
     //   driver.findElement(By.id("save")).click();
        WebElement table = driver.findElement(By.className("dataTable")).findElement(By.tagName("tbody"));
        WebElement row3 = table.findElement(By.xpath(".//tr[3]"));
        System.out.println("row3.getText() = " + row3.getText());
        //    table.findElement(By.tagName("tr"))
     //  To get 3rd row's 3nd column data
        WebElement row3col3 = row3.findElement(By.xpath(".//td[3]"));
        System.out.println(row3col3.getText());
     //  Get all the values of a Dynamic Table
        int satirSayisi = table.findElements(By.xpath(".//tr")).size();
        System.out.println(satirSayisi);
        int sutunSayisi = row3.findElements(By.xpath(".//td")).size();
        System.out.println(sutunSayisi);
        for(int i = 1; i<=satirSayisi; i++){

            for(int j = 1; j<=sutunSayisi; j++){
                By locator = By.xpath(".//tr["+ i +"]//td[" + j + "]");
                WebElement tableData = table.findElement(locator);
                System.out.print("||" + tableData.getText());
            }
            System.out.println();
        }


    }
}