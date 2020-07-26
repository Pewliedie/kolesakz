package kz.kolesa.searchWithPhoto;

import kz.kolesa.AbstractClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class SearchingResultPage extends AbstractClass {

    public SearchingResultPage(WebDriver driver) {
        super(driver);
    }

    public void dismissHint(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.kl-button.kl-button.js__tutorial-close")));
        driver.findElement(By.cssSelector("button.kl-button.kl-button.js__tutorial-close")).click();
    }

    public void checkPicture(){
        Assert.assertTrue(driver.findElement(
                By.xpath("//button[@class='gallery__main js__gallery-main']//picture//img")).isDisplayed());
    }
}
