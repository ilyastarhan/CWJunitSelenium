package Exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class iFrame03 {
    WebDriver driver;

    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //   driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @After
    public void after() {
        // driver.quit();

    }

    @Test
    public void iFrameTest() {
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        driver.manage().window().maximize();

      driver.switchTo().frame("emoojis");
      driver.findElement(By.xpath("//a[contains(@href,'nature')]")).click();
      List<WebElement> emojiler = driver.findElements(By.xpath("//div[@id='nature']/img"));
      for (WebElement each : emojiler) {
          each.click();
      }
      driver.switchTo().defaultContent();
      Actions action = new Actions(driver);
      action.moveToElement(driver.findElement(By.className("mdl-textfield__input"))).sendKeys("Bir"+ Keys.TAB)
              .sendKeys("iframe" + Keys.TAB)
              .sendKeys("sorusu" + Keys.TAB)
              .sendKeys("bu" + Keys.TAB)
              .sendKeys("kadar" + Keys.TAB)
              .sendKeys("eglenceli" + Keys.TAB)
              .sendKeys("olabilir" + Keys.TAB)
              .sendKeys("sizce de" + Keys.TAB)
              .sendKeys("oyle degil mi?" + Keys.TAB)
              .sendKeys(Keys.TAB)
              .sendKeys(Keys.TAB)
              .sendKeys(Keys.TAB).sendKeys(Keys.SPACE).perform();

    }
}