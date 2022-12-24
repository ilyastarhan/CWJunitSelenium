package codeChallenge.PracticeDay01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class Task06 extends BaseTest {




    @Test
    public void test() {

        driver.get("https://html.com/tags/iframe/");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement iFrame = driver.findElement(By.xpath("(//iframe[@frameborder='0'])[1]"));
        driver.switchTo().frame(iFrame);

        WebElement play = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        actions.click(play).perform();

        Assert.assertFalse(play.isDisplayed());
    }
    }

