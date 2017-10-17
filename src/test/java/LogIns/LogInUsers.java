package LogIns;

import PageObject.LogInForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInUsers {

    private WebDriver driver;
    public String baseUrl = "http://ctmr.codebnb.me/";

    @BeforeMethod
    public void basicUrl() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterMethod
    public void endSession(){
        driver.close();
    }

    @Test()
    public void loginSuperAdmin() throws InterruptedException{
        LogInForm SuperLogIn=new LogInForm(driver);
        SuperLogIn.isInitialized();
        SuperLogIn.loginSupertrue();
        Thread.sleep(2000);
        SuperLogIn.isLoggedIn();
    }

    @Test()
    public void LoginWithInvalidCredentials() throws InterruptedException {
        LogInForm WrongCredentials = new LogInForm(driver);
        WrongCredentials.LogInFail();
        Thread.sleep(2000);
    }

    @Test()
     public  void loginWithInvalidUsernamevalidpass() throws InterruptedException {
        LogInForm invalidUsername=new LogInForm(driver);
        invalidUsername.isInitialized();
        invalidUsername.logincredentials("test", "stDevAdmin4crms");
        }

     @Test()
    public void loginWithValidUserNameInvalidPass() throws InterruptedException {
         LogInForm invalidPass = new LogInForm(driver);
         invalidPass.isInitialized();
         invalidPass.logincredentials("stdevadmin", "123456" );
     }

}



