@SmokeTest

Feature: Prefence tab Verification

  Scenario: Combined Model Verification
  Given I launch the browser for combined model
  And I verify the Home icon
  And I verify the About panel icon
  And I verify the help icon
  	  Then I close the browser