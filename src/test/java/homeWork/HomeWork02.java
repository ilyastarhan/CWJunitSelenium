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

public class HomeWork02 {


    WebDriver driver;
    Faker faker;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        faker = new Faker();
    }
    @After
    public void tearDown(){
        driver.quit();

    }
    @Test
    public void test(){
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement calculator = driver.findElement(By.id("calculatetest"));
        calculator.click();
        WebElement number1 = driver.findElement(By.id("number1"));
        number1.sendKeys("15");
        WebElement funktion = driver.findElement(By.id("function"));
        funktion.sendKeys("times");
        WebElement number2 = driver.findElement(By.id("number2"));
        number2.sendKeys("22");
        WebElement calculate = driver.findElement(By.id("calculate"));
        calculate.click();
        WebElement answer = driver.findElement(By.id("answer"));
        String result = answer.getText();
        System.out.println("result = " + result);


    }
}
