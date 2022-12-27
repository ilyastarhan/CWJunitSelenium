package Exercises;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.BaseTest;

import java.io.File;
import java.io.IOException;

public class ScreenShots extends BaseTest {
    @Test
    public void screenShotTest() throws IOException {
        driver.get("https://www.amazon.de/");
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("\\test-output\\Screenshots\\Amazon.png"));

    }
}
