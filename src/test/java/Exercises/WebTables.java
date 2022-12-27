package Exercises;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.List;

public class WebTables extends BaseTest {
    @Test
    public void webTableTest() {
        driver.get("http://demo.guru99.com/test/web-table-element.php");
     //   driver.findElement(By.id("save")).click();
        List<WebElement> cells = driver.findElements(By.xpath("//table//tbody//tr[3]"));
        for (WebElement each : cells) {
            System.out.println(each.getText());
        }
        WebElement row3col2 = driver.findElement(By.xpath("//table//tbody//tr[3]//td[2]"));
        System.out.println(row3col2.getText());

        List<WebElement> rows = driver.findElements(By.xpath("//div[@id='leftcontainer']//table//tbody//tr"));

        for(int r= 1; r<=rows.size(); r++){

            for(int c = 1; c<=5; c++){
            WebElement element = driver.findElement(By.xpath("(//div[@id='leftcontainer']//table//tbody//tr)["+r+"]"));
                System.out.print(element.getText() + "\t");
            }
            System.out.println("\n");
        }
    }
}
