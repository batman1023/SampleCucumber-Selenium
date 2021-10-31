Feature: SauceLab Backpack
#
  @BackPack
  Scenario: Login to Sauce Lab
    Given I am on SauceLabs login page
    When I enter username "standard_user"
    And I enter password "secret_sauce"
    When I click on login button
    Then I am taken to SauceLabs Home Page


  @BackPack
  Scenario: Selecting SauceLab Backpack
    Given I am on SauceLabs HomePage
    And BackPage is available on HomePage
    When I click on SauceLabs BackPack
    Then I am taken to Sauce Labs Backpack page
    #And I close the browser
