package demoqa.Day5_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.time.Duration;

public class C10_Alert {


    WebDriver driver;
    Actions action;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        action = new Actions(driver);
    }

    @After
    public void tearDown() {
        //    driver.quit();
    }

    @Test
    public void test() {

        driver.get("http://www.google.com");

        driver.findElement(By.xpath("//div[text()='Tümünü kabul et']")).click();
        WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
        action.moveToElement(search).keyDown(Keys.SHIFT).sendKeys("ahmetabi").keyUp(Keys.SHIFT).perform();

     // Get attribute of current active element
     //  String attr = driver.switchTo().activeElement().getAttribute("title");
     //  System.out.println(attr);



    //   driver.get("https://demo.guru99.com/test/delete_customer.php");
    //  // driver.findElement((By.xpath("//span[text()='Tümünü Kabul Et']"))).click();
    //   driver.findElement(By.name("cusid")).sendKeys("12334");
    //   driver.findElement(By.name("submit")).click();
    //   driver.switchTo().alert().accept();
    //   driver.switchTo().alert().accept();

}
}
