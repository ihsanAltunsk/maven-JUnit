package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {
    //Create the necessary structure and complete the following task:
    //a. Go to the given web page https://testotomasyonu.com/form
    //b. Locate the Gender Radio button elements and select the appropriate one.
    //c. Test that the radio button you selected is selected, and the others are not selected.

    static WebDriver driver;
@BeforeClass
public static void setup(){
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
