package Exercises.Day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Test01_RegisterUser {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Signup / Login' button
    //5. Verify 'New User Signup!' is visible
    //6. Enter name and email address
    //7. Click 'Signup' button
    //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    //9. Fill details: Title, Name, Email, Password, Date of birth
    //10. Select checkbox 'Sign up for our newsletter!'
    //11. Select checkbox 'Receive special offers from our partners!'
    //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    //13. Click 'Create Account button'
    //14. Verify that 'ACCOUNT CREATED!' is visible
    //15. Click 'Continue' button
    //16. Verify that 'Logged in as username' is visible
    //17. Click 'Delete Account' button
    //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

    static WebDriver driver;
    static Actions action;
    static String email = "ilzysdd@asqwd.com";
    static String password = "123456";

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        action = new Actions(driver);

    }


    @AfterClass
    public static void tearDown() {
        driver.quit();

    }

    @Before
    public void before() {
        driver.get("https://automationexercise.com/");

    }

    @After
    public void after() {

    }

    @Test
    public void Test01() {
        WebElement signUp = driver.findElement(By.xpath("//i[@class='fa fa-lock']"));
        signUp.click();
        WebElement homePageIsVisible = driver.findElement(By.xpath("//i[@class='fa fa-home']"));
        Assert.assertTrue(homePageIsVisible.isDisplayed());
        WebElement signUpIsVisible = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
        Assert.assertTrue(signUpIsVisible.isDisplayed());
        WebElement enterNameAndEmailAdress = driver.findElement(By.xpath("//input[@name='name']"));
        action.click(enterNameAndEmailAdress).sendKeys("ilyas" + Keys.TAB)
                .sendKeys(email + Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
        WebElement enterInformation = driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        Assert.assertTrue(enterInformation.isDisplayed());
        WebElement titleClick = driver.findElement(By.xpath("//div[@id='uniform-id_gender1']"));
        action.click(titleClick).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(password + Keys.TAB)
                .sendKeys("12" + Keys.TAB)
                .sendKeys("April" + Keys.TAB)
                .sendKeys("2000" + Keys.TAB)
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB)
                .sendKeys("ilyas" + Keys.TAB)
                .sendKeys("pabucuyarim" + Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Lalei sokak ihlamur caddesi" + Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Canada" + Keys.TAB)
                .sendKeys("Toronto" + Keys.TAB)
                .sendKeys("06600" + Keys.TAB)
                .sendKeys("1235563153" + Keys.TAB)
                .sendKeys("13131313321" + Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
        WebElement createdInfo = driver.findElement(By.xpath("//b[text()='Account Created!']"));
        Assert.assertTrue(createdInfo.isDisplayed());
        WebElement continueButton = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
        continueButton.click();
        WebElement logOut = driver.findElement(By.xpath("//i[@class='fa fa-lock']"));
        logOut.click();

    }

    @Test
    public void Test02() {
        WebElement isVisible = driver.findElement(By.xpath("//i[@class='fa fa-envelope']"));
        Assert.assertTrue(isVisible.isDisplayed());
        WebElement signUpButton = driver.findElement(By.xpath("//i[@class='fa fa-lock']"));
        signUpButton.click();
        WebElement loginIsVisible = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertTrue(loginIsVisible.isDisplayed());
        WebElement enterEmail = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        action.click(enterEmail).sendKeys(email + Keys.TAB)
                .sendKeys(password + Keys.TAB)
                .sendKeys(Keys.SPACE).perform();
        WebElement deleteAccount = driver.findElement(By.xpath("//i[@class='fa fa-trash-o']"));
        deleteAccount.click();
        WebElement deleted = driver.findElement(By.xpath("//b[text()='Account Deleted!']"));
        Assert.assertTrue(deleted.isDisplayed());
        WebElement continueButton2 = driver.findElement(By.xpath("//a[@data-qa='continue-button']"));
        continueButton2.click();

    }

}
