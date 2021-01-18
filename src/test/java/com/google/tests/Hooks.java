package com.google.tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static com.google.tests.config.DriverFactory.getChromeDriver;
import static com.google.tests.config.DriverFactory.getWebDriverWait;

public class Hooks {

    public WebDriver driver = null;
    public WebDriverWait wait = null;

    private final Logger log = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void beforeScenario(Scenario scenario) {
        driver = getChromeDriver();
        wait = getWebDriverWait();

        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        log.info("WebDriver initialized");
        log.info("Scenario Names : " + scenario.getName());
        log.info("Tag(s)         : " + scenario.getSourceTagNames());
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

        log.info("Scenario status : " + scenario.getStatus());
        log.info("WebDriver closed");
    }
}
