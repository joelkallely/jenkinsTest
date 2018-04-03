#Author: joel.jose@flytxt.com
#Summary : Test Cases of Consumer Profile


@NX-consumer_profileTestSuite
Feature: Title of your feature
  I want to use this template for my feature file

@NX-2773
@initBrowser
Scenario: Verify if Reports module is introduced to UI.
Given login
Then navigate to precision marketer
Then navigate to reports

@NX-2775

Scenario: Verify whether breadcrumbs are displayed in the page.
Then navigate to customer profile
Then verify whether breadcrumbs are displayed in the page

@NX-2776
Scenario: Verify whether user can search for a consumer by specifying the MSISDN.
Then search msisdn ""

@NX-2780
@closeBrowser
Scenario: Verify for the search button after number is entered.
Then verify customer info page of ""


@NX-2786   
@initBrowser
Scenario: Check whether 5 tabs are available in consumer profile page.
Given login
Then navigate to precision marketer
Then navigate to reports
Then navigate to customer profile
Then search msisdn ""
Then verify 5 tabs in customer profile page

@NX-2787   
@closeBrowser
Scenario: Verify whether each tabs are able to click alternatively whenever needed.
Then verify 5 tabs in customer profile page

#@NX-2788 @run_this
#@initBrowser
#Scenario: Verify whether consumer number is getting displayed at the top of the page.
#Given login
#Then navigate to precision marketer
#Then navigate to reports
#Then navigate to customer profile
#Then search msisdn ""
#Then verify customer info page of ""

###################PENDING
#@NX-2792   @run_this
#Scenario: Verify if Consumer Info tab is populated with valid data
#Then verify details in customer info page of ""

#@NX-2793 @run_this
#@closeBrowser
#Scenario: Verify whether user is able to change the subscriber from all the tabs.
#Then verify changing customer number from all tabs of ""
