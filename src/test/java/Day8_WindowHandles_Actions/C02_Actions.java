package Day8_WindowHandles_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class C02_Actions extends BaseTest {


    @Test

    public void test() {

        driver.get("https://demoqa.com/buttons");
        Actions action = new Actions(driver);

        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        action.doubleClick(doubleClickBtn).perform();
        Assert.assertTrue(driver.findElement(By.id("doubleClickMessage")).isDisplayed());

        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        action.contextClick(rightClickBtn).perform();
        Assert.assertTrue(driver.findElement(By.id("rightClickMessage")).isDisplayed());

        WebElement click = driver.findElement(By.xpath("//button[starts-with(text(),'Click Me')]"));
        click.click();
        Assert.assertTrue(driver.findElement(By.id("dynamicClickMessage")).isDisplayed());

    }
}
