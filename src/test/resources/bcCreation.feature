#Author: joel.jose@flytxt.com
#Keywords Summary : checking postive flow of bc creation

@NX-bcCreationSuite
Feature: positive flow of bc creation
	BC Creation

#@NX-bccreation1
#Scenario: create one off broadcast 
#Given initialize
#Then go to mesos


#########################recurring bc
@NXrecurring
Scenario: save recurring broadcast and activate
Given login
Then navigate to precision marketing
Then navigate to offer management
Then navigate to products
Then click create new product button
Then enter product details from sheet "fullDetails"
Then save product
Then navigate to offer management
Then Navigate_to_Offers
Then create new offer from sheet "rechargeWAP"
Then navigate to offer management
Then Navigate to Offer Catalogue
Then Create New Offer Catalogue from sheet "defaultCatalog"
Then Add "rechargeWAP" offer to Offer Catalogue
Then navigate to life cycle marketing
Then navigate to "Recharge" category
Then create new campaign from sheet "campaignBC"
Then naigate to "campaignBC" campaign view broadcasts
Then click create new broadcast button
Then enter details for new broadcast from sheet "recurringBC" with "rechargeWAP"
Then save bc
Then navigate to "Recurring" broadcasts
Then activate saved "Recurring" bc from sheet "recurringBC"
Then navigate to "Recurring" broadcasts
Then check if "Recurring" bc status is "Active" from sheet "recurringBC"

###################one off  bc
@NXoneoff
Scenario: save one off broadcast and activate
Given login
Then navigate to precision marketing
Then navigate to offer management
Then navigate to products
Then click create new product button
Then enter product details from sheet "fullDetails"
Then save product
Then navigate to offer management
Then Navigate_to_Offers
Then create new offer from sheet "rechargeWAP"
Then navigate to offer management
Then Navigate to Offer Catalogue
Then Create New Offer Catalogue from sheet "defaultCatalog"
Then Add "rechargeWAP" offer to Offer Catalogue
Then navigate to life cycle marketing
Then navigate to "Recharge" category
Then create new campaign from sheet "campaignBC"
Then naigate to "campaignBC" campaign view broadcasts
Then click create new broadcast button
Then enter details for new broadcast from sheet "one-offBC" with "rechargeWAP"
Then save bc
Then activate saved "" bc from sheet "one-offBC"
Then check if "" bc status is "Render Scheduled" from sheet "one-offBC"


#################seeding recurring
@NXseedrecur
Scenario: save seding broadcast and activate
Given login
Then navigate to precision marketing
Then navigate to offer management
Then navigate to products
Then click create new product button
Then enter product details from sheet "fullDetails"
Then save product
Then navigate to offer management
Then Navigate_to_Offers
Then create new offer from sheet "seedingWAPoffer"
Then navigate to offer management
Then Navigate to Offer Catalogue
Then Create New Offer Catalogue from sheet "defaultCatalog"
Then Add "seedingWAPoffer" offer to Offer Catalogue
Then navigate to life cycle marketing
Then navigate to "Recharge" category
Then create new campaign from sheet "campaignBC"
Then naigate to "campaignBC" campaign view broadcasts
Then click create new broadcast button
Then enter details for new broadcast from sheet "seedingRecurringBC" with "seedingWAPoffer"
Then save bc
Then navigate to "Seedings" broadcasts
Then activate saved "Seeding" bc from sheet "seedingRecurringBC"
Then navigate to "Seedings" broadcasts
Then check if "Seeding" bc status is "Active" from sheet "seedingRecurringBC"


######################seeding triggerable bc
@NX-bccreation1
Scenario: save seeding triggerable broadcast and activate
Given login
Then navigate to precision marketing
Then navigate to offer management
Then navigate to products
Then click create new product button
Then enter product details from sheet "fullDetails"
Then save product
Then navigate to offer management
Then Navigate_to_Offers
Then create new offer from sheet "seedingWAPoffer"
Then navigate to offer management
Then Navigate to Offer Catalogue
Then Create New Offer Catalogue from sheet "defaultCatalog"
Then Add "seedingWAPoffer" offer to Offer Catalogue
Then navigate to life cycle marketing
Then navigate to "Recharge" category
Then create new campaign from sheet "campaignBC"
Then naigate to "campaignBC" campaign view broadcasts
Then click create new broadcast button
Then enter details for new broadcast from sheet "seedingTriggerableBC" with "seedingWAPoffer"
Then save bc
Then navigate to "Seedings" broadcasts
Then activate saved "Seeding" bc from sheet "seedingTriggerableBC"
Then navigate to "Seedings" broadcasts
Then check if "Seeding" bc status is "Active" from sheet "seedingTriggerableBC"

######################triggerable bc
@NXtrig
Scenario: save tiggerable broadcast and activate
Given login
Then navigate to precision marketing
Then navigate to offer management
Then navigate to products
Then click create new product button
Then enter product details from sheet "fullDetails"
Then save product
Then navigate to offer management
Then Navigate_to_Offers
Then create new offer from sheet "rechargeWAP"
Then navigate to offer management
Then Navigate to Offer Catalogue
Then Create New Offer Catalogue from sheet "defaultCatalog"
Then Add "rechargeWAP" offer to Offer Catalogue
Then navigate to life cycle marketing
Then navigate to "Recharge" category
Then create new campaign from sheet "campaignBC"
Then naigate to "campaignBC" campaign view broadcasts
Then click create new broadcast button
Then enter details for new broadcast from sheet "triggerableBC" with "rechargeWAP"
Then save bc
Then navigate to "Triggerable" broadcasts
Then activate saved "Triggerable" bc from sheet "triggerableBC"
Then navigate to "Triggerable" broadcasts
Then check if "Triggerable" bc status is "Active" from sheet "triggerableBC"

#@NX-bccreation1
#Scenario: create one off broadcast
#Given login
#Then navigate to precision marketing
#Then navigate to offer management
#Then navigate to products
#Then click create new product button
#Then enter product details from sheet "fullDetails"
#Then save product
#Then navigate to offer management
#Then Navigate_to_Offers
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
#Then enter details for new "one-off" broadcast from sheet "defaultBC"
#Then activate and save bc
#Then check bc status of "defaultBC"
#Then wait for "scheduledBC" to complete and check count
#
#@NX-bccreation1
#Scenario: create reccurring broadcast 
#Given login
#Then navigate to precision marketing
#Then navigate to offer management
#Then create single product from sheet "singleProductPage"
#Then navigate to offer management
#Then Navigate_to_Offers
#Then create new "Recharge" offer for product
#Then navigate to offer management
#Then Navigate to Offer Catalogue
#Then Create New Offer Catalogue for product
#Then Add offer to Offer Catalogue for product
#Then navigate to life cycle marketing
#Then navigate to "Recharge" category
#Then create new campaign
#Then create new "recurring" broadcast
#Then check bc status
#
#@NX-bccreation2
#Scenario: create seeding one-off broadcast 
#Given login
#Then navigate to precision marketing
#Then navigate to offer management
#Then create single product from sheet "singleProductPage"
#Then navigate to offer management
#Then Navigate_to_Offers
#Then create new "Seeding" offer for product
#Then navigate to offer management
#Then Navigate to Offer Catalogue
#Then Create New Offer Catalogue for product
#Then Add offer to Offer Catalogue for product
#Then navigate to life cycle marketing
#Then navigate to "Recharge" category
#Then create new campaign
#Then create new "one-off" broadcast
#Then check bc status


#@NX-bccreation
#Scenario: create one off broadcast 
#Given login
#Then navigate to precision marketing
#Then navigate to life cycle marketing
#Then navigate to "Recharge" category
#Then create new campaign
#Then create new "one-off" broadcast