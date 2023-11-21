package day_06JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.AssertionFailedError;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_beforeAfterAnnotation {
    // 3 different test methods are created to perform the following tests:
    // 1- Go to the testotomasyonu.com site.
    // 2- Perform searches for phone, shoes, and dress.
    // 3- Test that products are found in the search results.
    // 4- Close the page.

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test1(){
        // 1- Go to the testotomasyonu.com site.
        driver.get("https://testotomasyonu.com");

        // 2- Perform search for phone.
        driver.findElement(By.id("global-search")).sendKeys("phone" + Keys.ENTER);

        // 3- Test that products are found in the search results.
        WebElement searchElements = driver.findElement(By.className("product-count-text"));
        String numberOfSearchStr= searchElements.getText().replaceAll("\\D","");
        int numberOfSearch = Integer.parseInt(numberOfSearchStr);
        if (numberOfSearch >90){
            System.out.println("Phone test PASSED");
        }else{
            System.out.println("Phone test FAILED");
            throw new AssertionFailedError();
        }
    }

    @Test
    public void test2(){
        // 1- Go to the testotomasyonu.com site.
        driver.get("https://testotomasyonu.com");

        // 2- Perform search for shoes.
        driver.findElement(By.id("global-search")).sendKeys("shoes" + Keys.ENTER);

        // 3- Test that products are found in the search results.
        WebElement searchElements = driver.findElement(By.className("product-count-text"));
        String numberOfSearchStr= searchElements.getText().replaceAll("\\D","");
        int numberOfSearch = Integer.parseInt(numberOfSearchStr);
        if (numberOfSearch >0){
            System.out.println("Phone test PASSED");
        }else{
            System.out.println("Phone test FAILED");
            throw new AssertionFailedError();
        }
    }

    @Test
    public void test3(){
        // 1- Go to the testotomasyonu.com site.
        driver.get("https://testotomasyonu.com");

        // 2- Perform search for dress.
        driver.findElement(By.id("global-search")).sendKeys("dress" + Keys.ENTER);

        // 3- Test that products are found in the search results.
        WebElement searchElements = driver.findElement(By.className("product-count-text"));
        String numberOfSearchStr= searchElements.getText().replaceAll("\\D","");
        int numberOfSearch = Integer.parseInt(numberOfSearchStr);
        if (numberOfSearch >0){
            System.out.println("Phone test PASSED");
        }else{
            System.out.println("Phone test FAILED");
            throw new AssertionFailedError();
        }
    }
}
