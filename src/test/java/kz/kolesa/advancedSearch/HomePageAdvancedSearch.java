package kz.kolesa.advancedSearch;

import kz.kolesa.AbstractClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePageAdvancedSearch extends AbstractClass {

    private static final String PRICE = "110_000_000";

    public HomePageAdvancedSearch(WebDriver driver) {
        super(driver);
    }

    public void openAutoSection() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='menu-container container']//li[1]")));
        driver.findElement(By.xpath("//div[@class='menu-container container']//li[1]")).click();
    }

    public void chooseCity() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[1]//button")));
        driver.findElement(By.xpath("//li[1]//button")).click();
    }

    public void fillPrice() {
        driver.findElement(By.id("price[from]")).sendKeys(PRICE);
    }

    public void openAdvancedSearch() {
        driver.findElement(By.cssSelector("button.set-optional span.label")).click();
    }

    public void configureCountry() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.element-group.element-group-parameter-mark-country")));
        driver.findElement(By.cssSelector("div.element-group.element-group-parameter-mark-country")).click();
        driver.findElement(By.xpath("//li[contains(.,'Англия')]")).click();
    }

    public void configureCarStatus() {
        driver.findElement(By.cssSelector("div.element-group.element-group-parameter-auto-emergency")).click();
        driver.findElement(By.xpath("//li[contains(.,'На ходу')]")).click();
    }

    public void configureBodyType() {
        driver.findElement(By.cssSelector("div.element-group.element-group-parameter-auto-car-body")).click();
        driver.findElement(By.xpath("//li[contains(.,'внедорожник')]")).click();
    }

    public void configureEngineType() {
        driver.findElement(By.cssSelector("div.element-group.element-group-parameter-auto-fuel")).click();
        driver.findElement(By.xpath("//li[contains(.,'бензин')]")).click();
    }

    public void configureLocationWheel() {
        driver.findElement(By.cssSelector("div.element-group.element-group-parameter-auto-sweel")).click();
        driver.findElement(By.xpath("//li[contains(.,'слева')]")).click();
    }

    public void configureDriveUnit() {
        driver.findElement(By.cssSelector("div.element-group.element-group-parameter-car-dwheel")).click();
        driver.findElement(By.xpath("//li[contains(.,'полный привод')]")).click();
    }

    public void configureEngineVolume() {
        driver.findElement(By.cssSelector("#auto-car-volume\\[from\\]")).sendKeys("6.5");
        driver.findElement(By.cssSelector("#auto-car-volume\\[to\\]")).sendKeys("6.7");
    }

    public void clickSearchButton() {
        driver.findElement(By.cssSelector("button.primary-button")).click();
    }

    public void openFoundResult() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Rolls-Royce Cullinan')]")));
        driver.findElement(By.xpath("//a[contains(text(),'Rolls-Royce Cullinan')]")).click();
        switchTab();
    }
}
