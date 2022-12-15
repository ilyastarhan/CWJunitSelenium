package Day2_WebElementLocators;

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

public class C01_Locators {

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.linkedin.com/");

    }

    @After
    public void tearDown() {
       // driver.quit();


    }


    @Test
    public void idLocator() {


        WebElement email = driver.findElement(By.id("email-or-phone"));
        email.sendKeys("ilyastarhan.de@gmail.com");

    }

    @Test
    public void nameLocator(){

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("261215Linkedin.!");

    }

    @Test
    public void classLocator(){
        List<WebElement> classList = driver.findElements(By.className("input__input"));
        WebElement email = classList.get(2);
        email.sendKeys("ilyastarhan.de@gmail.com");


    }
    @Test
    public void tagLocator() {
     List<WebElement> tagList = driver.findElements(By.tagName("input"));
     WebElement email = tagList.get(2);
     email.sendKeys("ilyastarhan.de@gmail.com");
    }

    @Test
    public void linkTextLocator(){

        WebElement gizlilikPolitikasi = driver.findElement(By.linkText("Gizlilik Politikasını"));
        gizlilikPolitikasi.click();
    }

    @Test
    public void partialLinkText(){

        // link text -> "Forgot password?"

        WebElement forgotPwd = driver.findElement(By.linkText("Forgot password?"));
        forgotPwd.click();

    }
    @Test
    public void absoluteXpath(){
        WebElement eMailxPath = driver.findElement(By.xpath("/html/body/main/section[1]/div/form/section/div[2]/div[1]/input"));
        eMailxPath.sendKeys("ilyas absolute xpath kismini gayet basarili tamamladi");
    }

    @Test
    public void relativeXpath(){
        WebElement eMailRelativeXPath = driver.findElement(By.xpath("//input[@id='email-or-phone']"));
        eMailRelativeXPath.sendKeys("merhaba dünya");
    }


}
