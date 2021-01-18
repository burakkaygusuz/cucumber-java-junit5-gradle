package com.google.tests.pages;

import com.google.tests.locators.SearchPageLocators;

import static com.google.tests.pages.BasePage.getPage;

public class SearchPage {

    private final BasePage page = getPage();

    private SearchPage() {
    }

    public static SearchPage getSearchPage() {
        return new SearchPage();
    }

    public String getFirstListedResultLinkText() {
        return page.getText(SearchPageLocators.FIRST_LISTED_RESULT);
    }
}
