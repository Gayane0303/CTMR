package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

import static java.lang.Thread.sleep;


public class LogInForm {

    WebDriver driver;


    @FindBy(xpath="//input[@id='UserUsername']")
    private WebElement UserName;

    @FindBy(xpath="//input[@id='UserPassword']")
    private WebElement Password;

    @FindBy(xpath="//input[@id='loginBtn']")
    private WebElement LoginButton;

    @FindBy (xpath="//span[contains(.,'Invalid username or password')]")
    private WebDriver LogInInvalidMessage;

    @FindBy (xpath="//i[@class='icon-home']")
    private WebElement HomeIcon;

    public void browser (){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://georgene:ofelie@v2fairygod.startupix.com/");
    }

    public void isInitialized() {
        LoginButton.isDisplayed();
    }

    public void isLoggedIn(){ HomeIcon.isDisplayed(); }

    public LogInForm(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void loginSupertrue() {
        this.UserName.click();
        this.UserName.sendKeys("stdevadmin");
        this.Password.sendKeys("stDevAdmin4crms");
        this.LoginButton.click();
    }

    public void LogInFail() throws InterruptedException {
        String contain = "abcdefghijk123456";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(4);
        for (int i = 0; i < 4; i++) {
            sb.append(contain.charAt(rnd.nextInt(contain.length())));
        }
        String random = sb.toString();
        this.UserName.sendKeys(random);
        this.Password.sendKeys(random);
        this.LoginButton.click();
        Thread.sleep(2000);
        boolean WrongUserPassDone = driver.findElement(By.xpath("//span[contains(.,'Invalid username or password')]")).isDisplayed();
        System.out.println(WrongUserPassDone);
        Thread.sleep(1000);
    }

        public void logincredentials(String username, String password) throws InterruptedException {

            UserName.sendKeys(username);
            Password.sendKeys(password);
            LoginButton.click();
            Thread.sleep(2000);
        }



      /*  this.UserName.clear();
        this.UserName.sendKeys("stdevadmin");
        this.Password.clear();
        this.Password.sendKeys("123456");
        this.LoginButton.click();
        Thread.sleep(2000);
        boolean WrongPassDone=driver.findElement(By.xpath("//span[contains(.,'Invalid username or password')]")).isDisplayed();
        System.out.println(WrongPassDone);
        this.UserName.clear();
        this.UserName.sendKeys(random);
        this.Password.clear();
        this.Password.sendKeys("stDevAdmin4crms");
        this.LoginButton.click();
        Thread.sleep(2000);
        boolean WrongUsernameDone=driver.findElement(By.xpath("//span[contains(.,'Invalid username or password')]")).isDisplayed();
        System.out.println(WrongUsernameDone);
        Thread.sleep(2000);

*/


    }



