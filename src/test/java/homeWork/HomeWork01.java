package homeWork;

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

public class HomeWork01 {

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
    public void test() {
        driver.get("https://id.heroku.com/login");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        WebElement emailField = driver.findElement(By.cssSelector("#email"));
        emailField.sendKeys(faker.internet().emailAddress());
        WebElement passField = driver.findElement(By.cssSelector("#password"));
        passField.sendKeys(faker.internet().password());
        WebElement submit = driver.findElement(By.cssSelector("button[name='commit']"));
        submit.click();
        WebElement alert = driver.findElement(By.cssSelector("div[class='alert alert-danger']"));
        boolean displayed = alert.isDisplayed();
        if (displayed)
            System.out.println("Kayıt Yapılamadı");
        else
            System.out.println("Kayıt Yapıldı");
    }
}
