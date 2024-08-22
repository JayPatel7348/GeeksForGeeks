package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {
    public void mouseHover(WebDriver driver,String locator) {
        Actions actions = new Actions(driver);
        WebElement menu = driver.findElement(By.xpath(locator));
        actions.moveToElement(menu).perform();
    }
}
