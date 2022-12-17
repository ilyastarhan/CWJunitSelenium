package Day4_LocatorPractice;

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

import java.time.Duration;

public class C01_Practice {

    //Navigate to website  https://testpages.herokuapp.com/styled/index.html
    // Under the ORIGINAL CONTENTS
    // Click on Alerts
    // Print the URL
    // Navigate back
    // Print the URL
    // Click on Basic Ajax
    // Print the URL
    // Enter value  20 and Enter
    // And then verify Submitted Values is displayed open page
    // Close driver.

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void test(){
        driver.get("https://testpages.herokuapp.com/styled/index.html");
        WebElement alert = driver.findElement(By.xpath("//a[@id='alert']"));
        alert.click();
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);
        driver.navigate().back();
        String currentUrl2 = driver.getCurrentUrl();
        System.out.println("currentUrl2 = " + currentUrl2);
        WebElement basicAjaxLink = driver.findElement(By.xpath("//a[@id='basicajax']"));
        basicAjaxLink.click();
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        WebElement textElement = driver.findElement(By.xpath("//input[@id='lteq30']"));
        textElement.sendKeys("20"+ Keys.ENTER);
        WebElement display = driver.findElement(By.xpath("//p[text()='Submitted Values']"));
        Assert.assertTrue(display.isDisplayed());
    }
}
