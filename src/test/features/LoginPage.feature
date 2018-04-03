#Author: joel.jose@flytxt.com
#Keywords Summary : checking postive flow of bc creation

@NXLoginPage
Feature: Login Page test cases with 


#@NX-427
#@initBrowser @closeBrowser
#Scenario: Verify the Login of NEON
#Given neon is loaded
#Then login with "flyops@flytxt.com" and "flytxt"
#Then verify login success

@NX-429
@initBrowser
Scenario: Verify Login with correct username and wrong password
Given neon is loaded
Then login with "flyops@flytxt.com" and "dfgdfgdfg"
Then verify login failure

@NX-432

Scenario: Verify Login with incorrect username
Then login with "flyops@flytxt.co" and "flytxt"
Then verify login failure

@NX-2099 

Scenario: Verify SQL Injection in Login Page
Then login with "flyops@flytxt.com" and "'  OR EXISTS(SELECT 1 FROM dual WHERE database() LIKE '%j%') AND ''='"
Then verify login failure

@NX-2099 

Scenario: Verify SQL Injection in Login Page
Then login with "flyops@flytxt.com" and "'  OR EXISTS(SELECT 1 FROM dual WHERE database() LIKE '%j%') AND ''='"
Then verify login failure

@NX-2098 

Scenario: Verify SQL Injection in Login Page
Then login with "flyops@flytxt.com" and "' OR EXISTS(SELECT * FROM users WHERE username='fyops@flytxt.com' AND password LIKE '%f%') AND ''="
Then verify login failure

@NX-2096 

Scenario: Verify SQL Injection in Login Page
Then login with "flyops@flytxt.com" and "' OR EXISTS(SELECT * FROM users WHERE username='fyops@flytxt.com' AND password LIKE '%f%') AND ''="
Then verify login failure

@NX-2095 

Scenario: Verify SQL Injection in Login Page
Then login with "' OR '1'='1' ({" and "foo'"
Then verify login failure
@NX-2094 

Scenario: Verify SQL Injection in Login Page
Then login with "' OR '1'='1' --" and "foo'"
Then verify login failure

@NX-2092 

Scenario: Verify SQL Injection in Login Page
Then login with "'test' OR 1=1--" and "foo'"
Then verify login failure

@NX-2091 

Scenario: Verify SQL Injection in Login Page
Then login with "1' or '1' = '1')) LIMIT 1/*" and "foo'"
Then verify login failure

@NX-2089 

Scenario: Verify SQL Injection in Login Page
Then login with "1' or '1' = '1'))/*" and "foo'"
Then verify login failure

@NX-2087 

Scenario: Verify SQL Injection in Login Page
Then login with "1' or '1' = '1" and "1' or '1' = '1"
Then verify login failure

@NX-2086 

Scenario: Verify SQL Injection in Login Page
Then login with ";" and ";"
Then verify login failure

@NX-1355 
@closeBrowser
Scenario: Login Case
Then login with "**!@#$%^&;" and "@#$%^&:+"
Then verify login failure

@NX-464 
@initBrowser
Scenario: Verify changing the URL from Login to Home.do
Given neon is loaded
Then change url to landing
Then verify login failure

@NX-463 
@closeBrowser
Scenario: Verify the Branding Area Content of Login page
Then Verify the Branding Area Content of Login page "Intelligent Customer Engagement" "Engage with customers by learning their behaviour and predicting what they want in real time"

@NX-427
@initBrowser @closeBrowser
Scenario: Verify the Login of NEON
Given neon is loaded
Then verify login button

@NX-459
@initBrowser @closeBrowser
Scenario: Verify Forget Password Link by not adding username
Given neon is loaded
Then verify forgot password by not adding username