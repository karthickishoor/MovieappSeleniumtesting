Feature: Login Functionality
  As a user of the movies website
  I want to be able to log in to my account
  So that I can access personalized features and watch movies

  Scenario: Successfull Login
    Given I am on the login page
    When I enter valid username and password
    And I click on login button
    Then I should be able to redirected to the homepage

  Scenario: Invalid Username
    Given I am on the login page
    When I enter Invalid username and I enter a valid password
    And I click on login button
    Then I should be able see a error message

  Scenario: Invalid Password
    Given I am on the login page
    When I enter valid username and I enter a Invalid password
    And I click on login button
    Then I should be able see a error message

  Scenario: Invalid username and Invalid Password
    Given I am on the login page
    When I enter Invalid username and I enter a Invalid password
    And I click on login button
    Then I should be able see a error message
