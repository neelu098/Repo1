@SmokeTest
Feature: Session Connectivity Verification 
 
 Scenario: Smoke Test for Session Connectivity -Postive scenario -3270
    Given I launch browser and enter the url   
   Then I click on 3270 Session
   And I verify the session connectivity
    
   Scenario: Smoke Test for Session Connectivity -Nagative for 3270
    Given I launch browser and enter the url  
   Then right click on the session and go to properties
	   And I click on 3270 Session
    Then the session is not connected
    
     Scenario: Smoke Test for Session Connectivity -Postive scenario -5250
    Given I launch browser and enter the url     
    Then I click on 5250 Session
    And I verify the session connectivity for 5250
    
     Scenario: Smoke Test for Session Connectivity -Nagative for 5250
    Given I launch browser and enter the url  
   Then right click on the 5250 session and go to properties
	  Then I click on 5250 Session
    Then the session is not connected for 5250