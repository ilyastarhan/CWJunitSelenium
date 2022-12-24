package codeChallenge.PracticeDay01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

public class Task03 extends BaseTest {


    @Test
    public void acceptAlert() {
        // ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // ● Bir method oluşturun: acceptAlert
        //     ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının "You successfully clicked an alert" olduğunu test edin.
        WebElement jsAlert = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        jsAlert.click();
        driver.switchTo().alert().accept();
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals("You successfully clicked an alert", result.getText());


        // ● Bir method oluşturun: dismissAlert
        //     ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının "successfuly" içermediğini test edin.
        // ● Bir method oluşturun: sendKeysAlert
        //     ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajında isminizin içerdiğini doğrulayın.

    }

    @Test
    public void dismissAlert() {
        // ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // ● Bir method oluşturun: acceptAlert
        //     ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının "You successfully clicked an alert" olduğunu test edin.
        WebElement jsConfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        jsConfirm.click();
        driver.switchTo().alert().dismiss();
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertFalse(result.getText().contains("successfuly"));
    }

    @Test
    public void sendKeysAlert() {

        // ● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // ● Bir method oluşturun: acceptAlert
        //     ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının "You successfully clicked an alert" olduğunu test edin.
        WebElement jsPrompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsPrompt.click();
        driver.switchTo().alert().sendKeys("ilyas");
        driver.switchTo().alert().accept();
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertTrue(result.getText().contains("ilyas"));
    }
}