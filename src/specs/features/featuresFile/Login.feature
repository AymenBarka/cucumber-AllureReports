@Login
Feature: Login

  Background: 
    Given I am on the login page

  @valid-credentials
  Scenario: Login with valid credentials
    When I enter the email and password
    And I click the login button
    Then Page Title should be Cogemento

  @invalid-credentials
  Scenario Outline: Login with invalid credentials
    When I enter the email "<email>" and password "<password>"
    And I click the login button
    Then I should see an error message

    Examples: 
      | email                   | password          |
      | adminxxxx@yourstore.com | admin             |
      | admin@yourstore.com     | incorrectpassword |
