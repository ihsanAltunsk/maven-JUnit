package tests.day12_webTables_excelAutomation;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class C03_ReadExcelTest {
    // 1- Let's go to the 2nd cell in the 1st row and print its content.
    // 2- Assign the content of the 2nd cell in the 1st row to a string variable and print it.
    // 3- Test if the 4th cell in the 2nd row states the capital of Afghanistan.
    // 4- Find the total number of rows.
    // 5- Test if the capital city of Samoa is named Apia.
    // 6- Create a method that, based on the English country name
    //    and language preference we provide, returns the capital city.
    // 7- Find the number of physically used rows.
    // 8- Save English country names and their capitals as a map.

    Sheet page1;

        @Test
        public void readExcelTesti() throws IOException {
            String dosyaYolu = "src/test/java/tests/day12_webTables_excelAutomation/ulkeler.xlsx";
            FileInputStream fis = new FileInputStream(dosyaYolu);
            Workbook workbook = WorkbookFactory.create(fis);

            // Ulkeler excel'indeki Turkce ulke isimleri ve
            // Turkce baskent isimlerini bir Map olarak kaydedin
            // Ulke isimleri key, baskent isimleri value olsun

            Map<String,String> ulkelerMap = new TreeMap<>();
            String satirdakiUlkeIsmi;
            String satirdakiBaskentIsmi;
            int sonSatirIndex = workbook.getSheet("Sayfa1").getLastRowNum();

            for (int i = 0; i <=sonSatirIndex ; i++) {
                satirdakiUlkeIsmi = workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString();
                satirdakiBaskentIsmi= workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
                ulkelerMap.put(satirdakiUlkeIsmi,satirdakiBaskentIsmi);
            }

            // Rusya'nin baskentinin Moskova oldugunu test edelim

            String expectedBaskentIsmi= "Moskova";
            String actualBaskentIsmi = ulkelerMap.get("Rusya");
            Assert.assertEquals(expectedBaskentIsmi,actualBaskentIsmi);

            // Listede baskenti San Marino olan bir ulke oldugunu test edelim

            Assert.assertTrue(ulkelerMap.containsValue("San Marino"));

            // Listede Filipinler'in oldugunu test edelim

            Assert.assertTrue(ulkelerMap.containsKey("Filipinler"));
        }
}
