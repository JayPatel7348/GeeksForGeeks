package pages;

import org.apache.commons.io.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class screenShot {

    public void Screenshot(WebDriver driver) throws IOException {
        TakesScreenshot ss=(TakesScreenshot) driver;
        File srcFile=ss.getScreenshotAs(OutputType.FILE);
        String time= new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date());
        File destFile=new File("./SS/"+time+".png");
        try{
        FileUtils.copyFile(srcFile, destFile);}
        catch(Exception e){
            System.out.println(e);
        }
    }
}
