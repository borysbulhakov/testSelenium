import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


public class TestDriverInitialize {

    private static WebDriver webDriver;


    public static WebDriver initializeDriver(String driverType) throws MalformedURLException {
        if (driverType.equalsIgnoreCase("chrome")) {
            ChromeOptions capability = new ChromeOptions();
            webDriver = new RemoteWebDriver(new URL("http://192.168.56.1:5556/wd/hub"), capability);
            return webDriver;
        } else {
            FirefoxOptions capability = new FirefoxOptions();
            webDriver = new RemoteWebDriver(new URL("http://192.168.56.1:5558/wd/hub"), capability);
            return webDriver;
        }
    }
}
