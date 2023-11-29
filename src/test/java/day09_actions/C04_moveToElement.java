package day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.testBase;

import static utilities.reusableMethods.waitabit;

public class C04_moveToElement extends testBase {
    // 1- Go to https://www.testotomasyonu.com/
    // 2- Hover the mouse over the "Kids Wear" menu to open it
    // 3- Click on the "Boys" link
    // 4- Click on the first product on the opened page
    // 5- Test that the product name on the opened page is "Boys Shirt White Color"


    @Test
    public void test01(){
        // 1- Go to https://www.testotomasyonu.com/
        driver.get("https://www.testotomasyonu.com/");
        waitabit(1);
        // 2- Hover the mouse over the "Kids Wear" menu to open it
        Actions actions = new Actions(driver);
        WebElement kidsWearElement = driver.findElement(By.xpath("(//*[@class='has-sub'])[7]"));
        actions.moveToElement(kidsWearElement).perform();

        // 3- Click on the "Boys" link
        driver.findElement(By.xpath("//a[text()='Boys']")).click();

        // 4- Click on the first product on the opened page
        driver.findElement(By.className("prod-img")).click();

        // 5- Test that the product name on the opened page is "Boys Shirt White Color"
        String expectedName = "Boys Shirt White Color";
        String actualName = driver.findElement(By.xpath("//*[text()='Boys Shirt White Color']")).getText();
        Assert.assertEquals(expectedName, actualName);
    }
}
