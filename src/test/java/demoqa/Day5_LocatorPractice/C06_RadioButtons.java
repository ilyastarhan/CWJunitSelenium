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

import java.time.Duration;
import java.util.List;

public class C06_RadioButtons {

    //    Go to URL:  https://www.facebook.com/
    //    Click on Create an Account button.
    //    Then click on the radio buttons.
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
       // driver.quit();
    }

    @Test
    public void radioButtons(){

        //Facebook sitesine gidildi
        driver.get("https://www.facebook.com/");

        WebElement registerButton = driver.findElement(By.xpath("//a[contains(@data-testid,'registration-form')]"));
        registerButton.click();

        WebElement kadinRadio = driver.findElement(By.xpath("//input[@name='sex' and @value='1']"));
        WebElement erkekRadio = driver.findElement(By.xpath("//input[@name='sex' and @value='2']"));

        kadinRadio.click();

        erkekRadio.click();

        Assert.assertTrue(erkekRadio.isSelected());
        Assert.assertTrue(!kadinRadio.isSelected());

    }
}