package tests.day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.testBase;

import static utilities.reusableMethods.waitabit;

public class C06_CreatingAUser extends testBase {
    // 1- Go to https://www.testotomasyonu.com
    // 2- Click on the "Account" link
    // 3- Click on the "Sign Up" link
    // 4- Enter values in the name, surname, email, and password boxes, and click the "Sign Up" button
    // 5- Test that the registration is successfully created.

    @Test
    public void test01(){
        // 1- Go to https://www.testotomasyonu.com
        driver.get("https://www.testotomasyonu.com");

        // 2- Click on the "Account" link
        driver.findElement(By.className("cart-bar")).click();

        // 3- Click on the "Sign Up" link
        driver.findElement(By.xpath("//*[text()=' Sign Up']")).click();
        waitabit(1);
        // 4- Enter values in the name, surname, email, and password boxes, and click the "Sign Up" button
        WebElement fistNameKutusu = driver.findElement(By.xpath("//*[@id='firstName']"));
        Actions actions = new Actions(driver);
        actions.click(fistNameKutusu)
                .sendKeys("İhsan")
                .sendKeys(Keys.TAB)
                .sendKeys("Altunışık")
                .sendKeys(Keys.TAB)
                .sendKeys("altnskihsan@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("hard2find")
                .sendKeys(Keys.TAB)
                .sendKeys("hard2find")
                .perform();
        driver.findElement(By.id("btn-submit-form")).click();

        // 5- Test that the registration is successfully created.
        driver.findElement(By.id("email")).sendKeys("altnskihsan@gmail.com");
        driver.findElement(By.id("password")).sendKeys("hard2find");
        driver.findElement(By.id("submitlogin")).click();
        WebElement logoutLink = driver.findElement(By.xpath("//span[text()='Logout']"));
        Assert.assertTrue(logoutLink.isDisplayed());
        logoutLink.click();

    }
}
