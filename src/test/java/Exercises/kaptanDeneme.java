package Exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseTest;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class kaptanDeneme extends BaseTest {



    @Test
    public void kaptanTest() throws InterruptedException, AWTException {
        driver.get("https://www.google.com/");
        Thread.sleep(5000);
        driver.findElement(By.id("L2AGLb")).click();
        WebElement mic = driver.findElement(By.className("XDyW0e"));
        mic.click();
        Assert.assertTrue(mic.isEnabled());
        Robot rbt = new Robot();
        rbt.keyPress(KeyEvent.VK_TAB);
        rbt.keyPress(KeyEvent.VK_TAB);
        rbt.keyPress(KeyEvent.VK_ENTER);


    }
}
