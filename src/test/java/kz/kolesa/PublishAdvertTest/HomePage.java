package kz.kolesa.PublishAdvertTest;

import kz.kolesa.AbstractClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends AbstractClass {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openLogInPage(){
        WebElement header = driver.findElement(By.xpath("//div[@class='kolesa-top-header container']"));
        header.findElement(By.xpath("//header//li[2]//a[1]//span")).click();
    }

    public void checkDraft(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='header-menu-dropdown__toggler-label']")));
        driver.findElement(By.xpath("//span[@class='header-menu-dropdown__toggler-label']")).click();
        driver.findElement(By.xpath("//li[@class='header-menu__list-item']//li[2]//a[1]")).click();
        driver.findElement(By.xpath("//li[3]//a[1]//span")).click();
        //Assert that advert presented in draft
        softAssertion.assertEquals(driver.findElement(By.xpath("//a[@class='link a-action-link']")).getText(),
                "Редактировать текст");
    }


}
