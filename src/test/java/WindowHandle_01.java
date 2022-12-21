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
import java.util.Iterator;
import java.util.Set;

public class WindowHandle_01 {




    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @After
    public void tearDown() {
        //  driver.quit();

    }

    @Test
    public void test() {


      //  Go to URL: https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");
        //  Verify the text: “Opening a new window”
        String textString = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals("Opening a new window", textString);
      //  Verify the title of the page is “The Internet”
        String mainTitle = driver.getTitle();
        Assert.assertEquals("The Internet", mainTitle);
      //  Click on the “Click Here” button
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> itr = handles.iterator();
        String parentId = itr.next();
        String childId = itr.next();
      //  Verify the new window title is “New Window”
        driver.switchTo().window(childId);
        System.out.println(driver.getCurrentUrl());
        String newTitle = driver.getTitle();
        Assert.assertEquals("New Window", newTitle);
      //  Go back to the previous window and then verify the title: “The Internet”
        driver.switchTo().window(parentId);
        Assert.assertEquals("The Internet", driver.getTitle());
        //

    }
}