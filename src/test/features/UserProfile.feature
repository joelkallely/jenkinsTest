#Author: joel.jose@flytxt.com
#Summary : Test Cases of User Profile


@NX-UserProfile
Feature: Title of your feature
  I want to use this template for my feature file

@NX-6038
@initBrowser @closeBrowser
Scenario: Verify whether drop down list is displayed on clicking the user name
Given login
Then click username on topbar
Then verify dropdown

@NX-6039
@initBrowser
Scenario: Verify  pop-up is displayed on clicking change password option
Given neon is loaded
Then login with "joel.jose@flytxt.com" and "flytxt"
Then navigate to precision marketer
Then click username on topbar
Then click change password
Then click cancel in change password

@NX-6040
@closeBrowser
Scenario: Verify the functionality of Change password option
Then click username on topbar
Then click change password
Then change password "flytxt1" from "flytxt"
Then logout
Then login with "joel.jose@flytxt.com" and "flytxt1"
Then click username on topbar
Then click change password
Then change password "flytxt" from "flytxt1"

@NX-6041
@initBrowser @closeBrowser
Scenario: Verify  error message shown if  new password and confirm password doesnâ€™t match
Given neon is loaded
Then login with "joel.jose@flytxt.com" and "flytxt"
Then click username on topbar
Then click change password
Then change password "Newflytxt1" from "wrongPassword"
Then verify wrong password toast