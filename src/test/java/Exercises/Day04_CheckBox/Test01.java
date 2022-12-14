package Exercises.Day04_CheckBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Test01 {


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
        driver.quit();

    }

    @Test
    public void test() {
        driver.get("https://itera-qa.azurewebsites.net/home/automation");
        List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox' and @class='form-check-input']"));
        for (WebElement webElement : checkbox) {
            webElement.click();
        }

    }
}
