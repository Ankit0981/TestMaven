Feature: Add a Customer with Login as Manager

Scenario: Positive test Login as a valid credentials positive test 
Given Initialize the browser with chrome
And Navigate to "way2automation" site 
And Click on Bank Manager Login 
And Navigate to Add Customer Test
When Enter user "John" and "Sharma" and "125874"
And Click on AddCustomer Button 
Then Customer is entered sucessfully with Customer Id