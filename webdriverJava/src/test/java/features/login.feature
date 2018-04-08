@goodLogin
Feature: The Login Page
As a returning customer
I want to login to the application
So that I can view my account balance

  Background: Given the user is on the login page

  Scenario: The user should be able to login with valid credentials

    When the user enters a valid username "username"
    When the user enters a valid password "password"
    Then user click login button
    And the user should be able to view account balance

  Scenario: The user should not be able to login with invalid credentials

    When the user enters invalid credentials
    Then the user should not be able to view account balance
    And the user should get an invalid login message
