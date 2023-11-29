package tests.day05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_googleSearchTest {
    // 1- Go to https://www.google.com/.
    // 2- Accept and close the cookies notification.
    // 3- Test that the page title contains the expression "Google".
    // 4- Type "Nutella" into the search bar and perform the search.
    // 5- Print the number of search results.
    // 6- Test that the number of results is more than 10 million.
    // 7- Close the page.

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- Go to https://www.google.com/.
        driver.get("https://www.google.com/");

        // 2- Accept and close the cookies notification.
        //no cookies

        // 3- Test that the page title contains the expression "Google".
        if(driver.getTitle().contains("Google")){
            System.out.println("Title test PASSED");
        }else{
            System.out.println("Title test FAILED");
            System.out.println("Title: " + driver.getTitle());
        }

        // 4- Type "Nutella" into the search bar and perform the search.
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        // 5- Print the number of search results.
        String numberOfResults = driver.findElement(By.id("result-stats")).getText();
        String[] result = numberOfResults.split(" ");

        String numberOfResultsStr = result[1];
        numberOfResultsStr = numberOfResultsStr.replaceAll("\\D","");

        int numberOfResultsInt = Integer.parseInt(numberOfResultsStr);

        // 6- Test that the number of results is more than 10 million.
        if (numberOfResultsInt > 10000000) {
            System.out.println("Number of result test PASSED");
        }else{
            System.out.println("Number of result test FAILED");
            System.out.println("Number of result: " + numberOfResultsInt);
        }

        // 7- Close the page.
        driver.quit();
    }
}
