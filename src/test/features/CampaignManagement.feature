#Author: joel.jose@flytxt.com
#Keywords Summary : checking postive flow of bc creation


@NXCampaign
Feature: campaign management 

	
#########################recurring bc
@NXCampaignCreation
@initBrowser @closeBrowser
Scenario: create a campaign
Given login
Then navigate to precision marketer
Then navigate to life cycle marketing
Then navigate to "Recharge" category
Then create new campaign from sheet "campaignBC"