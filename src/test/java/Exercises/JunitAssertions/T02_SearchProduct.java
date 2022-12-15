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

public class T02_SearchProduct {


    WebDriver driver;

    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void after() {
        driver.quit();


    }

    @Test
    public void test() {

        //  1. Launch browser
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //  2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com/");

        //  3. Verify that home page is visible successfully
        WebElement isVisible = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(isVisible.isDisplayed());
        //  4. Click on 'Products' button
        driver.findElement(By.xpath("//a[text()=' Products']")).click();
        //  5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement producktsPage = driver.findElement(By.xpath("//h2[text()='All Products']"));
        Assert.assertTrue(producktsPage.isDisplayed());
        //  6. Enter product name in search input and click search button
        WebElement searchInput = driver.findElement(By.xpath("//input[@id='search_product']"));
        searchInput.sendKeys("women");
        searchInput.findElement(By.xpath("//button[@id='submit_search']")).click();
        //  7. Verify 'SEARCHED PRODUCTS' is visible
        WebElement searchedProducts = driver.findElement(By.xpath("//h2[text()='Searched Products']"));
        Assert.assertTrue(searchedProducts.isDisplayed());
        //  8. Verify all the products related to search are visible


    }
}
