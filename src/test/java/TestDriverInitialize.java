import constants.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestDriverInitialize {

    private static WebDriver webDriver;


    public static WebDriver initializeDriver(String driverType) {
        if (driverType.equalsIgnoreCase("chrome")) {
            System.setProperty(Constants.DRIVER_C, Constants.DRIVER_CHROME);
            System.out.println("TEST chromedriver");
            webDriver = new ChromeDriver();
            webDriver.get(Constants.URL);
            return webDriver;
        } else {
            System.setProperty(Constants.DRIVER_F, Constants.DRIVER_FIREFOX);
            System.out.println("TEST geckodriver");
            webDriver = new FirefoxDriver();
            webDriver.get(Constants.URL);
            return webDriver;
        }
    }
}
