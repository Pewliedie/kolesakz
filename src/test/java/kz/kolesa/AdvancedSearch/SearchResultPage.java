package kz.kolesa.AdvancedSearch;

import kz.kolesa.AbstractClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultPage extends AbstractClass {
    private static final String BODY_TYPE = "седан";
    private static final String DRIVE_UNIT = "полный привод";
    private static final String ENGINE_VOLUME = "6.7 (бензин)";
    private static final String LOCATION_OF_WHEEL = "слева";

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void AssertParameters(){
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
