package Day9_JSEScroll_Cookies_Files;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;

public class C08_FileExists {

    @Test
    public void fileExists() {
      //  C:\\Users\\ilyas\\Desktop\\fileExist.png
        System.out.println(System.getProperty("user.home"));
        String homepath = System.getProperty("user.home");
        String filePath = "\\Desktop\\fileExist.png";
        String homePath = homepath+filePath;
        File image = new File(homePath);
        Assert.assertTrue(image.exists());



    }
}
