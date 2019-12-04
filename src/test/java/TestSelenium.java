import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObject.GoogleSearchPageMain;

public class TestSelenium {

    static WebDriver driver;
    static GoogleSearchPageMain googleMainPage = new GoogleSearchPageMain();

    @Test
    public static void testGoogleSearch1() {
        driver = TestDriverInitialize.initializeDriver("Chrome");
        Assert.assertEquals(driver.getTitle(), Constants.URL_MATCH);
        googleMainPage.textInput(driver, Constants.SEARCH_STRING_1);
        googleMainPage.clickSearch(driver);
        Assert.assertEquals(driver.getTitle(),
                Constants.SEARCH_STRING_1 + " - Поиск в Google");
    }

    @Test
    public static void testGoogleSearch2() {
        driver = TestDriverInitialize.initializeDriver("Firefox");
        Assert.assertEquals(driver.getTitle(), Constants.URL_MATCH);
        googleMainPage.textInput(driver, Constants.SEARCH_STRING_1);
        googleMainPage.clickSearch(driver);
        Assert.assertEquals(driver.getTitle(),
                Constants.SEARCH_STRING_1 + " - Поиск в Google");
    }

    @AfterMethod
    public static void closeBrowser() {
        driver.close();
    }
}

