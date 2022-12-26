package homeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

public class UploadFileTask extends BaseTest {


    @Test
    public void uploadFile(){
      //  Go to URL: https://www.monsterindia.com/seeker/registration
        driver.get("https://www.monsterindia.com/seeker/registration");
      //  Upload file.
        String filePath = "C:\\Users\\ilyas\\Desktop\\resume.docx";
        WebElement uploadBtn = driver.findElement(By.id("file-upload"));
        uploadBtn.sendKeys(filePath);
        WebElement result = driver.findElement(By.id("registrationDetails"));
        Assert.assertTrue(result.isDisplayed());
        Assert.assertTrue(filePath.contains(result.getText()));
    }
}
