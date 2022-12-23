package Day9_JSEScroll_Cookies_Files;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.awt.*;
import java.awt.event.KeyEvent;

public class C03_RobotClass extends BaseTest {


    @Test
    public void test() throws AWTException, InterruptedException {

        driver.get("https://demo.guru99.com/test/upload/");
        WebElement uploadBtn = driver.findElement(By.id("uploadfile_0"));
        uploadBtn.sendKeys("C:\\Users\\ilyas\\IdeaProjects\\CWJunitSelenium\\src\\test\\java\\resources\\robot.txt");
        Robot rbt = new Robot();
        rbt.keyPress(KeyEvent.VK_CONTROL);
        rbt.keyPress(KeyEvent.VK_S);
        Thread.sleep(3000);
        rbt.keyRelease(KeyEvent.VK_CONTROL);
        rbt.keyRelease(KeyEvent.VK_S);
        Thread.sleep(3000);

        rbt.keyPress(KeyEvent.VK_ENTER);
        rbt.keyRelease(KeyEvent.VK_ENTER);


    }
}
