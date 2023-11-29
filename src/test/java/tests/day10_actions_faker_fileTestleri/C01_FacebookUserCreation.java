package tests.day10_actions_faker_fileTestleri;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_FacebookUserCreation extends TestBase {
    // 1- Go to https://www.facebook.com
    // 2- Accept cookies
    // 3- Click on the "Create New Account" button
    // 4- Enter values in the name, surname, email, and password boxes, and click the "Sign Up" button
    // 5- Click the "Sign Up" button again.

    @Test
    public void test01(){
        // 1- Go to https://www.facebook.com
        driver.get("https://www.facebook.com");

        // 2- Accept cookies
        //no cookies

        // 3- Click on the "Create New Account" button
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

        // 4- Enter values in the name, surname, email, and password boxes, and click the "Sign Up" button
        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        WebElement nameElement =driver.findElement(By.xpath("//*[@name='firstname']"));
        actions.click(nameElement)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("1")
                .sendKeys(Keys.TAB)
                .sendKeys("January")
                .sendKeys(Keys.TAB)
                .sendKeys("1999")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .perform();

        // 5- Click the "Sign Up" button again.
        driver.findElement(By.name("websubmit")).click();

    }
}
