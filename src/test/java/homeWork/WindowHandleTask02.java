package homeWork;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.BaseTest;

import java.util.Iterator;
import java.util.Set;

public class WindowHandleTask02 extends BaseTest {



    @Test
    public void test(){


        driver.get("https://demoqa.com/browser-windows");
        String mainWindow = driver.getWindowHandle();

        driver.findElement(By.id("tabButton")).click();
        driver.findElement(By.id("windowButton")).click();
      //  driver.findElement(By.id("messageWindowButton")).click();

        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        while(iterator.hasNext()){
            driver.switchTo().window(iterator.next());
            if(!driver.getWindowHandle().equals(mainWindow)){
                String bodyText = driver.findElement(By.tagName("body")).getText();
                System.out.println(bodyText);
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
        System.out.println(driver.getTitle());

    }
}
