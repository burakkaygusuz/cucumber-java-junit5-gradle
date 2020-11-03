package com.google.tests.locators;

import org.openqa.selenium.By;

public interface SearchPageLocators {
    By FIRST_LISTED_RESULT = By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/a/h3/span");
}
