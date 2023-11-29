package day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.testBase;

public class C01_actions extends testBase {
    //1- Go to https://testotomasyonu.com/click
    //2- Right-click on "DGI Drones"
    //3- Test that the text in the alert is "Congratulations!... You performed a right click."
    //4- Accept the alert by clicking "OK" to close it.

    @Test
    public void test01() throws InterruptedException {
        //1- Go to https://testotomasyonu.com/click
        driver.get("https://testotomasyonu.com/click");
        Thread.sleep(1000);
        //2- Right-click on "DGI Drones"
        Actions actions = new Actions(driver);
        WebElement thumbElement = driver.findElement(By.id("pic2_thumb"));
        actions.contextClick(thumbElement).perform();

        //3- Test that the text in the alert is "Tebrikler!... Sağ click yaptınız."
        String expectedAlert = "Tebrikler!... Sağ click yaptınız.";
        String actualAlert = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlert,actualAlert);

        //4- Accept the alert by clicking "OK" to close it.
        driver.switchTo().alert().accept();
    }
}
