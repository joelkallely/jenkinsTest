#Author: joel.jose@flytxt.com
#Keywords Summary : checking postive flow of bc creation

@NX-bcCreationSuite
Feature: positive flow of bc creation
	BC Creation
#@NX-bccreation1
#Scenario: create one off broadcast 
#Given login
#Then navigate to precision marketing
#Then navigate to offer management
#Then create single product from sheet "singleProductPage"
#Then navigate to offer management
#Then Navigate_to_Offers
#Then create new offer for product
#Then navigate to offer management
#Then Navigate to Offer Catalogue
#Then Create New Offer Catalogue for product
#Then Add offer to Offer Catalogue for product

@NX-bccreation
Scenario: create one off broadcast 
Given login
Then navigate to precision marketing
Then navigate to life cycle marketing
Then navigate to "Recharge" category
#Then create new campaign
Then create new broadcast