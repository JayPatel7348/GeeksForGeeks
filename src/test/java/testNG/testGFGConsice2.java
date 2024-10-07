package testNG;

import Utilities.util;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;


public class testGFGConsice2 extends util {

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
    public void openMenuDropdown(String mainmenu,String submenu,String submenu1,String expectedTitle) throws InterruptedException, IOException {

        //Mouse Hover
        utl.mouseHover(driver,"//*[normalize-space()='"+mainmenu+"']");

        Thread.sleep(1000);
        utl.mouseHover(driver,"//*[normalize-space()='"+submenu+"']");
        Thread.sleep(1000);
        utl.Screenshot(driver);
        driver.findElement(By.xpath("//*[normalize-space()='"+submenu1+"']")).click();
      //  driver.findElement(By.xpath("//*[normalize-space()='"+submenu2+"']")).click();
        Thread.sleep(1000);
        //implicit wait globally for any web element to be load first
        //utl.impliWait(driver);

        // explicit wait till the specific condition true
        utl.expliWait(driver);
        utl.Screenshot(driver);
        String subject= driver.getTitle();
        Assert.assertEquals(subject,expectedTitle);

    }

    @DataProvider
    Object[][] getData()
    {
        Object[][] data=new Object[1][4];

        data[0][0]="Jobs";
        data[0][1]="Filtered Jobs";
        data[0][2]="Jobs for Experienced";
        data[0][3]="Community (Beta)";
       // data[0][3]="";

        return data;
    }

}


