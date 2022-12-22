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

public class Actions04 {
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
        driver.get("https://rangeslider.js.org/");
        WebElement slider = driver.findElement(By.className("rangeslider__handle"));
        Actions action = new Actions(driver);
        action.dragAndDropBy(slider,-100,0).perform();
        action.dragAndDropBy(slider,100,0).perform();




    }

}