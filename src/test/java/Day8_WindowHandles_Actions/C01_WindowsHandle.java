package Day8_WindowHandles_Actions;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import utilities.BaseTest;

import java.util.Iterator;
import java.util.Set;

public class C01_WindowsHandle extends BaseTest {

    @Test
    public void newWindow(){

        // Ana sekmemizde url i ziyaret ediyoruz.
        driver.get("https://testproject.io/");

        // Yeni pencere olusturup o pencereye switch ediyoruz.
        driver.switchTo().newWindow(WindowType.WINDOW);

        // Yeni penceremizde url imizi ziyaret ediyoruz
        driver.get("https://blog.testproject.io/");
    }

    @Test
    public void newTab(){

        // Ana sekmemizden testproject acildi
        driver.get("https://testproject.io/");

        // Yeni bir sekme olusturuldu
        WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);

        // Yeni sekmeden amazona gidildi
        newTab.get("https://www.amazon.com/");

        //Aktif tab in title i yazdirildi -> Aktif tab imiz = yeni olusturulan tab
        System.out.println(driver.getTitle());

    }


    @Test
    public void handleWindows() {

        driver.get("https://www.amazon.com/");
        String mainWindow = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com.tr/");

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.google.com/");

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> i = handles.iterator();
        for (String each : handles) {
            driver.switchTo().window(each);
            System.out.println(driver.getCurrentUrl());
            if(!driver.getWindowHandle().equals(mainWindow))
                driver.close();

        }
        driver.switchTo().window(mainWindow);
        System.out.println(driver.getTitle());

    }
}
