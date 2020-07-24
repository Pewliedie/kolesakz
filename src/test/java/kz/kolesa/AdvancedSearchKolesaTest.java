package kz.kolesa;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class AdvancedSearchKolesaTest extends ConfigurationClass {

    private static final String PRICE = "110_000_000";
    private static final String BODY_TYPE = "седан";
    private static final String DRIVE_UNIT = "полный привод";
    private static final String ENGINE_VOLUME = "6.7 (бензин)";
    private static final String LOCATION_OF_WHEEL = "слева";

    @Test(groups = {"UiTest"}, alwaysRun = true)
    public void advancedSearch() {

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

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.kl-button.kl-button.js__tutorial-close")));

        driver.findElement(By.cssSelector("button.kl-button.kl-button.js__tutorial-close")).click();

        //Assert parameters
        softAssertion.assertEquals(driver.findElement(By.xpath("//dl[2]//dd")).getText(), BODY_TYPE, "parameter is not matching");
        softAssertion.assertEquals(driver.findElement(By.xpath("//dl[3]//dd")).getText(), ENGINE_VOLUME, "parameter is not matching");
        softAssertion.assertEquals(driver.findElement(By.xpath("//dl[6]/dd")).getText(), LOCATION_OF_WHEEL, "parameter is not matching");
        softAssertion.assertEquals(driver.findElement(By.xpath("//dl[8]//dd")).getText(), DRIVE_UNIT, "parameter is not matching");
        softAssertion.assertAll();
    }
}
