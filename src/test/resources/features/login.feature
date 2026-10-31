Feature: Login Page Feature for SauceDemo Application

  Scenario: Login page title verification
    Given user is on login page
    When user gets the title of the page
    Then page title should be "Swag Labs"

  Scenario: Login with valid credentials
    Given user is on login page
    When user enters username "standard_user"
    And user enters password "secret_sauce"
    And user clicks on Login button
    Then user should be navigated to products page