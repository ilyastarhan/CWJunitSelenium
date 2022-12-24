package codeChallenge.PracticeDay01;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class Task02 extends BaseTest {




    @Test
    public void test() {


         //  1. "https://facebook.com" adresine gidin.
        driver.get("https://facebook.com");
        //  2. "Create New Account" butonuna basın.
        driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
        driver.findElement(By.linkText("Yeni Hesap Oluştur")).click();
        //  3. "firstName" giriş kutusuna bir isim yazın.
        //  4. "surname" giriş kutusuna bir soyisim yazın.
        //  5. "email" giriş kutusuna bir email yazın.
        //  6. "email" onay kutusuna emaili tekrar yazın.
        //  7. Bir şifre girin.
        //  8. Tarih için gün seçin.
        //  9. Tarih için ay seçin.
        //  10. Tarih için yıl seçin.
        //  11. Cinsiyeti seçin.
        WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
       // Faker faker= new Faker();
       // Actions action = new Actions(driver);
        String email = faker.internet().emailAddress();
        action.click(firstname)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(1,30)))
                .sendKeys(Keys.TAB)
                .sendKeys("MAY")
                .sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(1970,2004)))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        //  12. İşaretlediğiniz cinsiyetin seçili, diğer cinsiyet kutularının seçili olmadığını doğrulayın.
        //  13. Sayfayı kapatın.
        Assert.assertTrue(driver.findElement(By.xpath("(//input[@name='sex'])[2]")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("(//input[@name='sex'])[1]")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("(//input[@name='sex'])[3]")).isSelected());





    }
}
