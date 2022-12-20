package Exercises.Day05_Select;

import com.github.javafaker.Faker;
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
import java.util.List;

public class Test01 {



    WebDriver driver;
    Faker faker;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        faker = new Faker();


    }

    @After
    public void tearDown() {
      //  driver.quit();

    }

    @Test
    public void test(){
        driver.get("https://opensource-demo.orangehrmlive.com");
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        driver.findElement(By.xpath("//a[text()='Employee List']")).click();
        WebElement employeeName = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
        List<WebElement> ids = driver.findElements(By.xpath("//input[@placeholder='Type for hints...']"));
        WebElement id = ids.get(1);
        employeeName.sendKeys(faker.name().firstName());
        id.sendKeys(faker.idNumber().valid());

    }
}
