package day08_iFrame_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.testBase;

import java.util.Set;

public class C05_uncontrolledWindow extends testBase {
    // 1- Go to https://testotomasyonu.com/addremove/.
    // 2- Verify that the text on the page is "Add/Remove Elements".
    // 3- Verify that the page title is "Test Otomasyonu".
    // 4- Click on the 'Please click for Electronics Products' link.
    // 5- Test that the Electronics page is opened.
    // 6- Test that the number of found products is 16.
    // 7- Return to the initially opened addremove page.
    // 8- Test that the URL contains 'addremove'.

    @Test
    public void test01(){

        // 1- Go to https://testotomasyonu.com/addremove/.
        driver.get("https://testotomasyonu.com/addremove/");

        // 2- Verify that the text on the page is "Add/Remove Elements".
        WebElement textElement = driver.findElement(By.tagName("h2"));
        String expectedText = "Add/Remove Elements";
        String actualText = textElement.getText();
        Assert.assertEquals(expectedText, actualText);

        // 3- Verify that the page title is "Test Otomasyonu".
        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        // 4- Click on the 'Please click for Electronics Products' link.
        driver.findElement(By.linkText("Electronics Products")).click();


        String firstWHD = driver.getWindowHandle();
        Set<String> wHDSet = driver.getWindowHandles();
        String secondWhd ="";
        for (String each : wHDSet) {
            if (!each.equals(firstWHD)){
                secondWhd = each;
            }
        }
        driver.switchTo().window(secondWhd);

        // 5- Test that the Electronics page is opened.
        String expectedTitleIcerik = "Electronics";
        actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));

        // 6- Test that the number of found products is 16.
        WebElement resultElement = driver.findElement(By.className("product-count-text"));
        String numberOfResultsStr = resultElement.getText().replaceAll("\\D","");
        int actualNumberOfResult = Integer.parseInt(numberOfResultsStr);
        int expectedNumberOfResult = 16;
        Assert.assertEquals(expectedNumberOfResult, actualNumberOfResult);

        // 7- Return to the initially opened addremove page.
        driver.switchTo().window(firstWHD);

        // 8- Test that the URL contains 'addremove'.
        String expectedUrl = "addremove";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }
}
