package tests.day08_iFrame_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import utilities.testBase;

public class C04_controlledWindow extends testBase {
    // 1- Go to the Testotomasyonu homepage.
    // 2- Test that the URL contains 'testotomasyonu'.
    // 3- Open the 'Electronics' link in a new tab.
    // 4- Test that the opened page is the Electronics page.
    // 5- Click on the 'Men's Fashion' link to open it in a new window.
    // 6- Test that the Men's Fashion page is opened.
    // 7- Return to the initially opened page.
    // 8- Test that we are back on the Testotomasyonu homepage.

    @Test
    public void controlledWindowTest(){
        // Testotomasyonu anasayfaya gidin

        driver.get("https://www.testotomasyonu.com");
        // url'in testotomasyonu icerdigini test edin

        String expectedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));
        String anasayfaWHD = driver.getWindowHandle();
        // yeni bir tab olarak elctronics linkini acin

        driver.switchTo().newWindow(WindowType.TAB).get("https://www.testotomasyonu.com");
        driver.findElement(By.xpath("(//a[text()='Electronics'])[3]")).click();
        String electronicsWHD = driver.getWindowHandle();

        // acilan sayfanin electronics sayfasi oldugunu test edin
        // Title'da Electronics oldugunu test edelim
        String expectedTitleIcerik = "Electronics";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));
        // yeni bir window'da acilacak sekilde menfashion linkini tiklayin

        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.testotomasyonu.com");
        driver.findElement(By.xpath("(//a[text()='Men Fashion'])[3]")).click();
        String menFashionWHD = driver.getWindowHandle();

        // menfashion sayfasinin acildigini test edin
        expectedTitleIcerik = "Men Fashion";
        actualTitle = driver.getTitle();

        Assert.assertFalse(actualTitle.contains(expectedTitleIcerik));
        // ilk actigimiz sayfaya donun
        driver.switchTo().window(anasayfaWHD);

        // EGER bir test'de acilan windowlar farkli tab veya window'larda aciliyorsa
        // ve testimizde bu sayfalar arasinda gecis isteniyorsa
        // gectigimiz her sayfanin WindowHandleDegerini kaydetmeliyiz

        // test otomasyon anasayfada oldugumuzu test edin
        // url ile test edelim https://testotomasyonu.com/

        String expectedUrl = "https://www.testotomasyonu.com/";
        actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);

        // tekrar electronics acik olan tab'a gecin
        driver.switchTo().window(electronicsWHD);
        // electronics bolumunde oldugunuzu test edin

        expectedTitleIcerik = "Electronics";
        actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));

        // tekrar men fashion acik olan tab'a gecin
        driver.switchTo().window(menFashionWHD);


        // men fashion bolumunde oldugunuzu test edin
        expectedTitleIcerik = "Men Fashion";
        actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));


    }
}
