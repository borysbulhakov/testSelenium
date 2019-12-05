import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.GoogleSearchPageMain;

import java.net.MalformedURLException;

public class TestSelenium {

    static WebDriver driver;
    static GoogleSearchPageMain googleMainPage = new GoogleSearchPageMain();

    @BeforeTest
    @Parameters(value={"browser"})
    public static void driversInnitialise(String browser) throws MalformedURLException {
        driver = TestDriverInitialize.initializeDriver(browser);
    }

    @Test
    public static void testGoogleSearch1() {
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

