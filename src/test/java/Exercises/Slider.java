package Exercises;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

public class Slider extends BaseTest {


    @Test
    public void name() {


        driver.get("https://jqueryui.com/slider/#colorpicker");
        driver.switchTo().frame(0);
        WebElement slider = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
        action.dragAndDropBy(slider, -50,0).perform();
        action.dragAndDropBy(slider, -70,0).perform();
        action.dragAndDropBy(slider, 70,0).perform();
        action.dragAndDropBy(slider, 0,-100).perform();

    }
}
