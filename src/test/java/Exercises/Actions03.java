package Exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Actions03 {


    WebDriver driver;
    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @After
    public void after(){
        // driver.quit();

    }

    @Test
    public void actionTest() throws InterruptedException {
        driver.get("https://demo.guru99.com/test/drag_drop.html");

        WebElement bank = driver.findElement(By.id("credit2"));
        WebElement bankTarget = driver.findElement(By.id("bank"));

        WebElement sales = driver.findElement(By.id("credit1"));
        WebElement salesTarget = driver.findElement(By.id("loan"));

        WebElement arti5000 = driver.findElement(By.id("fourth"));
        WebElement debitAmount = driver.findElement(By.id("amt7"));

       WebElement arti5000_2 = driver.findElement(By.xpath("//li[@id='fourth'][2]"));
       WebElement creditAmount = driver.findElement(By.id("amt8"));

      //  driver.findElement(By.id("save")).click();
        Thread.sleep(4000);
        Actions action = new Actions(driver);
        action.dragAndDrop(bank, bankTarget).perform();
        action.dragAndDrop(sales,salesTarget).perform();
        action.dragAndDrop(arti5000,debitAmount).perform();
        action.dragAndDrop(arti5000_2,creditAmount).perform();
        Assert.assertTrue(driver.findElement(By.id("equal")).isDisplayed());



    }

}
