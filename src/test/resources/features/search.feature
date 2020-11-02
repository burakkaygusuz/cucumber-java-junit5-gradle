Feature: Google
  Scenario: Search Algorithms
    Given I type "Cucumber" in searchBar
    When I clicked the search button
    Then I should see the first listed result should be "Cucumber: BDD Testing"

