package tests.day11_waits_cookies_webTables;

import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C03_Cookies extends TestBase {
    // 1- Go to the Amazon homepage.
    // 2- List all cookies on the page.
    // 3- Test that the number of cookies on the page is greater than 5.
    // 4- Test that the value of the cookie named "i18n-prefs" is USD.
    // 5- Create a cookie with the name "en sevdigim cookie" and the value "cikolatali," then add it to the page.
    // 6- Test that the added cookie is present on the page.
    // 7- Delete the cookie named "skin" and test that it has been deleted.
    // 8- Delete all cookies and test that they have been deleted.

    @Test
    public void test(){
        // 1- Go to the Amazon homepage.
        driver.get("https://www.amazon.com.tr");

        // 2- List all cookies on the page.
        Set<Cookie> cookiesSet = driver.manage().getCookies();

        // 3- Test that the number of cookies on the page is greater than 1.
        int expectedMinCookie = 1;
        int actualCookie =cookiesSet.size();
        Assert.assertTrue(actualCookie>expectedMinCookie);
        
        // 4- Test that the value of the cookie named "i18n-prefs" is TRY.
        String expectedCookieValue = "TRY";
        String actualCookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertEquals(expectedCookieValue, actualCookieValue);

        // 5- Create a cookie with the name "en sevdigim cookie" and the value "cikolatali," then add it to the page.
        Cookie newCookie = new Cookie("en sevdigim cookie" ,"cikolatali");
        driver.manage().addCookie(newCookie);

        // 6- Test that the added cookie is present on the page.
        expectedCookieValue = "cikolatali";
        actualCookieValue = driver.manage().getCookieNamed("en sevdigim cookie").getValue();
        Assert.assertEquals(expectedCookieValue,actualCookieValue);

        // 7- Delete the cookie named "skin" and test that it has been deleted.
        driver.manage().deleteCookieNamed("skin");
        Assert.assertTrue(driver.manage().getCookieNamed("skin") == null);

        // 8- Delete all cookies and test that they have been deleted.
        driver.manage().deleteAllCookies();
        cookiesSet = driver.manage().getCookies();
        Assert.assertTrue(cookiesSet.isEmpty());

    }
}
