#Author: joel.jose@flytxt.com
#Keywords Summary : generic product class test cases

 
@NXProductClass
Feature: generic product class

#@NX-7015
#@initBrowser 
#Scenario: Verify deletion of attributes from the product class
#Given login
#Then navigate to configuration management
#Then naviagte to product classes
#Then create product class and add attributes from "TestProductClass"
#Then pass next scenario based on this step



@NX-7188
@initBrowser
Scenario: Verify creation of product in a product class without any attributes NX-7188
Given login
Then navigate to configuration management
Then naviagte to product classes
Then create product class without any attributes from "TestProductClass"
Then navigate to landing page
Then navigate to precision marketer
Then navigate to offer management
Then navigate to products
Then navigate to product class "TestProductClass"
Then click create new product button
Then create product without any attributes from sheet "fullDetails"
#@NX-6967
#@closeBrowser
#Scenario: Verify the deactivating the products NX-6967
Then deactivate product from sheet "fullDetails"
Then 

@NX-6973  
@initBrowser 
Scenario: Verify creation of product class
Given login
Then navigate to configuration management
Then naviagte to product classes
Then create product class and add attributes from "TestProductClass"
Then pass next scenario based on this step

@NX-7116
Scenario: Verify selecting Allow multiple option in the product class page NX-7116
Then check previous step and pass this
Then pass next scenario based on this step

@NX-7111
Scenario: Verify selecting the mandatory option in the attribute page NX-7111
Then check previous step and pass this
Then pass next scenario based on this step

@NX-7108
Scenario: verify whether add sub attribute option is available for the attribute with type combo NX-7108
Then check previous step and pass this
Then pass next scenario based on this step

@NX-7107
Scenario: Verify addition of sub attribute to the combo type NX-7107
Then check previous step and pass this
Then pass next scenario based on this step

@NX-7187
Scenario: Verify  type field with Combo type NX-7187
Then check previous step and pass this
Then pass next scenario based on this step

@NX-6988
Scenario: Verify whether attributes option is available on the context menu NX-6988
Then check previous step and pass this
Then pass next scenario based on this step
@NX-6990
Scenario: Verify whether add attributes button is available or not NX-6990
Then check previous step and pass this
Then pass next scenario based on this step
@NX-6993
Scenario: Verify the add attribute page NX-6993
Then check previous step and pass this
Then pass next scenario based on this step
@NX-6971
Scenario: Verify whether product class module is available NX-6971
Then check previous step and pass this

@NX-6980  
Scenario: Verify the Name field(100 characters)
Then navigate to landing page
Then navigate to precision marketer
Then navigate to offer management
Then navigate to products
Then navigate to product class "TestProductClass"
Then click create new product button
Then verify name field character limit

@NX-6987
Scenario: Verify the Description filed(200 characters)
Then verify description field character limit

@NX-6974  
Scenario: Veriy creation of products inside a product class NX6974
Then create selClass product from sheet "fullDetails"
Then pass next scenario based on this step

@NX-7055
Scenario: Verify whether product can be added when clicked on the add button in the product listing page NX-7055
Then check previous step and pass this

@NX-6979
@closeBrowser
Scenario: Verify whether products are listed when clicked on the view products NX6979
Then veirfy SelClass product "fullDetails" in grid

@NX-6995
@initBrowser 
Scenario: Verify  whether type field accept number NX-6995
Given login
Then navigate to precision marketer
Then navigate to offer management
Then navigate to products
Then navigate to product class "TestProductClass"
Then click create new product button
Then verify SelClass number field

@NX-6998  
Scenario: Verify  whether type field accept number NX-6998
Then verify SelClass text field

@NX-6999  
Scenario: Verify type field with single select NX-6999
Then verify SelClass single select field

@NX-7012  
@closeBrowser
Scenario: verify type field with multi select NX-7012
Then verify SelClass multi select field

@NX-7042
@initBrowser 
Scenario: Verify the duplicate option  for the product class NX-7042
Given login
Then navigate to configuration management
Then naviagte to product classes
Then duplicate "TestProductClass"

@NX-7048
Scenario: Verify deactivating the product class NX-7048
Then verify deactivating product class "TestProductClass"
Then pass next scenario based on this step

@NX-7032
Scenario: Verify whether hexagon showing active/inactive status is added  NX-7032
Then check previous step and pass this

@NX-7046
Scenario: Verify activating the product class NX-7046
Then verify activating product class "TestProductClass"

@NX-7051
Scenario: Verify the duplicate option  for attributes NX-7051
Then verify duplicating attribute of "TestProductClass"

@NX-7049
Scenario: Verify edit option for attributes NX-7049
Then verify edit attribute

@NX-7053
Scenario: Verify delete option for attributes NX-7053
Then verify delete attribute

@NX-7040
Scenario: Verify the edit option for the product class NX-7040
Then navigate to landing page
Then navigate to configuration management
Then naviagte to product classes
Then verify edit product class of "TestProductClass"

@NX-7044
@closeBrowser
Scenario: Verify delete option for the product class NX-7044
Then delete duplicate of "TestProductClass"

@NX-7017
@initBrowser 
Scenario: Verify the product listing page NX-7017
Given login
Then navigate to precision marketer
Then navigate to offer management
Then navigate to products
Then navigate to product class "TestProductClass"
Then verify product listing page

@NX-7019
Scenario: Verify whether the product listing page shows the name and description NX-7019
Then verify name and description "fullDetails"

@NX-7020
Scenario: Verif whether product list show the details of the user who created / edited the products  NX-7020
Then verify details of user who created / edited

@NX-7028
Scenario: Verify whether created and modified timestamps are displayed in the product listing page  NX-7028
Then verify timestamps in product grid

@NX-7031
@closeBrowser
Scenario: Verify whether details of the products are shown when clicked on the row  NX-7031
Then verify SelClass product details in grid
Then pass next scenario based on this step

@NX-7109
Scenario: Verify the attribute label is displayed when the  product is expanded NX-7109
Then check previous step and pass this