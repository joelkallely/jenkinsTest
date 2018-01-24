#Author: joel.jose@flytxt.com
#Keywords Summary : checking postive flow of bc creation

@IM-Feature
Feature: positive flow of im program creation
Program Creation
#IM-Label
#@NX-426
#Scenario: Verify the new touchpoint landing page
#Given login
#Then navigate to intent management
#Then navigate to touchpoints
#Then check touchpoint landing page
#
#@NX-428
#Scenario: Verify Create New Touchpoint button behaviour for SMS TP
#Given login
#Then navigate to intent management
#Then navigate to touchpoints
#Then navigate to sms
#Then click create new touchpoint
#Then verify sms tp creation form
#
#@NX-430
#Scenario: Verify new SMS touchpoint creation
#Given login
#Then navigate to intent management
#Then navigate to touchpoints
#Then navigate to sms
#Then click create new touchpoint
#Then create sms touchpoint
#Then check sms touchpoint in grid
#
#@NX-431
#Scenario: Verify new Trigger touchpoint creation 
#Given login
#Then navigate to intent management
#Then navigate to touchpoints
#Then navigate to trigger
#Then click create new touchpoint
#Then create trigger touchpoint
#Then check trigger touchpoint in grid 
#
#@NX-433
#Scenario: Verify new Customer Care touchpoint creation
#Given login
#Then navigate to intent management
#Then navigate to touchpoints
#Then navigate to customer care
#Then click create new touchpoint
#Then create customer care touchpoint
#Then check customer care touchpoint in grid
#
#@NX-434
#Scenario: Verify new API touchpoint creation 
#Given login
#Then navigate to intent management
#Then navigate to touchpoints
#Then navigate to api
#Then click create new touchpoint
#Then create api touchpoint
#Then check api touchpoint in grid
#
#@NX-435
#Scenario: Verify new API touchpoint creation 
#Given login
#Then navigate to intent management
#Then navigate to touchpoints
#Then navigate to ussd
#Then click create new touchpoint
#Then create ussd touchpoint
#Then check ussd touchpoint in grid
#
#@NX-436
#Scenario: Verify Cancel button functionality for SMS TP
#Given login
#Then navigate to intent management
#Then navigate to touchpoints
#Then navigate to sms
#Then click create new touchpoint
#Then verify cancel button of sms touchpoint
#
#@NX-437
#Scenario: Verify Cancel button functionality for trigger TP
#Given login
#Then navigate to intent management
#Then navigate to touchpoints
#Then navigate to trigger
#Then click create new touchpoint
#Then verify cancel button of trigger touchpoint
#
#@NX-445
#Scenario: Verify Trigger touchpoint delete functionality
#Given login
#Then navigate to intent management
#Then navigate to touchpoints
#Then navigate to trigger
#Then click create new touchpoint
#Then create trigger touchpoint
#Then verify delete trigger touchpoint
#
#@NX-450
#Scenario: Field level validation check while creating new Trigger TP
#Given login
#Then navigate to intent management
#Then navigate to touchpoints
#Then navigate to trigger
#Then click create new touchpoint
#Then check mandatory fields for trigger touchpoint
#
#@NX-709
#Scenario: Verify the new program landing page
#Given login
#Then navigate to intent management
#Then navigate to programs
#Then verify program landing page
#
#@NX-710
#Scenario: Verify Create New Program button behaviour
#Given login
#Then navigate to intent management
#Then navigate to programs
#Then click create program button
#Then verify create program page
#
#@NX-712
#Scenario: Verify Proceed button functionality for Details tabs
#Given login
#Then navigate to intent management
#Then navigate to programs
#Then click create program button
#Then verify program proceed button functionality for details tab
#
#@NX-713
#Scenario: Verify Proceed button functionality for Details tabs
#Given login
#Then navigate to intent management
#Then navigate to programs
#Then click create program button
#Then verify program cancel button functionality for details tab
#
#@NX-714
#Scenario: Verify Choose Catalog field values
#Given login
#Then navigate to intent management
#Then navigate to programs
#Then click create program button
#Then verify program choose catalog field values
#
#@NX-716
#Scenario: Verify field level validation for Details tabs
#Given login
#Then navigate to intent management
#Then navigate to programs
#Then click create program button
#Then verify program field validation for details tab
#
#@NX-724
#Scenario: Verify touchpoint tab functionality
#Given login
#Then navigate to intent management
#Then navigate to programs
#Then click create program button
#Then verify program touchpoint tab
#
@NX-725
Scenario: Verify New touchpoint addition on Touchpoint tab
Given login
Then navigate to intent management
Then navigate to programs
Then click create program button
Then verify program touchpoint addition


#@NX-bccreation1
#Scenario: create ussd application
#Given login to legacy
#Then navigate to intercative marketing
#Then create new ussd application

#@NX-bccreation1
#Scenario: create im program
#Given login
#Then navigate to intent management
#Then navigate to touchpoints
#Then navigate to sms
#Then click create new touchpoint
#Then create sms touchpoint
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
#Then navigate to programs
#Then click create program button
#Then enter program details
#Then click confirm button
#Then wait till programs is active
