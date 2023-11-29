package tests.day10_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C07_FileUpload extends TestBase {
    // 1- Let's go to https://the-internet.herokuapp.com/upload
    // 2- Click on the chooseFile button
    // 3- Choose the file you want to upload.
    // 4- Click on the Upload button.
    // 5- Test whether the "File Uploaded!" text is displayed.

    @Test
    public void test(){

            /*
                In Selenium, we perform operations with the webdriver.
                The webdriver cannot access or use files on our computer directly.
                For file existence checks, we can use Java and perform operations using the file path.

                When uploading a file, when we click the chooseFile button,
                the file structure on our computer is displayed.
                Since we cannot perform operations with the webdriver on our computer's file structure,
                we send the file path to the chooseFile button using sendKeys().
            */

        // 1- Let's go to https://the-internet.herokuapp.com/upload
        driver.get("https://the-internet.herokuapp.com/upload");

        // 2- Click on the chooseFile button
        WebElement chooseFileButonu = driver.findElement(By.id("file-upload"));

        // 3- Choose the file you want to upload.
        /*
            For our tests to work on all team members' machines,
            we need to make the file path dynamic.
            In the previous test, we downloaded the logo.png to the downloads folder.
            Now let's upload it.
        */
        String dynamicFilePath = System.getProperty("user.home") +
                "/Downloads/eva-logo.png";
        chooseFileButonu.sendKeys(dynamicFilePath);

        // 4- Click on the Upload button.
        driver.findElement(By.id("file-submit")).click();

        // 5- Test whether the "File Uploaded!" text is displayed.
        WebElement uplodedElement = driver.findElement(By.tagName("h3"));
        String expected = "File Uploaded!";
        String actual = uplodedElement.getText();
        Assert.assertEquals(expected,actual);

    }
}
