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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class iFrame {


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
    public void iFrameTest() {
        driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
        driver.findElement(By.id("name")).sendKeys("Hello");
        driver.switchTo().frame("frm3");
        driver.switchTo().frame("frm1");
        Select course = new Select(driver.findElement(By.id("selectnav1")));
        course.selectByVisibleText("Tech News");
        driver.switchTo().parentFrame();
        driver.findElement(By.id("name")).sendKeys("frame3");
        driver.switchTo().parentFrame();
        driver.findElement(By.id("name")).sendKeys("World");








    }
    }

