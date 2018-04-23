#Author: joel.jose@flytxt.com
#Keywords Summary : checking postive flow of bc creation

@NX-BroadcastManagement
Feature: Test cases related to Broadcast Management

@NX-recurrBC
@initBrowser @closeBrowser
Scenario: test recurring BC
Given login
Then navigate to precision marketer
Then navigate to life cycle marketing
Then navigate to campaign category from sheet "campaignCategory"
Then naigate to "campaignBC" campaign view broadcasts
Then click create new broadcast button
Then enter details for new broadcast from sheet "recurringBC" with "rechargeWAP"
Then activate bc

@NX-1234
@initBrowser @closeBrowser
Scenario: Broadcast grid: Verify the breadcrum for broadcast listing screen.
Given login
Then navigate to configuration management
Then navigate to campaign categories
Then create new campaign category from sheet "campaignCategory"
Then navigate to landing page
Then navigate to precision marketer
Then navigate to life cycle marketing
Then navigate to campaign category from sheet "campaignCategory"
Then create new campaign from sheet "campaignBC"
Then naigate to "campaignBC" campaign view broadcasts
Then verify view braodcast breadcrumb

@NX-1238
@initBrowser @closeBrowser
Scenario: Broadcast grid: Verify the label displaying the selected campaign name
Given verify selected campaign name

@NX-1239
@initBrowser @closeBrowser
Scenario: Broadcast grid: Verify the label displaying the selected campaign category name
Given verify selected campaign category name

@NX-1247
@initBrowser @closeBrowser
Scenario: Broadcast grid: Verify create new broadcast button.
Given login
Then navigate to precision marketer
Then navigate to life cycle marketing
Then navigate to campaign category from sheet "campaignCategory"
Then naigate to "campaignBC" campaign view broadcasts
Then click create new broadcast button
Then verify create new broadcast button

@NX-1269
@initBrowser
Scenario: Broadcast grid: Verify the options available for the BC
Given login
Then navigate to precision marketer
Then navigate to life cycle marketing
Then navigate to campaign category from sheet "campaignCategory"
Then naigate to "campaignBC" campaign view broadcasts
Then click create new broadcast button
Then enter details for new broadcast from sheet "one-offBC" with "rechargeWAP"
Then activate bc
Then verify options icon of bc

@NX-1273
Scenario: Broadcast grid: Verify the Pause option of the BC
Given verify pause option of bc

@NX-1271
@closeBrowser
Scenario: Broadcast grid: Verify the edit option for the BC
Given verify edit option of bc

@NX-1192
@initBrowser @closeBrowser
Scenario: Category screen : Verify the delete option when the category is linked with campaigns
Given login
Then navigate to configuration management
Then navigate to campaign categories
Then create new campaign category from sheet "campaignCategory"
Then navigate to landing page
Then navigate to precision marketer
Then navigate to life cycle marketing
Then navigate to campaign category from sheet "campaignCategory"
Then create new campaign from sheet "campaignBC"
Then navigate to landing page
Then navigate to configuration management
Then navigate to campaign categories
Then check delete campaign category with linked campaigns from sheet "campaignCategory"

@NX-1185
@initBrowser @closeBrowser
Scenario: Category screen : Verify editing the category
Given login
Then navigate to configuration management
Then navigate to campaign categories
Then create new campaign category from sheet "campaignCategory"
Then edit campaign category from sheet "campaignCategory"

@NX-1190
@initBrowser @closeBrowser
Scenario: Category screen : Verify deleting the category
Given login
Then navigate to configuration management
Then navigate to campaign categories
Then create new campaign category from sheet "campaignCategory"
Then delete campaign category from sheet "campaignCategory"

@NX-1184
@initBrowser @closeBrowser
Scenario: Category screen : Verify the options of the category
Given login
Then navigate to configuration management
Then navigate to campaign categories
Then verify options of category

@NX-1180
@initBrowser @closeBrowser
Scenario: Category screen : Verify the count added with the template
Given login
Then navigate to configuration management
Then navigate to campaign categories
Then create new campaign category from sheet "campaignCategory"
Then navigate to landing page
Then navigate to precision marketer
Then navigate to life cycle marketing
Then verify campaign template count from sheet "campaignCategory"

@NX-1177
@initBrowser @closeBrowser
Scenario: Category screen : Verify screen navigation by clicking on the category
Given login
Then navigate to configuration management
Then navigate to campaign categories
Then create new campaign category from sheet "campaignCategory"
Then navigate to landing page
Then navigate to precision marketer
Then navigate to life cycle marketing
Then navigate to campaign category from sheet "campaignCategory"
Then create new campaign from sheet "campaignBC"
Then naigate to "campaignBC" campaign view broadcasts

@NX-1170
@initBrowser @closeBrowser
Scenario: Category screen : Verify the campaign count under the category.
Given login
Then navigate to configuration management
Then navigate to campaign categories
Then create new campaign category from sheet "campaignCategory"
Then navigate to landing page
Then navigate to precision marketer
Then navigate to life cycle marketing
Then verify campaign count from sheet "campaignCategory"

@NX-1169
@initBrowser @closeBrowser
Scenario: Category screen : Verify creating a category without adding a name.
Given login
Then navigate to configuration management
Then navigate to campaign categories
Then create new campaign category without adding name

@NX-1168
@initBrowser @closeBrowser
Scenario: Category screen : Verify adding the new category
Given login
Then navigate to configuration management
Then navigate to campaign categories
Then create new campaign category from sheet "campaignCategory"

@NX-1167
@initBrowser @closeBrowser
Scenario: Category screen : Verify the categories under Life Cycle Marketing
Given login
Then navigate to precision marketer
Then navigate to life cycle marketing
Then navigate to campaign category from sheet "campaignCategory"

@NX-2050
@initBrowser
Scenario: Create New Broadcast: Verify the Creation and Activation of One Off Broadcast
Given login
Then navigate to precision marketer
Then navigate to life cycle marketing
Then navigate to campaign category from sheet "campaignCategory"
Then naigate to "campaignBC" campaign view broadcasts
Then click create new broadcast button
Then enter details for new broadcast from sheet "one-offBC" with "rechargeWAP"
Then activate bc

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

#@NX-645
#@initBrowser @closeBrowser
#Scenario: Create BC: Deliver tab: Verify Broadcast Schedule Range details
#Given login
#Then navigate to precision marketer
#Then navigate to life cycle marketing
#Then navigate to "Recharge" category
#Then naigate to "campaignBC" campaign view broadcasts
#Then click create new broadcast button
#Then verify broadcast schedle range details

#@NX-588
#@initBrowser @closeBrowser
#Scenario: Create BC: Choose Offers: Verify creating new offer by clicking on the Create New Offer button
#Given login
#Then navigate to precision marketer
#Then navigate to life cycle marketing
#Then navigate to "Recharge" category
#Then naigate to "campaignBC" campaign view broadcasts
#Then click create new broadcast button
#Then check create new offer in bc creation

#@NX-613
#@initBrowser @closeBrowser
#Scenario: Create BC: Choose Offers: Verify selecting the channel and sender input
#Given login
#Then navigate to precision marketer
#Then navigate to life cycle marketing
#Then navigate to "Recharge" category
#Then naigate to "campaignBC" campaign view broadcasts
#Then click create new broadcast button
#Then enter details for new broadcast from sheet "one-offBC" with "rechargeWAP"
#Then activate bc


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