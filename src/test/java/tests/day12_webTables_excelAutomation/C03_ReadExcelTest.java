package tests.day12_webTables_excelAutomation;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_ReadExcelTest {
    // 1- Let's go to the 2nd cell in the 1st row and print its content.
    // 2- Assign the content of the 2nd cell in the 1st row to a string variable and print it.
    // 3- Test if the 4th cell in the 2nd row states the capital of Afghanistan.
    // 4- Find the total number of rows.
    // 5- Test if the capital city of Samoa is named Apia.
    // 6- Find the number of physically used rows.
    // 7- Save English country names and their capitals as a map.

    @Test
    public void test01() throws IOException {
        String filePath = "src/test/java/tests/day12_webTables_excelAutomation/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet page1 = workbook.getSheet("Sayfa1");

        // 1- Let's go to the 2nd cell in the 1st row and print its content.
        System.out.println(page1.getRow(0).getCell(1));

        // 2- Assign the content of the 2nd cell in the 1st row to a string variable and print it.
        String wantedCell = page1.getRow(0).getCell(1).toString();
        System.out.println("Content of the 2nd cell in the 1st row: " + wantedCell);

        // 3- Test if the 4th cell in the 2nd row states the capital of Afghanistan.
        wantedCell = page1.getRow(1).getCell(3).toString();
        Assert.assertEquals("Kabil",wantedCell);

        // 4- Find the total number of rows.
        int numberOfRows = page1.getLastRowNum();
        System.out.println("Total number of rows: " + (numberOfRows + 1));

        // 5- Test if the capital city of Samoa is named Apia.
        String expectedCapital = "Apia";
        String actualCapital="";
        for (int i =0;i<numberOfRows; i++){
            if (page1.getRow(i).getCell(0).equals("Samoa")){
                actualCapital = page1.getRow(i).getCell(1).toString();
            }
        }
        Assert.assertEquals(expectedCapital,actualCapital);

        // 6- Find the number of physically used rows.


        // 7- Save English country names and their capitals as a map.


    }
}
