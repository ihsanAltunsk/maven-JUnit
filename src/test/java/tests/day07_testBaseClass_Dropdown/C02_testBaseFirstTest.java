package tests.day07_testBaseClass_Dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_testBaseFirstTest extends TestBase {

    @Test
    public void test01(){
        driver.get("https://www.testotomasyonu.com");

        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys("phone" + Keys.ENTER);

        WebElement searchResult = driver.findElement(By.className("product-count-text"));
        String searchResultStr = searchResult.getText().replaceAll("\\D","");
        int numberOfResult = Integer.parseInt(searchResultStr);

        Assert.assertTrue(numberOfResult > 0);
    }
}
