package Exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class kaptanDeneme extends BaseTest {



    @Test
    public void kaptanTest() throws InterruptedException {
        driver.get("https://www.google.com/");
        Thread.sleep(5000);
        driver.findElement(By.id("L2AGLb")).click();
        WebElement mic = driver.findElement(By.className("XDyW0e"));
        mic.click();
        Assert.assertTrue(mic.isEnabled());


    }
}
