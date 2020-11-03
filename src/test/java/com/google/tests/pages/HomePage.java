package com.google.tests.pages;

import com.google.tests.locators.HomePageLocators;

import static com.google.tests.pages.BasePage.getPage;

public class HomePage {

    private final BasePage page = getPage();

    private HomePage() {
    }

    public static HomePage getHomePage() {
        return new HomePage();
    }

    public void typeInSearchBar(String item) {
        page.clearAndType(HomePageLocators.SEARCH_BAR, item);
    }

    public void submitGoogleSearchButton() {
        page.submit(HomePageLocators.GOOGLE_SEARCH_BUTTON);
    }
}
