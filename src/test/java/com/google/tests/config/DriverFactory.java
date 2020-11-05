package com.google.tests.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverFactory {

    private static WebDriver driver;
    private static WebDriverWait wait;

    public static WebDriver getChromeDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();

            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            Logger.getLogger("org.openqa.selenium").setLevel(Level.SEVERE);

            ChromeOptions options = new ChromeOptions();
            options.addArguments("enable-automation");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-gpu");
            options.setHeadless(true);
            options.setAcceptInsecureCerts(true);
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static WebDriverWait getWebDriverWait() {
        if (wait == null) wait = new WebDriverWait(getChromeDriver(), Duration.ofSeconds(30));
        return wait;
    }
}
