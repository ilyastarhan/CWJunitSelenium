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

import java.time.Duration;

public class TextBox {

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
        driver.get("https://demoqa.com/text-box");
        WebElement name = driver.findElement(By.id("userName"));
        WebElement email = driver.findElement(By.id("userEmail"));
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        name.sendKeys(faker.name().fullName());
        email.sendKeys(faker.internet().emailAddress());
        currentAddress.sendKeys(faker.address().fullAddress());
        permanentAddress.sendKeys(faker.address().fullAddress());
        WebElement submit = driver.findElement(By.xpath("//button[@id='submit']"));
        submit.click();
    }
}
