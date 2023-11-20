package day04_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_JUnitFramework {
    public static void main(String[] args) throws InterruptedException {

        /* Before starting the test operations in a class,
         we must first create our Webdriver object
         and make the necessary configurations*/
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.testotomasyonu.com");
        Thread.sleep(2000);
        driver.quit();
    }
}
