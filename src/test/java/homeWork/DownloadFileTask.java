package homeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.nio.file.Files;
import java.nio.file.Paths;

public class DownloadFileTask extends BaseTest {


    @Test
    public void downloadFile() throws InterruptedException {
        // Go to https://the-internet.herokuapp.com/download
        driver.get("https://the-internet.herokuapp.com/download");
        //  Download sample.png file
        WebElement samplePng = driver.findElement(By.linkText("sample.png"));
        samplePng.click();
        Thread.sleep(3000);

        //  Then verify if the file downloaded successfully
        String filePath = "C:\\Users\\ilyas\\Downloads\\sample.png";
        Assert.assertTrue(Files.exists(Paths.get(filePath)));
    }
}
