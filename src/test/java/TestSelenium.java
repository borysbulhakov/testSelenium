import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.GoogleSearchPageMain;

import java.net.MalformedURLException;

public class TestSelenium {

    static GoogleSearchPageMain googleMainPage = new GoogleSearchPageMain();


    @Test
    @Parameters(value={"browser"})
    public static void testGoogleSearch1(String browser) throws MalformedURLException {
        System.out.println("Open " + browser);
        WebDriver driver = TestDriverInitialize.initializeDriver(browser);
        driver.navigate().to(Constants.URL);
        Assert.assertEquals(driver.getTitle(), Constants.URL_MATCH);
        googleMainPage.textInput(driver, Constants.SEARCH_STRING_1);
        googleMainPage.clickSearch(driver);
        Assert.assertEquals(driver.getTitle(),
                Constants.SEARCH_PAGE_TITLE.replace("?", Constants.SEARCH_STRING_1));
        driver.quit();
    }
}

