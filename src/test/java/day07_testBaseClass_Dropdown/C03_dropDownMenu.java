package day07_testBaseClass_Dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.reusableMethods;
import utilities.testBase;

import java.util.List;

public class C03_dropDownMenu extends testBase {
    // Go to https://testotomasyonu.com/form.
    // 1. Choose 5 from the day options of the birth date using index.
    // 2. Select April from the month options of the birth date using value.
    // 3. Choose 1990 from the year options of the birth date using visible text.
    // 4. Print the selected values to the console.
    // 5. Print all values (value) in the month dropdown menu.
    // 6. Test that the size of the Month Dropdown menu is 30.

    @Test
    public void testDropDownMenu(){
        // Go to https://testotomasyonu.com/form.
        driver.get("https://testotomasyonu.com/form");

        // 1. Choose 5 from the day options of the birth date using index.
        WebElement dayOfBirth = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
        Select selectDay = new Select(dayOfBirth);
        selectDay.selectByIndex(5);

        // 2. Select April from the month options of the birth date using visible text.
        WebElement monthOfBirth = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        Select selectMonth = new Select(monthOfBirth);
        selectMonth.selectByVisibleText("Nisan");

        // 3. Choose 1990 from the year options of the birth date using visible text.
        WebElement yearOfBirth = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
        Select selectYear = new Select(yearOfBirth);
        selectYear.selectByVisibleText("1990");

        // 4. Print the selected values to the console.
        System.out.println("Selected date: " + selectDay.getFirstSelectedOption().getText()+
                " " + selectMonth.getFirstSelectedOption().getText()+
                " " + selectYear.getFirstSelectedOption().getText());

        // 5. Print all values (value) in the month dropdown menu.
        List<WebElement> monthElements = selectMonth.getOptions();
        System.out.println(reusableMethods.convertToString(monthElements));

        // 6. Test that the size of the Month Dropdown menu is 30.
        Assert.assertEquals(13,monthElements.size());


    }
}
