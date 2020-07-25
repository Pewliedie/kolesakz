package kz.kolesa.publishAdvertTest;

import kz.kolesa.AbstractClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractClass {


    private static final String PHONE_NUMBER = "87021704773";
    private static final String PASSWORD = "qwerty123";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void logIn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        getDriver().findElement(By.id("login")).sendKeys(PHONE_NUMBER);
        getDriver().findElement(By.cssSelector(".form-item button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        getDriver().findElement(By.id("password")).sendKeys(PASSWORD);
        getDriver().findElement(By.cssSelector(".form-item button")).click();
        isAlertPresent();
    }
}
