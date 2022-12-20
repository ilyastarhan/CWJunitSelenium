package demoqa.Day5_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_CheckBoxes {


    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @After
    public void tearDown(){
    //    driver.quit();
    }

    @Test
    public void test(){
        driver.get("https://demoqa.com/");
        WebElement element = driver.findElement(By.xpath("//div[@class='card mt-4 top-card']"));
        element.click();
        driver.findElement(By.xpath("//span[text()='Check Box']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='rct-checkbox']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'selected')]")).isDisplayed());
    }
}
