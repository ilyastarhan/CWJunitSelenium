package Day9_JSEScroll_Cookies_Files;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.BaseTest;

public class C2_ScrolWithJSExecutor extends BaseTest {

        /*
            executeScript("window.scrollBy(x-piksel,y-piksel)");  ya da js.executeScript("scroll(x,y);");
            x-piksel x eksenindeki sayıdır, sayı pozitifse sola, sayı negatifse saga hareket eder.
            y-piksel y eksenindeki sayıdır, sayı pozitifse ise aşağı doğru,sayı negatif ise yukarı doğru hareket eder.
            js.executeScript("window.scrollBy(0,1000)"); // Dikey olarak 1000 piksel asagi kaydır
            js.executeScript("window.scrollTo(0, 0)");  // en asagiya gider
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); // en asagiya gider
                // scrollTo : Verilen pixele gider.
                // scrollBy : Verilen kadar daha ileri gider.
           scrollIntoView () web sayfasindaki bir ogenin gorunurlulugune gore kaydirir
           js.executeScript("arguments[0].scrollIntoView();"  , webelement);
 */
    /*
    go to url : https://api.jquery.com/dblclick/
    double click on the blue square at the bottom of the page and then write the changed color.
     */




    @Test
    public void doubleClickBtn(){

        //  go to url : https://api.jquery.com/dblclick/
        //  double click on the blue
        //  square at the bottom of the page and then write the changed color.
        driver.get("https://api.jquery.com/dblclick/");
        driver.switchTo().frame(0);
        WebElement blueBox = driver.findElement(By.tagName("div"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", blueBox);
        System.out.println(blueBox.getCssValue("background-color"));
        Actions action = new Actions(driver);
        action.doubleClick(blueBox).perform();
        System.out.println(blueBox.getCssValue(("background-color")));


    }
}
