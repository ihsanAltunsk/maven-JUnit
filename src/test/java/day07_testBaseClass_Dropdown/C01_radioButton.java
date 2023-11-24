package day07_testBaseClass_Dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_radioButton {
    // -  Create the necessary structure and complete the following task:
    // a. Go to the given web page https://testotomasyonu.com/form
    // b. Locate the Gender Radio button elements and select the appropriate one.
    // c. Create two different test methods and select the appropriate option
    //    either through text or directly from the button.
    // d. Test that the radio button you selected is selected, and the others are not selected.

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // a. Go to the given web page https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");
    }
    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void radioButtonBoxTest(){
        // b. Locate the Gender Radio button elements and select the appropriate option
        //   through button
        driver.findElement(By.id("inlineRadio2")).click();

        // d. Test that the radio button you selected is selected, and the others are not selected.
        WebElement woman = driver.findElement(By.id("inlineRadio1"));
        WebElement man = driver.findElement(By.id("inlineRadio2"));
        WebElement other = driver.findElement(By.id("inlineRadio3"));

        Assert.assertTrue(man.isSelected());
        Assert.assertFalse(woman.isSelected());
        Assert.assertFalse(other.isSelected());
    }

    @Test
    public void  radioButtonTextTest(){
        /// b. Locate the Gender Radio button elements and select the appropriate option
        //   through text
        driver.findElement(By.xpath("//*[text()='Erkek']")).click();

        // d. Test that the radio button you selected is selected, and the others are not selected.
        WebElement woman = driver.findElement(By.id("inlineRadio1"));
        WebElement man = driver.findElement(By.id("inlineRadio2"));
        WebElement other = driver.findElement(By.id("inlineRadio3"));

        Assert.assertTrue(man.isSelected());
        Assert.assertFalse(woman.isSelected());
        Assert.assertFalse(other.isSelected());
    }
}
