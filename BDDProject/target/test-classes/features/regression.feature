Feature: Buy a ticket
Scenario Outline: successful purchase of a ticket
	Given The user launch the application
  Then The user select trip type "<trip>"
  Then The user "<key>" select origin "origin" and destination "destination"
  Then The user select passenger "<passenger>"
  Then The user select date
  Then The user select search
  Then The user select basic
	Examples:
	| trip       | key   | passenger   |                                                                                    
	#| One Way    | 1     |1 Passenger |
	| Round Trip | 1    |1 Passenger |
	