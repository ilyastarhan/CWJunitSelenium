package Day12_ScreenShots;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.BaseTest;

import java.io.File;
import java.io.IOException;

public class C01_ScreenShots {


    @Test
    public void fullPageScreenshot() throws IOException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.amazon.de/");
        driver.findElement(By.id("sp-cc-accept")).click();
        File source = ((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("test-output\\Screenshots\\amazonFullScreenshot.png"));
    }
}
