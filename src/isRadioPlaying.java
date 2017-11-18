import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class isRadioPlaying {
    public boolean isRadioPlaying(FirefoxDriver driver) {
        boolean foundPlaying = false;
        isAlertPresent present = new isAlertPresent();
        boolean checkpresent = present.isAlertPresent(driver);
        if (checkpresent == true){
            Alert alert = driver.switchTo().alert();
            alert.accept();
        }
        foundPlaying = driver.findElement(By.xpath(".//*[@id='pauseBtn']")).isDisplayed();
        return foundPlaying;
    }
}
