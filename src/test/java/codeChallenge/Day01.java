package codeChallenge;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day01 {

    //1-->git->"https://amazon.com"
//2-->arama kutusundan "Electronic" seç
//3-->"tv" yazdır
//4-->"2. sayfaya" git
//5-->tv  sepete ekle
//6-->sepete git
//7-->Proceed to checkout' a tıkla
//8-->"Email or mobile phone number" gir
//9-->"continue" butonuna tıkla
//10--->"There was a problem" yazısının görüntülendiğini kontrol et
//11-->Taraycı kapat


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
     //   driver.quit();

    }

    @Test
    public void test() {

        //1-->git->"https://amazon.com"

        driver.get("https://www.amazon.com");
        //2-->arama kutusundan "Electronic" seç
        //3-->"tv" yazdır
        //4-->"2. sayfaya" git
        //5-->tv  sepete ekle
        //6-->sepete git
        //7-->Proceed to checkout' a tıkla
        //8-->"Email or mobile phone number" gir
        //9-->"continue" butonuna tıkla
        //10--->"There was a problem" yazısının görüntülendiğini kontrol et
        //11-->Taraycı kapat
    }
}