package tests.day12_webTables_excelAutomation;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {
    // 1- Go to the "https://testotomasyonu.com/webtables2" page
    // 2- Print the titles present in the headers
    // 3- Print the title of the 3rd column
    // 4- Print all the data in the table
    // 5- Print the number of cells (data) in the table
    // 6- Print the number of rows in the table
    // 7- Print the number of columns in the table
    // 8- Print the 3rd column in the table
    // 9- Print the price of the product with "Category" as Furniture in the table
    // 10- Create a method that, when provided with the row and column numbers on the Test page, prints the corresponding data

    @Test
    public void test01(){
        // 1- Go to the "https://testotomasyonu.com/webtables2" page
        driver.get("https://testotomasyonu.com/webtables2");

        // 2- Print the titles present in the headers
        List<WebElement> headerElements = driver.findElements(By.xpath("//div[@role='hdata']"));
        List<String> headerElementsStr = ReusableMethods.convertToString(headerElements);
        System.out.println("TITLES: " + headerElementsStr);

        // 3- Print the title of the 3rd column
        System.out.println("The title of the 3rd column: " + headerElementsStr.get(2));

        // 4- Print all the data in the table
        List<WebElement> allDataElements = driver.findElements(By.xpath("//div[@role='tdata']"));
        List<String> allDataElementsStr = ReusableMethods.convertToString(allDataElements);
        System.out.println("All the data in the table: " + allDataElementsStr);

        // 5- Print the number of cells (data) in the table
        System.out.println("Number of cells (data) in the table: " + allDataElements.size());

        // 6- Print the number of rows in the table
        List<WebElement> rowElements = driver.findElements(By.xpath("//div[@role='trow']"));
        System.out.println("Number of rows in the table: " + rowElements.size());

        // 7- Print the number of columns in the table
        System.out.println("Number of columns in the table: " + headerElements.size());

        // 8- Print the 3rd column in the table
        List<WebElement> thirdColumnElements = driver.findElements(By.xpath("//*[@role='trow']/*[@role='tdata'][3]"));
        List<String > thirdColumnElementsStr = ReusableMethods.convertToString(thirdColumnElements);
        System.out.println("3rd Column : " + thirdColumnElementsStr);

        // 9- Print the price of the product with "Category" as Furniture in the table

        // 10- Create a method that, when provided with the row and column numbers on the Test page, prints the corresponding data
    }

}
