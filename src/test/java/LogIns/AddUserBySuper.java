package LogIns;

import PageObject.LogInForm;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static java.lang.Thread.sleep;

public class AddUserBySuper {
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
        driver.quit();
    }


    @Test()
        public void AddDistrict () throws InterruptedException {

        String contain = "abcdefghijk123456";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(3);
        for (int i = 0; i < 4; i++) {
            sb.append(contain.charAt(rnd.nextInt(contain.length())));
        }
        String random = sb.toString();

        LogInForm LogInAsSuper = new LogInForm(driver);
        LogInAsSuper.loginSupertrue();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(.,'Add New Account')]")).click();
        driver.findElement(By.xpath("//h3[contains(.,'District Account')]")).isDisplayed();
        System.out.println("The form is opened");
        Thread.sleep(2000);

        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("window.scrollBy(0,700)", "");
        Thread.sleep(3000);
      /*  jse.executeScript("arguments[0].click();", driver.findElement(By.xpath("//input[@value='Save']"))); */

        driver.findElement(By.xpath("//div[@class='submitSect']/input[@value='Save']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(.,'Please select account name')]")).isDisplayed();

        driver.findElement(By.xpath("//span[contains(.,'Please select account name')]")).sendKeys(random+"DistrictSTdev");
        driver.findElement(By.xpath("//input[@value='Save']")).click();
        driver.findElement(By.xpath("//span[contains(.,'Please enter first name')]")).isDisplayed();
        driver.findElement(By.xpath("//input[@id='UserFirstName']")).sendKeys(random);
        driver.findElement(By.xpath("//input[@value='Save']")).click();
        driver.findElement(By.xpath("//span[contains(.,'Please enter last name')]")).isDisplayed();
        driver.findElement(By.xpath("//input[@id='UserLastName']")).sendKeys(random);
        driver.findElement(By.xpath("//input[@value='Save']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[contains(.,'Please enter E-mail address')]")).isDisplayed();
        driver.findElement(By.xpath("//input[@id='UserUsername']")).sendKeys("gayanestdev@gmail.com");
        driver.findElement(By.xpath("//input[@value='Save']")).click();
        driver.findElement(By.xpath("//span[contains(.,'This email address is already in use')]")).isDisplayed();
        driver.findElement(By.xpath("//input[@id='UserUsername']")).sendKeys(random+"mailinator.com");
        driver.findElement(By.xpath("//input[@value='Save']")).click();
        driver.findElement(By.xpath("//span[contains(.,'District successfully added')]")).isDisplayed();
        Thread.sleep(2000);












    }

    }





