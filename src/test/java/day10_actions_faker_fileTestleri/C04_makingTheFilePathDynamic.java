package day10_actions_faker_fileTestleri;

import org.junit.Test;
import utilities.testBase;

public class C04_makingTheFilePathDynamic extends testBase {
    /*
        To make the Java file path dynamic, we have two ready methods to access two fundamental locations:

        1- If you want to access the file path of the project you are running:
        System.getProperty("user.dir")

        2- If you want to access the main file path of the computer:
        System.getProperty("user.home")

        If you are working collaboratively and want to test the existence of a file in our project
        or a file we downloaded to the downloads folder,
        we should make the file path dynamic using these two codes.
*/
    @Test
    public void test01(){
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));
    }
}
