package tests.day13_excelAutomation_getScreenshot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C06_WebElementScreenshotTest extends TestBase {
    // 1- Go to the test automation's homepage.
    // 2- Perform a search for "shoes."
    // 3- Click on the first product from the search results.
    // 4- On the opened product page, test if the term "shoe" is present in the product name without case sensitivity.
    // 5- Capture and save the screenshot of the product name element.

    @Test
    public void test(){
        // 1- Go to the test automation's homepage.
        driver.get("https://www.testotomasyonu.com");

        // 2- Perform a search for "shoes."
        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys("shoes" + Keys.ENTER);

        // 3- Click on the first product from the search results.
        driver.findElement(By.xpath("(//div[@class='product-box my-2  py-1'])[1]"))
                .click();

        // 4- On the opened product page, test if the term "shoe" is present in the product name without case sensitivity.
        WebElement productNameElement = driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']"));
        String expectedName = "shoe";
        String actualNameLowerCase = productNameElement.getText().toLowerCase();
        Assert.assertTrue(actualNameLowerCase.contains(expectedName));
        ReusableMethods.waitabit(1);

        // 5- Capture and save the screenshot of the product name element.
        ReusableMethods.wantedWebElementScreenshot(productNameElement);
    }
}
