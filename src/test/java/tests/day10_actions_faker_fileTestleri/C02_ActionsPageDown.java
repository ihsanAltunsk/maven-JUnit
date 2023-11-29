package tests.day10_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.testBase;

import static utilities.reusableMethods.waitabit;

public class C02_ActionsPageDown extends testBase {
    // 1- Go to https://html.com/tags/iframe/
    // 2- Scroll down enough to see the video
    // 3- Press the Play button to watch the video
    // 4- Test that you have successfully started playing the video.

    @Test
    public void test(){
        // 1- Go to https://html.com/tags/iframe/
        driver.get("https://html.com/tags/iframe/");

        // 2- Scroll down enough to see the video
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        waitabit(4);

        // 3- Press the Play button to watch the video
        WebElement iframeElement = driver.findElement(By.xpath("//iframe[1]"));
        driver.switchTo().frame(iframeElement);
        driver.findElement(By.xpath("//button[@title='Play']")).click();
        waitabit(1);

        // 4- Test that you have successfully started playing the video.
        WebElement startElement = driver.findElement(By.xpath("//*[@*='ytp-play-button ytp-button']"));
        Assert.assertTrue(startElement.isDisplayed());

    }
}
