package Day9_JSEScroll_Cookies_Files;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class C1_ScrollActions extends BaseTest {




    @Test
public void scrollPageUp_PageDownTest() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        action.sendKeys(Keys.PAGE_UP).perform();
        action.sendKeys(Keys.PAGE_UP).perform();


    }

    public void scrollArrowUpDownTest() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(3000);
        action.sendKeys(Keys.ARROW_UP).perform();
        action.sendKeys(Keys.ARROW_UP).perform();

    }



    }
