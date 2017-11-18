import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class seleniumtestcase1 {


    public static void main(String[] args) throws IOException, InterruptedException {
        //setup web driver
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String baseUrl = "https://play.kkbox.com/";
        driver.get(baseUrl);
        driver.findElement(By.xpath(".//*[@id='uid']")).sendKeys("cliff5345179@gmail.com");
        driver.findElement(By.xpath(".//*[@id='pwd']")).sendKeys("Saki0608");
        driver.findElement(By.xpath(".//*[@id='login-btn']")).click();
        //close ads if exist
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        int ads = driver.findElements(By.className("close")).size();
        if (ads != 0) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.className("close")).click();
        }
        //find the four bookmarks and make sure they exist
        int sidebarNav = driver.findElements(By.className("sidebar-nav")).size();
        }
        driver.findElement(By.className("search_hint")).sendKeys("清平調");
        driver.findElement(By.id("search_btn_cnt")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("[ng-click*=radio]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
        }
    }

}