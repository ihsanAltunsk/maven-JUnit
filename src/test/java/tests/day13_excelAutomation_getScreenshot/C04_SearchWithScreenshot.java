package tests.day13_excelAutomation_getScreenshot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_SearchWithScreenshot extends TestBase {
    // Go to the homepage of the test automation.
    // Search for "dress."
    // Test that a product is found in the search results.
    // Capture and save a screenshot of the entire page.
    @Test
    public void test(){
        // Go to the homepage of the test automation.
        driver.get("https://www.testotomasyonu.com");

        // Search for "dress."
        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys("dress" + Keys.ENTER);

        // Test that a product is found in the search results.
        WebElement resultElement = driver.findElement(By.className("product-count-text"));
        String unexpectedResult = "0 Products Found";
        String actualResult = resultElement.getText();
        Assert.assertNotEquals(unexpectedResult, actualResult);
        ReusableMethods.waitabit(1);

        // Capture and save a screenshot of the entire page.
        ReusableMethods.getScreenshot(driver);

    }
}
