@SmokeTest
Feature: Setting Panel GUI Verification
Scenario: Verify the GUI functionalities for Settingpanel
    Given I launch browser and enter the url 
    Then I click on 3270 Session
    And I click on Navigation Bar
	  Then click on Settings icon
	  #And Verify the all fields in Setting panel