package com.burakkaygusuz.tests.pages;

import com.burakkaygusuz.tests.locators.HomePageLocators;

import static com.burakkaygusuz.tests.pages.BasePage.getPage;

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
        page.click(HomePageLocators.GOOGLE_SEARCH_BUTTON);
    }
}
