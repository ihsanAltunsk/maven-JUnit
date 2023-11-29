package tests.day10_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.testBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_filesExistsTest extends testBase {
    // 1. Go to https://the-internet.herokuapp.com/download
    // 2. Download the Logo.png file
    // 3. Test whether the file has been successfully downloaded or not.

    @Test
    public void test(){
        // 1. Go to https://the-internet.herokuapp.com/download
        driver.get("https://the-internet.herokuapp.com/download");

        // 2. Download the eva-logo.png file
        driver.findElement(By.xpath("//*[text()='eva-logo.png']")).click();

        // 3. Test whether the file has been successfully downloaded or not.
        String filePath = "C:/Users/user/Downloads/eva-logo.png";
        Assert.assertTrue(Files.exists(Paths.get(filePath)));

    }
}
