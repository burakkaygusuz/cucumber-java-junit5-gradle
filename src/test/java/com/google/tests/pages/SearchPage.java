package com.google.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.google.tests.config.DriverFactory.getChromeDriver;

public class SearchPage{

    private final WebDriver driver = getChromeDriver();

    @FindBy(xpath = "//*[@id='rso']/div[1]/div/div[1]/a/h3/span")
    private WebElement firstListedResult;

    public SearchPage() {
        PageFactory.initElements(driver, this);
    }

    public static SearchPage getSearchPage() {
        return new SearchPage();
    }

    public String getFirstListedResultLinkText(){
        return firstListedResult.getText();
    }
}
