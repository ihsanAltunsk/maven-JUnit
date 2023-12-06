package tests.day13_excelAutomation_getScreenshot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C07_ScroolIntoView extends TestBase {

    @Test
    public void test(){
        // Go to the test automation's homepage
        driver.get("https://www.testotomasyonu.com");
        ReusableMethods.waitabit(1);

        // Scroll down until the "Best Sport Shoes" section is visible

        /*

            Although this method allows scrolling down,
            it should be customized for each computer
            because screen resolution may vary from one computer to another

            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).perform();

        */

        WebElement bestSportShoesElement = driver.findElement(By.xpath("(//p[@class='blog-heading'])[2]"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", bestSportShoesElement);

        // Click the link
        ReusableMethods.waitabit(2);
        bestSportShoesElement.click();

        // javascriptExecutor.executeScript("arguments[0].click();", bestSportShoesElement);

        // Test if "Best Sport Shoes For Multi Gender" is written in the h1 tag
        String expected = "Best Sport Shoes For Multi Gender";
        String actual = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expected,actual);

        javascriptExecutor.executeScript("alert('HEEEYYYYY');");

        ReusableMethods.waitabit(5);


    }
}
