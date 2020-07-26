package kz.kolesa.publishAdvertTest;

import kz.kolesa.AbstractClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ConfigurationAdPage extends AbstractClass {

    private static final String EMAIL = "qqq@com.com";
    private static final String PRICE = "10000000";

    public ConfigurationAdPage(WebDriver driver) {
        super(driver);
    }

    public void configureCategory(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body//option[1]")));
        driver.findElement(By.xpath("//body//option[1]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='category-parameter']//option[1]")));
        driver.findElement(By.xpath("//div[@id='category-parameter']//option[1]")).click();
    }

    public void configureMark(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Toyota')]")));
        driver.findElement(By.xpath("//div[contains(text(),'Toyota')]")).click();
    }

    public void configureModel(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Camry')]")));
        driver.findElement(By.xpath("//button[contains(text(),'Camry')]")).click();
    }

    public void configureYearModel(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'2015')]")));
        driver.findElement(By.xpath("//label[contains(text(),'2015')]")).click();
    }

    public void configureEngineType(){
        ((JavascriptExecutor) driver).executeScript("scroll(0,300)");
        driver.findElement(By.xpath("//div[@class='a-form__input-group']//li[1]//label")).click();
    }

    public void configureModification(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[2]//label[1]//div")));
        driver.findElement(By.xpath("//li[2]//label[1]//div")).click();
    }

    public void fillPrice(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='ui-input a-form__price']")));
        driver.findElement(By.xpath("//label[@class='ui-input a-form__price']")).sendKeys(PRICE);
    }

    public void configureCity(){
        driver.findElement(By.xpath("//input[@placeholder='Выберите']")).click();
        driver.findElement(By.xpath("//ul/li[contains(.,'Караганда')]")).click();
    }

    public void fillEmail(){
        driver.findElement(By.xpath("//label[@class='ui-input a-form__email']")).sendKeys(EMAIL);
    }

    public void returnToMainPage(){
        driver.findElement(By.xpath("//a[@class='header-logo']//img")).click();
    }

    public void configureAdvert() {
        configureCategory();
        configureMark();
        configureModel();
        configureYearModel();
        configureEngineType();
        configureModification();
        fillPrice();
        configureCity();
        fillEmail();
    }

    public void postAd(){
        driver.findElement(By.xpath("//a[@class='link a-action-link']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-button--blue")));
        driver.findElement(By.cssSelector(".ui-button--blue")).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ui-button--shadow")));
        driver.findElement(By.cssSelector(".ui-button--shadow")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Подать без продвижения')]")));
        driver.findElement(By.xpath("//div[contains(text(),'Подать без продвижения')]")).click();
        softAssertion.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Объявление отправлено на проверку!", "Advert is not posted");
    }
}
