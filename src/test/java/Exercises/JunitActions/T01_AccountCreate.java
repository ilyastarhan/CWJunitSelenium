package Exercises.JunitActions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.util.Asserts;
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

public class T01_AccountCreate {

    WebDriver driver;
    Actions action;

    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        action = new Actions(driver);

    }

    @After
    public void After() {
        driver.quit();


    }

    @Test
    public void test() {

        // 1. Navigate to url : 'https://automationexercise.com/'
        driver.get("https://automationexercise.com/");
        // 2. Click on 'Signup / Login' button
        driver.findElement(By.xpath(" //a[text()=' Signup / Login']")).click();
        // 3. Enter name and email adress
        WebElement name = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        action.click(name).
                sendKeys("Ilyas").
                sendKeys(Keys.TAB).
                sendKeys("ilyas@assgmail.com").
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();

        WebElement title = driver.findElement(By.xpath("//div[@id='uniform-id_gender1']"));
        action.click(title)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("123456789")
                .sendKeys(Keys.TAB).sendKeys("12")
                .sendKeys(Keys.TAB).sendKeys("March")
                .sendKeys(Keys.TAB).sendKeys("1990")
                .sendKeys(Keys.TAB).sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB).sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB).sendKeys("ilyas")
                .sendKeys(Keys.TAB).sendKeys("papucuyarim")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("ulu cadde no 95")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("United States")
                .sendKeys(Keys.TAB).sendKeys("USA")
                .sendKeys(Keys.TAB).sendKeys("LosAngeles")
                .sendKeys(Keys.TAB).sendKeys("06600")
                .sendKeys(Keys.TAB).sendKeys("1236654525")
                .sendKeys(Keys.TAB).sendKeys(Keys.ENTER)
                .sendKeys("ankara soksk").sendKeys(Keys.TAB).perform();

        String expectedMessage = "ACCOUNT CREATED!";
        String actualMessage = driver.findElement(By.xpath("//h2[@data-qa='account-created']")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }
}
