@SmokeTest
Feature: AdminConsole Account Tab Verification 
 
   Scenario: AdminConsole Account Tab Verification
  Given I launch the browser for AdminConsole
 # When I enter the invalid credentials and verify the error message for Adminconsole
  And I enter the credentials and verify the access for Adminconsole
  And I expand the ribbon bar for AdminConsole
 # And I varify the options for AdminConsole
  And I click on Preferences Settings tab and varify account tab functionalities