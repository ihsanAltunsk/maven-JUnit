package tests.day01_maven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_mavenFirstTest {
    public static void main(String[] args) {
        // 1- Go to the homepage of testotomasyonu.com.
        // 2- Test that the URL contains 'testotomasyonu'.
        // 3- Close the page.


        /*Our first step was to configure the webdriver, but this step is not mandatory.
         With Selenium 4.8, since it creates its own webdriver,
         even if we don't declare a webdriver externally,
         Selenium will use its own driver.*/

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- Go to the homepage of testotomasyonu.com.
        driver.get("https://testotomasyonu.com");

        // 2- Test that the URL contains 'testotomasyonu'.
        if(driver.getCurrentUrl().contains("testotomasyonu")){
            System.out.println("url test PASSED");
        }else{
            System.out.println("url test FAILED");
        }

        // 3- Close the page.
        driver.quit();
    }
}
