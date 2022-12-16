package Exercises.JunitActions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class T02_ActionClass {



    WebDriver driver;
    Actions action;

    @Before
    public void setrup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        action = new Actions(driver);

    }

    @After
    public void tearDown(){

    }

    @Test
    public void action(){
        driver.get("https://demoqa.com/buttons");
        WebElement doubleClick = driver.findElement(By.xpath("//button[@id='doubleClickBtn']"));
        action.doubleClick(doubleClick).perform();
        WebElement rightClick = driver.findElement(By.xpath("//button[@id='rightClickBtn']"));
        action.contextClick(rightClick).perform();
        WebElement leftclick = driver.findElement(By.xpath("//button[@id='3IU1J']"));
        action.click(leftclick).perform();

    }
}
