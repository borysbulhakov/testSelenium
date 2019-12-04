import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObject.GoogleSearchPageMain;

import java.net.MalformedURLException;

public class TestSelenium {

    static WebDriver driver;
    static GoogleSearchPageMain googleMainPage = new GoogleSearchPageMain();

    @Test
    public static void testGoogleSearch1() throws MalformedURLException {
        driver = TestDriverInitialize.initializeDriver("Chrome");
        driver.navigate().to(Constants.URL);
        Assert.assertEquals(driver.getTitle(), Constants.URL_MATCH);
        googleMainPage.textInput(driver, Constants.SEARCH_STRING_1);
        googleMainPage.clickSearch(driver);
        Assert.assertEquals(driver.getTitle(),
                Constants.SEARCH_PAGE_TITLE.replace("?", Constants.SEARCH_STRING_1));
    }

    @Test
    public static void testGoogleSearch2() throws MalformedURLException {
        driver = TestDriverInitialize.initializeDriver("Firefox");
        driver.navigate().to(Constants.URL);
        Assert.assertEquals(driver.getTitle(), Constants.URL_MATCH);
        googleMainPage.textInput(driver, Constants.SEARCH_STRING_1);
        googleMainPage.clickSearch(driver);
        Assert.assertEquals(driver.getTitle(),
                Constants.SEARCH_PAGE_TITLE.replace("?", Constants.SEARCH_STRING_1));
    }

    @AfterMethod
    public static void closeBrowser() {
        driver.close();
    }
}

