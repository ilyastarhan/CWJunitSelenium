package homeWork;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import utilities.BaseTest;

import java.util.Set;

public class Cookies1 extends BaseTest {


    @Test
    public void test() throws InterruptedException {

       // Go to URL: http://facebook.com
        driver.get("http://facebook.com");
        driver.findElement(By.xpath("(//button[@value='1'])[3]")).click();

       // getCookies,
        Set<Cookie> cookieSet = driver.manage().getCookies();
        System.out.println(cookieSet.size());//1
        for (Cookie each : cookieSet) {
            System.out.println(each.getName());
            System.out.println(each.getValue());
        }

        // addCookie,
        Cookie cookie1 = new Cookie("Facebook", "SocialMedia");
        Cookie cookie2 = new Cookie("Twitter", "Social");
        Cookie cookie3 = new Cookie("Youtube", "Media");
        driver.manage().addCookie(new Cookie("Tiktok", "Video"));
        driver.manage().addCookie(cookie1);
        driver.manage().addCookie(cookie2);
        driver.manage().addCookie(cookie3);
        cookieSet = driver.manage().getCookies();
        System.out.println(cookieSet.size());//5

        // deleteCookieNamed,
        driver.manage().deleteCookieNamed("Tiktok");
        driver.manage().deleteCookieNamed("_js_datr");
        cookieSet = driver.manage().getCookies();
        System.out.println(cookieSet.size());//3

       // deleteAllCookies.
        driver.manage().deleteAllCookies();
        cookieSet = driver.manage().getCookies();
        System.out.println(cookieSet.size());

    }
}
