package Constant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriver {

    private static WebDriver driver;

    public static WebDriver setUp() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            driver = new org.openqa.selenium.chrome.ChromeDriver(options);
        }
        return driver;
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


}
