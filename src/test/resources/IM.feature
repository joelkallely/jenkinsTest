#Author: joel.jose@flytxt.com
#Keywords Summary : checking postive flow of bc creation


Feature: positive flow of im program creation
	Program Creation

@NX-bccreation1
Scenario: create im program
Given login
Then navigate to intent management
Then navigate to touchpoints
Then navigate to sms
Then click create new touchpoint
Then create sms touchpoint
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
Then navigate to programs
Then click create program button
Then enter program details
Then click confirm button
Then wait till programs is active
