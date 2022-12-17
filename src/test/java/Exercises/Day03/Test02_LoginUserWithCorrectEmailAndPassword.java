package Exercises.Day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Test02_LoginUserWithCorrectEmailAndPassword {

    WebDriver driver;
    Actions action;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        action = new Actions(driver);
    }
    @After
    public void tearDown(){
        //driver.quit();
    }

    @Test
    public void testCase(){

        driver.get("http://automationexercise.com/");
        WebElement isVisible = driver.findElement(By.xpath("//i[@class='fa fa-envelope']"));
        Assert.assertTrue(isVisible.isDisplayed());
        WebElement signUpButton = driver.findElement(By.xpath("//i[@class='fa fa-lock']"));
        signUpButton.click();
        WebElement loginIsVisible = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(loginIsVisible.isDisplayed());
        WebElement enterEmail = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        action.click(enterEmail).sendKeys("ahmetselim"+ Keys.TAB)
                .sendKeys("12345"+Keys.TAB)
                .sendKeys(Keys.SPACE).perform();

    }
}
