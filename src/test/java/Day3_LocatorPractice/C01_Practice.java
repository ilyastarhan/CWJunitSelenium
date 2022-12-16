package Day3_LocatorPractice;

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
    public void xPathPractice(){

        //    Go to https://www.linkedin.com/
        driver.get("https://www.linkedin.com/");

        //    When we write an e-mail without the @ sign in the e-mail box and press enter.
        driver.findElement(By.xpath("//input[@id='email-or-phone']")).sendKeys("ilyastarhan" + Keys.ENTER);

        //    Let's test the "Invalid email address" warning.
        WebElement alertMessage = driver.findElement(By.xpath("//p[@class='alert-content']"));
        Assert.assertTrue("hata mesaji gelmedi", alertMessage.isDisplayed());
       // Assert.assertEquals(true, alertMessage.isDisplayed());
       // Assert.assertFalse(!alertMessage.isDisplayed())



    }
}
