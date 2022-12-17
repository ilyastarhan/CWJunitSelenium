package Exercises.Day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Task02 {


    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){

    }

    @Test
    public void test2(){

        driver.get("https://demoqa.com/text-box/");

        // Find elements using tag name
        List<WebElement> allInputElements = driver.findElements(By.tagName("input"));

        if(allInputElements.size() != 0)
        {
            System.out.println(allInputElements.size() + " Elements found by TagName as input \n");

            for(WebElement inputElement : allInputElements)
            {
                System.out.println(inputElement.getAttribute("placeholder"));
            }
        }
    }
    }
 //   public void test(){
 //       driver.get("https://www.linkedin.com/home");
 //       WebElement submitButton = driver.findElement(By.xpath("//button[@id='join-form-submit']"));
 //       System.out.println("submitButton.getText() = " + submitButton.getText());
 //       System.out.println("submitButton.getAccessibleName() = " + submitButton.getAccessibleName());
 //       System.out.println("submitButton.getAriaRole() = " + submitButton.getAriaRole());
 //       System.out.println("submitButton.getAttribute(\"value\") = " + submitButton.getAttribute("value"));
 //       System.out.println("submitButton.getLocation() = " + submitButton.getLocation());
 //       System.out.println("submitButton.getSize().getHeight() = " + submitButton.getSize().getHeight());
 //       System.out.println("submitButton.getTagName() = " + submitButton.getTagName());
 //
 //   }

