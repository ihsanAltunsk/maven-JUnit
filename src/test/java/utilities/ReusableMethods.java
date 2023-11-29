package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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


}
