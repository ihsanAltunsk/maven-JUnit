package tests.day11_waits_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C04 extends TestBase {

    // 1- Go to "https://testotomasyonu.com/webtables"
    // 2- Print the entire body of the web table
    // 3- Test if "Comfortable Gaming Chair" is present in the web table
    // 4- Test if the number of rows in the web table is 5
    // 5- Print all rows or print row web elements with a for loop, adding comments before each
    // 6- Test if the number of columns in the web table is 4
    // 7- Print the 3rd column using a for loop
    // 8- Print the table headers as a list
    // 9- Create a method that takes the row and column numbers as parameters
    //    and returns the information in that cell
    // 10- Test if the category value in the 4th row is "Furniture"

    @Test
    public void webTabletest() {
        /*
            In classic HTML codes used to create web tables, to access the data in the desired cell,
            we use only tags with the table/body/row/data hierarchy.
            1- If we can access the information for 1 of 1, we don't need to write the entire path.
            2- If we only want to look at child HTML tags or if we want to look at child HTML tags
            along with grandchild tags, we use // along with the child HTML tags.
        */

        // 1- Go to "https://testotomasyonu.com/webtables"
        driver.get("https://testotomasyonu.com/webtables");

        // 2- Print the entire body of the web table
        WebElement bodyElement = driver.findElement(By.xpath("//table/tbody"));
        System.out.println(bodyElement.getText());

        // 3- Test if "Comfortable Gaming Chair" is present in the web table
        String expectedContent = "Comfortable Gaming Chair";
        String actualBody = bodyElement.getText();
        Assert.assertTrue(actualBody.contains(expectedContent));

        // 4- Test if the number of rows in the web table is 5
        List<WebElement> rowElementsList = driver.findElements(By.xpath("//tbody/tr"));
        int expectedNumberOfRows = 5;
        int actualNumberOfRows = rowElementsList.size();
        Assert.assertEquals(expectedNumberOfRows, actualNumberOfRows);

        // 5- Print all rows
        System.out.println("====ALL ROWS===");
        // We can convert the entire list to a list of strings and print it.
        List<String> rowListStr = ReusableMethods.convertToString(rowElementsList);
        System.out.println(rowListStr);
        // or print row web elements with a for loop, adding comments before each
        for (int i = 0; i < rowElementsList.size() ; i++) {
            System.out.println(i+1 + ". row  : " + rowElementsList.get(i).getText());
        }

        // 6- Test if the number of columns in the web table is 4
        /*
            The web table does not have a column structure;
            it contains rows and data in those rows.
            To obtain the number of columns, we can look at the number of data in any row.
        */
        List<WebElement> headerElementsList = driver.findElements(By.xpath("//thead/tr/th"));
        int expectedNumberOfColumns = 4;
        int actualNumberOfColumns = headerElementsList.size();
        Assert.assertEquals(expectedNumberOfColumns, actualNumberOfColumns);

        // 7- Print the 3rd column
        List<WebElement> thirdColumnElementsList = driver.findElements(By.xpath("//tbody/tr/td[3]"));
        System.out.println("======3rd Column Elements=====");
        // using a for loop
        for (int i = 0; i < thirdColumnElementsList.size(); i++) {
            System.out.println(i+1 + ". row third column : " + thirdColumnElementsList.get(i).getText());
        }

        // 8- Print the table headers as a list
        List<String> headerListStr = ReusableMethods.convertToString(headerElementsList);
        System.out.println("Headers : " + headerListStr);

        // 9- Test if the category value in the 4th row is "Furniture"
        String expectedCategory = "Furniture";
        String actualCategory = getCellData(4,2);
        Assert.assertEquals(expectedCategory,actualCategory);

        // 10- Create a method that takes the row and column numbers as parameters
        //  and returns the information in that cell
        System.out.println(getCellData(1, 3)); // $399.00
        System.out.println(getCellData(2, 1)); // Samsung White Smart Watch
        System.out.println(getCellData(4, 2)); // Furniture
    }

    public String getCellData(int rowNo, int columnNo){
        //      //tbody/tr[4]/td[3]
        String dynamicXpath = "//tbody/tr[" + rowNo + "]/td[" + columnNo + "]";
        WebElement wantedCellDataElement = driver.findElement(By.xpath(dynamicXpath));
        return wantedCellDataElement.getText();
    }
}
