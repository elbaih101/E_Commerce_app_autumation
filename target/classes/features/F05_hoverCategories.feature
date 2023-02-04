@smoke
Feature: F05_hoverCategories.feature | user when hovers on categories dynamic lists appear

  Scenario: users can hover over categories to show their sub lists and navigate to any list he desires
    When randomly selecting a category
    And select random sub category from the main one
    Then the subcategory page is navigated to