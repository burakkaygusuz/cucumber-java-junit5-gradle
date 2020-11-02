package com.google.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.google.tests.config.DriverFactory.getChromeDriver;

public class HomePage {

    private final WebDriver driver = getChromeDriver();

    @FindBy(name = "q")
    private WebElement searchBar;

    @FindBy(name = "btnK")
    private WebElement googleSearchButton;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public static HomePage getHomePage() {
        return new HomePage();
    }

    public void typeInSearchBar(String item) {
        searchBar.sendKeys(item);
    }

    public void submitGoogleSearchButton() {
        googleSearchButton.submit();
    }
}
