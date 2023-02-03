@smoke
Feature: F01_register| guest user could create new account
  it does what it does
  #pos scenario
  Scenario: user create new account using valid user name and email and password
    Given user go to register page
    When user selects gender type
    And user enters "automation" & "tester"
    And user selects date of birth
    And user enters email
    And users enters passowrd "zebyalso8yer" and confirms it
    And user clicks on register button
    Then account is created succesfuly

