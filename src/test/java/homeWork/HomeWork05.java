package homeWork;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;

import java.util.List;

public class HomeWork05 extends BaseTest {

  //  - https://demoqa.com/select-menu sitesine gidin
  //  - <select> elementini locate edin
  //  - <select> elementinin seceneklerini yazdirin
  //  - Sirasiyla selectByIndex, selectByValue, selectByVisibleText methodlarini kullanarak;
  //  * Yellow (index)
  //  * Purple (value)
  //  * Black  (text)
  //  seceneklerini secin

    @Test
    public void selectTest(){
        driver.get("https://demoqa.com/select-menu");
        WebElement selectMenu = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(selectMenu);
        List<WebElement> selectList = select.getOptions();
        for (WebElement each : selectList) {
            System.out.println(each.getText());
        }
        select.selectByIndex(3);
        select.selectByValue("4");
        select.selectByVisibleText("Black");

    }


}
