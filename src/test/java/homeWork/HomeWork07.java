package homeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

import java.util.List;

public class HomeWork07 extends BaseTest {

    /*
    - https://demoqa.com/select-menu sitesine gidin
    - multiple <select> elementini locate edin
    - getOptions(), getFirstSelectedOption(), getAllSelected() methodlarini kullanmak adina:
    * Farkli secimler yaparak methodlarinizi kullanin ve Assertion yapmayi unutmayin
     */

    @Test
    public void test(){

        driver.get("https://demoqa.com/select-menu");

        WebElement multiSelect = driver.findElement(By.id("cars"));

        Select select = new Select(multiSelect);
        List<WebElement> list = select.getOptions();

        select.selectByIndex(2);
        select.selectByVisibleText("Volvo");
        select.selectByValue("audi");


        Assert.assertEquals("Volvo",select.getFirstSelectedOption().getText());
        Assert.assertTrue(list.get(2).isSelected());
        Assert.assertFalse(list.get(1).isSelected());




    }


}
