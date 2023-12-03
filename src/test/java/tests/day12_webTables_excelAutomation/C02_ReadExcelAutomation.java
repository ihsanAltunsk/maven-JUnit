package tests.day12_webTables_excelAutomation;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcelAutomation {

    @Test
    public void test01() throws IOException {
        String filePath = "src/test/java/tests/day12_webTables_excelAutomation/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        /*
        We cannot directly include a physical file on our computer in our code.
        Apache POI allows us to read all the data from the physical Excel file
        located at the given file path using the FileInputStream object.
        It creates a COPY of the EXCEL file that we can use.
        !!!It's important to note that all the operations we perform within this test method
        DO NOT affect the actual Excel file. When line 36 is executed, it operates on the existing information in Excel.
        Row and column information works with indices, starting from 0.
         */
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet page1 = workbook.getSheet("Sayfa1");
        Row thirdRow = page1.getRow(3); // index=3 corresponds to the physical 4th row.
        Cell secondData = thirdRow.getCell(2); //index=2 corresponds to the physical 3rd data item.
        System.out.println(secondData); // Cezayir

        //Test whether the country mentioned in the 12th line is called 'Azerbaycan' in Turkish.
        String nameOfCountry = page1.getRow(11).getCell(2).toString();
        Assert.assertEquals("Azerbaycan",nameOfCountry);
    }
}
