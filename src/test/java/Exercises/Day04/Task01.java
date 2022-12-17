package Exercises.Day04;

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

public class Task01 {


    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test(){
        driver.get("https://www.automationexercise.com/");
        WebElement pageIsVisible = driver.findElement(By.xpath("//a[text()=' Contact us']"));
        Assert.assertTrue(pageIsVisible.isDisplayed());
        WebElement signUp = driver.findElement(By.xpath("//i[@class='fa fa-lock']"));
        signUp.click();
        WebElement loginIsVisible = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        Assert.assertTrue(loginIsVisible.isDisplayed());
        WebElement enterEmail = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        enterEmail.sendKeys("ahmetselam@adadm.com");
        WebElement enterPass = driver.findElement(By.xpath("//input[@name='password']"));
        enterPass.sendKeys("1231231");
        WebElement loginButton = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        loginButton.click();
        WebElement alert = driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']"));
        Assert.assertTrue(alert.isDisplayed());

    }

}
