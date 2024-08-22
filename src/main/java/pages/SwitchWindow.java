package pages;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class SwitchWindow {

    public void switchWindow1(WebDriver driver) throws InterruptedException {

        Set<String> wind = driver.getWindowHandles(); // collection of windows
        Iterator<String> itr = wind.iterator();  // iterations of windows
        String mainwindow = itr.next();  // window 1
        String newwindow = itr.next();   // window 2


        // now our pointer is at new window
        driver.switchTo().window(newwindow);

        Thread.sleep(2000);
        driver.switchTo().window(mainwindow);

    }
}
