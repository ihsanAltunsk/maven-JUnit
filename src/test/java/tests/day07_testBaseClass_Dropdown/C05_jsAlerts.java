package tests.day07_testBaseClass_Dropdown;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.testBase;

public class C05_jsAlerts extends testBase {
    // Test - 1
    // 1- Go to https://testotomasyonu.com/javascriptAlert
    // 2- Click on the first alert
    // 3- Test that the text in the alert is "I am a JS Alert"
    // 4- Click OK to close the alert
    // Test - 2
    // 1- Go to https://testotomasyonu.com/javascriptAlert
    // 2- Click on the second alert
    // 3- Click Cancel and test that the result message is "You clicked: Cancel"
    // Test - 3
    // 1- Go to https://testotomasyonu.com/javascriptAlert
    // 2- Click on the third alert
    // 3- Enter "Abdullah" in the prompt
    // 4- Click OK to close the alert
    // 5- Test that the result message contains "Abdullah"


    @Test
    public void test01(){
        // 1- Go to https://testotomasyonu.com/javascriptAlert
        driver.get("https://testotomasyonu.com/javascriptAlert");

        // 2- Click on the first alert
        driver.findElement(By.className("j-button")).click();

        // 3- Test that the text in the alert is "I am a JS Alert"
        String expectedText = "I am a JS Alert";
        String actualText = driver.switchTo().alert().getText();

        Assert.assertEquals(expectedText,actualText);

        // 4- Click OK to close the alert
        driver.switchTo().alert().accept();
    }
    @Test
    public void test02(){
        // 1- Go to https://testotomasyonu.com/javascriptAlert
        driver.get("https://testotomasyonu.com/javascriptAlert");

        // 2- Click on the second alert
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();

        // 3- Click Cancel and test that the result message is "You clicked: Cancel"
        driver.switchTo().alert().dismiss();
        String actualMessage = driver.findElement(By.id("result")).getText();
        String expectedMessage = "You clicked: Cancel";

        Assert.assertEquals(expectedMessage,actualMessage);

    }
    @Test
    public void test03(){
        // 1- Go to https://testotomasyonu.com/javascriptAlert
        driver.get("https://testotomasyonu.com/javascriptAlert");

        // 2- Click on the third alert
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

        // 3- Enter "Abdullah" in the prompt
        driver.switchTo().alert().sendKeys("Abdullah");

        // 4- Click OK to close the alert
        driver.switchTo().alert().accept();

        // 5- Test that the result message contains "Abdullah"
        String actualMessage = driver.findElement(By.id("result")).getText();

        Assert.assertTrue(actualMessage.contains("Abdullah"));
    }

}
