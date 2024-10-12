package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class dashboardInvoice {

    private WebDriver driver;


    public dashboardInvoice(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitleMessage() {
        return driver.getTitle();
    }
}
