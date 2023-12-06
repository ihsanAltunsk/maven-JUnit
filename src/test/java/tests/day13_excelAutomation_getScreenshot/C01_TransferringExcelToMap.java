package tests.day13_excelAutomation_getScreenshot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C01_TransferringExcelToMap {
    // Save the Turkish country names and
    // Capital names from the Countries Excel sheet as a Map.
    // Use country names as keys and capital names as values.
    // Test if the capital of Russia is Moscow.
    // Test if there is a country in the list with the capital San Marino.
    // Test if the list contains the Philippines.

    @Test
    public void test01() throws IOException {
        String path = "src/test/java/tests/day12_webTables_excelAutomation/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // Save the Turkish country names and
        // Capital names from the Countries Excel sheet as a Map.
        // Use country names as keys and capital names as values.

        Map<String,String> mapOfCountries = new TreeMap<>();
        String countryNameOnRow, capitalNameOnRow;
        int lastIndex = workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i <= lastIndex ; i++) {
            countryNameOnRow = workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString();
            capitalNameOnRow = workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            mapOfCountries.put(countryNameOnRow, capitalNameOnRow);
        }

        // Test if the capital of Russia is Moscow.
        String expectedCapitalName= "Moskova";
        String actualCapitalName = mapOfCountries.get("Rusya");
        Assert.assertEquals(expectedCapitalName, actualCapitalName);

        // Test if there is a country in the list with the capital San Marino.
        Assert.assertTrue(mapOfCountries.containsValue("San Marino"));

        // Test if the list contains the Philippines.
        Assert.assertTrue(mapOfCountries.containsKey("Filipinler"));

    }
}
