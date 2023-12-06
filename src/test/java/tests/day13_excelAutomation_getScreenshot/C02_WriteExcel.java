package tests.day13_excelAutomation_getScreenshot;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {
    // 1- Create a new cell in the 5th column.
    // 2- Print "Population" in the created cell.
    // 3- In the 2nd row, write 1500000 in the population column.
    // 4- In the 10th row, write 250000 in the population column.
    // 5- In the 15th row, write 54000 in the population column.
    // 6- Save the file.
    // 7- Close the file.

    @Test
    public void test() throws IOException {
        String path = "src/test/java/tests/day12_webTables_excelAutomation/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet page1 = workbook.getSheet("Sayfa1");

        // 1- Create a new cell in the 5th column.
        page1.getRow(0).createCell(4);

        // 2- Print "Population" in the created cell.
        page1.getRow(0).getCell(4).setCellValue("Population");

        // 3- In the 2nd row, write 1500000 in the population column.
        page1.getRow(1).createCell(4).setCellValue(1500000);

        // 4- In the 10th row, write 250000 in the population column.
        page1.getRow(9).createCell(4).setCellValue(250000);

        // 5- In the 15th row, write 54000 in the population column.
        page1.getRow(14).createCell(4).setCellValue(54000);

        // 6- Save the file.
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        // 7- Close the file.
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();

    }
}
