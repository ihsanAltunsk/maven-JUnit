package day06_JUnitAssertions;

import org.junit.Assert;
import org.junit.Test;
public class C03_Assertions {
    @Test
    public void test01(){

        int age = 70;
        Assert.assertTrue(age >65); // test passed


        int num1 = 20 ;
        int num2 = 30 ;
        // Assert.assertTrue(sayi1 > sayi2); // FAILED
        Assert.assertFalse(num1> num2); // PASSED

        String actualUrl = "https://testotomasyonu.com/";
        Assert.assertTrue(actualUrl.contains("testotomasyonu")); // PASSED

        Assert.assertFalse(actualUrl.contains("wisequarter"));  // PASSED

        Assert.assertEquals("https://testotomasyonu.com/",actualUrl); // PASSED

        Assert.assertTrue("https://testotomasyonu.com/".equals(actualUrl)); // PASSED

        Assert.assertNotEquals("https://www.testotomasyonu.com/",actualUrl);// PASSED

        Assert.assertFalse("https://www.testotomasyonu.com/".equals(actualUrl)); // PASSED
    }
}
