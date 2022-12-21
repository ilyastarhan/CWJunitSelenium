package homeWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.BaseTest;

import java.util.List;

public class HomeWork08 extends BaseTest {



    @Test
    public void test(){

        //Go to URL: https://opensource-demo.orangehrmlive.com/
        driver.get("https://opensource-demo.orangehrmlive.com/");
        //Login with Username: Admin
        driver.findElement(By.name("username")).sendKeys("Admin");
        //Login with Password: admin123
        driver.findElement(By.name("password")).sendKeys("admin123");
        //Click login button
        driver.findElement(By.tagName("button")).click();
        //Click on PIM
        driver.findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[2]")).click();
        //Click on Employee List
        driver.findElement(By.xpath("(//a[contains(@class,'oxd')])[13]")).click();
        List<WebElement> list = driver.findElements(By.cssSelector(".oxd-grid-item.oxd-grid-item--gutters"));
        //    Employee Name -> Use Faker Class
        list.get(0).sendKeys(faker.name().name());
        //    ID -> Use Faker Class
        list.get(1).sendKeys(faker.idNumber().valid());
        //    Employment Status -> select by index: 2
        list.get(2).sendKeys("Full-Time Permanent");
        //    Include -> selectByVisibleText: Current and Past Employees
        list.get(3).sendKeys("Current and Past Employees");
        //    Supervisor Name -> Use Faker Class
        list.get(4).sendKeys(faker.name().name());
        //    Job Title ->selectByValue: IT Manager
        list.get(5).sendKeys("IT Manager");
        //    Sub Unit ->selectByValue: 3
        list.get(6).sendKeys("Devolopment");
        //Click search button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Verify text visible : "No Records Found"
        WebElement result = driver.findElement(By.xpath("//span[text()='No Records Found']"));
        Assert.assertTrue(result.isDisplayed());
        //


    }
}
