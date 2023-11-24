package day08_iFrame_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import utilities.testBase;

public class C04_controlledWindow extends testBase {
    // 1- Go to the Testotomasyonu homepage.
    // 2- Test that the URL contains 'testotomasyonu'.
    // 3- Open the 'Electronics' link in a new tab.
    // 4- Test that the opened page is the Electronics page.
    // 5- Click on the 'Men's Fashion' link to open it in a new window.
    // 6- Test that the Men's Fashion page is opened.
    // 7- Return to the initially opened page.
    // 8- Test that we are back on the Testotomasyonu homepage.

    @Test
    public void controlledWindowTest(){
        // 1- Go to the Testotomasyonu homepage.
        driver.get("https://testotomasyonu.com");

        // 2- Test that the URL contains 'testotomasyonu'.
        String expectedURL ="testotomasyonu";
        String actualURL= driver.getCurrentUrl();
        Assert.assertTrue(actualURL.contains(expectedURL));
        String mainWHD = driver.getWindowHandle();

        // 3- Open the 'Electronics' link in a new tab.
        driver.switchTo().newWindow(WindowType.TAB).get("https://testotomasyonu.com");
        driver.findElement(By.linkText("Electronics")).click();
        String electronicsWHD = driver.getWindowHandle();

        // 4- Test that the opened page is the Electronics page.
        String expectedTitle = "Electronics";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // 5- Click on the 'Men's Fashion' link to open it in a new window.
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.testotomasyonu.com");
        driver.findElement(By.xpath("(//a[text()='Men Fashion'])[3]")).click();
        String menFashionWHD = driver.getWindowHandle();

        /// 6- Test that the Men's Fashion page is opened.
        expectedTitle = "Men Fashion";
        actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // 7- Return to the initially opened page.
        driver.switchTo().window(mainWHD);

        // 8- Test that we are back on the Testotomasyonu homepage.
        String expectedUrl = "https://www.testotomasyonu.com/";
        actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualURL);
    }
}
