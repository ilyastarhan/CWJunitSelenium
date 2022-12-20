package Day6_Dropdown_SeleniumWaits;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_Faker {

    @Test
    public void fakerExample(){

        Faker faker = new Faker();
        System.out.println("faker.name().name() = " + faker.name().name());
        System.out.println(faker.name().lastName());


    }
}
