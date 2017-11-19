import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class ArtistExistCheck {
    private String target;
    public boolean ArtistExist(FirefoxDriver driver, String target){
        boolean Exist = false;
        String check = "";
        this.target = target;
        List<WebElement> allElements = driver.findElements(By.cssSelector("[ng-click*=artist"));
        for (WebElement element : allElements){
            check = element.getText();
            if (target.equals(check)){
                Exist = true;
                return Exist;
            }
        }
        return Exist;
    }
}
