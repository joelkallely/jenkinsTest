#Author: joel.jose@flytxt.com
#Keywords Summary : checking postive flow of bc creation


Feature: positive flow of list upload and verification in cuctomer info

	BC Creation
	
@NXregistrationList
@initBrowser
Scenario: generate randrom registration list and upload
Given login
#Then check and add profile fields
Given random registration list is generated
Then upload list
Given login
Then navigate to precision marketer
Then check the upoaded list in ui