package utilities;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public abstract class BaseTest {

    /*
    Abstract yaparak TestBase Class'ından obje oluşturulmasının önüne geçeriz.
TestBase Class'ı sadece extends ile inherit ederek kullanacağız. Dolayısıyla
oluşturduğumuz driver variable'i için protected access modifier seçiyoruz. (
     */

    protected WebDriver driver;
    protected Actions action;
    protected Faker faker;


    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        action = new Actions(driver);
        faker = new Faker();

    }

    @After
    public void tearDown() {
       //driver.quit();

    }

}
