package kz.kolesa;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;


public abstract class ConfigurationClass {

    protected WebDriver driver;
    WebDriverWait wait;


    @BeforeClass(groups = {"UiTest"})
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "A:\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 15);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
    }

    public boolean isAlertPresent() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().dismiss();
            return true;
        } catch (NoAlertPresentException Ex) {
            return false;
        }
    }

    @AfterClass(groups = {"UiTest"})
    public void close() {
        driver.quit();
    }
}
