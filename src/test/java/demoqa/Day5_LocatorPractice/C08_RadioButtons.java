package demoqa.Day5_LocatorPractice;

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
import java.util.List;


public class C08_RadioButtons {
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
        //    driver.quit();
    }

    @Test
    public void test() {

            //Go to URL: https://demoqa.com/radio-button
            driver.get("https://demoqa.com/radio-button");
//Soruya verilen 3 seçeneğin de seçilme durumlarını doğrulayınız.

            WebElement yesKontrol= driver.findElement(By.xpath("//label[@for='yesRadio']"));
            WebElement Impressive= driver.findElement(By.xpath("//label[text()='Impressive']"));
            Impressive.click();
            WebElement ımKontrol=driver.findElement(By.xpath("//input[@id='impressiveRadio']"));
            Assert.assertTrue(ımKontrol.isSelected());
            WebElement No= driver.findElement(By.xpath("//label[text()='No']"));
            No.click();
            WebElement noKontrol=driver.findElement(By.xpath("//label[@class='custom-control-label disabled']"));
            Assert.assertTrue("secilemedi", noKontrol.isEnabled());
//Her bir seçenek seçildiğinde aşağıda çıkan text’leri konsolda yazdırınız.
            System.out.println(yesKontrol.getText());
            System.out.println(Impressive.getText());
            System.out.println(No.getText());
        }}