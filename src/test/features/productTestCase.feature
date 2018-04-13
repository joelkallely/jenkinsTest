#Author: Joel Jose
#Keywords Summary : Product page test cases
#Feature: Product Page Features


@NX-runProductTestCase

Feature: Product Page Feature Files
	Product page test cases

@NX-1048
@initBrowser @closeBrowser
Scenario: Create Product: Verify saving the product without adding the benefit NX-1048
Given login
Then navigate to precision marketer
Then navigate to offer management
Then navigate to products
Then navigate to prepaid telecom
Then click create new product button
Then verify saving the product without adding benefits

@NX-1042
@initBrowser @closeBrowser
Scenario: Create Product: Verify clicking on the Add button to add benefits NX-1042
Given login
Then navigate to precision marketer
Then navigate to offer management
Then navigate to products
Then navigate to prepaid telecom
Then click create new product button
Then clicking on the Add button to add benefits for the product

@NX-1047
@initBrowser @closeBrowser
Scenario: Create Product: Verify adding multiple benefits for the single product NX-1047
Given login
Then navigate to precision marketer
Then navigate to offer management
Then navigate to products
Then navigate to prepaid telecom
Then click create new product button
Then saving product with multiple benefits



#
@NX-1011
@initBrowser @closeBrowser
Scenario: Products Grid: Verify the product details displayed in the Products screen NX-1011
Given login
Then navigate to precision marketer
Then navigate to offer management
Then navigate to products
Then navigate to prepaid telecom
Then click create new product button
Then create single product from sheet "singleProductPage"
Then verify "singleProductPage" product details displayed in the products screen
#
@NX-1061
@initBrowser @closeBrowser
Scenario: Create Product: Verify clicking on the cancel option after adding all the details NX-1061
Given login
Then navigate to precision marketer
Then navigate to offer management
Then navigate to products
Then navigate to prepaid telecom
Then click create new product button
Then enter valid details and click cancel
And check if product is saved after cancel


@NX-2064
@initBrowser @closeBrowser
Scenario: Checking cross site scripting in creation of new product under CLV Max NX-2064
Given login
Then navigate to precision marketer
Then navigate to offer management
Then navigate to products
Then navigate to prepaid telecom
Then click create new product button
Then enter special characters for name and validate
#
@NX-1023
@initBrowser @closeBrowser
Scenario: Verify Clicking on the Remove Icon in the products tab NX-1023
Given login
Then navigate to precision marketer
Then navigate to offer management
Then navigate to products
Then navigate to prepaid telecom
Then click create new product button
Then create single product from sheet "singleProductPage"
Then delete product from sheet "singleProductPage"

#
@NX-2055
@initBrowser @closeBrowser
Scenario: Offer Management : Check for the Filter icon in Products NX-2055
Given login
Then navigate to precision marketer
Then navigate to offer management
Then navigate to products
Then navigate to prepaid telecom
Then check if  the filter option is saving data after cancel
#
@NX-1058
@initBrowser @closeBrowser
Scenario: Create Product: Verify adding products with same price under segmented scope NX-1058
Given login
Then navigate to precision marketer
Then navigate to offer management
Then navigate to products
Then navigate to prepaid telecom
Then click create new product button
Then create new segmented product from sheet "productsSamePrice"
Then click create new product button
Then create new segmented product from sheet "productsSamePrice"
Then verify "productsSamePrice" product details displayed in the products screen
#
@NX-1057
@initBrowser @closeBrowser
Scenario: Create Product: Verify adding products with same price under open market NX-1057
Given login
Then navigate to precision marketer
Then navigate to offer management
Then navigate to products
Then navigate to prepaid telecom
Then click create new product button
Then create single product from sheet "productsSamePrice"
Then create single product from sheet "productsSamePrice"
Then check if "productsSamePrice" products with same price under open market


@NX-1055
@initBrowser @closeBrowser
Scenario: Create Product: Verify the product with Segmented scope NX-1055, NX-1015
Given login
Then navigate to precision marketer
Then navigate to offer management
Then navigate to products
Then navigate to prepaid telecom
Then click create new product button
Then create new segmented product from sheet "singleProductPage"
Then verify "singleProductPage" product details displayed in the products screen
#
@NX-1053
@initBrowser @closeBrowser
Scenario: Create Product: Verify the product with Open Market scope NX-1053
Given login
Then navigate to precision marketer
Then navigate to offer management
Then navigate to products
Then navigate to prepaid telecom
Then click create new product button
Then create single product from sheet "singleProductPage"
Then verify "singleProductPage" product details displayed in the products screen

@NX-1022
@initBrowser @closeBrowser
Scenario: Products Grid: Verify the duplicate option of the product added NX-1022
Given login
Then navigate to precision marketer
Then navigate to offer management
Then navigate to products
Then navigate to prepaid telecom
Then click create new product button
Then create single product from sheet "singleProductPage"
Then check duplicate product of "singleProductPage"
#
@NX-1014
@initBrowser @closeBrowser
Scenario: Products Grid: Verify by clicking on the Options icon available at the end of the product row. NX-1014
Given login
Then navigate to precision marketer
Then navigate to offer management
Then navigate to products
Then navigate to prepaid telecom
Then verify clicking on options icon
@NX-1021
@initBrowser  @closeBrowser
Scenario: Products Grid: Verify the Edit option of the product added NX-1021
Given login
Then navigate to precision marketer
Then navigate to offer management
Then navigate to products
Then navigate to prepaid telecom
Then click create new product button
Then create single product from sheet "singleProductPage"
Then check edit product functionality
#

#

@initBrowser  @closeBrowser
@NX-2072
Scenario: Verify cross site scripting for Filtering products under CLV Max NX-2072
Given login
Then navigate to precision marketer
Then navigate to offer management
Then navigate to products
Then navigate to prepaid telecom
Then check script in product name field "<script>alert(document.cookies)</script>"

@NX-2100
@initBrowser  @closeBrowser
Scenario: Verify cross site scripting for Filtering products under CLV Max NX-2100
Given login
Then navigate to precision marketer
Then navigate to offer management
Then navigate to products
Then navigate to prepaid telecom
Then check script in product name field "productname'; SELECT * FROM products;"
#

@initBrowser  @closeBrowser
@NX-2299
Scenario: Offer Management: Verify for the details present in the Help page NX-2299
Given login
Then navigate to precision marketer
Then navigate to offer management
Then navigate to products
Then veirfy help icon of products
#

@initBrowser  @closeBrowser
@NX-790
Scenario: Create offer:Offers Display: Verify the offers listed in the offer Management --> Offers tab. NX-790
Given login
Then navigate to precision marketer
Then navigate to offer management
Then navigate to offers
Then verify scroll bar for list of offers

@NX-800
@initBrowser 
Scenario: Create offer:Offers Display: Verify by expanding the offer row to know a quick summary details of the offer. NX-800
Given login
Then navigate to precision marketer
Then navigate to offer management
Then navigate to products
Then navigate to prepaid telecom
Then click create new product button
Then create single product from sheet "fullDetails"
Then navigate to offer management
Then navigate to offers
Then create new offer from sheet "rechargeWAP" with product "fullDetails"
Then verify quick summary of product "fullDetails" in offer grid of "rechargeWAP"
#
#@NX-805
#Scenario: Create offer:Offers Display: Verify the offer details in the grid by expanding the offers NX-805
#Given login
#Then navigate to precision marketer
#Then navigate to offer management
#Then navigate to products
#Then create single product from sheet "singleProductPage"
#Then navigate to offer management
#Then navigate to offers
#Then create new "Recharge" offer for product
#Then verify offer details in grid
#
#@NX-808
#Scenario: Create offer:Offers Display: Verify collapsing the expanded offer summary details. NX-808
#Given login
#Then navigate to precision marketer
#Then navigate to offer management
#Then navigate to offers
#Then verify collapsing and expanding offer summary
#
#@NX-809
#Scenario: Create offer:Offers Display: Verify collapsing the expanded offer summary details. NX-809
#Given login
#Then navigate to precision marketer
#Then navigate to offer management
#Then navigate to offers
#Then verify clicking on options icon in offer grid
#
#@NX-810
#Scenario: Create offer:Offers Display: Verify the edit option of the offers NX-810
#Given login
#Then navigate to precision marketer
#Then navigate to offer management
#Then navigate to offers
#Then create new "Recharge" offer for product
#Then check edit offer functionality

#@NX-1046
#Scenario: Create Product: Verify the field validations for the benefit details NX-1046
#Given login
#Then navigate to precision marketer
#Then navigate to offer management
#Then navigate to products
#Then click create new product button
#Then enter product details from sheet "benefitFieldValidation-NX-1046"
#Then check field validations under the benefits grid
#@NX-1012
#Scenario: Products Grid: Verify scrolling functionality to view the product at the end of the screen NX-1012
#Given login
#Then navigate to precision marketer
#Then navigate to offer management
#Then navigate to products
#Then click create new product button
#Then enter product details from sheet "fullDetails"
#Then save product
#Then scrolling to view "fullDetails" in the entire product list
#@NX-1036
#Scenario: Create Product: Verify the field validations for the Basic informations NX-1036
#Given login
#Then navigate to precision marketer
#Then navigate to offer management
#Then navigate to products
#Then click create new product button
#Then field validations for the Basic Information

#@NX-1038
#Scenario: Create Product: Verify saving the products by not adding the mandatory fields NX-1038
#Given login
#Then navigate to precision marketer
#Then navigate to offer management
#Then navigate to products
#Then click create new product button
#Then saving the products by not adding the mandatory fields


#@NX-1045
#no limit in adding benefits
#Scenario: Create Product: Verify adding more than 3 benefits NX-1045
#Given login
#Then navigate to precision marketer
#Then navigate to offer management
#Then navigate to products
#Then click create new product button
#Then enter product details from sheet "benefitFieldValidation-NX-1046"
#Then verify adding more than 3 benefits for product

#@NX-1026
#Scenario: Products Grid: Verify View offers options for the products added NX-1026
#Given login
#Then navigate to precision marketer
#Then navigate to offer management
#Then navigate to products
#Then create single product from sheet "singleProductPage"
#Then navigate to offer management
#Then navigate to offers
#Then create new "Recharge" offer for product
#Then navigate to offer management
#Then navigate to products
#Then check if offer is shown in view offers
##invalid##
#@NX-1051
#
#Scenario: Create Product: Verify adding multiple benefit with same usage leg and Type NX-1051
#Given login
#Then navigate to precision marketer
#Then navigate to offer management
#Then navigate to products
#Then create product having multiple benefits with same usage leg and type combinations
#

#