package kz.kolesa;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PublishAdvertKolesaTest extends ConfigurationClass {

    @Test(groups = {"UiTest"})
    public void publishAdTest() {
        driver.manage().window().maximize();

        driver.get("https://kolesa.kz/");

        WebElement header = driver.findElement(By.xpath("//div[@class='kolesa-top-header container']"));

        header.findElement(By.xpath("//header//li[2]//a[1]//span")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));

        driver.findElement(By.id("login")).sendKeys("+77711947916");

        driver.findElement(By.cssSelector(".form-item button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));

        driver.findElement(By.id("password")).sendKeys("qwerty123");

        driver.findElement(By.cssSelector(".form-item button")).click();

        isAlertPresent();

        Assert.assertTrue(driver.findElement(By.className("fi-arrow-mini")).isDisplayed());

        driver.findElement(By.cssSelector(".btn")).click();

        driver.findElement(By.xpath("//body//option[1]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='category-parameter']//option[1]")));

        driver.findElement(By.xpath("//div[@id='category-parameter']//option[1]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("a-columns__list")));

        driver.findElement(By.xpath("//div[contains(text(),'Toyota')]")).click();

        driver.findElement(By.xpath("//button[contains(text(),'Camry')]")).click();

        driver.findElement(By.xpath("//label[contains(text(),'2015')]")).click();

        driver.findElement(By.xpath("//div[@class='a-form__input-group']//li[1]//label")).click();

        driver.findElement(By.xpath("//li[2]//label[1]//div")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='ui-input a-form__price']")));

        driver.findElement(By.xpath("//label[@class='ui-input a-form__price']")).sendKeys("10_000_000");

        driver.findElement(By.xpath("//input[@placeholder='Выберите']")).click();

        driver.findElement(By.xpath("//ul/li[contains(.,'Караганда')]")).click();

        driver.findElement(By.xpath("//label[@class='ui-input a-form__email']")).sendKeys("wladyslaw.permyakov@gmail.com");

        driver.findElement(By.xpath("//a[@class='header-logo']//img")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='header-menu-dropdown__toggler-label']")));

        driver.findElement(By.xpath("//span[@class='header-menu-dropdown__toggler-label']")).click();

        driver.findElement(By.xpath("//li[@class='header-menu__list-item']//li[2]//a[1]")).click();

        driver.findElement(By.xpath("//li[3]//a[1]//span")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='a-info-added']")).isDisplayed());

        driver.findElement(By.xpath("//a[@class='link a-action-link']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-button--blue")));

        driver.findElement(By.cssSelector(".ui-button--blue")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ui-button--shadow")));

        driver.findElement(By.cssSelector(".ui-button--shadow")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Подать без продвижения')]")));

        driver.findElement(By.xpath("//div[contains(text(),'Подать без продвижения')]")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Объявление отправлено на проверку!')]")).isDisplayed());

        driver.findElement(By.xpath("//span[@class='header-menu-dropdown__toggler-label']")).click();

        driver.findElement(By.xpath("//li[@class='header-menu__list-item']//li[2]")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Toyota Camry')]")).isDisplayed());

        driver.findElement(By.xpath("//span[@class='header-menu-dropdown__toggler-label']")).click();

        driver.findElement(By.xpath("//a[@class='header-menu-dropdown__menu-link logout-link']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Личный кабинет')]")).isDisplayed());
    }
}
