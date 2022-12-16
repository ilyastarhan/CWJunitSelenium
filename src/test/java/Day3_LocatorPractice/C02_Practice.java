package Day3_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Practice {

//    Create the driver with BeforeClass and make it static inside the class.
//    Go to http://www.google.com
//    Type "Green Mile" in the search box and print the number of results.
//    Type "Premonition" in the search box and print the number of results.
//    Type "The Curious Case of Benjamin Button" in the search box and print the number of results.
//    Close with AfterClass.

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Before
    public void beforeEach() {
        driver.get("https://www.google.com/");

    }

    @After
    public void afterEach() {
    }

   @Test
   public void test01() {
       //    Type "Green Mile" in the search box and print the number of results.
       driver.findElement(By.xpath("//button[@id='L2AGLb']")).click();
       WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
       search.sendKeys("Green Mile" + Keys.ENTER);
       String result = driver.findElement(By.xpath("//div[@id='result-stats']")).getText();
       System.out.println("result = " + result);

   }

    @Test
    public void test02() {
        //    Type "The Curious Case of Benjamin Button" in the search box and print the number of results.
        WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
        search.sendKeys("The Curious Case of Benjamin Button" + Keys.ENTER);
        String result = driver.findElement(By.xpath("//div[@id='result-stats']")).getText();
        System.out.println("result = " + result);

    }
}
