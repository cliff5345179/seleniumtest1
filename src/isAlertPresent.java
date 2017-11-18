import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class isAlertPresent {

    public boolean isAlertPresent(FirefoxDriver driver){
        boolean foundAlert = false;
        WebDriverWait wait = new WebDriverWait(driver, 3 /*timeout in seconds*/);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            foundAlert = true;
        } catch (TimeoutException NoAlert) {
            foundAlert = false;
        }
        return foundAlert;
    }
}
