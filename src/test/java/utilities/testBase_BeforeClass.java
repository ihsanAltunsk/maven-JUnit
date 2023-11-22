package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class testBase_BeforeClass {

    protected static WebDriver driver;

    @BeforeClass
    protected static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // a. Go to the given web page https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");
    }
    @AfterClass
    protected static void teardown(){
        driver.quit();
    }
}
