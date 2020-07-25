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


    public void configureSearch() {
        driver.findElement(By.xpath("//div[@class='menu-container container']//li[1]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[1]//button")));

        driver.findElement(By.xpath("//li[1]//button")).click();

        driver.findElement(By.id("price[from]")).sendKeys(PRICE);

        driver.findElement(By.cssSelector("button.set-optional span.label")).click();

        driver.findElement(By.cssSelector("div.element-group.element-group-parameter-mark-country")).click();

        driver.findElement(By.xpath("//li[contains(.,'Англия')]")).click();

        driver.findElement(By.cssSelector("div.element-group.element-group-parameter-auto-emergency")).click();

        driver.findElement(By.xpath("//li[contains(.,'На ходу')]")).click();

        driver.findElement(By.cssSelector("div.element-group.element-group-parameter-auto-car-body")).click();

        driver.findElement(By.xpath("//li[contains(.,'седан')]")).click();

        driver.findElement(By.cssSelector("div.element-group.element-group-parameter-auto-fuel")).click();

        driver.findElement(By.xpath("//li[contains(.,'бензин')]")).click();

        driver.findElement(By.cssSelector("div.element-group.element-group-parameter-auto-sweel")).click();

        driver.findElement(By.xpath("//li[contains(.,'слева')]")).click();

        driver.findElement(By.cssSelector("div.element-group.element-group-parameter-car-dwheel")).click();

        driver.findElement(By.xpath("//li[contains(.,'полный привод')]")).click();


        driver.findElement(By.cssSelector("#auto-car-volume\\[from\\]")).sendKeys("6.5");
        driver.findElement(By.cssSelector("#auto-car-volume\\[to\\]")).sendKeys("6.7");

        driver.findElement(By.cssSelector("button.primary-button")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Rolls-Royce Ghost')]")));

        driver.findElement(By.xpath("//a[contains(text(),'Rolls-Royce Ghost')]")).click();

        switchTab();
    }
}
