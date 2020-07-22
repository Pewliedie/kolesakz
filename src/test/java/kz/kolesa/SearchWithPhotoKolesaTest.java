package kz.kolesa;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class SearchWithPhotoKolesaTest extends ConfigurationClass {

    @Test
    public void searchWithPhoto() {
        driver.manage().window().maximize();

        driver.get("https://kolesa.kz/");

        WebDriverWait wait = new WebDriverWait(driver, 15);

        driver.findElement(By.xpath("//div[@class='menu-container container']//li[1]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[4]//button")));

        driver.findElement(By.xpath("//li[4]//button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("year[from]")));

        driver.findElement(By.id("year[from]")).sendKeys("2020");

        driver.findElement(By.id("price[from]")).sendKeys("60000000");

        driver.findElement(By.xpath("//span[7]//span")).click();

        driver.findElement(By.xpath("//span[contains(text(),'BMW')]")).click();

        driver.findElement(By.xpath("//label[@for='_sys-hasphoto-checkbox-0']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.label.js__search-form-submit-value")));

        driver.findElement(By.cssSelector("span.label.js__search-form-submit-value")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='results']//picture")).isDisplayed());

        driver.findElement(By.xpath("//a[contains(text(),'BMW X6 M')]")).click();

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.kl-button.kl-button.js__tutorial-close")));

        driver.findElement(By.cssSelector("button.kl-button.kl-button.js__tutorial-close")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//button[@class='gallery__main js__gallery-main']//picture//img")).isDisplayed());

    }
}
