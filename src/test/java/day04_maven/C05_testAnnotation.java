package day04_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_testAnnotation {
    /* Can there be multiple independent tests within a class?
    When working with JUnit and there are multiple tests in a class,
    we CANNOT KNOW or CONTROL the order in which they will run when executed collectively.*/

    @Test
    public void testAutomationTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //go to testotomasyonu.com
        driver.get("https://testotomasyonu.com");

        //test if the title contains "Test Otomasyon"
        if (driver.getTitle().contains("Test Otomasyonu")){
            System.out.println("Title test PASSED");
        }else {
            System.out.println("Title test FAILED");
            System.out.println("Title: " + driver.getTitle() );
        }
        driver.quit();
    }
    @Test
    public void wisequarterTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //go to wisequarter.com
        driver.get("https://www.wisequarter.com");

        //test if the title contains "Wise"
        if (driver.getTitle().contains("Wise")){
            System.out.println("Wise title test PASSED");
        }else {
            System.out.println("Wise title test FAILED");
            System.out.println("Wise title: " + driver.getTitle() );
        }
        driver.quit();
    }
    @Test
    public void googleTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //go to google.com
        driver.get("https://google.com");

        //test if the url contains "google"
        if (driver.getCurrentUrl().contains("google")){
            System.out.println("url test PASSED");
        }else {
            System.out.println("url test FAILED");
            System.out.println("url: " + driver.getCurrentUrl() );
        }
        driver.quit();
    }


}
