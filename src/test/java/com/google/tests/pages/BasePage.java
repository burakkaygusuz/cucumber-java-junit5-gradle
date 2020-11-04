package com.google.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.google.tests.config.DriverFactory.getWebDriverWait;

public class BasePage {

    private final WebDriverWait wait = getWebDriverWait();

    private BasePage() {
    }

    public static BasePage getPage() {
        return new BasePage();
    }

    public BasePage click(By locator) {
        findElementByLocator(locator).click();
        return this;
    }

    public BasePage clearAndType(By locator, String text) {
        findElementByLocator(locator).clear();
        findElementByLocator(locator).sendKeys(text);
        return this;
    }

    public String getText(By locator) {
        return findElementByLocator(locator).getText();
    }

    private WebElement findElementByLocator(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}
