package test1;

import Utilities.util;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.dashboardInvoice;
import pages.loginInvoice;

public class testInvoice {

    ChromeDriver driver;

    @BeforeMethod
    public void browserLaunch() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.invoiceplane.com/sessions/login");
    }
    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }

    @Test
    public void loginTest() {
        loginInvoice lgn=new loginInvoice(driver);
        dashboardInvoice dashboard=lgn.login("admin@invoiceplane.com","demopassword");
        Assert.assertEquals(dashboard.getTitleMessage(),"InvoicePlane");
    }
}
