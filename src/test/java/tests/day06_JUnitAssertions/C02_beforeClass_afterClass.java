package tests.day06_JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.AssertionFailedError;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_beforeClass_afterClass {
    // Complete the given tasks by creating 3 different test methods:
    // 1 - Go to the testotomasyonu.com page.
    //   - Test that the URL contains 'testotomasyonu'.
    // 2 - Perform a search for 'phone'.
    //   - Test that products are found in the search results.
    // 3 - Click on the first product
    //   - Test that 'phone' is mentioned in the product description case-insensitively.

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("'before' worked");
    }

    @AfterClass
    public static void teardown(){
        System.out.println("'after' worked");
        driver.quit();
    }


    @Test
    public void test01(){
        // 1 - Go to the testotomasyonu.com page.
        driver.get("https://www.testotomasyonu.com");

        // - Test that the URL contains 'testotomasyonu'.
        String expectedUrl = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)){
            System.out.println("Url test PASSED");
        }else{
            System.out.println("Url test FAILED");
            throw new AssertionFailedError();
        }
    }

    @Test
    public void test02(){
        // 2 - Perform a search for 'phone'.
        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys("phone" + Keys.ENTER);

        // - Test that products are found in the search results.
        WebElement searchElement = driver.findElement(By.className("product-count-text"));

        String numberOfResultsStr = searchElement.getText().replaceAll("\\D","");
        int numberOfResults = Integer.parseInt(numberOfResultsStr);

        if (numberOfResults >0){
            System.out.println("Search test PASSED");
        }else{
            System.out.println("Search test FAILED");
            throw new AssertionFailedError();
        }
    }

    @Test
    public void test03(){
        // 3 - Click on the first product
        driver.findElement(By.xpath("(//*[@class='product-box my-2  py-1'])[1]")).click();

        // - Test that 'phone' is mentioned in the product description case-insensitively.
        WebElement contentElement = driver.findElement(By.xpath("//*[@*='product-short-desc  my-2']"));

        String expectedContent = "phone";
        String productDesc = contentElement.getText().toLowerCase();

        if (productDesc.contains(expectedContent)){
            System.out.println("Product test PASSED");
        }else {
            System.out.println("Product test FAILED");
            throw new AssertionFailedError();
        }

    }
}
