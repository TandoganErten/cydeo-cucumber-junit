Feature: Vytrack app login with different roles

  Scenario: login as driver
    Given user is on the login page
    When user enters driver credentials
    Then user should see driver navigation options


  Scenario: login as sales manage or store manager
    Given user is on the login page
    When user enters "role" information
    Then user should see manager navigation options