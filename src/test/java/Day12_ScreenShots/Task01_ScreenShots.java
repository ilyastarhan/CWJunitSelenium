package Day12_ScreenShots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Task01_ScreenShots {


    @Test
    public void fullPageScreenShot() throws IOException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path = ".\\test-output\\Screenshots\\logoScreenshot_";
        String date = new SimpleDateFormat("yyyy_MM_dd-HH_mm_ss").format(new Date());
        String fullPath = path+date+".png";
        FileUtils.copyFile(screenshot, new File(fullPath));
    }
    @Test
    public void webElementScreenshot() throws IOException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        WebElement topSellers = driver.findElement(By.xpath("(//ul[@class='a-unordered-list a-nostyle a-horizontal feed-carousel-shelf'])[2]"));
     //   JavascriptExecutor jse = (JavascriptExecutor) driver;
     //   jse.executeScript("arguments[0].scrollIntoView();", topSellers);

        File screenshot = topSellers.getScreenshotAs(OutputType.FILE);
        String path = ".\\test-output\\Screenshots\\logoScreenshot_";
        String date = new SimpleDateFormat("yyyy_MM_dd-HH_mm_ss").format(new Date());
        FileUtils.copyFile(screenshot, new File(path+date+".png"));

      //  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

    }

    @Test
    public void fullPageScreenshot() throws IOException {
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        File file = driver.getFullPageScreenshotAs(OutputType.FILE);
        String path = ".\\test-output\\Screenshots\\logoScreenshot_";
        String date = new SimpleDateFormat("yyyy_MM_dd-HH_mm_ss").format(new Date());
        FileUtils.copyFile(file, new File(path+date+".png"));
     //   FileHandler.copy(file,new File(path+date+".png"));
    }

}
