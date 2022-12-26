package Exercises;

import org.junit.Test;
import utilities.BaseTest;

public class FilesClass extends BaseTest {


    @Test
    public void test() {

        System.out.println("System.getProperty(\"file.seperator\") = " + System.getProperty("file.seperator"));
        System.out.println("System.getProperty(\"java.class.path\") = " + System.getProperty("java.class.path"));
        System.out.println("System.getProperty(\"java.home\") = " + System.getProperty("java.home"));
        System.out.println("System.getProperty(\"java.vendor\") = " + System.getProperty("java.vendor"));
        System.out.println("System.getProperty(\"java.vendor.url\") = " + System.getProperty("java.vendor.url"));
        System.out.println("System.getProperty(\"java.version\") = " + System.getProperty("java.version"));
        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"os.version\") = " + System.getProperty("os.version"));
        System.out.println("System.getProperty(\"path.seperator\") = " + System.getProperty("path.seperator"));
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));
        System.out.println("System.getProperty(\"user.home\") = " + System.getProperty("user.home"));
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));
    }
}
