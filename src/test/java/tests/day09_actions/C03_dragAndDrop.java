package tests.day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.testBase;

import static utilities.reusableMethods.waitabit;

public class C03_dragAndDrop extends testBase {
    // 1- Go to https://testotomasyonu.com/droppable
    // 2- In the "Accept" section, drag the "Acceptable" button and drop it onto the "Drop here" box
    // 3- Test that the text is now "Dropped!" instead of "Drop here"
    // 4- Refresh the page
    // 5- Drag the "Not Acceptable" button and drop it onto the "Drop here" box
    // 6- Test that the text "Drop here" has not changed

    @Test
    public void test01(){
        // 1- Go to https://testotomasyonu.com/droppable
        driver.get("https://testotomasyonu.com/droppable");
        waitabit(1);
        // 2- In the "Accept" section, drag the "Acceptable" button and drop it onto the "Drop here" box
        Actions actions = new Actions(driver);
        WebElement acceptableElement = driver.findElement(By.id("draggable2"));
        WebElement target1 = driver.findElement(By.id("droppable2"));
        actions.dragAndDrop(acceptableElement,target1).perform();

        // 3- Test that the text is now "Dropped!" instead of "Drop here"
        String expectedText = "Dropped!";
        String actualText = driver.findElement(By.id("droppable2")).getText();
        Assert.assertEquals(expectedText, actualText);

        // 4- Refresh the page
        driver.navigate().refresh();
        waitabit(1);

        // 5- Drag the "Not Acceptable" button and drop it onto the "Drop here" box
        WebElement notAcceptableElement = driver.findElement(By.id("draggable-nonvalid2"));
        WebElement target2 = driver.findElement(By.id("droppable2"));
        actions.dragAndDrop(notAcceptableElement, target2).perform();

        // 6- Test that the text "Drop Here" has not changed
        expectedText = "Drop Here";
        actualText = driver.findElement(By.id("droppable2")).getText();
        Assert.assertEquals(expectedText, actualText);
    }

}
