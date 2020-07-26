package kz.kolesa.searchWithPhoto;

import kz.kolesa.AbstractClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends AbstractClass {

    private static final String PRICE = "60000000";
    private static final String YEAR_MoDEL = "2020";

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public void openAutoSection() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='menu-container container']//li[1]")));
        driver.findElement(By.xpath("//div[@class='menu-container container']//li[1]")).click();
    }

    public void chooseCity() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[4]//button")));
        driver.findElement(By.xpath("//li[4]//button")).click();
    }

    public void fillYearModel(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("year[from]")));
        driver.findElement(By.id("year[from]")).sendKeys("2020");
    }

    public void fillPrice() {
        driver.findElement(By.id("price[from]")).sendKeys(PRICE);
    }

    public void configureMark(){
        driver.findElement(By.xpath("//span[7]//span")).click();
        driver.findElement(By.xpath("//span[contains(text(),'BMW')]")).click();
    }

    public void withPhoto(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='_sys-hasphoto-checkbox-0']")));
        driver.findElement(By.xpath("//label[@for='_sys-hasphoto-checkbox-0']")).click();
    }

    public void clickSearchButton(){
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.label.js__search-form-submit-value")));
        driver.findElement(By.cssSelector("span.label.js__search-form-submit-value")).click();
    }

    public void openFoundResult(){
        driver.findElement(By.xpath("//a[contains(text(),'BMW X6 M')]")).click();
        switchTab();
    }
}
