Feature: To Search For A KeyWord in Different Search Engines And Compare The Results

  @upwork
  Scenario:Parse The Search Results From Google and ASK Search Engine and compare the search results
    Given user navigates to "https://www.google.com/"
    When user searches using the keyWord
    And user clicks on enter tab from keyboard
    Then user is able to see the search results for the keyWord
    And user navigates to "https://www.ask.com/"
    When user searches for the keyWord
    And user clicks on enter
    Then user is able to see the  results for the keyWord
    And then the result is compared between both the search engines
