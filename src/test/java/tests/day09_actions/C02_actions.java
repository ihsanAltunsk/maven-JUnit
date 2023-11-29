package tests.day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.testBase;

import static utilities.reusableMethods.changePageWithTitle;
import static utilities.reusableMethods.waitabit;

public class C02_actions extends testBase {
    // 1- Go to https://the-internet.herokuapp.com/context_menu
    // 2- Right-click on the designated area
    // 3- Test that the text in the alert is "You selected a context menu."
    // 4- Accept the alert by clicking "OK" to close it.
    // 5- Click on the Elemental Selenium link
    // 6- Test that the h1 tag on the opened page contains the text "Make sure your code lands."


    @Test
    public void test01() {
        // 1- Go to https://the-internet.herokuapp.com/context_menu
        driver.get("https://the-internet.herokuapp.com/context_menu");
        waitabit(1);
        // 2- Right-click on the designated area
        Actions actions = new Actions(driver);
        WebElement areaElement = driver.findElement(By.id("hot-spot"));
        actions.contextClick(areaElement).perform();

        // 3- Test that the text in the alert is "You selected a context menu"
        String expectedAlert = "You selected a context menu";
        String actualAlert = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlert,actualAlert);

        // 4- Accept the alert by clicking "OK" to close it.
        driver.switchTo().alert().accept();

        // 5- Click on the Elemental Selenium link
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        changePageWithTitle(driver,"Elemental Selenium | Elemental Selenium");
        // 6- Test that the h1 tag on the opened page contains the text "Make sure your code lands."
        String expectedH1 = "Make sure your code lands";
        String actualH1 = driver.findElement(By.xpath("//h1[@class='home-header']")).getText();
        Assert.assertEquals(expectedH1, actualH1);
    }
}