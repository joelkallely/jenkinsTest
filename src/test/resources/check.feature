#Author: your.email@your.domain.com

@tag111111111
Feature: Just to checkr
  I want to use this template to check the
@tag1376
    Scenario: Offer Management-->Create new offer-->Cancel button NX-1376
    Given login
  	Then navigate to precision marketing
  	Then navigate to offer management
		Then navigate to offers
		Then Check_Offer_help_icon
@tag2180
    Scenario: Offer Management : Verify for the Offers Help icon NX-2180
    Given login
  	Then navigate to precision marketing
  	Then navigate to offer management
		Then navigate to offers
		Then Check_Offer_help_icon
@tag885		
		Scenario: Create offer: Creative: Verify the proceed button without entering details NX-885
    Given login
  	Then navigate to precision marketing
  	Then navigate to offer management
		Then navigate to offers
		Then Check_details_tab_without_entering_details

@tag6214
		Scenario: Offer-Creation: Verify filtering based on product name inside product tab NX-6214
    Given login
  	Then navigate to precision marketing
  	Then navigate to offer management
		Then navigate to offers
		Then Check_filter_operation_in_products_tab_with_ProductName
@tag6215
		Scenario:Offer-Creation: Verify filtering based on Price in products tab NX-6215
    Given login
  	Then navigate to precision marketing
  	Then navigate to offer management
		Then navigate to offers
		Then Check_filter_operation_in_products_tab_with_Price
@tag6216		
		Scenario: Offer-Creation: Verify filtering Based on Validity inside the products tab NX-6216
    Given login
  	Then navigate to precision marketing
  	Then navigate to offer management
		Then navigate to offers
		Then Check_filter_operation_in_products_tab_with_Validity
@tag6217
		Scenario: Offer-Creation: Verify Filtering Based on Service Leg in Products tab NX-6217
    Given login
  	Then navigate to precision marketing
  	Then navigate to offer management
		Then navigate to offers
		Then Check_filter_operation_in_products_tab_with_ServiceLeg		
		