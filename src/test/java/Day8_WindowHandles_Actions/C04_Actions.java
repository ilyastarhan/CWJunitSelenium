package Day8_WindowHandles_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class C04_Actions extends BaseTest {


    @Test
    public void keyBoardActions() {
        driver.get("https://demoqa.com/auto-complete");
        WebElement input = driver.findElement(By.id("autoCompleteMultipleContainer"));
        Actions action = new Actions(driver);
        action.keyDown(Keys.SHIFT).sendKeys(input, "y")
                .keyUp(Keys.SHIFT).sendKeys("ou are ")
                .keyDown(Keys.SHIFT).sendKeys("e")
                .keyUp(Keys.SHIFT).sendKeys("xceptional").build().perform();
        action.click(driver.findElement(By.id("autoCompleteSingleContainer")))
                .sendKeys("Red").perform();

    }
}
