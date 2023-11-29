package tests.day11_waits_cookies_webTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_ExplicitWait {
    // 1- Go to https://the-internet.herokuapp.com/dynamic_controls address.
    // 2- Verify that the textbox is not enabled.
    // 3- Click on the Enable button and wait until the textbox becomes enabled.
    // 4- Verify that the message "It's enabled!" is displayed.
    // 5- Verify that the textbox is enabled.

    @Test
    public void test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // 1- Go to https://the-internet.herokuapp.com/dynamic_controls address.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 2- Verify that the textbox is not enabled.
        WebElement textboxElement = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textboxElement.isEnabled());

        // 3- Click on the Enable button,
        driver.findElement(By.xpath("//*[text()='Enable']")).click();
        //    and wait until the textbox becomes enabled.
            // 1- Create a wait object.
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
            // 2- If possible, locate the web element to be used.
            // We will wait for the textbox to be usable; the textbox is located.

            // 3- Wait with the wait object for the expected condition on the desired web element.
            wait.until(ExpectedConditions.elementToBeClickable(textboxElement));

        // 4- Verify that the message "It's enabled!" is displayed.
        WebElement itsEnabledElement = driver.findElement(By.xpath("//*[text()=\"It's enabled!\"]"));

        // 5- Verify that the textbox is enabled.
        Assert.assertTrue(itsEnabledElement.isEnabled());
        driver.quit();
    }
}
