package day04_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_webAppTest {
    //Go to http://zero.webappsecurity.com.
    //Click on the Sign-in button.
    //Enter "username" in the login field.
    //Enter "password" in the password field.
    //Click on the Sign in button.
    //Go back to the page using the Back button.
    //Navigate to the Pay Bills page from the Online Banking menu.
    //Enter any amount you want to deposit in the "amount" section.
    //Enter "2023-09-10" in the date section.
    //Click on the Pay button.
    //Test that the message "The payment was successfully submitted." appears.

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Go to http://zero.webappsecurity.com.
        driver.get("http://zero.webappsecurity.com");

        //Click on the Sign-in button.
        driver.findElement(By.xpath("//button [@id='signin_button']")).click();

        //Enter "username" in the login field.
        driver.findElement(By.xpath("//input [@id='user_login']")).sendKeys("username");

        //Enter "password" in the password field.
        driver.findElement(By.xpath("//input [@id='user_password']")).sendKeys("password");

        //Click on the Sign in button.
        driver.findElement(By.xpath("//input [@name='submit']")).click();

        //Go back to the page using the Back button.
        driver.navigate().back();

        //Navigate to the Pay Bills page from the Online Banking menu.
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("pay_bills_link")).click();

        //Enter any amount you want to deposit in the "amount" section.
        driver.findElement(By.id("sp_amount")).sendKeys("1000");

        //Enter "2023-09-10" in the date section.
        WebElement date = driver.findElement(By.id("sp_date"));
        date.sendKeys("2023-09-10");
        date.submit();

        //Click on the Pay button.
        driver.findElement(By.xpath("//input [@class='btn btn-primary']")).click();

        //Test that the message "The payment was successfully submitted." appears.
        String actualMessage = driver.findElement(By.id("alert_content")).getText();
        String expectedMessage ="The payment was successfully submitted.";

        if (actualMessage.contains(expectedMessage)){
            System.out.println("Message test PASSED");
        }else{
            System.out.println("Message test FAILED");
            System.out.println("Message: " + actualMessage);
        }
        driver.quit();

    }

}
