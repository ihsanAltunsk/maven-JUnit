package tests.day08_iFrame_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.testBase;

public class C02_iFrame extends testBase {
    // 1- Go to https://the-internet.herokuapp.com/iframe.
    // 2- Create a method: iframeTest
    // 3- Test if the text "An IFrame containing…." is accessible and print it to the console.
    // 4- Enter "Hello World!" into the Text Box.
    // 5- Verify that the text "Elemental Selenium" link below the TextBox is visible and print it to the console.

    @Test
    public void iframeTest(){
        // 1- Go to https://the-internet.herokuapp.com/iframe.
        driver.get("https://the-internet.herokuapp.com/iframe");

        // 3- Test if the text "An IFrame containing…." is accessible and print it to the console.
        WebElement anIframeElement = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(anIframeElement.isEnabled());
        System.out.println(anIframeElement.getText());

        // 4- Enter "Hello World!" into the Text Box.
        WebElement iFrameElement = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iFrameElement);
        WebElement textBox = driver.findElement(By.tagName("p"));
        textBox.clear();
        textBox.sendKeys("Hello World!");

        // 5- Verify that the text "Elemental Selenium" link below the TextBox is visible and print it to the console.
        // driver.switchTo().defaultContent();
        driver.switchTo().parentFrame();
        WebElement elementalSeleniumElementi = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elementalSeleniumElementi.isDisplayed());
        System.out.println(elementalSeleniumElementi.getText());

    }
}
