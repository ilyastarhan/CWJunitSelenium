package Day8_WindowHandles_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utilities.BaseTest;

public class C03_Actions extends BaseTest {





    @Test
    public void hoverOver(){
        driver.get("https://www.amazon.com/");
        driver.findElement(By.xpath("//a[text()='Your Account']")).click();
        WebElement accountAndList = driver.findElement(By.id("nav-link-accountList"));
        Actions action = new Actions(driver);
        action.moveToElement(accountAndList).click(driver.findElement(By.id("nav_prefetch_yourorders"))).build().perform();
        Assert.assertEquals(driver.getTitle(), "Amazon Sign-In");
    }
}
