package day_06JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_checBox {
    //  - Go to the given web page https://testotomasyonu.com/form
    //  - Select the checkboxes for Back Pain and Cramps.
    // 1- Test that the Back Pain and Cramps checkboxes are selected.
    // 2- Test that the checkboxes for Sugar and Epilepsy are not selected.

    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testotomasyonu.com/form");
        driver.findElement(By.id("gridCheck4")).click();
        driver.findElement(By.id("gridCheck5")).click();
    }
    @AfterClass
    public static void teardown(){
        driver.quit();
    }

    @Test
    public void test01(){
        // 1- Test that the Back Pain and Cramps checkboxes are selected.
        Assert.assertTrue(driver.findElement(By.id("gridCheck4")).isSelected());
        Assert.assertTrue(driver.findElement(By.id("gridCheck5")).isSelected());
    }

    @Test
    public void test02(){
        // 2- Test that the checkboxes for Sugar and Epilepsy are not selected.
        Assert.assertFalse(driver.findElement(By.id("hastalikCheck2")).isSelected());
        Assert.assertFalse(driver.findElement(By.id("hastalikCheck7")).isSelected());
    }

}
