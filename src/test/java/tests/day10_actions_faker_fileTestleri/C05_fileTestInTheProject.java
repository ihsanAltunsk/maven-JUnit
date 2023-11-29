package tests.day10_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import utilities.testBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_fileTestInTheProject extends testBase {
    // Test whether there is a deneme.txt file under the day10 package in our project.

    @Test
    public void test01(){
        // Test whether there is a deneme.txt file under the day10 package in our project.
        String filePath = "C:\\Users\\user\\IdeaProjects\\com.team127_JUnit\\src\\test\\java\\tests\\day10_actions_faker_fileTestleri\\experiment.txt";
        Assert.assertTrue(Files.exists(Paths.get(filePath)));

            // The part that is unique to each person ==> user.dir
            //          C:\Users/user\IdeaProjects\com.team127_JUnit
            // The part that is the same for everyone ==> the file path inside the project
            //          \src\test\java\tests\day10_actions_faker_fileTestleri\experiment.txt

        String dynamicFilePath = System.getProperty("user.dir") +
                "\\src\\test\\java\\tests\\day10_actions_faker_fileTestleri\\experiment.txt";
        Assert.assertTrue(Files.exists(Paths.get(dynamicFilePath)));

    }
}
