package homeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.List;
import java.util.Set;

public class IframeTask extends BaseTest {


    @Test
    public void test() throws InterruptedException {


        //  Go to URL: http://demo.guru99.com/test/guru99home/
        driver.get("http://demo.guru99.com/test/guru99home/");
        String mainWindow = driver.getWindowHandle();
        //  Find the number of iframes on the page.
        List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
        System.out.println(iframeList.size());
        Thread.sleep(3000);

        //driver.findElement(By.xpath("//span[contains(text(),'Kabul Et')]")).click();

        //  Link to the fourth iframe (JMeter Made Easy) (https://www.guru99.com/live selenium project.html) click here.
        driver.switchTo().frame("a077aa5e");
        driver.findElement(By.cssSelector("[src='Jmeter720.png']")).click();
        //  Exit the iframe and return to the main page.
        driver.switchTo().window(mainWindow);
        driver.switchTo().defaultContent();
        Assert.assertTrue(driver.findElement(By.id("site-name")).isDisplayed());
    }
}