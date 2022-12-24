package codeChallenge.PracticeDay01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.Set;

public class Task08 extends BaseTest {




    @Test
    public void test() {

        //  1- https://demoqa.com/droppable adresine gidelim.
        driver.get("https://demoqa.com/droppable");
        //  2- "Drag me" butonunu tutup "Drop here" kutusunun üstüne bırakalım.
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
        action.dragAndDrop(drag, drop).perform();
        //  3- "Drop here" yazısı yerine "Dropped!" olduğunu test edin.
        WebElement text = driver.findElement(By.xpath("//div[@id='droppable']/p"));
        Assert.assertEquals("Dropped!", text.getText());




    }
}
