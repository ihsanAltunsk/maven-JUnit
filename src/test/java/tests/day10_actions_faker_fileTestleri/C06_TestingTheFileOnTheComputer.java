package tests.day10_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C06_TestingTheFileOnTheComputer extends TestBase {
    // Test whether eva-logo.png exists in Downloads.

    @Test
    public void test01(){
        // Test whether eva-logo.png exists in Downloads.
        String filePath ="C:/Users/user/Downloads/eva-logo.png";
        Assert.assertTrue(Files.exists(Paths.get(filePath)));

            // The part that is unique to each person ==> user.dir
            //          C:/Users/user
            // The part that is the same for everyone ==> the file path inside the project
            //          /Downloads/eva-logo.png

        String dynamicFilePath = System.getProperty("user.home") +
                "/Downloads/eva-logo.png";
        Assert.assertTrue(Files.exists(Paths.get(dynamicFilePath)));
    }
}
