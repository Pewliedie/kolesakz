package kz.kolesa.uiTest;

import kz.kolesa.advancedSearch.HomePageAdvancedSearch;
import kz.kolesa.advancedSearch.SearchResultPage;
import kz.kolesa.ConfigProp;
import kz.kolesa.publishAdvertTest.*;
import kz.kolesa.searchWithPhoto.BasePage;
import kz.kolesa.searchWithPhoto.SearchingResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class KolesaTest {

    protected WebDriver driver;

    @BeforeMethod(groups = {"UiTest"})
    protected void setUp() {
        System.setProperty("webdriver.chrome.driver", ConfigProp.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigProp.getProperty("homepage"));
    }


    @Test(groups = {"UiTest"})
    public void publishAdvertTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openLogInPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn();

        LoggedAccountPage loggedAccountPage = new LoggedAccountPage(driver);
        loggedAccountPage.configureAd();

        ConfigurationAdPage configurationAdPage = new ConfigurationAdPage(driver);
        configurationAdPage.configure();

        homePage.checkDraft();
        configurationAdPage.postAd();
        loggedAccountPage.checkAd();
        loggedAccountPage.logOut();
    }

    @Test(groups = {"UiTest"})
    public void advancedSearchTest(){
        HomePageAdvancedSearch homePage = new HomePageAdvancedSearch(driver);
        homePage.configureSearch();
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.AssertParameters();
    }

    @Test(groups = {"UiTest"})
    public void searchWithPhotoTest(){
        BasePage basePage = new BasePage(driver);
        basePage.configureSearch();
        SearchingResultPage searchResultPage = new SearchingResultPage(driver);
        searchResultPage.checkPicture();
    }

    @AfterMethod(groups = {"UiTest"})
    protected void close() {
        driver.quit();
    }
}
