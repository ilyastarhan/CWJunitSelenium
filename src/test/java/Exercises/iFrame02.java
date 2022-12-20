package Exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class iFrame02 {
    WebDriver driver;

    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @After
    public void after() {
        // driver.quit();

    }

    @Test
    public void iFrameTest() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        Assert.assertTrue(driver.findElement(By.tagName("h3")).getText().contains("Editor"));
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.tagName("p")).clear();
        driver.findElement(By.tagName("p")).sendKeys("Hi everyone!");
        driver.switchTo().defaultContent();
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).isDisplayed());


    }
}