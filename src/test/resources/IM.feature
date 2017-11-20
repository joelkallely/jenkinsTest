#Author: joel.jose@flytxt.com
#Keywords Summary : checking postive flow of bc creation

@NX-bcCreationSuite
Feature: positive flow of im program creation
	Program Creation

@NX-bccreation1
Scenario: create im program
Given login
Then navigate to intent management
#Then navigate to touchpoints
#Then navigate to sms
#Then click create new touchpoint
#Then create sms touchpoint
#Then navigate to offer management
#Then create single product from sheet "singleProductPage"
#Then navigate to offer management
#Then Navigate_to_Offers
#Then create new "Recharge" offer for product
#Then navigate to offer management
#Then Navigate to Offer Catalogue
#Then Create New Offer Catalogue for product
#Then Add offer to Offer Catalogue for product
Then navigate to programs
Then create program
Then wait till programs is active
