package day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.testBase;

import static utilities.reusableMethods.changePageWithTitle;
import static utilities.reusableMethods.waitabit;

public class C02_actions extends testBase {
    // 2- Go to https://the-internet.herokuapp.com/context_menu
    // 3- Right-click on the designated area
    // 4- Test that the text in the alert is "You selected a context menu."
    // 5- Accept the alert by clicking "OK" to close it.
    // 6- Click on the Elemental Selenium link
    // 7- Test that the h1 tag on the opened page contains the text "Make sure your code lands."


    @Test
    public void test01() {
        // 2- Go to https://the-internet.herokuapp.com/context_menu
        driver.get("https://the-internet.herokuapp.com/context_menu");
        waitabit(1);
        // 3- Right-click on the designated area
        Actions actions = new Actions(driver);
        WebElement areaElement = driver.findElement(By.id("hot-spot"));
        actions.contextClick(areaElement).perform();

        // 4- Test that the text in the alert is "You selected a context menu"
        String expectedAlert = "You selected a context menu";
        String actualAlert = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlert,actualAlert);

        // 5- Accept the alert by clicking "OK" to close it.
        driver.switchTo().alert().accept();

        // 6- Click on the Elemental Selenium link
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        changePageWithTitle(driver,"Elemental Selenium | Elemental Selenium");
        // 7- Test that the h1 tag on the opened page contains the text "Make sure your code lands."
        String expectedH1 = "Make sure your code lands";
        String actualH1 = driver.findElement(By.xpath("//h1[@class='home-header']")).getText();
        Assert.assertEquals(expectedH1, actualH1);
    }
}