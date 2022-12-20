package Day6_Dropdown_SeleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;

public class C02_Select_Dropdown {


    WebDriver driver;

    @Before
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {

    }

    @Test
    public void selectByIndex() throws InterruptedException {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        //  Thread.sleep(3000);
        //  driver.findElement(By.xpath("//span[text()='Tümünü Kabul Et']")).click();
        WebElement drpDown = driver.findElement(By.xpath("//select[@name='country']"));
        Select select = new Select(drpDown);
        select.selectByIndex(2);

    }

    @Test
    public void selectByValue() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        //  driver.findElement(By.xpath("//button[@id='save']")).click();
        WebElement drpDown = driver.findElement(By.xpath("//select[@name='country']"));
        Select select = new Select(drpDown);
        select.selectByValue("TURKEY");
        System.out.println("select.isMultiple() = " + select.isMultiple());


    }


    @Test
    public void selectByVisibleText() {
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement drpDown = driver.findElement(By.xpath("//select[@name='country']"));
        Select select = new Select(drpDown);
        select.selectByVisibleText("NEPAL");
    }

    @Test
    public void multipleSelect() {
        driver.get("https://output.jsbin.com/osebed/2");
        Select select = new Select(driver.findElement(By.id("fruits")));
        if (select.isMultiple()) {
            select.selectByValue("apple");
            select.selectByIndex(3);
        }
    }

    @Test
    public void getOptions(){
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        WebElement drpDown = driver.findElement(By.xpath("//select[@name='country']"));
        Select select = new Select(drpDown);
        List<WebElement> getOptions = select.getOptions();
        for (WebElement value : getOptions){
            System.out.println(value.getText());
        }
    }

    @Test
    public void getFirstSelectedOption(){
        driver.get("https://uotput.jsbin.com/osebed/2");
        Select select = new Select(driver.findElement(By.id("fruits")));
        select.selectByIndex(2);
        select.selectByIndex(3);
        select.deselectByIndex(2);
        System.out.println(select.getFirstSelectedOption().getText());
    }

    @Test
    public void getAllSelectedOptions(){
        driver.get("https://uotput.jsbin.com/osebed/2");
        Select select = new Select(driver.findElement(By.id("fruits")));
        select.selectByIndex(2);
        select.selectByIndex(3);
        select.selectByIndex(1);
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        selectedOptions.forEach(t-> System.out.println(t.getText()));



    }
}

