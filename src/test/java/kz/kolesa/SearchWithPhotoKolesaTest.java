package kz.kolesa;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchWithPhotoKolesaTest extends ConfigurationClass {

    @Test(groups = {"UiTest"}, alwaysRun = true)
    public void searchWithPhoto(){

        driver.findElement(By.xpath("//div[@class='menu-container container']//li[1]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[4]//button")));

        driver.findElement(By.xpath("//li[4]//button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("year[from]")));

        driver.findElement(By.id("year[from]")).sendKeys("2020");

        driver.findElement(By.id("price[from]")).sendKeys("60000000");

        driver.findElement(By.xpath("//span[7]//span")).click();

        driver.findElement(By.xpath("//span[contains(text(),'BMW')]")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='_sys-hasphoto-checkbox-0']")));

        driver.findElement(By.xpath("//label[@for='_sys-hasphoto-checkbox-0']")).click();

        System.out.println(driver.findElement(By.xpath("//label[@for='_sys-hasphoto-checkbox-0']")).isEnabled());

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.label.js__search-form-submit-value")));

        driver.findElement(By.cssSelector("span.label.js__search-form-submit-value")).click();

        driver.findElement(By.xpath("//a[contains(text(),'BMW X6 M')]")).click();

        switchTab();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.kl-button.kl-button.js__tutorial-close")));

        driver.findElement(By.cssSelector("button.kl-button.kl-button.js__tutorial-close")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//button[@class='gallery__main js__gallery-main']//picture//img")).isDisplayed());
    }
}
