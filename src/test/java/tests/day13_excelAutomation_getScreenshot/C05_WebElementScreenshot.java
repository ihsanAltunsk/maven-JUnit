package tests.day13_excelAutomation_getScreenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C05_WebElementScreenshot extends TestBase {
    // Go to the homepage of the test automation.
    // Search for "dress."
    // Test that a product is found in the search results.
    // Capture and save a screenshot of search result text.

    @Test
    public void test() throws IOException {
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

        // Capture and save a screenshot of search result text.
        // Step 1: Locate the WebElement from which we will take the screenshot.
        // Step 2: Create the file where we will save the screenshot.
        File wantedWebElement = new File("target/Screenshots/wantedWebElement.jpg");

        // Step 3: Capture a screenshot from the WebElement and save it to a temporary file.
        File temporaryFile = resultElement.getScreenshotAs(OutputType.FILE);

        // Step 4: Copy the temporary file to the actual file.
        FileUtils.copyFile(temporaryFile,wantedWebElement);

    }
}
