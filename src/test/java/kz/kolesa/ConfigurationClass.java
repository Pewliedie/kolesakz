package kz.kolesa;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


public abstract class ConfigurationClass {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected SoftAssert softAssertion;

    @BeforeClass(groups = {"UiTest"})
    protected void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 15);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        softAssertion = new SoftAssert();
        maximizeWindow();
        initHomePage();
    }

    public void isAlertPresent() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException ignored) {
        }
    }

    protected void initHomePage(){
        driver.get("https://kolesa.kz/");
    }

    protected void maximizeWindow(){
        driver.manage().window().maximize();
    }

    protected void switchTab(){
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }

    @AfterClass(groups = {"UiTest"})
    protected void close() {
        driver.quit();
    }
}
