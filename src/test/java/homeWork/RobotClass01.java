package homeWork;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.BaseTest;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotClass01 extends BaseTest {


    @Test
    public void test() throws AWTException {

      //  https://api.jquery.com/ sitesine gidelim
        driver.get("https://api.jquery.com/");
      //  arama alanina json yazalim
        driver.findElement(By.name("s")).sendKeys("json");
      //  Enter islemini robot class kullanrak yapalim
        Robot rbt = new Robot();
        rbt.keyPress(KeyEvent.VK_ENTER);
        rbt.keyRelease(KeyEvent.VK_ENTER);
    }
}
