package Exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Actions02 {    WebDriver driver;
    @Before
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @After
    public void after(){
        // driver.quit();

    }

    @Test
    public void actionTest() {
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        Actions action = new Actions(driver);

        List<WebElement> cities = new ArrayList<>();
        for (int i = 1; i <=7 ; i++) {
            cities.add(driver.findElement(By.id("box"+i)));}
        List<WebElement> states = new ArrayList<>();
        for (int i = 1; i<=7;i++){
            states.add(driver.findElement(By.id("box10"+i)));
        }
        for(int i=0; i<7; i++){
            action.dragAndDrop(cities.get(i), states.get(i)).perform();
        }

    //    WebElement copenhagen = driver.findElement(By.id("box4"));
    //    WebElement seoul = driver.findElement(By.id("box5"));
    //    WebElement rome = driver.findElement(By.id("box6"));
    //    WebElement madrid = driver.findElement(By.id("box7"));
    //    WebElement oslo = driver.findElement(By.id("box1"));
    //    WebElement stockholm = driver.findElement(By.id("box2"));
    //    WebElement washington = driver.findElement(By.id("box3"));
//
    //    WebElement italy = driver.findElement(By.id("box106"));
    //    WebElement spain = driver.findElement(By.id("box107"));
    //    WebElement norway = driver.findElement(By.id("box101"));
    //    WebElement denmark = driver.findElement(By.id("box104"));
    //    WebElement southKorea = driver.findElement(By.id("box105"));
    //    WebElement sweden = driver.findElement(By.id("box102"));
    //    WebElement unitedStates = driver.findElement(By.id("box103"));


     //  action.dragAndDrop(copenhagen,denmark)
     //  .dragAndDrop(washington,unitedStates)
     //          .dragAndDrop(seoul,southKorea)
     //          .dragAndDrop(rome,italy)
     //          .dragAndDrop(stockholm,sweden)
     //          .dragAndDrop(oslo,norway)
     //          .dragAndDrop(madrid,spain).build().perform();





    }
}