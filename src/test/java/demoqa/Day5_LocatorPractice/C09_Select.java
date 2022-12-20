package demoqa.Day5_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C09_Select {

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        //    driver.quit();
    }

    @Test
    public void test() {
        driver.get("https://demoqa.com/select-menu");
        WebElement selectValue = driver.findElement(By.cssSelector("div#withOptGroup"));
        WebElement selectOne = driver.findElement(By.cssSelector("div#selectOne"));
        WebElement oldStyleSelect = driver.findElement(By.cssSelector("select#oldSelectMenu"));
        Select select = new Select(selectOne);
        select.selectByVisibleText("Group 2, option 2");
     //   Select select1 = new Select(selectValue);
     //   select1.selectByIndex(2);
        Select select2 = new Select(oldStyleSelect);
        select2.selectByIndex(2);
    }
}