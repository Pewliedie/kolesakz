package kz.kolesa;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;


public abstract class AbstractClass {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected SoftAssert softAssertion;

    public AbstractClass(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,15);
        softAssertion = new SoftAssert();
    }

    protected WebDriver getDriver() {
        return this.driver;
    }

    protected void switchTab(){
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }

    public void isAlertPresent() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException ignored) {
        }
    }
}
