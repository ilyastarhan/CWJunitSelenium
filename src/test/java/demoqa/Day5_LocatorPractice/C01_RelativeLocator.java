package demoqa.Day5_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C01_RelativeLocator {

    // Go to http://www.bestbuy.com
    // Verify that the page title contains "Best" Also, using Relative Locator.
    // LogoTest  Verify if the BestBuy logo is displayed.
    // mexicoLinkTest  Verify if the link is displayed.
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        //  driver.quit();
    }

    @Test
    public void test() {
        // Go to http://www.bestbuy.com

        driver.get("http://www.bestbuy.com");
        // Verify that the page title contains "Best" Also, using Relative Locator.

        Assert.assertTrue(driver.getTitle().contains("Best"));
        // LogoTest  Verify if the BestBuy logo is displayed.

        By logoLocater = RelativeLocator.with(By.tagName("img")).above(By.xpath("//div[text()='Hello!']"));
        WebElement logo = driver.findElement(logoLocater);
        Assert.assertTrue(logo.isDisplayed());
        // mexicoLinkTest  Verify if the link is displayed.

        By linkLocator = RelativeLocator.with(By.tagName("a")).toRightOf(By.xpath("//a[@class='us-link']"));
        WebElement link = driver.findElement(linkLocator);
        Assert.assertTrue(link.isDisplayed());
    }
}