package Exercises.JunitAssertions;

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

public class T01_LogoutUser {


    WebDriver driver;
    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void after(){
        driver.quit();

    }

    @Test
    public void loginTest(){


        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'

        driver.get("https://automationexercise.com/");

        // 3. Verify that home page is visible successfully
        WebElement logo = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logo.isDisplayed());

        // 4. Click on 'Signup / Login' button
        WebElement signUpButton = driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
        signUpButton.click();
        // 5. Verify 'Login to your account' is visible
        WebElement loginStr = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(loginStr.isDisplayed());
        // 6. Enter correct email address and password
        WebElement emailAdress = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        emailAdress.sendKeys("ahmet@nehaber.com");
        WebElement password = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        password.sendKeys("12345");
        // 7. Click 'login' button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        // 8. Verify that 'Logged in as username' is visible
        WebElement logged = driver.findElement(By.xpath("//a[text()=' Logged in as ']"));
        Assert.assertTrue(logged.isDisplayed());
        // 9. Click 'Logout' button
        driver.findElement(By.xpath("//a[text()=' Logout']")).click();
        // 10. Verify that user is navigated to login page
        Assert.assertEquals("https://automationexercise.com/login", driver.getCurrentUrl());
        // 11. Close the browser
        driver.quit();





    }
}
