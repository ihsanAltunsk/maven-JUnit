package utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class reusableMethods {

    public static List<String> convertToString(List<WebElement> elementsList){

        List<String> stringList = new ArrayList<>();

        for (WebElement each : elementsList
        ) {

            stringList.add(each.getText());
        }

        return stringList;
    }

    public static void wait(int second){

        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
