package Day9_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C09_FileDownload extends BaseTest {



    @Test
    public void fileDownload() throws InterruptedException {

     //   Go to URL: https://opensource-demo.orangehrmlive.com/
        driver.get("https://opensource-demo.orangehrmlive.com/");
     //   Login page valid credentials.
        WebElement userName = driver.findElement(By.name("username"));
        userName.sendKeys("Admin");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123" + Keys.ENTER);
     //   Download sample CSV file.
        WebElement pimBtn = driver.findElement(By.linkText("PIM"));
        pimBtn.click();
        WebElement confg = driver.findElement(By.xpath("//span[@class='oxd-topbar-body-nav-tab-item']"));
        confg.click();
        WebElement dataImport = driver.findElement(By.linkText("Data Import"));
        dataImport.click();
        WebElement download = driver.findElement(By.linkText("Download"));
        download.click();
        Thread.sleep(5000);
     //   Verify if the file downloaded successfully.
        String filePath = "C:\\Users\\ilyas\\Downloads\\importData.csv";
        File file = new File(filePath);
        Assert.assertTrue(file.exists());
        Assert.assertTrue(Files.exists(Paths.get(filePath)));

    }
}
