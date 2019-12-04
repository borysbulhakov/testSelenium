package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchPageMain {
    static By searchFieldLocator = By.name("q");
    static By searchButtonLocator = By.cssSelector(".aajZCb .gNO89b");


    public static void textInput(WebDriver webDriver, String searchString) {
        System.out.println("Input string" + searchString + " in main google page search field");
        WebElement searchElementName = webDriver.findElement(searchFieldLocator);
        searchElementName.sendKeys(searchString);
    }

    public static void clickSearch(WebDriver webDriver) {
        System.out.println("Click search button in main google page");
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        WebElement searchElementButton = webDriver.findElement
                (searchButtonLocator);
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (searchButtonLocator));
        searchElementButton.click();
    }
}
