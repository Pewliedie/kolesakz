package kz.kolesa.publishAdvertTest;

import kz.kolesa.AbstractClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoggedAccountPage extends AbstractClass {

    public LoggedAccountPage(WebDriver driver) {
        super(driver);
    }

    public void configureAd(){
        driver.findElement(By.xpath("//a[@class='btn btn-primary a-new-btn js__add-new']")).click();
    }


    public void checkAd(){
        getDriver().findElement(By.xpath("//span[@class='header-menu-dropdown__toggler-label']")).click();
        getDriver().findElement(By.xpath("//li[@class='header-menu__list-item']//li[2]")).click();

        softAssertion.assertEquals(driver.findElement(
                By.xpath("//span[@class='total-nb']")).getText(), "1 объявление", "Advert is not posted");
    }

    public void logOut(){
        driver.findElement(By.xpath("//span[@class='header-menu-dropdown__toggler-label']")).click();
        driver.findElement(By.xpath("//a[@class='header-menu-dropdown__menu-link logout-link']")).click();
        softAssertion.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Личный кабинет')]")).getText(), "Личный кабинет", "Not logged out");
        softAssertion.assertAll();
    }
}
