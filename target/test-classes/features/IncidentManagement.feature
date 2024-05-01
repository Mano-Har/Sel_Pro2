Feature: Incident Management

#Scenario: Create new Incident
#Given Set End Point
#And Set up Basic Auth
#When Place the Post Request
#Then Verify the status code as 201
#And Verify the response body contains contentType as 'json'

#Scenario: Create new Incident with two data
#Given Set End Point
#And Set up Basic Auth
#When Send the Post Request with body as 'Incident created in feature file' and 'Scenario Test'
#Then Verify the status code as 201
#And Verify the response body contains contentType as 'json'

Scenario Outline: Create Multiple Incident 
#Given Set End Point
#And Set up Basic Auth
When Send the Post Request with body as '<ShortDesp>' and '<Desc>'
Then Verify the status code as 201
And Verify the response body contains contentType as 'json'

Examples:
|ShortDesp|Desc|
|Incident created in Scenario Outline 3|Scenario Outline Test3|
|Incident created in Scenario Outline 4|Scenario Outline Test4|

