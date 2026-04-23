package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static void capture(WebDriver driver, String testName) {
        if (driver == null) {
            System.out.println("Driver is null. Screenshot not captured.");
            return;
        }

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            File dest = new File("screenshots/" + testName + "_" + timestamp + ".png");

            FileUtils.copyFile(src, dest);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}