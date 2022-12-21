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

public class Actions01 {
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
    public void actionTest() {
        driver.get("https://demoqa.com/buttons");
        Actions action = new Actions(driver);
        WebElement doubleClick = driver.findElement(By.id("doubleClickBtn"));
        WebElement rightClick = driver.findElement(By.id("rightClickBtn"));
        WebElement click = driver.findElement(By.xpath("//button[starts-with(text(), 'Click Me')]"));
        action.doubleClick(doubleClick).perform();
        Assert.assertTrue(driver.findElement(By.id("doubleClickMessage")).isDisplayed());
        action.contextClick(rightClick).perform();
        Assert.assertTrue(driver.findElement(By.id("rightClickMessage")).isDisplayed());
        click.click();
        Assert.assertTrue(driver.findElement(By.id("dynamicClickMessage")).isDisplayed());







    }
}
