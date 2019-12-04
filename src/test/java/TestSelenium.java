import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObject.GoogleSearchPageMain;

import java.net.MalformedURLException;

public class TestSelenium {

    static WebDriver driverMOZ;
    static WebDriver driverCH;
    static GoogleSearchPageMain googleMainPage = new GoogleSearchPageMain();

    @BeforeTest
    public static void driversInnitialise() throws MalformedURLException {
        driverCH = TestDriverInitialize.initializeDriver("Chrome");
        driverMOZ = TestDriverInitialize.initializeDriver("Firefox");
    }

    @Test
    public static void testGoogleSearch1() throws MalformedURLException {

        driverCH.navigate().to(Constants.URL);
        driverMOZ.navigate().to(Constants.URL);

        Assert.assertEquals(driverCH.getTitle(), Constants.URL_MATCH);
        Assert.assertEquals(driverMOZ.getTitle(), Constants.URL_MATCH);

        googleMainPage.textInput(driverCH, Constants.SEARCH_STRING_1);
        googleMainPage.textInput(driverMOZ, Constants.SEARCH_STRING_1);

        googleMainPage.clickSearch(driverCH);
        googleMainPage.clickSearch(driverMOZ);

        Assert.assertEquals(driverCH.getTitle(),
                Constants.SEARCH_PAGE_TITLE.replace("?", Constants.SEARCH_STRING_1));
        Assert.assertEquals(driverMOZ.getTitle(),
                Constants.SEARCH_PAGE_TITLE.replace("?", Constants.SEARCH_STRING_1));
    }


    @AfterMethod
    public static void closeBrowser() {
        driverMOZ.close();
        driverCH.close();
    }
}

