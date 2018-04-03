#Author: joel.jose@flytxt.com
#Keywords Summary : checking postive flow of bc creation

@NX-BroadcastManagement
Feature: Test cases related to Broadcast Management

@NX-613
@initBrowser @closeBrowser
Scenario: Create BC: Choose Offers: Verify selecting the channel and sender input
Given login
Then navigate to precision marketer
Then navigate to life cycle marketing
Then navigate to "Recharge" category
Then naigate to "campaignBC" campaign view broadcasts
Then click create new broadcast button
Then enter details for new broadcast from sheet "one-offBC" with "rechargeWAP"
Then activate bc


#@NX-613
#@initBrowser @closeBrowser
#Scenario: Create BC: Choose Offers: Verify selecting the channel and sender input
#Given login
#Then navigate to precision marketer
#Then navigate to life cycle marketing
#Then navigate to "Recharge" category
#Then naigate to "campaignBC" campaign view broadcasts
#Then click create new broadcast button
#Then verify selecting channel and sender
#Then pass next scenario based on this step
#
#@NX-630
#Scenario: Create BC: Choose Offers:Verify navigation to the delivery tab without adding channel & Sender details
#Then check previous step and pass this

#@NX-611
#@initBrowser @closeBrowser
#Scenario: Create BC: Choose Offers: Verify the choose offer window after selecting an offer.
#Given login
#Then navigate to precision marketer
#Then navigate to life cycle marketing
#Then navigate to "Recharge" category
#Then naigate to "campaignBC" campaign view broadcasts
#Then click create new broadcast button
#Then verify choose offer window after selecting offer

#@NX-575
#@initBrowser @closeBrowser
#Scenario: Create BC- Manual Target: Verify the proceed button without adding target conditions
#Given login
#Then navigate to precision marketer
#Then navigate to life cycle marketing
#Then navigate to "Recharge" category
#Then naigate to "campaignBC" campaign view broadcasts
#Then click create new broadcast button
#Then verify proceed button without adding target condition

#@NX-573
#@initBrowser @closeBrowser
#Scenario: Create BC- Manual Target: Verify deleting the textual conditions
#Given login
#Then navigate to precision marketer
#Then navigate to life cycle marketing
#Then navigate to "Recharge" category
#Then naigate to "campaignBC" campaign view broadcasts
#Then click create new broadcast button
#Then verify delete option of target condition

#@NX-569
#@initBrowser @closeBrowser
#Scenario: Create BC- Manual Target: Verify the textual editor
#Given login
#Then navigate to precision marketer
#Then navigate to life cycle marketing
#Then navigate to "Recharge" category
#Then naigate to "campaignBC" campaign view broadcasts
#Then click create new broadcast button
#Then verify textual editor for target condition
#Then pass next scenario based on this step
#
#@NX-572
#Scenario: Create BC- Manual Target: Verify editing the added textual conditions
#Then check previous step and pass this

#@NX-529
#@initBrowser @closeBrowser
#Scenario: Create BC-Details tab: Verify the headers for previous tab after proceeding to the next tab.
#Given login
#Then navigate to precision marketer
#Then navigate to life cycle marketing
#Then navigate to "Recharge" category
#Then naigate to "campaignBC" campaign view broadcasts
#Then click create new broadcast button
#Then verify headers after proceeding to next target tab

#@NX-528 
#@initBrowser @closeBrowser
#Scenario: Create BC-Details tab: Verify proceeding to the next tab.
#Given login
#Then navigate to precision marketer
#Then navigate to life cycle marketing
#Then navigate to "Recharge" category
#Then naigate to "campaignBC" campaign view broadcasts
#Then click create new broadcast button
#Then verify proceeding to target tab

#@NX-518 
#@initBrowser @closeBrowser
#Scenario: Create BC-Details tab: Verify the proceed button without adding the mandatory fields
#Given login
#Then navigate to precision marketer
#Then navigate to life cycle marketing
#Then navigate to "Recharge" category
#Then naigate to "campaignBC" campaign view broadcasts
#Then click create new broadcast button
#Then verify mandatory fields in details tab

#@NX-517 
#@initBrowser @closeBrowser
#Scenario: Create BC-Details tab: Verify the text box validations for the BC details tab
#Given login
#Then navigate to precision marketer
#Then navigate to life cycle marketing
#Then navigate to "Recharge" category
#Then naigate to "campaignBC" campaign view broadcasts
#Then click create new broadcast button
#Then verify validations of bc details tab

#@NX-505 
#@initBrowser @closeBrowser
#Scenario: Create BC-Details tab: Verify Create New BC lands in the details tab.
#Given login
#Then navigate to precision marketer
#Then navigate to life cycle marketing
#Then navigate to "Recharge" category
#Then naigate to "campaignBC" campaign view broadcasts
#Then click create new broadcast button
#Then check if create new bc lands in details tab


#########################recurring bc
#@NXrecurring 
#@initBrowser @closeBrowser
#Scenario: save recurring broadcast and activate
#Given login
#Then navigate to precision marketer
#Then navigate to offer management
#Then navigate to products
#Then navigate to prepaid telecom
#Then click create new product button
#Then create single product from sheet "singleProductPage"
#Then navigate to offer management
#Then navigate to offers
#Then create new offer from sheet "rechargeWAP"
#Then navigate to offer management
#Then Navigate to Offer Catalogue
#Then Create New Offer Catalogue from sheet "defaultCatalog"
#Then Add "rechargeWAP" offer to Offer Catalogue
#Then navigate to life cycle marketing
#Then navigate to "Recharge" category
#Then create new campaign from sheet "campaignBC"
#Then naigate to "campaignBC" campaign view broadcasts
#Then click create new broadcast button
#Then enter details for new broadcast from sheet "one-offBC" with "rechargeWAP"
#Then save bc
#Then navigate to "Recurring" broadcasts
#Then activate saved "Recurring" bc from sheet "recurringBC"
#Then navigate to "Recurring" broadcasts
#Then check if "Recurring" bc status is "Active" from sheet "recurringBC"