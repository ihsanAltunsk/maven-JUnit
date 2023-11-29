package tests.day11_waits_cookies_webTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitlyWait {
    //  - Create two methods: implicitWait(), explicitWait()
    //  - Test the following steps for both methods.
    // 1- Go to the https://the-internet.herokuapp.com/dynamic_controls address.
    // 2- Click on the Remove button.
    // 3- Verify that the message "It's gone!" is displayed.
    // 4- Click on the Add button.
    // 5- Test if the message "It's back" is visible.

    @Test
    public void implicitWaitTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // 1- Go to the https://the-internet.herokuapp.com/dynamic_controls address.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 2- Click on the Remove button.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        // 3- Verify that the message "It's gone!" is displayed.
        WebElement itsGoneElement = driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneElement.isDisplayed());

        // 4- Click on the Add button.
        driver.findElement(By.xpath("//*[text()=\"Add\"]")).click();

        // 5- Test if the message "It's back" is visible.
        WebElement itsBackElement = driver.findElement(By.xpath("//*[text()=\"It's back!\"]"));
        Assert.assertTrue(itsBackElement.isDisplayed());
        driver.quit();
    }
    @Test
    public void explicitWaitTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // 1- Go to the https://the-internet.herokuapp.com/dynamic_controls address.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 2- Click on the Remove button.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        // 3- Verify that the message "It's gone!" is displayed.
            /*
                If the element we want to use is locatable,
                we can first locate it and
                then wait for the desired condition.
                However, if locating and waiting create a circular dependency,
                locating and waiting can be done together.
                // Step 1: Create a wait object
                    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

                // Step 2: Locate the web element we will wait for
                    WebElement itsGoneElement = driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));

                // Step 3: Perform operations on the desired web element using the wait object
                    wait.until(ExpectedConditions.visibilityOf(itsGoneElement));
            */

                // 1- Create a wait object
                WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

                // 2- Using the wait object created for waiting,
                //    perform both the locating of the web element and waiting together
                WebElement itsGoneElement =
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));


        // 4- Click on the Add button.
        driver.findElement(By.xpath("//*[text()=\"Add\"]")).click();

        // 5- Test if the message "It's back" is visible.
        WebElement itsBackElement =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));

        driver.quit();
    }
}
