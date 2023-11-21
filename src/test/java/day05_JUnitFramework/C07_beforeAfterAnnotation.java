package day05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.AssertionFailedError;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_beforeAfterAnnotation {
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void googleTest(){
        //go to google.com
        driver.get("https://google.com");

        //test if the url contains "google"
        if (driver.getCurrentUrl().contains("google")){
            System.out.println("Google url test PASSED");
        }else {
            System.out.println("Google url test FAILED");
           throw new AssertionFailedError();
        }
    }
    @Test
    public void testAutomationTest(){
        //go to testotomasyonu.com
        driver.get("https://testotomasyonu.com");

        //test if the title contains "Test Otomasyon"
        if (driver.getTitle().contains("Test Otomasyonu")){
            System.out.println("Title test PASSED");
        }else {
            System.out.println("Title test FAILED");
            System.out.println("Title: " + driver.getTitle() );
        }
    }
    @Test
    public void wisequarterTest(){
        //go to wisequarter.com
        driver.get("https://www.wisequarter.com");

        //test if the title contains "Wise"
        if (driver.getTitle().contains("Wise")){
            System.out.println("Wise title test PASSED");
        }else {
            System.out.println("Wise title test FAILED");
            System.out.println("Wise title: " + driver.getTitle() );
        }
    }
}
