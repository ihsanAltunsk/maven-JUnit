package tests.day12_webTables_excelAutomation;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_ReadExcel {
    // 1- Make the necessary adjustments and open Page 2.
    // 2- Test that the last used row on the page is the 26th row.
    // 3- Test that the actual number of rows with written text on the page is 12.

    @Test
    public void test1() throws IOException {
        // 1- Make the necessary adjustments and open Page 2.
        String filePath = "src/test/java/tests/day12_webTables_excelAutomation/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet page2 = workbook.getSheet("Sayfa2");

        // 2- Test that the last used row on the page is the 26th row.
        int expectedNumberOfRows = 26;
        int actualNumberOfRows = page2.getLastRowNum()+1;
        Assert.assertEquals(expectedNumberOfRows,actualNumberOfRows);

        // 3- Test that the actual number of rows with written text on the page is 12.
        int expectedPhysicallyNumberOfRows = 12;
        int actualPhysicallyNumberOfRows = page2.getPhysicalNumberOfRows();
        Assert.assertEquals(expectedPhysicallyNumberOfRows, actualPhysicallyNumberOfRows);
    }
}
