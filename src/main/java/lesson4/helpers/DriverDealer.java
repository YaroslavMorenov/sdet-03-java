package lesson4.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverDealer {
    private WebDriver driver;
    private static DriverDealer instance;

    public WebDriver createDriver() {
        if(this.driver != null) {
            return driver;
        }
        String browser = AppProperties.getProperty("browser");
        String time = AppProperties.getProperty("timeout");
        switch(browser) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver","C:/Users/Yaroslav.Morenov/Desktop/chromedriver.exe");
                System.setProperty("webdriver.chrome.driver",AppProperties.getProperty("chromepath"));
                driver = new ChromeDriver();
                break;
            case "Firefox":
                System.setProperty("webdriver.gecko.driver",AppProperties.getProperty("firefoxpath"));
                driver = new FirefoxDriver();
                break;
            default:
                driver = null;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(time),TimeUnit.SECONDS);
        driver.get(AppProperties.getProperty("loginpage"));
        return driver;
    }

    public static DriverDealer getInstance() {
        if(instance == null) {
            instance = new DriverDealer();
        }
        return instance;
    }

    public void closeDriver() {
        this.driver.close();
    }

    public void quitDriver() {
       this.driver.quit();
    }
}
