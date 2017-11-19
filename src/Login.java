import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {
    private String id;
    private  String pwd;
    public Boolean Logincheck(FirefoxDriver driver, String id, String pwd){
        this.id = id;
        this.pwd = pwd;
        boolean login = true;
        driver.findElement(By.xpath(".//*[@id='uid']")).sendKeys(id);
        driver.findElement(By.xpath(".//*[@id='pwd']")).sendKeys(pwd);
        driver.findElement(By.xpath(".//*[@id='login-btn']")).click();
        if (driver.findElements(By.className("alert alert-error")).size()!=0){
            login = false;
        }
        return  login;
    }
}
