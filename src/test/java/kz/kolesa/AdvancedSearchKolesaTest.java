package kz.kolesa;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class AdvancedSearchKolesaTest extends ConfigurationClass {

    @Test
    public void advancedSearch() {
        driver.manage().window().setSize(new Dimension(1920, 1080));

        driver.get("https://kolesa.kz/");

        WebDriverWait wait = new WebDriverWait(driver, 15);

        driver.findElement(By.xpath("//div[@class='menu-container container']//li[1]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[1]//button")));

        driver.findElement(By.xpath("//li[1]//button")).click();

        driver.findElement(By.id("price[from]")).sendKeys("110_000_000");

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

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.kl-button.kl-button.js__tutorial-close")));

        driver.findElement(By.cssSelector("button.kl-button.kl-button.js__tutorial-close"));

        Assert.assertTrue(driver.findElement(By.xpath("//dl[8][contains(.,'полный привод')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//dl[2][contains(.,'седан')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//dd[contains(.,'6.7')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//dl[6][contains(.,'слева')]")).isDisplayed());

    }
}
