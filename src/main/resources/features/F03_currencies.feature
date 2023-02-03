Feature: F03_currencies.feature|user should be able to change currencies

  Scenario: user changes currency to euro
    When  user Select Euro currency from the dropdown list on the top left of home page
   Then currency changes for the product shown in the page