@smoke
Feature: F04_Search.feature |search feature functionality

  Scenario Outline:user could search using product name
    When user enters product "name" "<proname>"in the search bar
    And user clicks search button
    Then user is directed to search resault page
    Examples:
      | proname |
      | book    |
      | laptop  |
      | nike    |

  Scenario Outline:user could search using product sku
    When user enters product "serialno" "<sku>"in the search bar
    And user clicks search button
    Then user is directed to search resault page
    And user clicks on the earched item
    And user is directed to the required item with sku "<sku>"
    Examples:
      |   sku    |
      | SCI_FAITH|
      | APPLE_CAM|
      | SF_PRO_11|