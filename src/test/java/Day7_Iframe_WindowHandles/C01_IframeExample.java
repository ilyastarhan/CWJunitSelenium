package Day7_Iframe_WindowHandles;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_IframeExample {

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
        //driver.quit();
    }

    @Test
    public void iframeExample() {
        //        Go to URL: https://the-internet.herokuapp.com/iframe
        //        Verify the Bolded text contains "Editor"
        //        Locate the text box
        //        Delete the text in the text box
        //        Type "Hi everyone"
        //        Verify the text Elemental Selenium text is displayed on the page.
}}
