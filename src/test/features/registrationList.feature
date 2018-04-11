#Author: joel.jose@flytxt.com
#Keywords Summary : checking postive flow of bc creation


Feature: positive flow of list upload and verification in cuctomer info

	BC Creation
	
@NXregistrationList
@initBrowser
Scenario: generate randrom registration list and upload
#Given random registration list is generated
Given login
#Then navigate to data foundation
#Then navigate to registration list
#Then click create new registration list button
#Then enter details of registration list
#Then save registration list
#Then navigate to landing page
#Then navigate to data foundation
#Then check and add profile fields
Then upload list
#Given login
#Then navigate to precision marketer
#Then check the upoaded list in ui