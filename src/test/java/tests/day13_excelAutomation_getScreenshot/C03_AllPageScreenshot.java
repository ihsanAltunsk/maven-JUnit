package tests.day13_excelAutomation_getScreenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_AllPageScreenshot extends TestBase {
    // Go to the homepage of the test automation.
    // Search for Nutella.
    // Test that no product is found in the search results.
    // Capture and save a screenshot of the entire page.
    // Step 1: Create a TakesScreenshot (tss) object.
    // Step 2: Create a File with the file path where we will save the photo.
    // Step 3: Use the tss object to take a photo and save it to a temporary file.
    // Step 4: Copy the temporary file to the actual file.


    @Test
    public void test() throws IOException {
        // Go to the homepage of the test automation.
        driver.get("https://www.testotomasyonu.com");

        // Search for Nutella.
        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        // Test that no product is found in the search results.
        WebElement resultElement = driver.findElement(By.className("product-count-text"));
        String expectedResult = "0 Products Found";
        String actualResult = resultElement.getText();
        Assert.assertEquals(expectedResult, actualResult);
        ReusableMethods.waitabit(1);

        // Capture and save a screenshot of the entire page.
        // Step 1: Create a TakesScreenshot (tss) object.
        TakesScreenshot tss = (TakesScreenshot) driver;

        // Step 2: Create a File with the file path where we will save the photo.
        File AllPageScreenshot = new File("target/Screenshots/AllPageScreenshots.jpg");

        // Step 3: Use the tss object to take a photo and save it to a temporary file.
        File temporaryFile = tss.getScreenshotAs(OutputType.FILE);

        // Step 4: Copy the temporary file to the actual file.
        FileUtils.copyFile(temporaryFile,AllPageScreenshot);

    }
}
