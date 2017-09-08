Feature: Navigate to  https://www.healthdirect.gov.au and then search for a keyword in the header search in Home page
  and verify the search result

  Scenario: Navigate to Home page and search for Keyword and verify search result
    Given I navigate to HealthDriect Home Page
    Then I check the Title of the home
    Then I type "asthma" in Header Search
    And I verify the search results of keyword "asthma"
    And I close browser
