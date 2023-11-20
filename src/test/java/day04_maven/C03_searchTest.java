package day04_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_searchTest {

    // 1- Let's go to the homepage of testotomasyonu.com.
    // 2- Let's locate the search box.
    // 3- Let's perform a search with "phone".
    // 4- Let's print the number of search results.
    // 5- Let's click on the first product.
    // 6- Test if the product is in stock.

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- Let's go to the homepage of testotomasyonu.com.
        driver.navigate().to("https://testotomasyonu.com");

        // 2- Let's locate the search box.
        WebElement searchBox = driver.findElement(By.id("global-search"));

        // 3- Let's perform a search with "phone".
        searchBox.sendKeys("phone");
        searchBox.submit();

        // 4- Let's print the number of search results.
        System.out.println(driver.findElement(By.className("product-count-text")).getText());

        // 5- Let's click on the first product.
        driver.findElement(By.xpath("(//div[@class=‘product-box my-2  py-1’])[1]")).click();

        // 6- Test if the product is in stock.
        WebElement actualStock = driver.findElement(By.xpath("(//span[@class=‘heading-xs ’])[1]"));
        System.out.println(actualStock.getText());
        String expectedStock ="In Stock";
        if (actualStock.equals(expectedStock)){
            System.out.println("Stock avaible.");
        }else{
            System.out.println("Stock NOT avaible");
        }
    }
}
