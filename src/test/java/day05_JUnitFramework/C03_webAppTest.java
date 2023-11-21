package day05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_webAppTest {
    // 1- Go to http://zero.webappsecurity.com.
    // 2- Click on the Sign-in button.
    // 3- Enter "username" in the login field.
    // 4- Enter "password" in the password field.
    // 5- Click on the Sign in button.
    // 6- Go back to the page using the Back button.
    // 7- Navigate to the Pay Bills page from the Online Banking menu.
    // 8- Enter any amount you want to deposit in the "amount" section.
    // 9- Enter "2023-09-10" in the date section.
    // 10- Click on the Pay button.
    // 11- Test that the message "The payment was successfully submitted." appears.

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- Go to http://zero.webappsecurity.com.
        driver.get("http://zero.webappsecurity.com");

        // 2- Click on the Sign-in button.
        driver.findElement(By.xpath("//button [@id='signin_button']")).click();

        // 3- Enter "username" in the login field.
        driver.findElement(By.xpath("//input [@id='user_login']")).sendKeys("username");

        // 4- Enter "password" in the password field.
        driver.findElement(By.xpath("//input [@id='user_password']")).sendKeys("password");

        // 5- Click on the Sign in button.
        driver.findElement(By.xpath("//input [@name='submit']")).click();

        // 6- Go back to the page using the Back button.
        driver.navigate().back();

        // 7- Navigate to the Pay Bills page from the Online Banking menu.
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("pay_bills_link")).click();

        // 8- Enter any amount you want to deposit in the "amount" section.
        driver.findElement(By.id("sp_amount")).sendKeys("1000");

        // 9- Enter "2023-09-10" in the date section.
        WebElement date = driver.findElement(By.id("sp_date"));
        date.sendKeys("2023-09-10");
        date.submit();

        // 10- Click on the Pay button.
        driver.findElement(By.xpath("//input [@class='btn btn-primary']")).click();

        // 11- Test that the message "The payment was successfully submitted." appears.
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
