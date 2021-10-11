#

Feature: SauceLab Backpack

  @Jacket
  Scenario: Login to Sauce Lab
    Given I am on SauceLabs login page
    When I enter username "standard_user"
    And I enter password "secret_sauce"
    When I click on login button
    Then I am taken to SauceLabs Home Page


  @Jacket
  Scenario: Selecting SauceLab Jacket
    Given I am on SauceLabs HomePage
    And Jacket is available on HomePage
    When I click on SauceLabs Jacket
    Then I am taken to Sauce Labs Jacket page
    And I close the browser