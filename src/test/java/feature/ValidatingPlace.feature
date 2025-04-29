Feature: Validating User API

@AddUserAPI
Scenario Outline: Verify if user is successfully added by AddUserAPI
Given Add User payload with "<name>", "<job>"
When User calls "AddUserAPI" with "POST" request method	
Then API call got success with status code 201
And "job" in response body is "Tester"
Examples:
|name|job|
|Sundar|Tester|

@GetUserAPI
Scenario: Verify if user is successfully fetched by GetUserAPI
When User calls "GetUserAPI" with "GET" request method	
Then API call got success with status code 200
And "data.first_name" in response body is "Janet"

@LoginUserAPI
Scenario Outline: Verify user is able to login with valid credentials
Given login user payload with "<email>" and "<password>"
When User calls "LoginUserAPI" with "POST" request method	
Then API call got success with status code 200
And "token" in response body is "QpwL5tke4Pnpja7X4"
Examples:
|email|password|
|eve.holt@reqres.in|cityslicka|

@RegisterUserAPI
Scenario Outline: Verify user is able to register with valid credentials
Given register user payload with "<email>" and "<password>"
When User calls "RegisterUserAPI" with "POST" request method	
Then API call got success with status code 200
And "token" in response body is "QpwL5tke4Pnpja7X4"
Examples:
|email|password|
|eve.holt@reqres.in|pistol|



