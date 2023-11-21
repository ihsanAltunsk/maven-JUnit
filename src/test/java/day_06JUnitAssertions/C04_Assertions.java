package day_06JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {
    // - Go to https://www.bestbuy.com/.
    // - Perform the following tests using different test methods:

    // 1- URLTest => Test that the page URL is equal to https://www.bestbuy.com/.
    // 2- TitleTest => Test that the page title does not contain "Rest".
    // 3- LogoTest => Test that the BestBuy logo is displayed.
    // 4- FrancaisLink Test => Test that the French link is displayed.

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.bestbuy.com/");
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }

    @Test
    public void test01(){
        // 1- URLTest => Test that the page URL is equal to https://www.bestbuy.com/.
        Assert.assertEquals("https://www.bestbuy.com/",driver.getCurrentUrl());
    }

    @Test
    public void test02(){
        // 2- TitleTest => Test that the page title does not contain "Rest".
        Assert.assertFalse(driver.getTitle().contains("Rest"));
    }

    @Test
    public void test03(){
        // 3- LogoTest => Test that the BestBuy logo is displayed.
        Assert.assertTrue(driver.findElement(By.className("logo")).isDisplayed());
    }

    @Test
    public void test04(){
        // 4- FrancaisLink Test => Test that the French link is displayed.
        Assert.assertTrue(driver.findElement(By.xpath("//button[@lang='fr']")).isDisplayed());
    }

}
