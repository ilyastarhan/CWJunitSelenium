package demoqa.Day5_LocatorPractice;

import com.github.dockerjava.api.model.WaitResponse;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class C02_Task {

    //https://www.teknosa.com/ adresine gidiniz.
// Arama çubuğuna ''oppo'’ yazıp ENTER tıklayınız.
// Sonuç sayısını yazdırınız.
// Çıkan ilk ürüne tıklayınız.
// Sepete ekleyiniz.
// Sepetime gite tıklayınız.
// Konsolda "Sipariş Özeti" WebElement'inin text'ini yazdırınız.
// Alışverişi tamamlayınız.
// Son olarak "Teknosa'ya Hoş Geldiniz" WebElement'inin text'ini yazdırınız.
// Driver'ı kapatınız.
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
        driver.quit();
    }

    @Test
    public void test(){

        //https://www.teknosa.com/ adresine gidiniz.
        driver.get("https://teknosa.com/");
        // Arama çubuğuna ''oppo'’ yazıp ENTER tıklayınız.
        driver.findElement(By.id("search-input")).sendKeys("oppo" + Keys.ENTER);
        // Sonuç sayısını yazdırınız.
        System.out.println(driver.findElement(By.xpath("//div[@class='plp-info']")).getText());
        // Çıkan ilk ürüne tıklayınız.
        driver.findElement(By.className("prd-link")).click();
        // Sepete ekleyiniz.
        driver.findElement(By.id("addToCartButton")).click();
        // Sepetime gite tıklayınız.

        driver.findElement((By.xpath("//a[@class='btn btn-secondary']"))).click();
        // Konsolda "Sipariş Özeti" WebElement'inin text'ini yazdırınız.
        System.out.println(driver.findElement(By.xpath("//div[@class='cart-sum-body']")).getText());
        // Alışverişi tamamlayınız.
        driver.findElement(By.xpath("//a[@class='btn btn-primary js-checkout-controls']")).click();
        // Son olarak "Teknosa'ya Hoş Geldiniz" WebElement'inin text'ini yazdırınız.
        System.out.println(driver.findElement(By.xpath("//div[@class='lrp-title']")).getText());
        // Driver'ı kapatınız.


    }
    }