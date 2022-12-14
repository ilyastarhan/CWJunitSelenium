package Exercises;

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

public class iFrame02 {
    WebDriver driver;

    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @After
    public void after() {
        // driver.quit();

    }

    @Test
    public void iFrameTest() {

        //        Go to URL: https://the-internet.herokuapp.com/iframe
        driver.get("https://the-internet.herokuapp.com/iframe");
        //        Verify the Bolded text contains "Editor"
        WebElement boldedText = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(boldedText.getText().contains("Editor"));
        //        Locate the text box
        driver.switchTo().frame(0);
        //        Delete the text in the text box
        WebElement textBox = driver.findElement(By.id("tinymce"));
        textBox.clear();
        //        Type "Hi everyone"
        textBox.sendKeys("Hi everyone!");
        //        Verify the text Elemental Selenium text is displayed on the page.
        driver.switchTo().defaultContent();
        Assert.assertTrue(driver.findElement(By.partialLinkText("Elemental")).isDisplayed());


    }
}