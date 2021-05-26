@Test

Feature: Prefence tab Verification

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
  
  