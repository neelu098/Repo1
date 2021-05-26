
@SmokeTest
Feature: HACPEE Smoke

 Scenario: Smoke Test for HACPEE
    Given I launch browser and enter the url   
    And I verify the build version details
    Then I connect to a session and verify the disconnect and reconnect options
    Then I click on 3270 Session
    And I close the session
    Then I verify the closed session
    Then I click on 3270 Session
    Then click on Home icon
    When click on Active session 
    Then Active session screen will appear
    And I maximize and minimize the connected session 
    #Then I expand the ribbon bar to verify the macro options
    And I click on Navigation Bar
	  Then click on Settings icon
	  And I click on all the options present in Settings ribbon bar
	  Then click on Home icon
	  Then right click on the session and go to properties and Verify the all fields in property panel 
#	  Then right click on the session and go to properties
#	  And I click and verify all the options present in the properties pannel
#	  And Verify the all fields from preferences tab are editable in session properties
#	  And I  Verify whether search field is editable in properties
#	  And I Verify the error message by entering invalid data in property panel  
	  Then I close the browser
	   
#	Scenario: Config Model Verification
  	Given I launch the browser and verify the login and logout from config model
  	Then I verify by accessing the pages with and without html
  	 Then I close the browser
	  
#	Scenario: Color Remap Verification
  #	Given I launch browser again and enter the url   
  #	Then I click on 3270 Session
  #	And I click on Navigation Bar
  #	Then I verify font color remap and keyremap from settings
#		  Then I close the browser
		  
 #Scenario: Launching Maximum Alternate Sessions
    Given I launch browser again and enter the url   
    Then I click on 3270 Session
    Then click on Home icon
    And I click on 5250 Session
    Then I verify launching maximum alternate sessions 
			  Then I close the browser
			   
	 #Scenario: Config Model Verification
  Given I launch the browser for config model
  When I enter the invalid credentials and verify the error message
  Then I enter the credentials and verify the access
  And I verify the welcome user
  And I verify the Home icon
  And I verify the About panel icon
  And I verify the help icon
  Then I click on logout
  	  Then I close the browser
  
  #Scenario: Config Model Logout while having active sessions
  Given I launch the browser for config model
  Then I enter the credentials and verify the access
  And I verify the welcome user
  Then I click on 3270 Session
  Then click on Home icon
  And I click on search bar to search the sessions
  And I click on 5250 Session
  Then click on Home icon
  Then I click on logout
  And I verify the warning message and click on Ok button to logout
  	  Then I close the browser
  
  #Scenario: Combined Model Verification
  Given I launch the browser for combined model
  And I verify the Home icon
  And I verify the About panel icon
  And I verify the help icon
  	  Then I close the browser

  #Scenario: Verify Ribbon bar is able to open while maximizing the screen
    Given I launch browser again and enter the url
    Then I click on 3270 Session
    And I maximize the connected session
    And I Verify Ribbon bar is able to open while maximizing the screen
    	  Then I close the browser
  
  #Scenario: Close the session by clicking on X icon
    Given I launch browser again and enter the url
    Then I click on 3270 Session
    And I close the session by X icon
    	  Then I close the browser
  
    #Scenario: Verfiy the serach field is editable in settings panel
   Given I launch browser again and enter the url
   Then I click on 3270 Session
   And I click on Navigation Bar
   Then click on Settings icon
   And I  Verify whether search field is editable
	 And I Verify the error message by entering invalid data
	 	  Then I close the browser
  
   #Scenario: Verfiy the session defenition and and session count on home page
   Given I launch browser again and enter the url
   Then I verify the session count in the home page
   And I verify the session defenition from the home page
   	  Then I close the browser
 
#	Scenario: Verify Print Screen 
  Given I launch browser again and enter the url   
  Then I click on 3270 Session
  And I click on Navigation Bar
	Then I click on Print Screen
		  Then I close the browser
		  
		 #  Scenario: Color Remap Verification
  	Given I launch browser again and enter the url   
  	Then I click on 5250 Session
  	And I click on Navigation Bar
  	Then click on Settings icon
  	Then I verify font for 5250 session
  	And I verify color remap for 5250 session
  	And I verify keyremap for 5250 session
		Then I close the browser
	    
#Scenario: Macro Record Verification
  	Given I launch browser again and enter the url   
  	Then I click on 5250 Session
  	And I click on Navigation Bar
  	Then I click on Macro Icon and verify the options
  	Then I click on Record Macro
  	And I enter the name and description for current session macro and click on Record button
  	Then I enter a text to record a current session macro and verify the record in progress
  	And I click on stop Macro
  	Then I play the recorded current session Macro and verify
  	And I click on Macro Icon to record a local macro
  	Then I click on Record Macro
  	And I select local macro
  	And I enter the name and description for local macro and click on Record button
 		Then I enter a text to record a local macro and verify the record in progress
  	And I click on stop Macro
  	Then I play the recorded local Macro and verify
    Then click on Home icon
    Then I click on 3270 Session
    Then I click on Macro Icon
  	Then I click on Record Macro
  	And I enter the name and description for current session macro and click on Record button
  	Then I enter a text to record a current session macro and verify the record in progress
  	And I click on Record a Prompt
  	And I validate the fields for record prompt and click cancel
  	Then I click on Macro Icon
  	And I click on Record an extract
  	And I validate the fields for extract record and click cancel
  	
  #Scenario: Macro Manager Verification
  	Given I launch browser again and enter the url   
  	Then I click on 5250 Session
  	And I click on Navigation Bar
  	Then I click on Macro Icon and verify the options
  	Then I click on Record Macro
  	And I enter the name and description for current session macro and click on Record button
  	Then I enter a text to record a current session macro and verify the record in progress
  	And I click on stop Macro
  	Then I click on Macro Icon
  	And I click on Edit Macro
  	And I click on Code Editor
  	And I make changes in code and click verify and validate error message
  	And I clear the error and click on save
  	Then I delete the macro
	  
#	  Given I launch the browser and verify the login and logout from config model
  #	Then I verify by accessing the pages withand without html
#	  When click on Active session 
    #Then I expand the ribbon bar to verify the macro options
    #Then I verify launching maximum sessions
    
    #Scenario: Close the session
    #Given I launch browser and enter the url
    #Then I click on 3270 Session
    #And I close the session
    #Then I verify the closed session
    #
    #
    #@Tc01
   #Scenario: Navigate to home and Active session
    #Given I launch browser and enter the url
    #Then I click on 3270 Session
    #Then click on Home icon
    #When click on Active session 
    #Then Active session screen will appear
    #
    #@Tc01
    #Scenario: Traverse between Multiple Session
   #Given I launch browser and enter the url
   #Then I click on 3270 Session
   #Then click on Home icon
   #Then I click on 3270 Session
   #Then click on Home icon
   #Then click on All Active session and screen will appear
    #
#		Scenario: 	Verifying the options are present in settings icon
#		Given I launch browser and enter the url
#	  Then I click on 3270 Session
#	    And I click on Navigation Bar
#	    Then click on Settings icon
#	    And I click on all the options present in Settings ribbon bar
#	   
#	  Scenario: Verifying the options are present in Properties pannel
#			Given I launch browser and enter the url
#	    Then I click on 3270 Session
#	    Then click on Home icon 
#	    Then right click on the session and go to properties
#	    And I click and verify all the options present in the properties pannel
#	    
#	  Scenario: Access HOD pages with and without giving .html in URL
#			Given I launch browser with .html URL and verify
#			Then I launch the URL without giving .html and verify		
#	  
#	  Scenario:Smoke Test for HACPEE
    #Given I launch browser and enter the url
    #And I verify the build version details
#	    
   