package tests.day07_testBaseClass_Dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C04_dropDownMenu extends TestBase {
    // 1- Go to http://zero.webappsecurity.com/.
    // 2- Click on the Sign in button.
    // 3- Enter "username" in the Login box.
    // 4- Enter "password" in the Password box.
    // 5- Click the Sign in button, then go back to the page.
    // 6- Navigate to the Pay Bills page from the Online Banking menu.
    // 7- Click on the "Purchase Foreign Currency" button.
    // 8- Choose Eurozone from the "Currency" dropdown menu.
    // 9- Enter a number in the "amount" box.
    // 10-Test that "US Dollars" is not selected.
    // 11-Select the "Selected currency" button.
    // 12-Click on the "Calculate Costs" button, then click on the "purchase" button.
    // 13-Verify that the message "Foreign currency cash was successfully purchased." appears.

    @Test
    public void dropdownTest(){
        // 1- Go to http://zero.webappsecurity.com/.
        driver.get("http://zero.webappsecurity.com/");

        // 2- Click on the Sign in button.
        driver.findElement(By.id("signin_button")).click();

        // 3- Enter "username" in the Login box.
        driver.findElement(By.id("user_login")).sendKeys("username");


        // 4- Enter "password" in the Password box.
        driver.findElement(By.id("user_password")).sendKeys("password");

        // 5- Click the Sign in button, then go back to the page.
        driver.findElement(By.name("submit")).click();
        driver.navigate().back();

        // 6- Navigate to the Pay Bills page from the Online Banking menu.
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("pay_bills_link")).click();;

        // 7- Click on the "Purchase Foreign Currency" button.
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();

        // 8- Choose Eurozone from the "Currency" dropdown menu.
        WebElement currency = driver.findElement(By.id("pc_currency"));
        Select selectCurrency = new Select(currency);
        selectCurrency.selectByValue("EUR");

        // 9- Enter a number in the "amount" box.
        driver.findElement(By.id("pc_amount")).sendKeys("3");

        // 10-Test that "US Dollars" is not selected.
        WebElement usd = driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(usd.isSelected());

        // 11-Select the "Selected currency" button.
        driver.findElement(By.id("pc_inDollars_false")).click();

        // 12-Click on the "Calculate Costs" button, then click on the "purchase" button.
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();

        // 13-Verify that the message "Foreign currency cash was successfully purchased." appears.
        String expectedMessage = "Foreign currency cash was successfully purchased.";
        String actualMessage = driver.findElement(By.id("alert_content")).getText();

        Assert.assertEquals(expectedMessage,actualMessage);
    }
}

