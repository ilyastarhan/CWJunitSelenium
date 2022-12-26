package Day9_JSEScroll_Cookies_Files;

import org.junit.Test;
import utilities.BaseTest;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C07_FileExist extends BaseTest {
    public static void main(String[] args) {


        System.out.println(System.getProperty("user.dir"));
        String projectRoot = System.getProperty("user.dir");
        String filePath = "\\src\\test\\java\\resources\\fileExist.jpg";
        filePath = projectRoot+filePath;
        System.out.println(filePath);
        System.out.println(Files.exists(Paths.get(filePath)));

        if(Files.exists(Paths.get(filePath)))
            System.out.println("Dosya bulundu");
        else
            System.out.println("Dosya bulunamadi");
        File file = new File("src/test/java/resources/fileExist.jpg");
        System.out.println(file.exists());




    }


    @Test
    public void test() {




    }
}