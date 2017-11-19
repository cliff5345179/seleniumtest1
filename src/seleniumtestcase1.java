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
        String baseUrl = "https://play.kkbox.com/";
        driver.get(baseUrl);

        // setup writer for report
        reportwriter write = new reportwriter();
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
        Date current = new Date();
        String result = String.valueOf(current);
        String description = "";
        write.writerTxt(result);

        /**
         * start of test case 1
         */
        //login
        String id = "cliff5345179@gmail.com";
        String pwd = "Saki0608";
        Login logincheck = new Login();
        Boolean checklogin = logincheck.Logincheck(driver, id, pwd);

        if (checklogin ==false){
            result ="test case 1 'failed'";
            description ="login unsuccessful";
            write.writerTxt(result);
            write.writerTxt(description);
        }

        // initiate mouse hover action
        Actions action = new Actions(driver);

        //close ads if exist
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        CloseAdsifExist AdsifExist = new CloseAdsifExist();
        AdsifExist.CloseAds(driver);


        //find the four bookmarks and make sure they exist
        int sidebarNav = driver.findElements(By.className("sidebar-nav")).size();
        if (sidebarNav != 0) {
            int cpl = driver.findElements(By.cssSelector("[ng-click*=cpl]")).size();
            int explore = driver.findElements(By.cssSelector("[ng-click*=explore]")).size();
            int radio = driver.findElements(By.cssSelector("[ng-click*=radio]")).size();
            int listen_with = driver.findElements(By.cssSelector("[ng-click*=listen-with]")).size();

            /**
             * end of test case 1
             */
            if (cpl != 0 && explore != 0 && radio != 0 && listen_with != 0) {
                result = "test case 1 'pass'";
                write.writerTxt(result);
            } else {
                result = "test case 1 'failed'";
                description = "Didn't find all four elements";
                write.writerTxt(result);
                write.writerTxt(description);
            }
        }
        else{
            result = "test case 1 'failed'";
            write.writerTxt(result);
            description = "no left panel";
            write.writerTxt(result);
            write.writerTxt(description);
        }

        /**
         * start of test case 2
         */

        // input target
        driver.findElement(By.className("search_hint")).sendKeys("清平調");

        //search
        driver.findElement(By.id("search_btn_cnt")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //target String
        String target = "王菲&鄧麗君 (Faye Wong & Teresa Teng)";
        Thread.sleep(3000);

        //get actual target
        ArtistExistCheck checkArtist = new ArtistExistCheck();
        Boolean Artistcheck = checkArtist.ArtistExist(driver, target);

        /**
         * end of test case 2
         */
        if (Artistcheck == true) {
            result = "test case 2 'pass'";
            write.writerTxt(result);
        }
        else{
            result = "test case 2 'failed'";
            description ="didn't find the song";
            write.writerTxt(result);
            write.writerTxt(description);
        }

        /**
         *         start of test case 3
         */
        driver.findElement(By.cssSelector("[ng-click*=radio]")).click();

        //wait for loading
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //initiate plying check
        isRadioPlaying Playing = new isRadioPlaying();
        Boolean checkPlaying = Playing.isRadioPlaying(driver);


        //find radio image in advance
        WebElement radio_image = driver.findElement(By.className("img-wrap"));

        //Play radio with check playing
        while (!checkPlaying) {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            // hover on image so button will show
            action.moveToElement(radio_image).build().perform();

            //press radio play button
            driver.findElement(By.className("btn-radio")).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            Thread.sleep(2000);

            //check ads
            AdsifExist.CloseAds(driver);

            // check if playing is true
            checkPlaying = Playing.isRadioPlaying(driver);
            int count = 0;
            count++;
            if (count > 3){
                result = "test case 3 'failed'";
                description = "cannot play radio";
                write.writerTxt(result);
                write.writerTxt(description);
                break;
            }
        }

        //record orginal song
        String beforeDislike = driver.findElement(By.xpath("//*[@id='container']/div[2]/div/div[1]/div/div/div/div[1]/div/div/div/h3/a")).getText();
        result = "before dislike:"+beforeDislike;
        write.writerTxt(result);

        //sleep a while
        Thread.sleep(2000);

        //press dislike
        driver.findElement(By.xpath("//*[@title = '不喜歡']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //wait until play
        checkPlaying = Playing.isRadioPlaying(driver);
        while (!checkPlaying){
            checkPlaying = Playing.isRadioPlaying(driver);
        }

        //record song afterwards
        String afterDislike = driver.findElement(By.xpath("//*[@id='container']/div[2]/div/div[1]/div/div/div/div[1]/div/div/div/h3/a")).getText();
        result = "after dislike:"+afterDislike;
        write.writerTxt(result);

        /**
         * end of test case 3
         */
        if (beforeDislike.equals(afterDislike)){
            result = "test case 3 'failed'";
            write.writerTxt(result);
        }
        else{
            result = "test case 3 'pass'";
            write.writerTxt(result);
        }

        //all done!
        driver.quit();
    }

}