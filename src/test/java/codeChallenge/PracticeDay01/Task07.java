package codeChallenge.PracticeDay01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.Set;

public class Task07 extends BaseTest {




    @Test
    public void test() {


     //   1- https://the-internet.herokuapp.com/context_menu sitesine gidelim.
        driver.get("https://the-internet.herokuapp.com/context_menu");
     //   2- Çizili alan üzerinde sağ click yapalım.
        WebElement box = driver.findElement(By.id("hot-spot"));
        action.contextClick(box).perform();
     //   3- Alert'te çıkan yazının "You selected a context menu" olduğunu test edelim.
        Assert.assertEquals("You selected a context menu", driver.switchTo().alert().getText());
     //   4- Tamam diyerek Alert'i kapatalım.
        driver.switchTo().alert().accept();
        action.sendKeys(Keys.ESCAPE).perform();
        String mainWindow = driver.getWindowHandle();
     //   5- Elemental Selenium linkine tıklayalım.
        driver.findElement(By.linkText("Elemental Selenium")).click();
     //   6- Açılan sayfada h1 tagında "Elemental Selenium" yazdığını test edelim.
        Set<String> allWindowHanles = driver.getWindowHandles();
        String secondPageHandle = "";
        for (String each : allWindowHanles) {
            if(!each.equals(mainWindow))
                secondPageHandle = each;

        }
        driver.switchTo().window(secondPageHandle);
        Assert.assertEquals("Elemental Selenium", driver.findElement(By.tagName("h1")).getText());
    }
}
