package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static List<String> convertToString(List<WebElement> elementsList){

        List<String> stringList = new ArrayList<>();

        for (WebElement each : elementsList
        ) {

            stringList.add(each.getText());
        }

        return stringList;
    }

    public static void waitabit(int second){

        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static WebDriver changePageWithTitle(WebDriver driver , String targetPageTitle){
        Set<String> allWhdSet = driver.getWindowHandles();
        for (String each : allWhdSet) {
            String eachTitle = driver.switchTo().window(each).getTitle();
            if (eachTitle.equals(targetPageTitle)){
                return driver;
            }
        }
        return driver;
    }
    public static String find2ndWhdWith1stWhd(WebDriver driver, String firstPageWhd) {
        Set<String > allWhdSet = driver.getWindowHandles();
        allWhdSet.remove(firstPageWhd);
        for (String each : allWhdSet){
            return each;
        }
        return null; // We know that this line will not execute
                     // It is written solely to address Java's concerns.
    }

    public static void getScreenshot(WebDriver driver) {
        // Capture and save a screenshot of the entire page.
        // Step 1: Create a TakesScreenshot (tss) object.
        TakesScreenshot tss = (TakesScreenshot) driver;

        // Step 2: Create a File with the file path where we will save the photo.
        // To ensure that each newly saved image does not overwrite the previous one,
        // we can make the file path dynamic by adding a timestamp label.
        // Let's add a timestamp label to the file path to make it dynamic.
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter expectedFormat = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String dynamicPath = "target/Screenshots/AllPageScreenshots" +
                              localDateTime.format(expectedFormat) +
                              ".jpg";
        File AllPageScreenshot = new File(dynamicPath);

        // Step 3: Use the tss object to take a photo and save it to a temporary file.
        File temporaryFile = tss.getScreenshotAs(OutputType.FILE);

        // Step 4: Copy the temporary file to the actual file.
        try {
            FileUtils.copyFile(temporaryFile,AllPageScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
