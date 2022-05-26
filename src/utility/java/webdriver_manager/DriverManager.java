package webdriver_manager;

import config.ConfigHolder;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromiumDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {

    public static final ThreadLocal<WebDriver> WEB_DRIVER_THREAD_LOCAL = ThreadLocal.withInitial(DriverManager::startBrowser);

    private static WebDriver startBrowser() {
        WebDriver driver = null;

        String browser = ConfigHolder.getBrowser();
        System.out.println(browser);

        if (browser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("start-maximized", "--disable-extensions", "--no-sandbox", "--disable-application-cache", "--disable-gpu", "--disable-dev-shm-usage");
            driver = new FirefoxDriver(options);
        } else if (browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("start-maximized");
            driver = new ChromeDriver(chromeOptions);
        }
            return driver;
    }

    public static WebDriver getDriver(){
        return WEB_DRIVER_THREAD_LOCAL.get();
    }
}
