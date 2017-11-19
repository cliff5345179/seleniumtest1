import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class CloseAdsifExist {
    public void CloseAds(FirefoxDriver driver) throws InterruptedException {

        Actions action = new Actions(driver);
        int ads = driver.findElements(By.className("close")).size();

        if (ads != 0) {
            Thread.sleep(3000);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement closeAds = driver.findElement(By.className("close"));
            action.moveToElement(closeAds).perform();
            driver.findElement(By.className("close")).click();
        }
    }
}
