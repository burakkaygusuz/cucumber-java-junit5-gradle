package com.google.tests.step_definitions;

import com.google.tests.pages.HomePage;
import com.google.tests.pages.SearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static com.google.tests.pages.HomePage.getHomePage;
import static com.google.tests.pages.SearchPage.getSearchPage;

public class SearchStepDefinitions {

    HomePage homePage = getHomePage();
    SearchPage searchPage = getSearchPage();

    @Given("I type {string} in searchBar")
    public void iTypeInSearchBar(String value) {
        homePage.typeInSearchBar(value);
    }

    @When("I clicked the search button")
    public void iClickedTheSearchButton() {
        homePage.submitGoogleSearchButton();
    }

    @Then("I should see the first listed result should be {string}")
    public void iShouldSeeTheFirstListedResultShouldBe(String text) {
        Assertions.assertTrue(searchPage.getFirstListedResultLinkText().startsWith(text));
    }
}
