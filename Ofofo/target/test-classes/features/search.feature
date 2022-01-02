Feature:
	Search and place the order
@SeleniumTest
Scenario:
	Search for items and validate results
Given User is on Greenkart Landing page
When User search for "Cucumber" vegetable
Then "Cucumber" results are displayed

@SeleniumTest
Scenario:
	Seacrh for items and then move to checkout page
Given User is on Greenkart Landing page
When User search for "Brinjal" vegetable
And Added items to cart
And User proceeded to checkout page for purchase
Then Verify selected "Brinjal" items are displayed in checkout page

@SeleniumTest
Scenario Outline:
		Search for items and validate results
Given User is on Greenkart Landing page
When User search for <Name> vegetable
Then <Name> results are displayed

Examples:
|Name|
|Cucumber|
|Beetroot|