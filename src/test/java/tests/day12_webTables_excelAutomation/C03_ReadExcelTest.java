package tests.day12_webTables_excelAutomation;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcelTest {
    // 1- Let's go to the 2nd cell in the 1st row and print its content.
    // 2- Assign the content of the 2nd cell in the 1st row to a string variable and print it.
    // 3- Test if the 4th cell in the 2nd row states the capital of Afghanistan.
    // 4- Find the total number of rows.
    // 5- Find the number of physically used rows.
    // 6- Save English country names and their capitals as a map.

    @Test
    public void test01() throws IOException {
        // 1- Let's go to the 2nd cell in the 1st row and print its content.
        String filePath = "src/test/java/tests/day12_webTables_excelAutomation/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet page1 = workbook.getSheet("Sayfa1");

        // 2- Assign the content of the 2nd cell in the 1st row to a string variable and print it.
        // 3- Test if the 4th cell in the 2nd row states the capital of Afghanistan.
        // 4- Find the total number of rows.
        // 5- Find the number of physically used rows.
        // 6- Save English country names and their capitals as a map.
    }
}
