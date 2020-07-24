package kz.kolesa.SearchWithPhoto;

import kz.kolesa.AbstractClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class SearchingResultPage extends AbstractClass {


    public SearchingResultPage(WebDriver driver) {
        super(driver);
    }

    public void checkPicture(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button.kl-button.kl-button.js__tutorial-close")));
        driver.findElement(By.cssSelector("button.kl-button.kl-button.js__tutorial-close")).click();
        Assert.assertTrue(driver.findElement(
                By.xpath("//button[@class='gallery__main js__gallery-main']//picture//img")).isDisplayed());
    }
}
