@SmokeTest
Feature: Admin Console GUI Verification

  Scenario: AdminConsole logout Verification
  Given I launch the browser for AdminConsole
 # When I enter the invalid credentials and verify the error message for Adminconsole
  And I enter the credentials and verify the access for Adminconsole
 # Then I verify the  title of adminconsole
 And I verify the build version details in HACP EE Admin console
  Then I verify the Help button in HACP EE Admin console
  And I logout the AdminConsole page


  Scenario: AdminConsole Verification
  Given I launch the browser for AdminConsole
 # When I enter the invalid credentials and verify the error message for Adminconsole
  And I enter the credentials and verify the access for Adminconsole
 # Then I verify the  title of adminconsole
  And I expand the ribbon bar for AdminConsole
  And I varify the options for AdminConsole
  When I click on All Users tab
  And I click on New User Icon and Verify the Options
  And I click on New Group Icon and Verify the Options
  And I click on 3 dots in Admin user 
  And I verify the option avaiable in Admin user 
  And I click on sessions tab and varify the options
   And I click on 3 dots in Admin user
  When I click on Disable Functions tab and varify the heading
  And I click on desktop tab and verify the options 
  And I click on  Connection tab in Disable fuction and verify the options
 And I click on  Appearance tab in Disable fuction and verify the options
  And I click on  Macro tab in Disable fuction and verify the options
  And I click on  File Transfer in Disable fuction and verify the options
 Then I expand the ribbon bar for File Transfer
  When I click on  FTP tab in File Transfer and verify the options
  And I click on  Data transfer tab in Disable fuction and verify the options
  Then I expand the ribbon bar for Data transfer tab
  When I click on  Edit Permissions tab in  Data transfer and verify the options
  And I click on  SQL Statements tab in  Data transfer and verify the options
  And I click on  Configuration tab in  Data transfer and verify the options
  And I click on  Display Print Functions tab in Disable fuction and verify the options
  And I click on  Printer Session tab in Disable fuction and verify the options
  And I click on  Preferences tab in Disable fuction and verify the options
  And I click on  Others tab in Disable fuction and verify the options
  And I click on 3 dots in Admin user
  And I click on Trace Facility tab and verify the options 
  And I click on 3 dots in Admin user
  And I click on properties tab and verify the options
  And I click on Services tab and varify the options
  And I click on Directory tab and varify the options
  And I click on Host Connections tab and varify the options
  And I click on Log tab and varify the options
  And I click on Trace setting tab and varify the options
  And I click on Preferences Settings tab and varify the options
  
  
  Scenario: AdminConsole  PCOMM Verification
  Given I launch the browser for AdminConsole
  #When I enter the invalid credentials and verify the error message for Adminconsole
  And I enter the credentials and verify the access for Adminconsole
 # Then I verify the  title of adminconsole
  And I expand the ribbon bar for AdminConsole
  When I click on All Users tab
  And I click on PCOMM Admin User
 And I click on 3 dots in PCOMM Admin user
 And I click on sessions tab and varify the options PCOMM Admin user
  And I click on 3 dots in PCOMM Admin user 
   When I click on Disable Functions tab and varify the title in PCOMM Admin user
  And I click on desktop tab and verify the options 
  And I click on  Connection tab in Disable fuction and verify the options
 And I click on  Appearance tab in Disable fuction and verify the options 
 And I click on  Macro tab in Disable fuction and verify the options
  And I click on  File Transfer in Disable fuction and verify the options
 Then I expand the ribbon bar for File Transfer
  When I click on  FTP tab in File Transfer and verify the options
  And I click on  Data transfer tab in Disable fuction and verify the options
  Then I expand the ribbon bar for Data transfer tab
  When I click on  Edit Permissions tab in  Data transfer and verify the options
  And I click on  SQL Statements tab in  Data transfer and verify the options
  And I click on  Configuration tab in  Data transfer and verify the options
  And I click on  Display Print Functions tab in Disable fuction and verify the options
  And I click on  Printer Session tab in Disable fuction and verify the options
  And I click on  Preferences tab in Disable fuction and verify the options
  And I click on  Others tab in Disable fuction and verify the options
  And I click on 3 dots in PCOMM Admin user
  And I click on properties tab and verify the options in PCOMM group
    
  Scenario: AdminConsole  HOD Verification
  Given I launch the browser for AdminConsole
  #When I enter the invalid credentials and verify the error message for Adminconsole
  And I enter the credentials and verify the access for Adminconsole
 # Then I verify the  title of adminconsole
  And I expand the ribbon bar for AdminConsole
  When I click on All Users tab
  And I click on HOD Admin User
 And I click on 3 dots in Admin user 
  And I verify the option avaiable in Admin user 
  And I click on sessions tab and varify the options
   And I click on 3 dots in Admin user
  When I click on Disable Functions tab and varify the heading
  And I click on desktop tab and verify the options 
  And I click on  Connection tab in Disable fuction and verify the options
 And I click on  Appearance tab in Disable fuction and verify the options 
 And I click on  Macro tab in Disable fuction and verify the options
  And I click on  File Transfer in Disable fuction and verify the options
 Then I expand the ribbon bar for File Transfer
  When I click on  FTP tab in File Transfer and verify the options
  And I click on  Data transfer tab in Disable fuction and verify the options
  Then I expand the ribbon bar for Data transfer tab
  When I click on  Edit Permissions tab in  Data transfer and verify the options
  And I click on  SQL Statements tab in  Data transfer and verify the options
  And I click on  Configuration tab in  Data transfer and verify the options
  And I click on  Display Print Functions tab in Disable fuction and verify the options
  And I click on  Printer Session tab in Disable fuction and verify the options
  And I click on  Preferences tab in Disable fuction and verify the options
  And I click on  Others tab in Disable fuction and verify the options
  And I click on 3 dots in Admin user
  And I click on Trace Facility tab and verify the options 
  And I click on 3 dots in Admin user
  And I click on properties tab and verify the options
  
  
  
  