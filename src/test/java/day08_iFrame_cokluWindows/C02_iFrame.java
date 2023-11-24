package day08_iFrame_cokluWindows;

import org.junit.Test;
import utilities.testBase;

public class C02_iFrame extends testBase {
    // 1- Go to https://the-internet.herokuapp.com/iframe.
    // 2- Create a method: iframeTest
    // 3- Test if the text "An IFrame containing…." is accessible and print it to the console.
    // 4- Enter "Merhaba Dunya!" into the Text Box.
    // 5- Verify that the text "Elemental Selenium" link below the TextBox is visible and print it to the console.

    @Test
    public void iframeTest(){
        // 1- Go to https://the-internet.herokuapp.com/iframe.
        driver.get("https://the-internet.herokuapp.com/iframe");
    }
}
