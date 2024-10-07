package testNG;

import Utilities.util;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.FullPageScreenShot;
import pages.MouseHover;
import pages.SwitchWindow;
import pages.screenShot;

import java.io.IOException;


public class testGFGConsice extends util {

    ChromeDriver driver;
    util utl;

    @BeforeMethod
    public void browserLaunch() throws InterruptedException {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.geeksforgeeks.org/");
    }
    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }

    @Test(dataProvider = "getData")
    public void openMenuDropdown(String mainmenu,String submenu,String submenu1,String submenu2,String expectedTitle) throws InterruptedException, IOException {

        //Mouse Hover
        utl.mouseHover(driver,"//*[normalize-space()='"+mainmenu+"']");

        Thread.sleep(1000);
        utl.mouseHover(driver,"//*[normalize-space()='"+submenu+"']");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[normalize-space()='"+submenu1+"']")).click();
        driver.findElement(By.xpath("//*[normalize-space()='"+submenu2+"']")).click();

        //Switching window
        utl.switchWindow1(driver);
        Thread.sleep(1000);
        //Take screenshot of switched window
        utl.Screenshot(driver);
        //Take Fullpage screenshot
       // utl.takeFullPageScreenshot(driver);

        String subject= driver.getTitle();
        Assert.assertEquals(subject,expectedTitle);

    }

    @DataProvider
    Object[][] getData()
    {
        Object[][] data=new Object[1][5];

        data[0][0]="Practice";
        data[0][1]="Language Wise Coding Practice";
        data[0][2]="Java";
        data[0][3]="Java Hello World";
        data[0][4]="Practice | GeeksforGeeks | A computer science portal for geeks";

        return data;
    }

}


