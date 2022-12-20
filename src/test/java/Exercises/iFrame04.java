package Exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class iFrame04 {

    WebDriver driver;

    @Before
    public void before() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //   driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @After
    public void after() {
        // driver.quit();

    }

    @Test
    public void iFrameTest() throws InterruptedException {
        driver.get("https://demo.guru99.com/test/guru99home/");
        List<WebElement> iFrames = driver.findElements(By.tagName("iframe"));
        System.out.println("iFrames.size() = " + iFrames.size());
        driver.switchTo().frame(iFrames.get(3));
      //  driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();


    }
}