package Day7_Iframe_WindowHandles;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class C03_WindowHandles extends BaseTest {


    @Test
    public void windowHandles(){
        //    Go to URL: https://www.toolsqa.com/selenium-webdriver/window-handle-in-selenium/
        driver.get("https://www.toolsqa.com/selenium-webdriver/window-handle-in-selenium/");
        //    Print the existing windowHandles ids by clicking all the links on the page.
        String mainHandle = driver.getWindowHandle();
        //    Click on the links that open a new page.
        List<WebElement> links = driver.findElements(By.xpath("//a[@target='_blank']"));
      //  links.forEach(WebElement::click);
       links.get(0).click();
       links.get(1).click();
       links.get(2).click();
        System.out.println(links.size());
        //    Close other pages other than the home page.
        Set<String> windows =driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        while(iterator.hasNext()){
            driver.switchTo().window(iterator.next());
            if(!driver.getWindowHandle().equals(mainHandle))
                driver.close();

        }

      //  for (String window : windows) {
      //      driver.switchTo().window(window);
      //      if (!window.equals(mainHandle))
      //          driver.close();
      //  }

        //    Set the driver back to the main page.
    }
}
