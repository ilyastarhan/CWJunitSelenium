package codeChallenge.PracticeDay01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.Set;

public class Task05 extends BaseTest {


    @Test
    public void test() {

        //  ● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ● Sayfadaki textin "Opening a new window" olduğunu doğrulayın.
        WebElement text = driver.findElement(By.tagName("h3"));
        Assert.assertEquals("Test istendigi gibi degil", "Opening a new window", text.getText());

        //  ● Sayfa başlığının (title) "The Internet" olduğunu doğrulayın.
        Assert.assertEquals("The Internet", driver.getTitle());

        //  ● Click Here butonuna basın.
        String mainWindow = driver.getWindowHandle();
        driver.findElement(By.linkText("Click Here")).click();

        //  ● Açılan yeni pencerenin sayfa başlığının (title) "New Window" olduğunu doğrulayın.
        Set<String> allWindowHandles = driver.getWindowHandles();
        String secondWindow="";
        for(String each : allWindowHandles){
            if(!each.equals(mainWindow))
                secondWindow = each;
        }
        driver.switchTo().window(secondWindow);
        String tabTitle = driver.getTitle();
        Assert.assertEquals("New Window", driver.getTitle());

        //  ● Sayfadaki textin "New Window" olduğunu doğrulayın.
        Assert.assertEquals("New Window", driver.findElement(By.tagName("h3")).getText());

        //  ● Bir önceki pencereye geri döndükten sonra sayfa başlığının "The Internet" olduğunu doğrulayın.
        driver.switchTo().window(mainWindow);
        Assert.assertEquals("The Internet", driver.getTitle());

    }
}
