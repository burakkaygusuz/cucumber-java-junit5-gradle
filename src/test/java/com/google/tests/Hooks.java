package com.google.tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static com.google.tests.config.DriverFactory.getChromeDriver;
import static com.google.tests.config.DriverFactory.getWebDriverWait;

public class Hooks {

    public WebDriver driver = null;
    public WebDriverWait wait = null;

    @Before
    public void beforeScenario(Scenario scenario) {
        driver = getChromeDriver();
        wait = getWebDriverWait();

        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
