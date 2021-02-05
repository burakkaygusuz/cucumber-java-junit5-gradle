package com.burakkaygusuz.tests.pages;

import com.burakkaygusuz.tests.config.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {

    private final WebDriverWait wait = DriverFactory.getWebDriverWait();
    private final Logger log = LoggerFactory.getLogger(BasePage.class.getName());

    private BasePage() {
    }

    public static BasePage getPage() {
        return new BasePage();
    }

    public BasePage click(By locator) {
        WebElement element = findElementByLocator(locator);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        log.info(String.format("The web element that has locator '%s' has been clicked", locator));
        return this;
    }

    public BasePage clearAndType(By locator, String text) {
        findElementByLocator(locator).clear();
        log.info(String.format("The web element that has locator: '%s' has been cleared", locator));
        findElementByLocator(locator).sendKeys(text);
        log.info(String.format("'%s' has been written in the web element that has locator: '%s'", text, locator));
        return this;
    }

    public String getText(By locator) {
        String text = findElementByLocator(locator).getText();
        log.info(String.format("Received text is: '%s'", text));
        return text;
    }

    private WebElement findElementByLocator(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}
