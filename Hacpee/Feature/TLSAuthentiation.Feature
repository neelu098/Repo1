
@SmokeTest

Feature: TLS Authentication Verification


Scenario: TLS Authentication Verification - postive 3270 session
  Given I launch the browser for TLS Authentication
  Then right click on the session and verify the properties for TLS Auth
  And I click on 3270 Session
  When click on the choose file and select the Certificate from Local machine
  And I enter the password for TLS auth
  Then I click on the Ok button
  And I click on Navigation Bar
	Then click on Settings icon
	And I click on Preferences tab
	And I select display status bar 
	And I click on Save button
  And I verify the session connectivity
    
 Scenario: TLS Authentication Verification -Negative 3270 session
  Given I launch the browser for TLS Authentication
  Then right click on the session and verify the properties for TLS Auth
  And I click on 3270 Session
  When click on the choose file and select the wrong Certificate from Local machine
  And I enter the password for TLS auth
  Then I click on the Ok button
  Then the session is not connected for TLS auth  
  
 Scenario: TLS Authentication Verification -5250 session
   Given I launch the browser for TLS Authentication
  Then right click on the 5250 session and verify the properties for TLS Auth
  And I click on 5250 Session
  When click on the choose file and select the Certificate for 5250 session
  And I enter the password for TLS auth
  Then I click on the Ok button
  And I click on Navigation Bar
	Then click on Settings icon
	And I click on Preferences tab
	And I select display status bar 
	And I click on Save button
  And I verify the session connectivity
  
  Scenario: TLS Authentication Verification -Negative 5250 session
  Given I launch the browser for TLS Authentication
 Then right click on the 5250 session and verify the properties for TLS Auth
  And I click on 5250 Session
  When click on the choose file and select the wrong Certificate for 5250 session
  And I enter the password for TLS auth
  Then I click on the Ok button
  Then the session is not connected for TLS auth    