package Utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class util {

    public static void mouseHover(WebDriver driver, String locator) {
        Actions actions = new Actions(driver);
        WebElement menu = driver.findElement(By.xpath(locator));
        actions.moveToElement(menu).perform();
    }

    public static void Screenshot(WebDriver driver) throws IOException {
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

    public static void switchWindow1(WebDriver driver) throws InterruptedException {

        Set<String> wind = driver.getWindowHandles(); // collection of windows
        Iterator<String> itr = wind.iterator();  // iterations of windows
        String mainwindow = itr.next();  // window 1
        String newwindow = itr.next();   // window 2


        // now our pointer is at new window
        driver.switchTo().window(newwindow);

        Thread.sleep(2000);
        driver.switchTo().window(mainwindow);

    }

    public static void impliWait(WebDriver driver){
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public static void expliWait(WebDriver driver){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement checkElement=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Apply before Fri Aug 16 2024']")));
        String expected=checkElement.getText();
        Assert.assertEquals("Apply before Fri Aug 16 2024",expected);
    }
  /*  public void takeFullPageScreenshot(WebDriver driver){
        try {
            // Use AShot to capture the full page screenshot
            Screenshot screenshot = new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(1000))
                    .takeScreenshot(driver);

            String time= new SimpleDateFormat("yyyyMMdd_hhmmss").format(new Date());
            // Save the screenshot to a file
            ImageIO.write(screenshot.getImage(), "PNG", new File("./SS/_fullpage"+time+".png"));

            System.out.println("Screenshot taken and saved as fullpage_screenshot.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    }

