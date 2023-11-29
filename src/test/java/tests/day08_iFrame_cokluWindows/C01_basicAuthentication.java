package tests.day08_iFrame_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_basicAuthentication extends TestBase {
    // 1- Go to https://testotomasyonu.com/basicauth
    // 2- Perform authentication using the following method and test data:
    //  -HTML command: https://username:password@URL
    //  -Username: membername
    //  -Password: sunflower
    // 3- Verify that access to the page is successful.
    @Test
    public void test01(){
        // 2- Perform authentication using the following method and test data:
        //  -HTML command: https://username:password@URL
        //  -Username: membername
        //  -Password: sunflower
        driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");

        // 3- Verify that access to the page is successful.
        WebElement successfulElement = driver.findElement(By.tagName("h3"));
        String expectedSuccesful = "Congratulations! You are logged in as: membername";
        String actualSuccessful = successfulElement.getText();
        Assert.assertEquals(expectedSuccesful, actualSuccessful);
    }
}
