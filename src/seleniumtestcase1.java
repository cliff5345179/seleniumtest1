import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class seleniumtestcase1 {


    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String baseUrl = "https://play.kkbox.com/";

        driver.get(baseUrl);
        //login with correct id and password
        driver.findElement(By.xpath(".//*[@id='uid']")).sendKeys("cliff5345179@gmail.com");
        driver.findElement(By.xpath(".//*[@id='pwd']")).sendKeys("Saki0608");
        driver.findElement(By.xpath(".//*[@id='login-btn']")).click();
        //close ads if exist
        int ads = driver.findElements(By.cssSelector("button[ng-class='close']")).size();
        if (ads != 0) {
            driver.findElement(By.cssSelector("button[ng-class='close']")).click();
        }
        //find the four bookmarks and make sure they exist
        int sidebarNav = driver.findElements(By.className("sidebar-nav")).size();
        if(sidebarNav !=0) {
            driver.findElement(By.cssSelector("[ng-click*=cpl]")).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.cssSelector("[ng-click*=explore]")).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.cssSelector("[ng-click*=radio]")).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.findElement(By.cssSelector("[ng-click*=listen-with]")).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
        //截圖
        File srcFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile1, new File("testcase1.png"));
        //search 清平調
        driver.findElement(By.className("search_hint")).sendKeys("清平調");
        driver.findElement(By.id("search_btn_cnt")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //截圖
        File srcFile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile2, new File("testcase2.png"));
        //開radio頁
        driver.findElement(By.cssSelector("[ng-click*=radio]")).click();
        //等待loading完畢
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id='container']/div[1]/ul/li[3]/a")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id='promote-stations']/div/ul/li[1]/div/div[1]")).click();
        driver.findElement(By.xpath("//*[@id='promote-stations']/div/ul/li[1]/div/div[1]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("[ng-class*=disablesd]")).click();
    }

}