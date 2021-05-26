@SmokeTest

Feature: Admin Console New User & Session Verification

  Scenario: AdminConsole New User Verification -3270 session
  Given I launch the browser for AdminConsole
  #When I enter the invalid credentials and verify the error message for Adminconsole
  And I enter the credentials and verify the access for Adminconsole
 # Then I verify the  title of adminconsole
  And I expand the ribbon bar for AdminConsole
   And I varify the options for AdminConsole
   When I click on All Users tab
  And I click on New User Icon and validate the details
  And I click on 3 dots in New User
  And verify the 3 dots options in New User and click Session Tab
  And I click on 3270 sessions tab and validate the options
  Then I verify the session is displayed or not for 3270
  
  Scenario: AdminConsole New User Verification -5250 session
  Given I launch the browser for AdminConsole
  #When I enter the invalid credentials and verify the error message for Adminconsole
  And I enter the credentials and verify the access for Adminconsole
 # Then I verify the  title of adminconsole
  And I expand the ribbon bar for AdminConsole
   When I click on All Users tab
 # And I click on New User Icon and validate the details
  And I click on 3 dots in New User
  And verify the 3 dots options in New User and click Session Tab
  And I click on sessions tab and validate the options for 5250
   Then I verify the session is displayed or not for 5250
   #And right click on the 5250 session and start sesson
    