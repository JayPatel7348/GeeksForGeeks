package pages;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FullPageScreenShot {
    public void takeFullPageScreenshot(WebDriver driver){
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
    }

}
