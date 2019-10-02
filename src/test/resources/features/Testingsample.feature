Feature: Handling Table using Selenium


Scenario: Verify getting the needed data from the table using selenium

Given navigating to Google Shopping list page
And Search 'milk' in the search bar
And enable/check the Buy on Google option in shopping page
When search for product less than 15
Then display the product falling under the given category
 
