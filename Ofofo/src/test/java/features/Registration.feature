Feature: to register as seller

Background:
    Given user launch firefox browser
    And goes to landing page

Scenario: scenario description
	Given when user enter
	|John|Nolan|memzwqlpbby@alilot.com|12324654|https://www.google.com|Ofofo@121|Ofofo@121|
		And click on register
		Then check wheather the otp page is displayed
		