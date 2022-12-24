package codeChallenge.PracticeDay01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseTest;

import java.time.Duration;

public class Task10 extends BaseTest {


    @Test
    public void test() {

        //   https://www.amazon.com.tr/ sitesi açılır.
        driver.get("https://www.amazon.de/");

        //   Ana sayfanın açıldığı kontrol edilir.
        Assert.assertEquals("https://www.amazon.de/", driver.getCurrentUrl());

        //   Çerez tercihlerinden Çerezleri kabul et seçilir.
        driver.findElement(By.id("sp-cc-accept")).click();

        //   Siteye login olunur.
        WebElement login = driver.findElement(By.id("nav-link-accountList"));
        login.click();

        WebElement email = driver.findElement(By.id("ap_email"));
        email.sendKeys("ilyastarhan.de@gmail.com" + Keys.ENTER);
        WebElement password = driver.findElement(By.id("ap_password"));
        password.sendKeys("261215Amazon.!" + Keys.ENTER);

        //   Login işlemi kontrol edilir.
        WebElement kontoName = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        Assert.assertTrue(kontoName.getText().contains("Ilyas"));

        //   Arama butonu yanındaki kategoriler tabından bilgisayar seçilir.
        WebElement drpDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(drpDown);
        select.selectByVisibleText("Computer & Zubehör");

        //   Bilgisayar kategorisi seçildiği kontrol edilir.
        Assert.assertEquals("Computer & Zubehör", select.getFirstSelectedOption().getText());

        //   Arama alanına MSI yazılır ve arama yapılır.
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("MSI" + Keys.ENTER);

        //   Arama yapıldığı kontrol edilir.
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText().contains("MSI"));

        //   Arama sonuçları sayfasından 2. sayfa acilir
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//a[@aria-label='Zu Seite 2']")));
        WebElement page2 = driver.findElement(By.xpath("//a[@aria-label='Zu Seite 2']"));
        page2.click();

        //   2. sayfanın açıldığı kontrol edilir.
        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'25-48')]")).isDisplayed());
        Assert.assertTrue(driver.getCurrentUrl().contains("sr_pg_2"));

        //   Sayfadaki 2. ürün favorilere eklenir.

        driver.findElement(By.xpath("(//img[@data-image-index='26'])[1]")).click();
        WebElement wishList = driver.findElement(By.id("wishListMainButton"));
        wishList.click();

        //   2. Ürünün favorilere eklendiği kontrol edilir.
        WebElement listControl = driver.findElement(By.xpath("//*[text()='1 Artikel wurde hinzugefügt zu']"));
        Assert.assertTrue(listControl.isDisplayed());

        //   Hesabım > Favori Listem sayfasına gidilir.
        action.sendKeys(Keys.ESCAPE).perform();
        action.sendKeys(Keys.PAGE_UP).perform();
        action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).perform();
        WebElement favori = driver.findElement(By.linkText("Wunschzettel"));
        favori.click();

        //   “Favori Listem” sayfası açıldığı kontrol edilir.
        WebElement shoppingList = driver.findElement(By.id("profile-list-name"));
        Assert.assertEquals("Einkaufsliste", shoppingList.getText());

        //   Eklenen ürün favorilerden silinir.
        WebElement delete = driver.findElement(By.xpath("//input[@name='submit.deleteItem']"));
        delete.click();

        //   Silme işleminin gerçekleştiği kontrol edilir.
        WebElement deleteConfirmation = driver.findElement(By.xpath("//div[text()='Gelöscht']"));
        Assert.assertTrue(deleteConfirmation.isDisplayed());

        //   Üye çıkış işlemi yapılır.
        action.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1"))).perform();
        driver.findElement(By.linkText("Abmelden")).click();

        //   Çıkış işleminin yapıldığı kontrol edilir.
        Assert.assertEquals("Anmelden", driver.findElement(By.tagName("h1")).getText());


    }
}
