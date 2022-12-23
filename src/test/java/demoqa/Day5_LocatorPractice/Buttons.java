package demoqa.Day5_LocatorPractice;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Buttons {
    WebDriver driver;
    Faker faker;
    Actions action;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        faker = new Faker();
        action = new Actions(driver);

    }

    @After
    public void tearDown() {
        //  driver.quit();
    }

    @Test
    public void test() {
        driver.get("https://demoqa.com/buttons");
        WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
        action.doubleClick(doubleClick).perform();
        WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
        action.contextClick(rightClick).perform();
        WebElement clickMe = driver.findElement(By.xpath("//button[starts-with(text(),'Click Me')]"));
        clickMe.click();
    }
}