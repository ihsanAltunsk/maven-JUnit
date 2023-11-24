package day08_iFrame_cokluWindows;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.testBase;

import java.util.List;

public class C03_iFrame extends testBase {
    // 1- Go to http://demo.guru99.com/test/guru99home/.
    // 2- Accept the cookies.
    // 3- Find the number of iframes on the page.
    // 4- Click on the play button in the first iframe (Youtube).
    // 5- Exit the first iframe and return to the homepage.
    @Test
    public void test01(){
        /// 1- Go to http://demo.guru99.com/test/guru99home/.
        driver.get("http://demo.guru99.com/test/guru99home/");

        // 2- Accept the cookies.
        WebElement cookiesIFrame = driver.findElement(By.xpath("(//iframe)[4]"));
        driver.switchTo().frame(cookiesIFrame);
        driver.findElement(By.xpath("//*[text()='Accept All']")).click();

        // 3- Find the number of iframes on the page.
        List<WebElement> iFrameList = driver.findElements(By.tagName("iframe"));
        System.out.println("Number of iFrame : " + iFrameList.size());

        // 4- Click on the play button in the first iframe (Youtube).
        WebElement playIFrame = driver.findElement(By.xpath("(//iframe)[4]"));
        driver.switchTo().frame(playIFrame);
        driver.findElement(By.xpath("//button[@title='Play']")).click();

        // 5- Exit the first iframe and return to the homepage.
        driver.switchTo().defaultContent();
    }
}
