package Day4_LocatorPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_CSSPractice {

    //http://the-internet.herokuapp.com/add_remove_elements/
    // Click on the "Add Element" button 100 times.
    // Write a function that takes a number, and clicks the "Delete" button.
    // Given number of times, and then validates that given number of buttons was deleted.
    // 1. Method: createButtons(100)
    // 2. Method: DeleteButtonsAndValidate()

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        createElements(100);
        deleteButtonsAndValidate(40);

    }

    private void deleteButtonsAndValidate(int amount) {
        List<WebElement> deleteButtonList = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        int sizeBefore = deleteButtonList.size();

        for (int i = 0; i <amount ; i++) {
            deleteButtonList.get(i).click();
        }

        List<WebElement> deleteButtonListafter = driver.findElements(By.cssSelector("button[onclick='deleteElement()']"));
        int sizeAfter = deleteButtonListafter.size();

        Assert.assertEquals(sizeBefore-amount,sizeAfter);

    }


    private void createElements(int amount) {
        WebElement addElement = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        for (int i = 0; i < 100; i++) {
            addElement.click();

        }
    }
}