package Day9_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.List;

public class C11_AssertElementTrick extends BaseTest {

@Test
    public void fileUpload() {
        //   Go to URL: https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");
        //   Find the path of the file that you want to upload.
        WebElement dosyaSec = driver.findElement(By.id("file-upload"));
        dosyaSec.sendKeys("C:\\Users\\ilyas\\Desktop\\fileExist.png");
        //   Click on Upload button.
        WebElement uploadBtn = driver.findElement(By.id("file-submit"));
        uploadBtn.click();
        //   Verify the upload message.

        List<WebElement> list = driver.findElements(By.tagName("h9"));
        Assert.assertEquals("Element locate edilemedi", 1, list.size());

        WebElement uploadMessage = list.get(0);
        Assert.assertTrue(uploadMessage.isDisplayed());
        Assert.assertEquals("Mesajin texti istenildigi gibi görüntülenemiyor", "File Uploaded!", uploadMessage.getText());

    }
}
