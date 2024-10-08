package testNG;

import Utilities.util;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static Utilities.util.drpDwnClk;

public class testGFGConcise3 {

    ChromeDriver driver;
    util utl;

    @BeforeMethod
    public void browserLaunch() {
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
    public void checkMenuDropDown(String mainmenu,String submenu,String submenu1,String waitElement,String expectedTitle) throws InterruptedException, IOException {

        utl.mouseHover2(driver,mainmenu);
        utl.mouseHover2(driver,submenu);
        utl.mouseHover2(driver,submenu1);
        utl.Screenshot(driver);
        drpDwnClk(driver,submenu1);
        utl.expliWait(driver,waitElement);
        utl.Screenshot(driver);
        String subject= driver.getTitle();
        Assert.assertEquals(subject,expectedTitle);
    }

    @DataProvider
    Object[][] getData()
    {
        Object[][] data=new Object[2][5];

        data[0][0]="Courses";
        data[0][1]="For Students";
        data[0][2]="Data Science (Live)";
        data[0][3]="Course Description";
        data[0][4]="Complete Machine Learning & Data Science Program";

        data[1][0]="Jobs";
        data[1][1]="Filtered Jobs";
        data[1][2]="Jobs for Experienced";
        data[1][3]="Apply before Fri Aug 16 2024";
        data[1][4]="Community (Beta)";
        return data;
    }


}
