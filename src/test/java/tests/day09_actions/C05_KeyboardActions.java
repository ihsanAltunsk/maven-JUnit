package tests.day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static utilities.ReusableMethods.waitabit;

public class C05_KeyboardActions extends TestBase {
    //2- Go to https://www.testotomasyonu.com
    //3- In the search box, use actions methods to type "DELL Core 13" and press Enter to perform the search
    //4- Test that the product name contains "DELL Core 13" in the search results.

    @Test
    public void test01(){
        //2- Go to https://www.testotomasyonu.com
        driver.get("https://www.testotomasyonu.com");
        waitabit(1);
        //3- In the search box, use actions methods to type "DELL Core 13" and press Enter to perform the search
        WebElement searchBox = driver.findElement(By.xpath("(//*[@id='global-search'])[1]"));
        Actions actions = new Actions(driver);
        actions.click(searchBox)
                .keyDown(Keys.SHIFT)
                .sendKeys("dell c")
                .keyUp(Keys.SHIFT)
                .sendKeys("ore ")
                .keyDown(Keys.SHIFT)
                .sendKeys("i")
                .keyUp(Keys.SHIFT)
                .sendKeys("3")
                .perform();

        //4- Test that the product name contains "DELL Core 13" in the search results.
        String expectedProductName = "DELL Core I3";
        String actualProductName = driver.findElement(By.xpath("//*[text()='DELL Core i3 11th Gen - (8 GB/256 GB SSD/32 GB E...']")).getText();
        System.out.println(actualProductName);
        Assert.assertTrue(actualProductName.contains(expectedProductName));

    }
}
